package com.example.openfeign.service.impl;

import com.example.openfeign.client.EmployeeClient;
import com.example.openfeign.model.EmployeeDTO;
import com.example.openfeign.model.EmployeeListDTO;
import com.example.openfeign.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeClient employeeClient;
   
    @Override
    public EmployeeListDTO getEmployees() {
        return employeeClient.getEmployees();
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        return employeeClient.getEmployeeById(id);
    }
}