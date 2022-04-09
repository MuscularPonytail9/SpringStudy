package io.cmg.rest.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import io.cmg.rest.entity.User;
import io.cmg.rest.service.userService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class userServiceLogicTest {
	
	@Autowired
	private userService userservice;
	
	private User kim;
	private User lee;
	
	@BeforeEach
	public void startUp() {
		this.kim = new User("Kim", "kim@naver.com");
		this.lee = new User("Lee", "lee@naver.com");
		this.userservice.register(kim);
		this.userservice.register(lee);
	}
	
	@Test
	public void registerTest() {
		User sample = User.sample();
		this.userservice.register(sample);
		assertThat(this.userservice.register(sample)).isEqualTo(sample.getId());
		assertThat(this.userservice.findAll().size()).isEqualTo(3);
		this.userservice.remove(sample.getId());
	}
	
	@Test
	public void find() {
		assertThat(this.userservice.find(lee.getId())).isNotNull();
		assertThat(this.userservice.find(lee.getId()).getEmail()).isEqualTo(lee.getEmail());
	}
	
	@AfterEach
	public void cleanUp() {
		this.userservice.remove(kim.getId());
		this.userservice.remove(lee.getId());
	}
}
