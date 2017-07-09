package com.spring.aspect.model;

public class Circle {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle setter called");
	}
	
	public void print(String str){
		System.out.println("Circle's print method called");
		throw new RuntimeException();
	}
	
	public String setNameandReturn(String name) {
		this.name=name;
		return name;
		
	}
	

}
