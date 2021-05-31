package com.gul.selim.service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.gul.selim.model.User;
import com.gul.selim.repository.UserRepository;

@Service
public class UserService {

	/*
	 	http://localhost:8080/h2-console

		JDBC URL: jdbc:h2:mem:testdb
		User Name: sa
		Pasword: <leave this empty>

	*/
	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void initUsers() {
		repository.saveAll(
				Stream.of(new User(101, "Kerem"), new User(102, "Belgin"), new User(103, "Selim"))
						.collect(Collectors.toList()));
	}

	public List<User> getUsers() {
		return repository.findAll();
	}

	public List<User> getUser(String name) {

		System.out.println("Return count => " + repository.count((root, criteriaQuery, criteriaBuilder) ->
																	criteriaBuilder.like(
																			criteriaBuilder.lower(root.get("name").as(String.class)),
																			MessageFormat.format("{0}%",name).toLowerCase())));
		return repository.getByLikeIgnoreCase(name);
	}

	public List<User> getUserNative(String name) {
		return repository.getByLikeNative(name);
	}

	public List<User> getByNameIgnoreCase(String name) {

		return repository.findByNameIgnoreCase(name);
	}

	public List<User> getUserByNameAndId(User user) {

		return repository.findByNameAndId(user.getName(), user.getId());
	}
}
