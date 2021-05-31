package com.gul.selim.reqresp;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gul.selim.model.Employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeListResp {

	@JsonProperty("status")
	private String status;
	
	@JsonProperty("data")
	private List<Employee> employeeList = new ArrayList<>();
}
