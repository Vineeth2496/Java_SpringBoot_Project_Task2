package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Data {
	private Integer id;
	private String name;
	private Float sal;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getSal() {
		return sal;
	}
	public void setSal(Float sal) {
		this.sal = sal;
	}
	
}
