package com.example.openfeign.service;

import com.example.openfeign.model.EmployeeDTO;
import com.example.openfeign.model.EmployeeListDTO;

public interface EmployeeService {
    EmployeeListDTO getEmployees();

    EmployeeDTO getEmployeeById(Long id);
}
