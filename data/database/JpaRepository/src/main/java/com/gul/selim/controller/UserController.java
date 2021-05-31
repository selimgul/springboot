package com.gul.selim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gul.selim.model.User;
import com.gul.selim.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/users")
	public List<User> getUsers() {

		return service.getUsers();
	}

	@GetMapping("/user/{name}")
	public List<User> getUser(@PathVariable String name) {

		return service.getUser(name);
	}

	@GetMapping("/user/native/{name}")
	public List<User> getUserNative(@PathVariable String name) {

		return service.getUserNative(name);
	}

	@PostMapping("/users")
	public List<User> getUserNative(@RequestBody User user) {

		return service.getUserByNameAndId(user);
	}

	@GetMapping("/user/ignoreCase/{name}")
	public List<User> getUserByNameIgnoreCase(@PathVariable String name) {

		return service.getByNameIgnoreCase(name);
	}
}
