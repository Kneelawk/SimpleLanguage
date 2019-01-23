package com.github.kneelawk.simplelanguage.language;

import org.apache.commons.math3.complex.Complex;

public class ComplexWrapper {
	private Complex value;

	public ComplexWrapper(Complex value) {
		this.value = value;
	}

	public Complex getValue() {
		return value;
	}

	public void setValue(Complex value) {
		this.value = value;
	}
}
