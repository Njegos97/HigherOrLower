package HigherOrLower.data;

import HigherOrLower.entity.User;

public interface UserRepository {
 
	User findByUsername(String username);
	
	User save (User user);
}
