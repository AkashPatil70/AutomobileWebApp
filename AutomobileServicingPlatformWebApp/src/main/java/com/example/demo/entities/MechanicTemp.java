package com.example.demo.entities;

public class MechanicTemp {

	private String name;
	private int exp;
	public MechanicTemp() {
		super();
	
	}
	public MechanicTemp(String name, int exp) {
		
		this.name = name;
		this.exp = exp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	
}
