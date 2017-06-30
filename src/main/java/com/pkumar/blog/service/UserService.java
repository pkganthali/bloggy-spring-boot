package com.pkumar.blog.service;

import java.util.List;

import com.pkumar.blog.entity.User;
import com.pkumar.blog.util.BloggyException;

public interface UserService {
	
	Long registerUser(User user) throws BloggyException;
	Long updateUser(User user) throws BloggyException;
	User getUser(Long id) throws BloggyException;
	boolean deleteUser(Long id) throws BloggyException;
	List<User> getAllUsers() throws BloggyException;
}
