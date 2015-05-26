package com.laneve.deadlock;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.laneve.bytecode.parser.BytecodeLexer;
import com.laneve.bytecode.parser.BytecodeParser;
import com.laneve.deadlock.models.BEClassFile;
import com.laneve.deadlock.models.BEConstantAndInfo;
import com.laneve.deadlock.models.BEConstantPool;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.utilities.MyFormatter;
import com.laneve.deadlock.visitor.BytecodeVisitor;

public class DeadlockAnalysis {
	public static void main(String[] args) throws IOException{
		//root log configuration

		Logger rootLog = Logger.getLogger("");
		rootLog.setLevel(Level.ALL);

		Handler handler = rootLog.getHandlers()[0];
		handler.setFormatter(new MyFormatter());

		ArrayList<BEClassFile> classfiles = new ArrayList<BEClassFile>();
		File folder = new File("bytecode");
		ArrayList<LamBase> lams = new ArrayList<LamBase>();
		Environment environment;
		LinkedHashMap<String, LinkedHashMap<String, String>> fields = new LinkedHashMap<String, LinkedHashMap<String,String>>(); 
		LinkedHashMap<String, String> method = new LinkedHashMap<String, String>(); 


		for ( File fileEntry : folder.listFiles()){

//			if(!fileEntry.getName().contains("Esempio")) continue;
			if(fileEntry.getName().contains("Deadlock")) continue;

			FileInputStream in = new FileInputStream(fileEntry);
			ANTLRInputStream input = new ANTLRInputStream(in);
			BytecodeLexer lexer = new BytecodeLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			BytecodeParser parser = new BytecodeParser(tokens);
			ParseTree tree = parser.classfile();

			BytecodeVisitor bcVisitor = new BytecodeVisitor();
			classfiles.add((BEClassFile) bcVisitor.visit(tree));
		}

		for(BEClassFile cf : classfiles){
			String className="";
			String nameAndType="";
			String fieldName = "";
			String type="";
			LinkedHashMap<String, String> fieldNameAndTypes = new LinkedHashMap<String, String>();;
			HashMap<String, BEConstantAndInfo> tableEntries = cf.getCostantPool().getTableEntries().getTableEntry();
			for (Map.Entry<String, BEConstantAndInfo> entry : tableEntries.entrySet()){
				ArrayList<String> a = entry.getValue().getConstantAndInfo();
				if(a.get(0).contentEquals("Fieldref")){
					className = BEConstantPool.takeCpoolRef( cf.getCostantPool(), a.get(1));
					nameAndType = BEConstantPool.takeCpoolRef( cf.getCostantPool(), a.get(2));
					type = nameAndType.substring(0, nameAndType.indexOf(" "));
					fieldName = nameAndType.substring(nameAndType.lastIndexOf(" ")+1);
					fieldNameAndTypes.put(fieldName, type);
				}
			}
			fields.put(className, fieldNameAndTypes);
		}
		
		for(BEClassFile cf : classfiles){
			String className="";
			String nameAndType="";
			String methodName = "";
			String type="";
			String methodNameAndTypes = "";
			HashMap<String, BEConstantAndInfo> tableEntries = cf.getCostantPool().getTableEntries().getTableEntry();
			for (Map.Entry<String, BEConstantAndInfo> entry : tableEntries.entrySet()){
				ArrayList<String> a = entry.getValue().getConstantAndInfo();
				if(a.get(0).contentEquals("Methodref")){
					className = BEConstantPool.takeCpoolRef( cf.getCostantPool(), a.get(1));
					nameAndType = BEConstantPool.takeCpoolRef( cf.getCostantPool(), a.get(2));
					type = nameAndType.substring(0, nameAndType.indexOf(" "));
					methodName = nameAndType.substring(nameAndType.lastIndexOf(" ")+1);
					//System.out.println(className+"."+methodName);
					//System.out.println(className+"."+methodName+""+type);
					//TODO questa mappa mi serve per prendere i riferimenti dei metodi nell'invoke
					//e aggiungere i parametri ricorsivamente
					methodNameAndTypes = className+"."+methodName+""+type;
				}
			}
			method.put(className, methodNameAndTypes);
		}

		for(BEClassFile cf : classfiles){
			environment = new Environment(method,fields , cf.getCostantPool(),cf.getClassName());
			lams.add(cf.generateLam(environment));
		}

	}
}
