package com.spring.aspect.model;

import com.spring.aspect.advice.MyAnnotation;

public class Traingle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@MyAnnotation
	public void myTriangle(){
		System.out.println("My annotated Triangle");
	}
}
