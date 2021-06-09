package com.gul.selim.service;

import com.gul.selim.aspect.Loggable;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Loggable
	public String createEmployee(String name, String empId) throws Exception {

		if (name.equals("error"))
			throw new Exception("Invalid name!");
			
		return String.format("Name: %s, ID: %s", name, empId);
	}
}
