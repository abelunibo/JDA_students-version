package com.laneve.deadlock.models;


public class BEInstruction extends BEBase{
	String number;
	String name;
	BERef ref;
	
	public BEInstruction(String number, String name, BERef ref) {
		this.number = number;
		this.name = name;
		this.ref = ref;
	}
	
	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}
	
	public BERef getRef() {
		return ref;
	}

	

}
