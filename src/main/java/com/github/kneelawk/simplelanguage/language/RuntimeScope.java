package com.github.kneelawk.simplelanguage.language;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

import org.apache.commons.math3.complex.Complex;

public class RuntimeScope {
	private Deque<RuntimeScopeInstance> instances = new ArrayDeque<>();

	public RuntimeScope() {
		instances.push(new RuntimeScopeInstance());
	}

	public void push() {
		instances.push(new RuntimeScopeInstance());
	}

	public void pop(Location location) throws ProgramRuntimeException {
		if (instances.size() <= 1) {
			throw new ProgramRuntimeException("Scope Instance Stack underflow", location);
		}

		instances.pop();
	}

	public void defineVariable(String name, Complex value) {
		instances.peek().defineVariable(name, value);
	}

	public boolean isVariableDefined(String name) {
		return instances.stream().anyMatch(i -> i.isVariableDefined(name));
	}

	public boolean isTopVariableDefined(String name) {
		return instances.peek().isVariableDefined(name);
	}

	public void setVariable(String name, Complex value, Location location) throws ProgramRuntimeException {
		for (var it = instances.iterator(); it.hasNext();) {
			RuntimeScopeInstance instance = it.next();
			if (instance.isVariableDefined(name)) {
				instance.setVariable(name, value, location);
			}
		}

		throw new ProgramRuntimeException("Variable " + name + " not defined", location);
	}

	public Complex getVariable(String name) {
		for (var it = instances.iterator(); it.hasNext();) {
			RuntimeScopeInstance instance = it.next();
			if (instance.isVariableDefined(name)) {
				return instance.getVariable(name);
			}
		}

		return null;
	}

	public RuntimeScope makeReferringCopy() {
		RuntimeScope newScope = new RuntimeScope();
		newScope.instances.addAll(instances.stream().map(i -> i.makeReferingCopy()).collect(Collectors.toList()));
		return newScope;
	}
}
