package com.gul.selim.controller;

import com.gul.selim.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp")
    public String emp(@RequestParam("name") String name, @RequestParam("id") String id) {

        try {
            return employeeService.createEmployee(name, id);
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
