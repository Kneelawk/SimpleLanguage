package com.github.kneelawk.simplelanguage.language;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.complex.Complex;
import org.objectweb.asm.MethodVisitor;

import com.github.kneelawk.simplelanguage.utils.StringUtils;

public class ASTBlock extends ASTExpression {

	private List<ASTExpression> expressions = new ArrayList<>();

	public void appendExpression(ASTExpression expression) {
		expressions.add(expression);
	}

	@Override
	public void validate(ValidationContext ctx) throws ValidationException {
		ValidationScope scope = ctx.currentScope();
		scope.push();
		for (ASTExpression expression : expressions) {
			expression.validate(ctx);
		}
		scope.pop(location);
	}

	@Override
	public Complex run(RuntimeContext ctx) throws ProgramRuntimeException {
		if (expressions.isEmpty()) {
			return Complex.ZERO;
		} else {
			RuntimeScope scope = ctx.currentScope();
			scope.push();
			int size = expressions.size() - 1;
			for (int i = 0; i < size; i++) {
				expressions.get(i).run(ctx);
			}
			Complex val = expressions.get(size).run(ctx);
			scope.pop(location);
			return val;
		}
	}

	@Override
	public void serialize(SerializationContext ctx, MethodVisitor mv) {
		// TODO Auto-generated method stub

	}

	@Override
	public void print(StringBuilder sb, int indent) {
		sb.append("Block(");
		if (!expressions.isEmpty()) {
			int size = expressions.size() - 1;
			for (int i = 0; i < size; i++) {
				StringUtils.indent(sb, indent + 1);
				expressions.get(i).print(sb, indent + 1);
				sb.append(",\n");
			}
			expressions.get(size).print(sb, indent + 1);
			sb.append("\n");
		}
		StringUtils.indent(sb, indent);
		sb.append(")");
	}

}
