package com.laneve.deadlock;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.laneve.bytecode.parser.BytecodeLexer;
import com.laneve.bytecode.parser.BytecodeParser;
import com.laneve.deadlock.models.BEBase;
import com.laneve.deadlock.visitor.BytecodeVisitor;

public class Test {

	final static File folder = new File("bytecode");

	public static void main(String[] args) throws IOException{
		File folder = new File("bytecode");
		LamBytecode lam = new LamBytecode();

		for ( File fileEntry : folder.listFiles()){
			
			FileInputStream in = new FileInputStream(fileEntry);
			ANTLRInputStream input = new ANTLRInputStream(in);
			BytecodeLexer lexer = new BytecodeLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			BytecodeParser parser = new BytecodeParser(tokens);
			ParseTree tree = parser.classfile();
			
			BytecodeVisitor bcVisitor = new BytecodeVisitor();
			BEBase o = bcVisitor.visit(tree);
			//System.out.println(o.getName());
			
			//bytecodevisitor visit(parser.classfile()); ritorna un classfileinfo 
			//devo tenermi in memoria la struttura dati del mio classfile
//			ParseTreeWalker walker = new ParseTreeWalker();
//			walker.walk(lam, tree);
		}
		//lam.printCpool();
		//lam.printMethod();
	}
}
