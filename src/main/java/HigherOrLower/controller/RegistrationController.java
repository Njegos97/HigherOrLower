package HigherOrLower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import HigherOrLower.data.UserRepository;
import HigherOrLower.security.RegistrationForm;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@GetMapping
	public String getRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String RegisterUser(RegistrationForm registrationForm) {
		userRepo.save(registrationForm.toUser(passwordEncoder));
		
		return"/login";
	}
	
}
