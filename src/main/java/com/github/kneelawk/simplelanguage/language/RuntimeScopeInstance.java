package com.github.kneelawk.simplelanguage.language;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.math3.complex.Complex;

public class RuntimeScopeInstance {
	private Map<String, ComplexWrapper> variables = new HashMap<>();

	public void defineVariable(String name, Complex value) {
		variables.put(name, new ComplexWrapper(value));
	}

	public void setVariable(String name, Complex value, Location location) throws ProgramRuntimeException {
		ComplexWrapper wrapper = variables.get(name);
		if (wrapper == null) {
			throw new ProgramRuntimeException("Variable " + name + " not defined", location);
		}
		wrapper.setValue(value);
	}

	public boolean isVariableDefined(String name) {
		return variables.containsKey(name);
	}

	public Complex getVariable(String name) {
		return variables.get(name).getValue();
	}

	public RuntimeScopeInstance makeReferingCopy() {
		RuntimeScopeInstance newInstance = new RuntimeScopeInstance();
		newInstance.variables.putAll(variables);
		return newInstance;
	}
}
