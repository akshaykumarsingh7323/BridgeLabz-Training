package com.fundooapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundooapp.dto.AuthResponse;
import com.fundooapp.dto.ForgotPasswordRequest;
import com.fundooapp.dto.LoginRequest;
import com.fundooapp.dto.RegisterRequest;
import com.fundooapp.dto.ResetPasswordRequest;
import com.fundooapp.entity.User;
import com.fundooapp.security.JwtService;
import com.fundooapp.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	private final UserService userService;

	private final AuthenticationManager authenticationManager;

	private final JwtService jwtService;

	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {

		User user = userService.register(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(new AuthResponse(null, "User registered successfully"));
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {

		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		String token = jwtService.generateToken(request.getEmail());

		return ResponseEntity.ok(new AuthResponse(token, "Login successful"));
	}

	@PostMapping("/forgot-password")
	public ResponseEntity<String> forgotPassword(@Valid @RequestBody ForgotPasswordRequest request) {

		String token = userService.forgotPassword(request.getEmail());

		return ResponseEntity.ok("Reset token: " + token);
	}

	@PostMapping("/reset-password")
	public ResponseEntity<String> resetPassword(@Valid @RequestBody ResetPasswordRequest request) {

		userService.resetPassword(request.getToken(), request.getNewPassword());

		return ResponseEntity.ok("Password reset successfully");
	}
}