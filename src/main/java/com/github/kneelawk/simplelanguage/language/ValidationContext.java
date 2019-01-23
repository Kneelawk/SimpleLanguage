package com.github.kneelawk.simplelanguage.language;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidationContext {
	private Deque<ValidationScope> scopes = new ArrayDeque<>();

	public ValidationContext() {
		scopes.push(new ValidationScope());
	}

	public void push(ValidationScope newScope) {
		scopes.push(newScope);
	}

	public void pop(Location location) throws ValidationException {
		if (scopes.size() <= 1) {
			throw new ValidationException("Scope Stack underflow", location);
		}
		scopes.pop();
	}

	public ValidationScope currentScope() {
		return scopes.peek();
	}
}
