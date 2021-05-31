package com.gul.selim.service;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	public void createEmployee(String name, String empId) {
		System.out.println("Name: " + name + ", ID: " + empId);
	}
}
