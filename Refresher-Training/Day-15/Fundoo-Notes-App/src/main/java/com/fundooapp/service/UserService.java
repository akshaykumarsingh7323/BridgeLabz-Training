package com.fundooapp.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fundooapp.dto.RegisterRequest;
import com.fundooapp.entity.User;
import com.fundooapp.exception.UserAlreadyExistsException;
import com.fundooapp.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	// REGISTER

	public User register(RegisterRequest request) {

		if (userRepository.existsByEmail(request.getEmail())) {

			throw new UserAlreadyExistsException("Email already registered");
		}

		User user = new User();

		user.setFirstName(request.getFirstName());

		user.setLastName(request.getLastName());

		user.setEmail(request.getEmail());

		user.setPassword(passwordEncoder.encode(request.getPassword()));

		return userRepository.save(user);
	}

	// FORGOT PASSWORD

	public String forgotPassword(String email) {

		User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

		String token = UUID.randomUUID().toString();

		user.setResetToken(token);

		user.setResetTokenExpiry(LocalDateTime.now().plusMinutes(15));

		userRepository.save(user);

		return token;
	}

	// RESET PASSWORD

	public void resetPassword(String token, String newPassword) {

		User user = userRepository.findByResetToken(token)
				.orElseThrow(() -> new RuntimeException("Invalid reset token"));

		// Check token expiry
		if (user.getResetTokenExpiry() == null || user.getResetTokenExpiry().isBefore(LocalDateTime.now())) {

			throw new RuntimeException("Reset token expired");
		}

		// Check old and new password
		if (passwordEncoder.matches(newPassword, user.getPassword())) {

			throw new RuntimeException("New password must be different from old password");
		}

		// Encode new password
		user.setPassword(passwordEncoder.encode(newPassword));

		// Remove reset token after successful reset
		user.setResetToken(null);

		user.setResetTokenExpiry(null);

		userRepository.save(user);
	}
}