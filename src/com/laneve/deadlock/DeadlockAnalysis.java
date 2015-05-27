package com.laneve.deadlock;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.FileHandler;
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
import com.laneve.deadlock.utilities.ConsoleFormatter;
import com.laneve.deadlock.utilities.LamsFileFormatter;
import com.laneve.deadlock.visitor.BytecodeVisitor;

public class DeadlockAnalysis {
	
	private static Logger FILELOGGER = Logger.getLogger("lams_log");

	public static void main(String[] args) throws IOException{
		
		/* log configuration */
		Logger rootLog = Logger.getLogger("");
		rootLog.setLevel(Level.INFO);
		Handler handler = rootLog.getHandlers()[0];
		handler.setFormatter(new ConsoleFormatter());
		
		FILELOGGER.setLevel(Level.INFO);
		FileHandler hand;
		hand = new FileHandler("lams_log_file.txt");
		hand.setFormatter(new LamsFileFormatter());
		Handler console = rootLog.getHandlers()[0];
		FILELOGGER.removeHandler(console);
		FILELOGGER.addHandler(hand);

		ArrayList<BEClassFile> classfiles = new ArrayList<BEClassFile>();
		File folder = new File("bytecode");
		ArrayList<LamBase> lams = new ArrayList<LamBase>();
		Environment environment;
		LinkedHashMap<String, LinkedHashMap<String, String>> fields = new LinkedHashMap<String, LinkedHashMap<String,String>>(); 

		for ( File fileEntry : folder.listFiles()){

			//if(fileEntry.getName().contains("Pluto")) continue;
			//if(fileEntry.getName().contains("Pippo")) continue;
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
			environment = new Environment(fields , cf.getCostantPool(),cf.getClassName());
			lams.add(cf.generateLam(environment));
		}

	}
}
