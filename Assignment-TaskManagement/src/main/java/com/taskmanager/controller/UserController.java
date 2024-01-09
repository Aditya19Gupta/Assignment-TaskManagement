package com.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.taskmanager.entities.User;
import com.taskmanager.repository.UserRepo;

@Controller
public class UserController {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/")
	public String test() {
		return "home";
	}

	// get register form
	@GetMapping("/register")
	public String getRegisterForm(Model model) {
		model.addAttribute("user", new User());
		return "registerForm";
	}

	// registration
	@PostMapping("/register-process")
	public String registerProcess(@ModelAttribute("user") User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		userRepo.save(user);
		return "registerForm";
	}
	@GetMapping("/signin")
	public String getLoginForm() {
		return "login";
	}

}
