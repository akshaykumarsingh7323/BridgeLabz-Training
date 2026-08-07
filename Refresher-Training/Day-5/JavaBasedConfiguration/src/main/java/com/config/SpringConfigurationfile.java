package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bean.Student;

@Configuration
public class SpringConfigurationfile {
	
	@Bean
	public Student stdId1() {
		Student std = new Student();
		std.setId(1);
		std.setName("Akshay");
		std.setEmail("akshay@gmail.com");
		return std;
	}
}
