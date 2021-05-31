package com.gul.selim.service;

import java.util.List;

import com.gul.selim.model.Employee;

public interface EmployeeService {
	void insertEmployee(Employee emp);	
	List<Employee> getAllEmployees();	
}