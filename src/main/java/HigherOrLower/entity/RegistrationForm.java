package HigherOrLower.entity;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class RegistrationForm {

	private String username;
	private String password;
	
	public User toUser(PasswordEncoder passwordEncoder) {
		User user = new User();
		user.setUsername(this.username);
		user.setPassword(passwordEncoder.encode(this.password));
		
		return user;
	}
	
}
