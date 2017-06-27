package com.pkumar.blog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pkumar.blog.entity.User;

@RestController
@RequestMapping(path = "/api")
public class BloggyController {

	@Autowired
	UserRepository userRepo;

	@RequestMapping(path = "/user", method = { RequestMethod.POST }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Long registerUser(@RequestBody User user) {
		userRepo.save(user);
		return user.getId();
	}

	@RequestMapping(path = "/user", method = { RequestMethod.PUT }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Long updateUser(@RequestBody User user) {
		userRepo.save(user);
		return user.getId();
	}

	@RequestMapping(path = "/user/{id}", method = { RequestMethod.GET })
	public User getUser(@PathVariable Long id) {
		return userRepo.findOne(id);
	}

	@RequestMapping(path = "/user/{id}", method = { RequestMethod.DELETE })
	public boolean updateUser(@PathVariable Long id) {
		try {
			userRepo.delete(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@RequestMapping(path = "/user", method = { RequestMethod.GET }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		userRepo.findAll().forEach(users::add);
		return users;
	}
}
