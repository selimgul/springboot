package com.example.openfeign.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmployeeDTO {

  @JsonProperty("status")
  private String status;
  @JsonProperty("message")
  private String message;
  @JsonProperty("data")
  private Employee employee;
  
}