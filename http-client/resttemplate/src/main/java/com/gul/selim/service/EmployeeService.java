package com.gul.selim.service;

import com.gul.selim.model.Employee;
import com.gul.selim.reqresp.EmployeeListResp;
import com.gul.selim.reqresp.EmployeeResp;

public interface EmployeeService {

	EmployeeListResp getEmployees();
	
	EmployeeResp getEmployeeById(String id);
	
	Employee createEmployee(Employee emp);
	
}
