package com.github.kneelawk.simplelanguage.language;

import org.apache.commons.math3.complex.Complex;
import org.objectweb.asm.MethodVisitor;

public class ASTVariable extends ASTExpression {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void validate(ValidationContext ctx) throws ValidationException {
		if (!ctx.currentScope().isVariableDefined(name)) {
			throw new ValidationException("Variable '" + name + "' is not defined", location);
		}
	}

	@Override
	public Complex run(RuntimeContext ctx) throws ProgramRuntimeException {
		return ctx.currentScope().getVariable(name);
	}

	@Override
	public void serialize(SerializationContext ctx, MethodVisitor mv) {

	}

	@Override
	public void print(StringBuilder sb, int indent) {
		sb.append("Variable(\"").append(name).append("\")");
	}

}
