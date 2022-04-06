package io.cmg.rest.store.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import io.cmg.rest.entity.User;
import io.cmg.rest.store.userStore;

@Repository
public class userStoreLogic implements userStore {
	
	private Map<String, User> userMap;
	
	public userStoreLogic() {
		this.userMap = new HashMap<>();
	}
	
	@Override
	public String create(User newUser) {
		this.userMap.put(newUser.getId(), newUser);
		return newUser.getId();
	}
	
	@Override
	public void update(User newUser) {
		this.userMap.put(newUser.getId(), newUser);
	}
	
	@Override
	public void delete(String id) {
		this.userMap.remove(id);
	}
	
	@Override
	public User retrieve(String id) {
		return this.userMap.get(id);
	}
	
	@Override
	public List<User> retrieveAll() {
		return this.userMap.values().stream().collect(Collectors.toList());
	}
}
