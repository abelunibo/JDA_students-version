package com.laneve.deadlock.visitor;
import java.util.ArrayList;
import java.util.LinkedList;

import org.antlr.v4.runtime.misc.NotNull;

import com.laneve.bytecode.parser.BytecodeBaseVisitor;
import com.laneve.bytecode.parser.BytecodeParser;
import com.laneve.bytecode.parser.BytecodeParser.FormalParameterContext;
import com.laneve.bytecode.parser.BytecodeParser.InstructionContext;
import com.laneve.bytecode.parser.BytecodeParser.MethodDeclarationContext;
import com.laneve.bytecode.parser.BytecodeParser.MethodModifierContext;
import com.laneve.bytecode.parser.BytecodeParser.RefContext;
import com.laneve.bytecode.parser.BytecodeParser.TableEntryContext;
import com.laneve.deadlock.models.BEBase;
import com.laneve.deadlock.models.BEClassFile;
import com.laneve.deadlock.models.BEConstantAndInfo;
import com.laneve.deadlock.models.BEConstantPool;
import com.laneve.deadlock.models.BEInstruction;
import com.laneve.deadlock.models.BEMethodBody;
import com.laneve.deadlock.models.BEMethodDeclaration;
import com.laneve.deadlock.models.BEMethodDeclarator;
import com.laneve.deadlock.models.BEMethodHeader;
import com.laneve.deadlock.models.BEMethodModifier;
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
			BEMethodDeclaration methodDec = (BEMethodDeclaration) visitMethodDeclaration(mdc);
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
		BERef ref = null;
		if(!(ctx == null))
			ref = new BERef(ctx.getText());
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

	@Override 
	public BEBase visitMethodDeclaration(@NotNull BytecodeParser.MethodDeclarationContext ctx) { 
		BEMethodDeclaration methodDeclaration;
		BEMethodModifier methodModifier = new BEMethodModifier("");;
		BEMethodBody methodBody;
		BEMethodHeader methodHeader;

		for(MethodModifierContext m : ctx.methodModifier()){
			BEMethodModifier modifier = (BEMethodModifier)visitMethodModifier(m);
			if(modifier.getModifier().contentEquals("syncronized"))
				methodModifier = modifier;

		}
		methodHeader = (BEMethodHeader) visitMethodHeader(ctx.methodHeader());
		methodBody = (BEMethodBody) visitMethodBody(ctx.methodBody());
		methodDeclaration = new BEMethodDeclaration(methodModifier, methodHeader, methodBody);

		return methodDeclaration;
	}

	@Override public BEBase visitMethodBody(@NotNull BytecodeParser.MethodBodyContext ctx) {
		BEMethodBody methodBody;
		LinkedList<BEInstruction> instruction = new LinkedList<BEInstruction>();
		for(InstructionContext i : ctx.instructions().instruction()){
			instruction.add((BEInstruction) visitInstruction(i)); 
		}
		methodBody = new BEMethodBody(instruction);
		return methodBody; 
	}

	@Override public BEBase visitInstruction(@NotNull BytecodeParser.InstructionContext ctx) { 
		BERef ref = (BERef) visitRef(ctx.ref());
		BEInstruction instruction = new BEInstruction(ctx.getChild(0).getText(), ctx.getChild(1).getText(), ref);

		return instruction;
	}


	@Override public BEBase visitMethodModifier(@NotNull BytecodeParser.MethodModifierContext ctx) {
		BEMethodModifier modifier = new BEMethodModifier(ctx.getText());
		return modifier; 
	}

	@Override public BEBase visitMethodHeader(@NotNull BytecodeParser.MethodHeaderContext ctx) { 
		BEMethodHeader methodHeader;
		String result = null;
		BEMethodDeclarator methodDeclarator = (BEMethodDeclarator) visitMethodDeclarator(ctx.methodDeclarator());
		if(ctx.result() == null)
			result = "void";
		else result = ctx.result().getText();

		methodHeader = new BEMethodHeader(result,methodDeclarator);
		return methodHeader;
	}

	@Override public BEBase visitMethodDeclarator(@NotNull BytecodeParser.MethodDeclaratorContext ctx) { 
		BEMethodDeclarator methodDeclarator;
		ArrayList<FormalParameterContext> formalParameters = new ArrayList<BytecodeParser.FormalParameterContext>();
		if(!(ctx.formalParameters() == null)){
			for(FormalParameterContext f : ctx.formalParameters().formalParameter()){
				formalParameters.add(f);
			}
		}
		methodDeclarator = new BEMethodDeclarator(ctx.methodName().packageAndClassName().getText(), formalParameters);

		return methodDeclarator; 
	}

}
