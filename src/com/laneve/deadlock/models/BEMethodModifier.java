package com.laneve.deadlock.models;

public class BEMethodModifier extends BEBase{
	String modifier;
	
	public BEMethodModifier(String modifier) {
		this.modifier = modifier;
	}
	public String getModifier(){
		return modifier;
	}

}
