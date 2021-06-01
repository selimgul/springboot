package com.example.openfeign.client;

import com.example.openfeign.model.EmployeeDTO;
import com.example.openfeign.model.EmployeeListDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "employeeClient", url = "http://dummy.restapiexample.com/api/v1/")
public interface EmployeeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/employees")
    EmployeeListDTO getEmployees();

    @RequestMapping(method = RequestMethod.GET, value = "/employee/{employeeID}", produces = "application/json")
    EmployeeDTO getEmployeeById(@PathVariable("employeeID") Long employeeID);
}