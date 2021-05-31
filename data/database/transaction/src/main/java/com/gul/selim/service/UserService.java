package com.gul.selim.service;

import com.gul.selim.model.User;
import com.gul.selim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> getUsers() {
		return repository.findAll();
	}

	@Transactional
	public void makeSomeTrxStuff(){
		int id = new Random().nextInt();

		repository.save(new User(id, "Trx-1"));

		Random rnd = new Random();
		int i = 1/(rnd.nextInt() % 2);

		repository.save(new User(id+1, "Trx-2"));
	}
}
