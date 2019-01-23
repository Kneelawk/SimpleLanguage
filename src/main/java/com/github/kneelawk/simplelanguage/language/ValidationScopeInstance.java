package com.github.kneelawk.simplelanguage.language;

import java.util.HashSet;
import java.util.Set;

public class ValidationScopeInstance {
	private Set<String> variables = new HashSet<>();

	public void defineVariable(String name) {
		variables.add(name);
	}

	public boolean isVariableDefined(String name) {
		return variables.contains(name);
	}
}
