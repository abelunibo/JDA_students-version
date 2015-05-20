package com.laneve.deadlock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

import com.laneve.bytecode.parser.BytecodeBaseListener;
import com.laneve.bytecode.parser.BytecodeParser;

public class LamBytecode extends BytecodeBaseListener{
	String className;
	HashMap<String, HashMap<String, ArrayList<String>>> cpools = new HashMap<String, HashMap<String,ArrayList<String>>>();
	Map<String,List<Map<String, List<String>>>> classMethods = new HashMap<String, List<Map<String,List<String>>>>();

	@Override public void enterClassDec(@NotNull BytecodeParser.ClassDecContext ctx) { 
		className = ctx.packageAndClassName(0).getText(); 
		cpools.put(className, new HashMap<String, ArrayList<String>>());
	}

	//tableEntrys
	@Override 
	public void enterTableEntries(@NotNull BytecodeParser.TableEntriesContext ctx) {
		//for tableEntry
		HashMap<String,ArrayList<String>> cpoolref = new HashMap<String, ArrayList<String>>();
		int tableEntryNum = ctx.getChildCount();
		for (int j = 0; j < tableEntryNum; j++){ 

			String ref = ctx.getChild(j).getChild(0).getText();
			String type = ctx.getChild(j).getChild(2).getChild(0).getText();

			if(type.contains("Fieldref") || type.contains("Methodref") 
					|| type.contains("NameAndType")  ){

				ArrayList<String> a = new ArrayList<String>();
				String r1 = ctx.getChild(j).getChild(2).getChild(1).getText();
				String r2 = ctx.getChild(j).getChild(2).getChild(3).getText();
				a.add(type);
				a.add(r1);
				a.add(r2);
				cpoolref.put(ref, a);

			}else if(type.contains("Class") || type.contains("Integer")){

				String r1 = ctx.getChild(j).getChild(2).getChild(1).getText();
				ArrayList<String> a = new ArrayList<String>();
				a.add(type);
				a.add(r1);
				cpoolref.put(ref,a);
				//System.out.println(ref+" "+type+" "+r1);

			}else{//UTF8 // non prende tutta la stringa che viene dopo
				ParseTree r1 = ctx.getChild(j).getChild(2);
				if(r1!=null){
					String s = r1.getText().substring(r1.getText().indexOf("8")+1, r1.getText().length());
					ArrayList<String> a = new ArrayList<String>();
					a.add(type);
					a.add(s);
					cpoolref.put(ref,a);
					//System.out.println(y);
				}
			}
			cpools.put(className, cpoolref);
		}

		printCpool();
	}

	@Override 
	public void enterMethodDeclaration(@NotNull BytecodeParser.MethodDeclarationContext ctx) { 	
		HashMap< String, List<String>> method = new HashMap<String, List<String>>();
		LinkedList<String> instructions = new LinkedList<String>();

		String signature = "";
		if(ctx.getText().contains("synchronized"))
			signature+= "synchronized ";
		//System.out.println(className);

		signature+= ctx.methodHeader().methodDeclarator().getText();
		//System.out.println(signature);

		for (int j = 0; j < ctx.methodBody().instructions().getChildCount(); j++) {
			instructions.add(ctx.methodBody().instructions().getChild(j).getText());
			//System.out.println(ctx.methodBody().instructions().getChild(j).getText());
		}
		method.put(signature, instructions);
		//classMethods.put(className, method);
		//printMethod();
	}

	//	public void printMethod(){
	//		for(Entry<String, HashMap<String, List<String>>> entry : classMethods.entrySet()){
	//			System.out.println(entry.getKey());
	//			HashMap<String, List<String>> methodTemp = entry.getValue();
	//			for(Entry<String, List<String>> m : methodTemp.entrySet()){
	//				System.out.println(m.getKey());
	//				List<String> instructionsTemp = m.getValue();
	//				ListIterator<String> iterator = instructionsTemp.listIterator();
	////				while(iterator.hasNext()){
	////					System.out.println(iterator.next());
	////				}
	//			}
	//		} 
	//	}

	public void printCpool(){
		for (Entry<String, HashMap<String, ArrayList<String>>> entry : cpools.entrySet()){
			HashMap<String, ArrayList<String>> cpool = entry.getValue();
			for (Entry<String, ArrayList<String>>  c : cpool.entrySet()){
				int n = c.getValue().size();
				switch (n) {
				case 2:
					System.out.println(entry.getKey()+" "+c.getKey() + " " + c.getValue().get(0)+ " " + c.getValue().get(1));
					break;
				case 3:
					System.out.println(entry.getKey()+" "+c.getKey() + " " + c.getValue().get(0)+ " " + c.getValue().get(1)+ " " + c.getValue().get(2) );
					break;
				}

			}
		}
	}


}