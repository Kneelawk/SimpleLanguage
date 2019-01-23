package com.github.kneelawk.simplelanguage.utils;

public class StringUtils {
	public static final String INDENT_STRING = "  ";

	public static void indent(StringBuilder sb, int indent) {
		for (int i = 0; i < indent; i++) {
			sb.append(INDENT_STRING);
		}
	}
}
