package HigherOrLower.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import HigherOrLower.entity.User;


@Repository
public class JdbcUserRepository implements UserRepository {

	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public User findByUsername(String username) {
		User user = jdbc.queryForObject("Select Users.username, password from Users where username =?",
				this:: mapRowToUser, username);
		return user;
	}

	@Override
	public User save(User user) {
	    jdbc.update("insert into Users (username, password) values (?, ?)",
	      user.getUsername(),
	      user.getPassword());
		return null;
	}
	
	private User mapRowToUser(ResultSet rs, int rowNumber) throws SQLException{
		User user = new User();
		user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
	    return user;
	}

}
