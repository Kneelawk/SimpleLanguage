package com.github.kneelawk.simplelanguage.language;

import java.util.ArrayDeque;
import java.util.Deque;

public class RuntimeContext {
	private Deque<RuntimeScope> scopes = new ArrayDeque<>();

	public RuntimeContext() {
		scopes.push(new RuntimeScope());
	}

	public void push(RuntimeScope newScope) {
		scopes.push(newScope);
	}

	public void pop(Location location) throws ProgramRuntimeException {
		if (scopes.size() <= 1) {
			throw new ProgramRuntimeException("Scope Stack underflow", location);
		}

		scopes.pop();
	}

	public RuntimeScope currentScope() {
		return scopes.peek();
	}
}
