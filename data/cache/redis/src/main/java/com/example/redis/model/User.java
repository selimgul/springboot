package com.example.redis.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class User implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
}
