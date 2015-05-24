package com.laneve.deadlock;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.laneve.bytecode.parser.BytecodeLexer;
import com.laneve.bytecode.parser.BytecodeParser;
import com.laneve.deadlock.models.BEClassFile;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.visitor.BytecodeVisitor;
import com.laneve.deadlock.utilities.MyFormatter;

public class DeadlockAnalysis {

	public static void main(String[] args) throws IOException{
		//root log configuration
		Logger rootLog = Logger.getLogger("");
		rootLog.setLevel(Level.INFO);
		Handler handler = rootLog.getHandlers()[0];
		handler.setFormatter(new MyFormatter());
		
		ArrayList<BEClassFile> classfiles = new ArrayList<BEClassFile>();
		File folder = new File("bytecode");
		ArrayList<LamBase> lams = new ArrayList<LamBase>();
		Environment environment;
		
		for ( File fileEntry : folder.listFiles()){
			
			if(fileEntry.getName().contains("Deadlock_")) continue;
			if(fileEntry.getName().contains("Pluto1")) continue;
			if(fileEntry.getName().contains("Pluto2")) continue;
			if(fileEntry.getName().contains("Pippo")) continue;
			
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
			environment = new Environment(cf.getCostantPool(),cf.getClassName());
			lams.add(cf.generateLam(environment));
		}
		
		//DataStructuresDebug.printDataStructures(classfiles);
		//DataStructuresDebug.printDataMethods(classfiles);
		//DataStructuresDebug.printGenerateLams(lams);
	}
}
