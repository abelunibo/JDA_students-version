package com.laneve.deadlock.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.laneve.bytecode.parser.BytecodeParser.FormalParameterContext;
import com.laneve.deadlock.models.BEClassFile;
import com.laneve.deadlock.models.BEConstantAndInfo;
import com.laneve.deadlock.models.BEInstruction;
import com.laneve.deadlock.models.BEMethodDeclaration;
import com.laneve.deadlock.models.BEMethodHeader;
import com.laneve.deadlock.models.BERef;
import com.laneve.deadlock.models.BETableEntries;

public class DataStructuresDebug {
	
	public static void printDataStructures(ArrayList<BEClassFile> classfiles){
		for(BEClassFile cf : classfiles){
			Logger.logInfo("\n file: "+ cf.getClassName()+" \n");
			BETableEntries tb = cf.getCostantPool().getTableEntries();
			HashMap<BERef, BEConstantAndInfo> t = tb.getTableEntries();
			for(Entry<BERef, BEConstantAndInfo> entry : t.entrySet()){
				String debug = " ";
				String ref = entry.getKey().getRef();
				debug +=ref;
				BEConstantAndInfo constantAndInfo = entry.getValue();
				ArrayList<String> cs = constantAndInfo.getConstantAndInfo();
				for(String c : cs){
					debug += " "+c;
				}
				Logger.logInfo(debug);
			}
		}
	}

	public static void printDataMethods(ArrayList<BEClassFile> classfiles) {
		for(BEClassFile cf : classfiles){
			Logger.logInfo("\n file: "+ cf.getClassName()+" \n");
			 HashMap<BEMethodHeader, BEMethodDeclaration> methodDeclaration = cf.getMethods();
			 for(Entry<BEMethodHeader, BEMethodDeclaration> m : methodDeclaration.entrySet()){
				 ArrayList<FormalParameterContext> formalparameters = m.getKey().getMethodDeclarator().getFormalParameters();
				 String parameters = "";
				 for(FormalParameterContext f : formalparameters){
					 parameters += '('+f.getText()+" "+')';
				 }
				 Logger.logInfo('\n'+m.getKey().getSignature()+" "+parameters);
				 for(BEInstruction i :  m.getValue().getMethodBody().getInstructions()){
					 if(i.getRef() == null)
						 Logger.logInfo(i.getNumber()+" "+i.getName());
					 else 	
						 Logger.logInfo(i.getNumber()+" "+i.getName()+" "+i.getRef().getRef());

				 }
			 }
		}
	}
	
}
