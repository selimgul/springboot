package com.gul.selim.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Employee {

  @JsonProperty("id")
  private Integer id;
  @JsonProperty("employee_name")
  private String name;
  @JsonProperty("employee_salary")
  private Integer salary;
  @JsonProperty("employee_age")
  private Integer age;
  @JsonProperty("profile_image")
  private String profileImage;
  
}