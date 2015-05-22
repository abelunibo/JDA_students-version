package com.laneve.deadlock.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.laneve.bytecode.parser.BytecodeParser.FormalParameterContext;
import com.laneve.deadlock.models.BEClassFile;
import com.laneve.deadlock.models.BEConstantAndInfo;
import com.laneve.deadlock.models.BEInstructionLine;
import com.laneve.deadlock.models.BEMethodDeclaration;
import com.laneve.deadlock.models.BEMethodHeader;
import com.laneve.deadlock.models.BETableEntries;
import com.laneve.deadlock.models.lam.LamBase;

public class DataStructuresDebug {

	public static void printDataStructures(ArrayList<BEClassFile> classfiles){
		for(BEClassFile cf : classfiles){
			Logger.logInfo("\n file: "+ cf.getClassName()+" \n");
			BETableEntries tb = cf.getCostantPool().getTableEntries();
			HashMap<String, BEConstantAndInfo> t = tb.getTableEntries();
			for(Entry<String, BEConstantAndInfo> entry : t.entrySet()){
				String debug = " ";
				String ref = entry.getKey();
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
				Logger.logInfo(m.getKey().getSignature()+" "+parameters);
				
				for(BEInstructionLine i :  m.getValue().getMethodBody().getInstructions()){
					Logger.logInfo(i.getIndex()+" "+i.getName()+" "+i.getNat()+" "+i.getNumber()+" "+i.getRef());

				}
			}
		}
	}

	public static void printGenerateLams(ArrayList<LamBase> lams) {
		int i = 0;
		for(LamBase l : lams ){
			System.out.print("LAM :"+ i +" ");
			System.out.println(l.getLam()+" ; ");
			i++;
		}
		System.out.println("\n");
	}


}
