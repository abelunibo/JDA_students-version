// Generated from Bytecode.g4 by ANTLR 4.4
package com.laneve.bytecode.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BytecodeParser}.
 */
public interface BytecodeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#classfile}.
	 * @param ctx the parse tree
	 */
	void enterClassfile(@NotNull BytecodeParser.ClassfileContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#classfile}.
	 * @param ctx the parse tree
	 */
	void exitClassfile(@NotNull BytecodeParser.ClassfileContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void enterExceptionType(@NotNull BytecodeParser.ExceptionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void exitExceptionType(@NotNull BytecodeParser.ExceptionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterInstructions(@NotNull BytecodeParser.InstructionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitInstructions(@NotNull BytecodeParser.InstructionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(@NotNull BytecodeParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(@NotNull BytecodeParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(@NotNull BytecodeParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(@NotNull BytecodeParser.FieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void enterExceptionTypeList(@NotNull BytecodeParser.ExceptionTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void exitExceptionTypeList(@NotNull BytecodeParser.ExceptionTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(@NotNull BytecodeParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(@NotNull BytecodeParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassModifier(@NotNull BytecodeParser.ClassModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassModifier(@NotNull BytecodeParser.ClassModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#packageAndClassName}.
	 * @param ctx the parse tree
	 */
	void enterPackageAndClassName(@NotNull BytecodeParser.PackageAndClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#packageAndClassName}.
	 * @param ctx the parse tree
	 */
	void exitPackageAndClassName(@NotNull BytecodeParser.PackageAndClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclarator(@NotNull BytecodeParser.MethodDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclarator(@NotNull BytecodeParser.MethodDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#num}.
	 * @param ctx the parse tree
	 */
	void enterNum(@NotNull BytecodeParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#num}.
	 * @param ctx the parse tree
	 */
	void exitNum(@NotNull BytecodeParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#referenceType}.
	 * @param ctx the parse tree
	 */
	void enterReferenceType(@NotNull BytecodeParser.ReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#referenceType}.
	 * @param ctx the parse tree
	 */
	void exitReferenceType(@NotNull BytecodeParser.ReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#innerClass}.
	 * @param ctx the parse tree
	 */
	void enterInnerClass(@NotNull BytecodeParser.InnerClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#innerClass}.
	 * @param ctx the parse tree
	 */
	void exitInnerClass(@NotNull BytecodeParser.InnerClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#constantPool}.
	 * @param ctx the parse tree
	 */
	void enterConstantPool(@NotNull BytecodeParser.ConstantPoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#constantPool}.
	 * @param ctx the parse tree
	 */
	void exitConstantPool(@NotNull BytecodeParser.ConstantPoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull BytecodeParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull BytecodeParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#result}.
	 * @param ctx the parse tree
	 */
	void enterResult(@NotNull BytecodeParser.ResultContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#result}.
	 * @param ctx the parse tree
	 */
	void exitResult(@NotNull BytecodeParser.ResultContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#ref}.
	 * @param ctx the parse tree
	 */
	void enterRef(@NotNull BytecodeParser.RefContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#ref}.
	 * @param ctx the parse tree
	 */
	void exitRef(@NotNull BytecodeParser.RefContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void enterMethodHeader(@NotNull BytecodeParser.MethodHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void exitMethodHeader(@NotNull BytecodeParser.MethodHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#identifierExtended}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExtended(@NotNull BytecodeParser.IdentifierExtendedContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#identifierExtended}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExtended(@NotNull BytecodeParser.IdentifierExtendedContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void enterFieldModifier(@NotNull BytecodeParser.FieldModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void exitFieldModifier(@NotNull BytecodeParser.FieldModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#methodModifier}.
	 * @param ctx the parse tree
	 */
	void enterMethodModifier(@NotNull BytecodeParser.MethodModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#methodModifier}.
	 * @param ctx the parse tree
	 */
	void exitMethodModifier(@NotNull BytecodeParser.MethodModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(@NotNull BytecodeParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(@NotNull BytecodeParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(@NotNull BytecodeParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(@NotNull BytecodeParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void enterFloatingPointType(@NotNull BytecodeParser.FloatingPointTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void exitFloatingPointType(@NotNull BytecodeParser.FloatingPointTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#tableEntry}.
	 * @param ctx the parse tree
	 */
	void enterTableEntry(@NotNull BytecodeParser.TableEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#tableEntry}.
	 * @param ctx the parse tree
	 */
	void exitTableEntry(@NotNull BytecodeParser.TableEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(@NotNull BytecodeParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(@NotNull BytecodeParser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#integralType}.
	 * @param ctx the parse tree
	 */
	void enterIntegralType(@NotNull BytecodeParser.IntegralTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#integralType}.
	 * @param ctx the parse tree
	 */
	void exitIntegralType(@NotNull BytecodeParser.IntegralTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#classDec}.
	 * @param ctx the parse tree
	 */
	void enterClassDec(@NotNull BytecodeParser.ClassDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#classDec}.
	 * @param ctx the parse tree
	 */
	void exitClassDec(@NotNull BytecodeParser.ClassDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#constantAndInfo}.
	 * @param ctx the parse tree
	 */
	void enterConstantAndInfo(@NotNull BytecodeParser.ConstantAndInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#constantAndInfo}.
	 * @param ctx the parse tree
	 */
	void exitConstantAndInfo(@NotNull BytecodeParser.ConstantAndInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#tableEntries}.
	 * @param ctx the parse tree
	 */
	void enterTableEntries(@NotNull BytecodeParser.TableEntriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#tableEntries}.
	 * @param ctx the parse tree
	 */
	void exitTableEntries(@NotNull BytecodeParser.TableEntriesContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(@NotNull BytecodeParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(@NotNull BytecodeParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#throws_}.
	 * @param ctx the parse tree
	 */
	void enterThrows_(@NotNull BytecodeParser.Throws_Context ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#throws_}.
	 * @param ctx the parse tree
	 */
	void exitThrows_(@NotNull BytecodeParser.Throws_Context ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#numericType}.
	 * @param ctx the parse tree
	 */
	void enterNumericType(@NotNull BytecodeParser.NumericTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#numericType}.
	 * @param ctx the parse tree
	 */
	void exitNumericType(@NotNull BytecodeParser.NumericTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(@NotNull BytecodeParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(@NotNull BytecodeParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link BytecodeParser#fields}.
	 * @param ctx the parse tree
	 */
	void enterFields(@NotNull BytecodeParser.FieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BytecodeParser#fields}.
	 * @param ctx the parse tree
	 */
	void exitFields(@NotNull BytecodeParser.FieldsContext ctx);
}