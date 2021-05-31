package com.gul.selim.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.gul.selim.controller.EmployeeController;
import com.gul.selim.model.Employee;
import com.gul.selim.reqresp.EmployeeListResp;
import com.gul.selim.reqresp.EmployeeResp;
import com.gul.selim.service.EmployeeService;

@RestController
public class EmployeeControllerImpl extends ControllerBaseImpl implements EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Override
	public ResponseEntity<EmployeeListResp> getEmployees() {
		return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<EmployeeResp> getEmployeeById(String id) {	
		return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Employee> createEmployee(Employee emp) {
		return new ResponseEntity<>(employeeService.createEmployee(emp), HttpStatus.OK);
	}

}
