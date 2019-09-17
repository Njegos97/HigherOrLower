package HigherOrLower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import HigherOrLower.data.UserRepository;
import HigherOrLower.entity.User;

@Controller
@RequestMapping("/UserProfile")
public class ProfileController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping
	public String getProfile(@AuthenticationPrincipal User user, Model model) {
		
		model.addAttribute("Username", user.getUsername());
		
		return "/UserProfile";
	}
	
}
