package com.springmvcpractice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.springmvcpractice.entity.User;

import com.springmvcpractice.service.UserService;

@Controller

public class UserController {

	@Autowired

	private UserService userService;

	// Login page

	@GetMapping({ "/", "/login" })

	public String loginPage() {

		return "login";
	}

	// Registration page

	@GetMapping("/register")

	public String registerPage() {

		return "registration";
	}

	// Registration

	@PostMapping("/register")

	public String register(

			@RequestParam("name") String name,

			@RequestParam("email") String email,

			@RequestParam("password") String password,

			Model model) {

		User user = new User(name, email, password);

		boolean result = userService.register(user);

		if (result) {

			model.addAttribute("success", "Registration successful. Please login.");

			return "login";
		}

		model.addAttribute("error", "Email is already registered.");

		return "registration";
	}

	// Login

	@PostMapping("/login")

	public String login(

			@RequestParam("email") String email,

			@RequestParam("password") String password,

			HttpSession session,

			Model model) {

		User user = userService.login(email, password);

		if (user != null) {

			session.setAttribute("loggedInUser", user);

			return "redirect:/home";
		}

		model.addAttribute("error", "Invalid email or password.");

		return "login";
	}

	// Home page

	@GetMapping("/home")

	public String homePage(HttpSession session) {

		User user = (User) session.getAttribute("loggedInUser");

		if (user == null) {

			return "redirect:/login";
		}

		return "home";
	}

	// Update password page

	@GetMapping("/profile")

	public String profile(

			HttpSession session,

			Model model) {

		User user = (User) session.getAttribute("loggedInUser");

		if (user == null) {

			return "redirect:/login";
		}

		model.addAttribute("user", user);

		return "profile";
	}

	// Update password

	@PostMapping("/update-password")

	public String updatePassword(

			@RequestParam("password") String password,

			HttpSession session) {

		User loggedInUser = (User) session.getAttribute("loggedInUser");

		if (loggedInUser == null) {

			return "redirect:/login";
		}

		User user = userService.getUserById(loggedInUser.getId());

		if (user == null) {

			session.invalidate();

			return "redirect:/login";
		}

		user.setPassword(password);

		userService.updateUser(user);

		session.setAttribute("loggedInUser", user);

		return "redirect:/home";
	}

	// Delete account

	@GetMapping("/delete-account")

	public String deleteAccount(HttpSession session) {

		User user = (User) session.getAttribute("loggedInUser");

		if (user == null) {

			return "redirect:/login";
		}

		userService.deleteUser(user.getId());

		session.invalidate();

		return "redirect:/login";
	}

	// Logout

	@GetMapping("/logout")

	public String logout(HttpSession session) {

		session.invalidate();

		return "redirect:/login";
	}
}