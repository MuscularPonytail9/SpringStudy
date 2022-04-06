package io.cmg.rest.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.cmg.rest.entity.User;
import io.cmg.rest.service.userService;
import io.cmg.rest.store.userStore;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class userServiceLogic implements userService {
	
//	@Autowired
//	private userStore userstore;
	
	private final userStore userstore;
	
//	public userServiceLogic(userStore userstore) {
//		this.userstore = userstore;
//	}
	
	

	@Override
	public String register(User newUser) {
		// TODO Auto-generated method stub
		return this.userstore.create(newUser);
	}

	@Override
	public void modify(User newUser) {
		// TODO Auto-generated method stub
		this.userstore.update(newUser);
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
		this.userstore.delete(id);
	}

	@Override
	public User find(String id) {
		// TODO Auto-generated method stub
		return this.userstore.retrieve(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return this.userstore.retrieveAll();
	}

}
