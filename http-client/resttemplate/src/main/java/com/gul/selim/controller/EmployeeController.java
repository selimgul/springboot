package com.gul.selim.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gul.selim.model.Employee;
import com.gul.selim.reqresp.EmployeeListResp;
import com.gul.selim.reqresp.EmployeeResp;

@Validated
@RequestMapping(value = "/api/v1/employee")
public interface EmployeeController {

	@GetMapping
	ResponseEntity<EmployeeListResp> getEmployees();
	
	@GetMapping(value = "/{id}")
	ResponseEntity<EmployeeResp> getEmployeeById(@PathVariable String id);
	
	@PostMapping
	ResponseEntity<Employee> createEmployee(@RequestBody Employee emp);
}
