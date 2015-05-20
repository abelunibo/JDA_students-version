package com.laneve.deadlock.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.laneve.bytecode.parser.BytecodeParser.ConstantPoolContext;

public class BECostantPool extends BEBase{
	HashMap<String, HashMap<String, ArrayList<String>>> cpools = new HashMap<String, HashMap<String,ArrayList<String>>>();

	public BECostantPool() {
		// TODO Auto-generated constructor stub
	}
	
	public void addHashMap(HashMap<String, HashMap<String, ArrayList<String>>> cpools){
		this.cpools = cpools;
	}

}
