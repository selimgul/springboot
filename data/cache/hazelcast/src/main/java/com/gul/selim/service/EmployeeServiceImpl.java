package com.gul.selim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.gul.selim.dao.EmployeeDao;
import com.gul.selim.model.Employee;

@Service
@CacheConfig(cacheNames = "employees")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void insertEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}

	@Override
	@Cacheable()
	public List<Employee> getAllEmployees() {
		System.out.println("Inside the service layer");
		return employeeDao.getAllEmployees();

	}

}