package com.fundooapp.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fundooapp.service.RedisService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtService jwtService;

	private final UserDetailsService userDetailsService;

	private final RedisService redisService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// 1. Authorization header se JWT token lena
		String authHeader = request.getHeader("Authorization");

		if (authHeader == null || !authHeader.startsWith("Bearer ")) {

			filterChain.doFilter(request, response);

			return;
		}

		// 2. "Bearer " remove karke actual token lena
		String jwtToken = authHeader.substring(7);

		String email;

		try {

			// 3. JWT se email extract karna
			email = jwtService.extractEmail(jwtToken);

		} catch (Exception e) {

			// Invalid JWT
			filterChain.doFilter(request, response);

			return;
		}

		// 4. Check authentication already present hai ya nahi
		if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			// 5. Database se user details lena
			UserDetails userDetails = userDetailsService.loadUserByUsername(email);

			// 6. JWT ko validate karna
			if (jwtService.isTokenValid(jwtToken, userDetails.getUsername())) {

				// 7. Redis mein JWT check karna
				String cachedEmail = redisService.get("jwt:" + jwtToken);

				// 8. Redis mein token mila aur email match hua
				if (cachedEmail != null && cachedEmail.equals(email)) {

					// 9. Authentication create karna
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());

					// 10. Request details set karna
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

					// 11. SecurityContext mein authentication set karna
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		}

		// 12. Request ko next filter/controller ki taraf bhejna
		filterChain.doFilter(request, response);
	}
}