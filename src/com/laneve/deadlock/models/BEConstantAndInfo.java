package com.laneve.deadlock.models;

import java.util.ArrayList;


public class BEConstantAndInfo extends BEBase{
	
	ArrayList<String> constantAndInfo; 
	
	public BEConstantAndInfo(ArrayList<String> constantAndInfo) {
		this.constantAndInfo = constantAndInfo;
	}

	public ArrayList<String> getConstantAndInfo() {
		return constantAndInfo;
	}

}
