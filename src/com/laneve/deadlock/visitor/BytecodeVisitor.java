package com.laneve.deadlock.visitor;
import java.util.ArrayList;
import java.util.LinkedList;

import org.antlr.v4.runtime.misc.NotNull;

import com.laneve.bytecode.parser.BytecodeBaseVisitor;
import com.laneve.bytecode.parser.BytecodeParser;
import com.laneve.bytecode.parser.BytecodeParser.MethodDeclarationContext;
import com.laneve.bytecode.parser.BytecodeParser.RefContext;
import com.laneve.bytecode.parser.BytecodeParser.TableEntryContext;
import com.laneve.deadlock.models.BEBase;
import com.laneve.deadlock.models.BEClassFile;
import com.laneve.deadlock.models.BEConstantAndInfo;
import com.laneve.deadlock.models.BEConstantPool;
import com.laneve.deadlock.models.BEMethodDec;
import com.laneve.deadlock.models.BERef;
import com.laneve.deadlock.models.BETableEntries;
import com.laneve.deadlock.models.BETableEntry;

public class BytecodeVisitor extends BytecodeBaseVisitor<BEBase> {


	@Override 
	public BEBase visitClassfile(@NotNull BytecodeParser.ClassfileContext ctx) {
		BEClassFile classFile;
		BEConstantPool costantPool;

		String className = ctx.classDec().ilmio.getText();
		costantPool = (BEConstantPool) visitConstantPool(ctx.constantPool());

		classFile = new BEClassFile(className,costantPool);

		for(MethodDeclarationContext mdc : ctx.methodDeclaration()){
			BEMethodDec methodDec = (BEMethodDec) visitMethodDeclaration(mdc);
			classFile.addMethod(methodDec);
		}

		return classFile;
	}

	@Override 
	public BEBase visitClassDec(@NotNull BytecodeParser.ClassDecContext ctx) { 
		return visitChildren(ctx); 
	}

	@Override 
	public BEBase visitConstantPool(@NotNull BytecodeParser.ConstantPoolContext ctx) { 
		BETableEntries tableEntries;
		BEConstantPool constantPool; 
		tableEntries = (BETableEntries) visitTableEntries(ctx.tableEntries());
		constantPool = new BEConstantPool(tableEntries);
		return constantPool;

	}

	@Override
	public BEBase visitTableEntries(@NotNull BytecodeParser.TableEntriesContext ctx) { 
		BETableEntries tableEntries = new BETableEntries() ;

		for(TableEntryContext tb : ctx.tableEntry()){
			BETableEntry tableEntry = (BETableEntry) visitTableEntry(tb);
			tableEntries.addTableEntry(tableEntry);
		}
		return tableEntries; 
	}

	@Override
	public BEBase visitTableEntry(@NotNull BytecodeParser.TableEntryContext ctx) { 
		BERef ref = (BERef) visitRef(ctx.ref());
		BEConstantAndInfo costantAndInfo = (BEConstantAndInfo) visitConstantAndInfo(ctx.constantAndInfo());
		BETableEntry tableEntry = new BETableEntry(ref, costantAndInfo);
		return tableEntry; 
	}

	@Override
	public BEBase visitRef(@NotNull BytecodeParser.RefContext ctx) { 
		BERef ref = new BERef(ctx.getText());
		return ref;
	}

	@Override
	public BEBase visitConstantAndInfo(@NotNull BytecodeParser.ConstantAndInfoContext ctx) { 
		ArrayList<String> c = new ArrayList<String>();
		String type = ctx.getChild(0).getText();
		c.add(type);

		if(!type.contentEquals("Utf8")){
			for(RefContext r : ctx.ref()){
				BERef ref = (BERef) visitRef(r);
				c.add(ref.getRef());
			}
		}else{
			String utf8 = ctx.getText();
			int n = utf8.indexOf('8');
			String utf8Ref = utf8.subSequence(n+1, utf8.length()).toString();
			c.add(utf8Ref);
		}

		BEConstantAndInfo costantAndInfo = new BEConstantAndInfo(c);
		return costantAndInfo;
	}

	//TODO dobbiamo prendere il return dei metodi 
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

			//TODO forse serve per recuperare il return nella costant pool
			//			if(ctx.methodBody().instructions().getChild(j).getText().contains("invokespecial")||
			//					ctx.methodBody().instructions().getChild(j).getText().contains("invokevirtual")){

			String is = ctx.methodBody().instructions().getChild(j).getText();
			//				System.out.println(is);

			//				int n = is.indexOf('#');
			//				String ref = is.substring(n, is.length());

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
		//}

		//System.out.println(ctx.getText());
		return null;
		//return visitChildren(ctx);
	}

}
