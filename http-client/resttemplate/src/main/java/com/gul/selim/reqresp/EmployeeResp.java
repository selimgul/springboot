package com.gul.selim.reqresp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gul.selim.model.Employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeResp {

	@JsonProperty("status")
	private String status;
	
	@JsonProperty("data")
	private Employee employee = new Employee();
}
