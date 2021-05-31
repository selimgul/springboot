package com.gul.selim.service.impl;

import org.springframework.stereotype.Service;

import com.gul.selim.model.Employee;
import com.gul.selim.reqresp.EmployeeListResp;
import com.gul.selim.reqresp.EmployeeResp;
import com.gul.selim.service.EmployeeService;

@Service
public class EmployeeServiceImpl extends ServiceBaseImpl implements EmployeeService {

	@Override
	public EmployeeListResp getEmployees() {
		uriHelper.setEndpoint(endpointConfig.getGetEmployeesEndpoint());	
		return reqHelper.get(securityConfig.getBasicAuthUser(), uriHelper.toString(), EmployeeListResp.class).getBody();
	}

	@Override
	public EmployeeResp getEmployeeById(String id) {
		uriHelper.setEndpoint(endpointConfig.getGetEmployeeByIdEndpoint());
		uriHelper.addPathParam("id", id);
		return reqHelper.get(securityConfig.getBasicAuthUser(), uriHelper.toString(), EmployeeResp.class).getBody();
	}

	@Override
	public Employee createEmployee(Employee emp) {
		uriHelper.setEndpoint(endpointConfig.getCreateEmployeeEndpoint());
		return reqHelper.post(securityConfig.getBasicAuthUser(), uriHelper.toString(), emp, Employee.class).getBody();		
	}

}
