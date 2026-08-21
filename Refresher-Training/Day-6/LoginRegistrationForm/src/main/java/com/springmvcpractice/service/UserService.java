package com.springmvcpractice.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.springmvcpractice.entity.User;

import com.springmvcpractice.repository.UserRepository;

@Service

public class UserService {

	@Autowired

	private UserRepository userRepository;

	// Registration

	public boolean register(User user) {

		User existingUser = userRepository.findByEmail(user.getEmail());

		if (existingUser != null) {

			return false;
		}

		userRepository.save(user);

		return true;
	}

	// Login

	public User login(String email, String password) {

		User user = userRepository.findByEmail(email);

		if (user != null && user.getPassword().equals(password)) {

			return user;
		}

		return null;
	}

	// Find user by ID

	public User getUserById(int id) {

		return userRepository.findById(id);
	}

	// Update user

	public void updateUser(User user) {

		userRepository.update(user);
	}

	// Delete user

	public void deleteUser(int id) {

		userRepository.delete(id);
	}
}