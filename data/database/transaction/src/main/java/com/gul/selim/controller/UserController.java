package com.gul.selim.controller;

import com.gul.selim.model.User;
import com.gul.selim.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/users")
	public List<User> getDoctors() {
		return service.getUsers();
	}

	@GetMapping("/trx-fun")
	public void trxFun() {
		try{
			service.makeSomeTrxStuff();
			System.out.println("makeSomeTrxStuff completed successfully.");
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
