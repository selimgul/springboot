package com.example.openfeign.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmployeeListDTO {

  @JsonProperty("status")
  private String status;
  @JsonProperty("message")
  private String message;
  @JsonProperty("data")
  private List<Employee> employees;
  
}