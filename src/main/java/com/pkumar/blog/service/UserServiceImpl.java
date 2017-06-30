package com.pkumar.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pkumar.blog.UserRepository;
import com.pkumar.blog.entity.User;
import com.pkumar.blog.util.BloggyException;

@Component("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public Long registerUser(User user) throws BloggyException {
		Long id = null;
		try {
		userRepo.save(user);
		id = user.getId();
		}
		catch(Exception e) {
			BloggyException.wrapAndThrowIt("Failed to save user " + user.getFirstName(), e);
		}
		return id;
	}

	@Override
	public Long updateUser(User user) throws BloggyException {
		Long id = null;
		try {
		userRepo.save(user);
		id = user.getId();
		}
		catch(Exception e) {
			BloggyException.wrapAndThrowIt("Failed to Update user " + user.getId(), e);
		}
		return id;
	}

	@Override
	public User getUser(Long id) throws BloggyException {
		User user = null;
		try{
			user = userRepo.findOne(id);
		}
		catch(Exception e) {
			BloggyException.wrapAndThrowIt("Failed to retrieve user " + id, e);
		}
		return user;
	}

	@Override
	public boolean deleteUser(Long id) throws BloggyException {
		boolean deleted = false;
		try {
			userRepo.delete(id);
			deleted = true;
		} catch (Exception e) {
			BloggyException.wrapAndThrowIt("Failed to delete user " + id, e);
		}
		return deleted;
	}

	@Override
	public List<User> getAllUsers() throws BloggyException {
		List<User> users = new ArrayList<User>();
		try {
		userRepo.findAll().forEach(users::add);
		}
		catch(Exception e) {
			BloggyException.wrapAndThrowIt("Failed to retrieve all users ", e);
		}
		return users;
	}

}
