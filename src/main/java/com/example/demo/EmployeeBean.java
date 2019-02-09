package com.example.demo;

/**
 * Mybatisで使用.
 *
 * @author eharadas
 *
 */
public class EmployeeBean {

	private static final long serialVersionUID = 1L;

    private String id;
	private String name;
	private String email;
	private String test = "カラムにない変数名へは入らない";

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "EmployeeBean [id=" + id + ", name=" + name + ", email=" + email + ", test=" + test + "]";
	}


}
