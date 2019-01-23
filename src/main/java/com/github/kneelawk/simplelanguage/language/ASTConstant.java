package com.github.kneelawk.simplelanguage.language;

import org.apache.commons.math3.complex.Complex;
import org.objectweb.asm.MethodVisitor;
import static com.github.kneelawk.simplelanguage.utils.StringUtils.indent;

public class ASTConstant extends ASTExpression {

	private Complex value;

	@Override
	public void validate(ValidationContext ctx) throws ValidationException {
	}

	@Override
	public Complex run(RuntimeContext ctx) {
		return value;
	}

	@Override
	public void serialize(SerializationContext ctx, MethodVisitor mv) {

	}

	@Override
	public void print(StringBuilder sb, int indent) {
		indent(sb, indent);
		sb.append("Constant(");
		sb.append(value);
		sb.append(")");
	}

	public Complex getValue() {
		return value;
	}

	public void setValue(Complex value) {
		this.value = value;
	}

}
