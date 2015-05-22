package com.laneve.deadlock;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.laneve.bytecode.parser.BytecodeLexer;
import com.laneve.bytecode.parser.BytecodeParser;
import com.laneve.deadlock.models.BEClassFile;
import com.laneve.deadlock.models.Environment;
import com.laneve.deadlock.models.lam.LamBase;
import com.laneve.deadlock.utilities.DataStructuresDebug;
import com.laneve.deadlock.visitor.BytecodeVisitor;

public class DeadlockAnalysis {

	public static void main(String[] args) throws IOException{
		ArrayList<BEClassFile> classfiles = new ArrayList<BEClassFile>();
		File folder = new File("bytecode");
		ArrayList<LamBase> lams = new ArrayList<LamBase>();
		Environment environment;
		
		for ( File fileEntry : folder.listFiles()){

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
			environment = new Environment(cf.getCostantPool());
			lams.add(cf.generateLam(environment));
		}
		
		//DataStructuresDebug.printDataStructures(classfiles);
		//DataStructuresDebug.printDataMethods(classfiles);
		DataStructuresDebug.printGenerateLams(lams);
	}
}
