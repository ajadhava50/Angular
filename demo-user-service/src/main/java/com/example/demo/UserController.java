package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user-service-app")
public class UserController {

	private List<User> userList= new ArrayList<>();
	
	@PostMapping(value = "/user",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public User addUser(@RequestBody User user ) throws InterruptedException {
		System.out.println(user.toString());
		User us = new User(user.getFirstName(), user.getLastName(), user.getAge(), user.getCity());
		userList.add(us);
		return us;
	}
	@GetMapping(value = "/users",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public List<User> findAllUsers() throws InterruptedException{
		System.out.println(userList);
		return userList;
	}

	
}
