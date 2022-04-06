package io.cmg.rest.service;

import java.util.List;

import io.cmg.rest.entity.User;

public interface userService {
	String register(User newUser);
	void modify(User newUser);
	void remove(String id);
	
	User find(String id);
	List<User> findAll();
}
