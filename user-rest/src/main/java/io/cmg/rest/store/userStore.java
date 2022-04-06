package io.cmg.rest.store;

import java.util.List;

import io.cmg.rest.entity.User;

public interface userStore {
	String create(User newUser);
	void update(User newUser);
	void delete(String id);
	
	User retrieve(String id);
	List<User> retrieveAll();
}
