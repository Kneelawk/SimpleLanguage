package com.github.kneelawk.simplelanguage.language;

import java.util.Set;

import org.apache.commons.math3.complex.Complex;
import org.objectweb.asm.MethodVisitor;

import com.github.kneelawk.simplelanguage.utils.StringUtils;
import com.google.common.collect.ImmutableSet;

public class ASTBinaryOperation extends ASTExpression {

	private static final Set<String> LEGAL_OPERATIONS = ImmutableSet.of("+", "-", "*", "/", "^");

	private String operation;
	private ASTExpression left;
	private ASTExpression right;

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void setLeft(ASTExpression left) {
		this.left = left;
	}

	public void setRight(ASTExpression right) {
		this.right = right;
	}

	@Override
	public void validate(ValidationContext ctx) throws ValidationException {
		if (!LEGAL_OPERATIONS.contains(operation)) {
			throw new ValidationException("Unknown binary operation: " + operation, location);
		}

		left.validate(ctx);
		right.validate(ctx);
	}

	@Override
	public Complex run(RuntimeContext ctx) throws ProgramRuntimeException {
		Complex l = left.run(ctx);
		Complex r = right.run(ctx);

		switch (operation) {
		case "+":
			return l.add(r);
		case "-":
			return l.subtract(r);
		case "*":
			return l.multiply(r);
		case "/":
			return l.divide(r);
		case "^":
			return l.pow(r);
		}

		throw new ProgramRuntimeException("Unknown binary operation: " + operation, location);
	}

	@Override
	public void serialize(SerializationContext ctx, MethodVisitor mv) {
		// TODO Auto-generated method stub

	}

	@Override
	public void print(StringBuilder sb, int indent) {
		sb.append("Append(\n");
		StringUtils.indent(sb, indent + 1);
		left.print(sb, indent + 1);
		sb.append(",\n");
		StringUtils.indent(sb, indent + 1);
		right.print(sb, indent + 1);
		sb.append("\n");
		StringUtils.indent(sb, indent);
		sb.append(")");
	}

}
