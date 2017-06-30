package com.pkumar.blog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pkumar.blog.entity.User;
import com.pkumar.blog.model.BloggyResponse;
import com.pkumar.blog.service.UserService;
import com.pkumar.blog.util.BloggyException;

@RestController
@RequestMapping(path = "/api")
public class BloggyController {
	
	@Autowired
	UserService userService;

	@RequestMapping(path = "/user", method = { RequestMethod.POST }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody BloggyResponse<Long> registerUser(@RequestBody User user) {
		BloggyResponse<Long> response = null;
		try {
			response = new BloggyResponse<Long>(userService.registerUser(user));
		} catch (BloggyException e) {
			response = new BloggyResponse<Long>(e.getMessage(), e.getRootCause());
		}
		return response;
	}

	@RequestMapping(path = "/user", method = { RequestMethod.PUT }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody BloggyResponse<Long> updateUser(@RequestBody User user) {
		BloggyResponse<Long> response = null;
		try {
			response = new BloggyResponse<Long>(userService.updateUser(user));
		} catch (BloggyException e) {
			response = new BloggyResponse<Long>(e.getMessage(), e.getRootCause());
		}
		return response;

	}

	@RequestMapping(path = "/user/{id}", method = { RequestMethod.GET })
	public @ResponseBody BloggyResponse<User> getUser(@PathVariable Long id) {
		BloggyResponse<User> response = null;
		try {
			response = new BloggyResponse<User>(userService.getUser(id));
		} catch (BloggyException e) {
			response = new BloggyResponse<User>(e.getMessage(), e.getRootCause());
		}
		return response;
	}

	@RequestMapping(path = "/user/{id}", method = { RequestMethod.DELETE })
	public @ResponseBody BloggyResponse<Boolean> deleteUser(@PathVariable Long id) {
		BloggyResponse<Boolean> response = null;
		try {
			response = new BloggyResponse<Boolean>(userService.deleteUser(id));
		} catch (BloggyException e) {
			response = new BloggyResponse<Boolean>(e.getMessage(), e.getRootCause());
		}
		return response;
	}

	@RequestMapping(path = "/user", method = { RequestMethod.GET }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public BloggyResponse<List<User>> getAllUsers() {
		BloggyResponse<List<User>> response = null;
		try {
			response = new BloggyResponse<List<User>>(userService.getAllUsers());
		} catch (BloggyException e) {
			response = new BloggyResponse<List<User>>(e.getMessage(), e.getRootCause());
		}
		return response;
	}
}
