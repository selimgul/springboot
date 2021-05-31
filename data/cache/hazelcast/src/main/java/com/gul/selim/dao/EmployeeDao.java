package com.gul.selim.dao;

import java.util.List;

import com.gul.selim.model.Employee;

public interface EmployeeDao {
	void insertEmployee(Employee emp);	
	List<Employee> getAllEmployees();

}