package com.example.openfeign.controller;

import java.util.List;

import com.example.openfeign.model.Employee;
import com.example.openfeign.model.EmployeeDTO;
import com.example.openfeign.model.EmployeeListDTO;
import com.example.openfeign.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/api/employees")
    public EmployeeListDTO getEmployees(){
        return employeeService.getEmployees();        
    }

    @GetMapping("/api/employees/{id}")
    public EmployeeDTO getEmployeeByID(@PathVariable final Long id){
        return employeeService.getEmployeeById(id);        
    }
}
