package springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "ID must not be NULL.")
	private Integer id;

	@NotEmpty(message = "Name must not be empty.")
	private String name;

	public Integer getID() {
		return id;
	}
	
	public void setID(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name  = name;
	}

	public Product() {

	}

	public Product(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [" + (id != null ? "ID=" + id + ", " : "") + (name != null ? "Name=" + name : "") + "]";
	}

}
