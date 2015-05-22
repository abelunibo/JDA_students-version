package com.laneve.deadlock.models;

import com.laneve.deadlock.models.lam.LamBase;

public class BEMethodModifier extends BEBase{
	String modifier;
	
	public BEMethodModifier(String modifier) {
		this.modifier = modifier;
	}
	public String getModifier(){
		return modifier;
	}
	@Override
	public LamBase generateLam(Environment environment) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
