package com.github.kneelawk.simplelanguage.language;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidationScope {
	private Deque<ValidationScopeInstance> instances = new ArrayDeque<>();

	public ValidationScope() {
		instances.push(new ValidationScopeInstance());
	}

	public void push() {
		instances.push(new ValidationScopeInstance());
	}

	public void pop(Location location) throws ValidationException {
		if (instances.size() <= 1) {
			throw new ValidationException("Scope Instance Stack underflow", location);
		}

		instances.pop();
	}

	public void defineVariable(String name) {
		instances.peek().defineVariable(name);
	}

	public boolean isVariableDefined(String name) {
		return instances.stream().anyMatch(i -> i.isVariableDefined(name));
	}

	public boolean isTopVariableDefined(String name) {
		return instances.peek().isVariableDefined(name);
	}
}
