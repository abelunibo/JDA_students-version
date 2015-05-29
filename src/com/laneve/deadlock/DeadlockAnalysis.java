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
import com.laneve.deadlock.models.lam.LamClass;
import com.laneve.deadlock.type.TypeObject;
import com.laneve.deadlock.utilities.ConsoleFormatter;
import com.laneve.deadlock.utilities.LamsFileFormatter;
import com.laneve.deadlock.visitor.BytecodeVisitor;

public class DeadlockAnalysis {
	
	private static Logger FILELOGGER = Logger.getLogger("lams_log");

	public static void main(String[] args) throws IOException{
		
		/* log configuration */
		Logger rootLog = Logger.getLogger("");
		rootLog.setLevel(Level.ALL);

		Handler handler = rootLog.getHandlers()[0];
		handler.setFormatter(new ConsoleFormatter());
		
		FILELOGGER.setLevel(Level.INFO);
		FileHandler hand;
		
		//TODO se la cartella 'output' non esiste il FileHandler non la crea (fare un controllo e crearla prima)
		hand = new FileHandler("output/lams_log_file.txt");
		hand.setFormatter(new LamsFileFormatter());
		FILELOGGER.setUseParentHandlers(false);
		FILELOGGER.addHandler(hand);

		ArrayList<BEClassFile> classfiles = new ArrayList<BEClassFile>();
		//TODO ottenere direttamente i file .txt da cartella bytecode java
		File folder = new File("bytecode"); //cartella in cui e' contenuto il nostro bytecode
		ArrayList<LamBase> lams = new ArrayList<LamBase>(); //insieme delle Lam
		Environment environment;
		LinkedHashMap<String, LinkedHashMap<String, String>> fields = new LinkedHashMap<String, LinkedHashMap<String,String>>(); 
		//LinkedHashMap<String, String> method = new LinkedHashMap<String, String>(); 

		for ( File fileEntry : folder.listFiles()){

			if(fileEntry.getName().contains("Dining")) continue;
		//	if(fileEntry.getName().contains("Pluto")) continue;
		//	if(fileEntry.getName().contains("Pippo")) continue;
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

		for(BEClassFile cf : classfiles){ //creiamo dalla constant Pool la mappa <NomeClasse, <nomeCampo, tipoCampo>>
			String className="",nameAndType="",fieldName = "",type="";
			LinkedHashMap<String, String> fieldNameAndTypes = new LinkedHashMap<String, String>();;
			HashMap<String, BEConstantAndInfo> tableEntries = cf.getCostantPool().getTableEntries().getTableEntry();
			for (Map.Entry<String, BEConstantAndInfo> entry : tableEntries.entrySet()){
				ArrayList<String> a = entry.getValue().getConstantAndInfo();
				if(a.get(0).contentEquals("Fieldref")){
					className = BEConstantPool.takeCpoolRef( cf.getCostantPool(), a.get(1));
					nameAndType = BEConstantPool.takeCpoolRef( cf.getCostantPool(), a.get(2));
					type = nameAndType.substring(0, nameAndType.indexOf(" "));
					fieldName = nameAndType.substring(nameAndType.lastIndexOf(" ")+1);
					if(type.trim().startsWith("L")){
						type=type.substring(1);
						fieldNameAndTypes.put(fieldName, type);
					}
					else
						fieldNameAndTypes.put(fieldName, "int");
				}
			}
			fields.put(className, fieldNameAndTypes);
		}
		
		 
		  	//print di debug
		/*	for(Map.Entry<String, LinkedHashMap<String, String>> entry : fields.entrySet()){

		    	System.out.println("-----" + entry.getKey());
		    	
			    for(Map.Entry<String, String> entry2 : entry.getValue().entrySet()){

			    	if(entry2.getValue().equals("int"))
			    		System.out.println(entry2.getKey() + " "+ entry2.getValue());
			    	else
			    		System.out.println(entry2.getKey() + " "+ entry2.getValue());

			    	
			    }
		 }*/
		
		//creo gli oggetti per ogni classe //devono essere in comune per tutte le classi
		HashMap<String, TypeObject> classObjects= new HashMap<String, TypeObject>();
		for (Map.Entry<String, LinkedHashMap<String, String>> entry : fields.entrySet()){
			String key = entry.getKey();
			TypeObject t = new TypeObject(key,fields,true);
			if(classObjects.containsKey(key)){
				System.err.println("Ci sono due classi con lo stesso nome nella mappa fields");
				System.exit(1);
			}
			classObjects.put(entry.getKey(), t);
		}		
		
		for(BEClassFile cf : classfiles){
			environment = new Environment(fields , cf.getCostantPool(),cf.getClassName(),classObjects);
			LamClass lam= (LamClass) cf.generateLam(environment); //contiene le Lam per tutti i metodi
			lams.add(lam); //lams alla fine sara' un insieme di LamClass
			
			String s = lam.simplify().toString();
			
			//creo il file delle lam per il tool DF4ABS			
			String cleanedLam = LamBase.cleanLamString(s);
			if(TypeObject.FLATTEN){
				FILELOGGER.info(cleanedLam+"\n");
			}else FILELOGGER.info(s+"\n");
			
		}		
		
	}
}
