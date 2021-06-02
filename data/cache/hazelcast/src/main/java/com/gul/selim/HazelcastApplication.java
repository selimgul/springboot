package com.gul.selim;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

import com.gul.selim.model.Employee;
import com.gul.selim.service.EmployeeService;

@SpringBootApplication
@EnableCaching
public class HazelcastApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HazelcastApplication.class, args);
		
		EmployeeService employeeService = context.getBean(EmployeeService.class);
				
		System.out.println("=============================== Started =============================== ");
		Employee emp= new Employee();
		emp.setEmpId("emp");
		emp.setEmpName("emp");
		
		Employee emp1= new Employee();
		emp1.setEmpId("emp1");
		emp1.setEmpName("emp1");
		
		Employee emp2= new Employee();
		emp2.setEmpId("emp2");
		emp2.setEmpName("emp2");
		
		employeeService.insertEmployee(emp);
		employeeService.insertEmployee(emp1);
		employeeService.insertEmployee(emp2);
				
		System.out.println("Inside the main class making call to service first time");
		List<Employee> employeeList1 = employeeService.getAllEmployees();
		for (Employee employee : employeeList1) {
			System.out.println(employee.toString());
		}
				
		System.out.println("Inside the main class making call to service second time where it will use hazelcast");
		List<Employee> employeeList2 = employeeService.getAllEmployees();
		for (Employee employee : employeeList2) {
			System.out.println(employee.toString());
		}
		
	}

}
