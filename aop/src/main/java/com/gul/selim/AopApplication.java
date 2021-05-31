package com.gul.selim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.gul.selim.service.EmployeeService;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(AopApplication.class, args);

		EmployeeService employeeService = context.getBean(EmployeeService.class);
		
		employeeService.createEmployee("selim", "10");
	}

}
