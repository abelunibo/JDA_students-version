package com.laneve.deadlock.visitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

import com.laneve.bytecode.parser.BytecodeBaseVisitor;
import com.laneve.bytecode.parser.BytecodeParser;
import com.laneve.bytecode.parser.BytecodeParser.MethodDeclarationContext;
import com.laneve.deadlock.models.BEBase;
import com.laneve.deadlock.models.BEClassDec;
import com.laneve.deadlock.models.BEClassFile;
import com.laneve.deadlock.models.BECostantPool;
import com.laneve.deadlock.models.BEMethodDec;

public class BytecodeVisitor extends BytecodeBaseVisitor<BEBase> {

	HashMap<String, LinkedList<String>> method = new HashMap<String, LinkedList<String>>();
	HashMap<String, ArrayList<String>> localvar = new HashMap<String, ArrayList<String>>();

	@Override public BEBase visitClassfile(@NotNull BytecodeParser.ClassfileContext ctx) {
		BEClassFile classFile;
		BECostantPool costantPool;
		BEClassDec classDec;
	
		String className = ctx.classDec().ilmio.getText();
		costantPool = (BECostantPool)visitConstantPool(ctx.constantPool());
		//TODO classdec forse non serve
		classFile = new BEClassFile(className, null, costantPool);
		
		for(MethodDeclarationContext mdc : ctx.methodDeclaration()){
			BEMethodDec methodDec = (BEMethodDec)visitMethodDeclaration(mdc);
			classFile.addMethod(methodDec);
		}
		
		return classFile;
	}

	@Override public BEBase visitClassDec(@NotNull BytecodeParser.ClassDecContext ctx) { 
		//	System.out.println("sdfafdaf'");		
		return visitChildren(ctx); 
	}

	@Override 
	public BEBase visitConstantPool(@NotNull BytecodeParser.ConstantPoolContext ctx) { 
		BECostantPool costantPool = new BECostantPool();
		HashMap<String, HashMap<String, ArrayList<String>>> cpools = new HashMap<String, HashMap<String,ArrayList<String>>>();	
		HashMap<String,ArrayList<String>> cpoolref = new HashMap<String, ArrayList<String>>();

		//System.out.println(ctx.tableEntries().getText());
		int tableEntryNum = ctx.tableEntries().getChildCount();
		for (int j = 0; j < tableEntryNum; j++){
			String ref = ctx.tableEntries().getChild(j).getChild(0).getText();
			String type = ctx.tableEntries().getChild(j).getChild(2).getChild(0).getText();

			//System.out.println(ref +" "+type);

			if(type.contains("Fieldref") || type.contains("Methodref") 
					|| type.contains("NameAndType")  ){

				ArrayList<String> a = new ArrayList<String>();
				String r1 = ctx.tableEntries().getChild(j).getChild(2).getChild(1).getText();
				String r2 = ctx.tableEntries().getChild(j).getChild(2).getChild(3).getText();
				a.add(type);
				a.add(r1);
				a.add(r2);
				cpoolref.put(ref, a);
				//System.out.println(ref+" "+type+ " " + r1 + " "+ r2);

			}else if(type.contains("Class") || type.contains("Integer")){

				String r1 = ctx.tableEntries().getChild(j).getChild(2).getChild(1).getText();
				ArrayList<String> a = new ArrayList<String>();
				a.add(type);
				a.add(r1);
				cpoolref.put(ref,a);
				//System.out.println(ref+" "+type+" "+r1);

			}else{//UTF8 
				ParseTree r1 = ctx.tableEntries().getChild(j).getChild(2);
				if(r1!=null){
					String s = r1.getText().substring(r1.getText().indexOf("8")+1, r1.getText().length());
					ArrayList<String> a = new ArrayList<String>();
					a.add(type);
					a.add(s);
					cpoolref.put(ref,a);
					//System.out.println(type + " " + s);
				}
			}
		}
		costantPool.addHashMap(cpools);
	//	cpools.put(className, cpoolref);
	  //printCpool();
		return costantPool; 
	}

	@Override 
	public BEBase visitMethodDeclaration(@NotNull BytecodeParser.MethodDeclarationContext ctx) { 

		LinkedList<String> instructions = new LinkedList<String>();
		String signature = "";

		if(ctx.getText().contains("synchronized"))
			signature+= "synchronized ";

		signature+= ctx.methodHeader().methodDeclarator().getText();
		//System.out.println(signature);

		for (int j = 0; j < ctx.methodBody().instructions().getChildCount(); j++) {
			instructions.add(ctx.methodBody().instructions().getChild(j).getText());
			if(ctx.methodBody().instructions().getChild(j).getText().contains("invokespecial")||
					ctx.methodBody().instructions().getChild(j).getText().contains("invokevirtual")){
				
				String is = ctx.methodBody().instructions().getChild(j).getText();
				int n = is.indexOf('#');
				String ref = is.substring(n, is.length());
				
				//System.out.print(ref);
//				ArrayList<String> a = cpools.get(className).get(ref);
//				//System.out.println(" "+a.get(1)+" "+a.get(2));
//				//System.out.println(a.get(2));
//				//System.out.println(" "+cpools.get(className).get(a.get(2)));
//				ArrayList<String> a2 = cpools.get(className).get(a.get(2));
//				
//				//System.out.println(a2.get(2));
//				ArrayList<String> a3 = cpools.get(className).get(a2.get(2));
//				System.out.println(a3.get(1));
//				a3.get(1).indexOf(')');


				//System.out.println(cpools.get(className).get(ref));
				//System.out.println(ctx.methodBody().instructions().getChild(j).getText());
			}
		}

		//System.out.println(ctx.getText());
		return null;
		//return visitChildren(ctx);
	}

	//	public void printCpool(){
	//		for (Entry<String, HashMap<String, ArrayList<String>>> entry : cpools.entrySet()){
	//			HashMap<String, ArrayList<String>> cpool = entry.getValue();
	//			for (Entry<String, ArrayList<String>>  c : cpool.entrySet()){
	//				int n = c.getValue().size();
	//				switch (n) {
	//				case 2:
	//					System.out.println(entry.getKey()+" "+c.getKey() + " " + c.getValue().get(0)+ " " + c.getValue().get(1));
	//					break;
	//				case 3:
	//					System.out.println(entry.getKey()+" "+c.getKey() + " " + c.getValue().get(0)+ " " + c.getValue().get(1)+ " " + c.getValue().get(2) );
	//					break;
	//				}
	//
	//			}
	//		}
	//	}

}
