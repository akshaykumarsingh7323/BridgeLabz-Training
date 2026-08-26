package com.fundooapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
public class TestController {

	@GetMapping("/api/test")
	@SecurityRequirement(name = "bearerAuth")
	public String test() {

		return "JWT authentication successful";
	}
}