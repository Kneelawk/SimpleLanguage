package com.github.kneelawk.simplelanguage.language;

import org.apache.commons.math3.complex.Complex;
import org.objectweb.asm.MethodVisitor;

public abstract class ASTExpression {
	protected Location location;

	public abstract void validate(ValidationContext ctx) throws ValidationException;

	public abstract Complex run(RuntimeContext ctx) throws ProgramRuntimeException;

	public abstract void serialize(SerializationContext ctx, MethodVisitor mv);

	public abstract void print(StringBuilder sb, int indent);

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
