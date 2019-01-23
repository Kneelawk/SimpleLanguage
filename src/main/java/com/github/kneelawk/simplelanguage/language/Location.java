package com.github.kneelawk.simplelanguage.language;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

public class Location {
	private String text;
	private int startLine = -1;
	private int endLine = -1;
	private int startCharInLine = -1;
	private int endCharInLine = -1;

	public Location(String text) {
		this.text = text;
	}

	public Location(String text, int startLine, int endLine, int startCharInLine, int endCharInLine) {
		this.text = text;
		this.startLine = startLine;
		this.endLine = endLine;
		this.startCharInLine = startCharInLine;
		this.endCharInLine = endCharInLine;
	}

	public Location(ParseTree tree) {
		if (tree instanceof ParserRuleContext) {
			ParserRuleContext ctx = (ParserRuleContext) tree;
			Token start = ctx.getStart();
			Token end = ctx.getStop();
			startLine = start.getLine();
			endLine = end.getLine();
			startCharInLine = start.getCharPositionInLine();
			endCharInLine = end.getCharPositionInLine();
		}
		text = tree.getText();
	}

	public Location(Token token) {
		startLine = endLine = token.getLine();
		startCharInLine = endCharInLine = token.getCharPositionInLine();
		text = token.getText();
	}

	public String getText() {
		return text;
	}

	public int getStartLine() {
		return startLine;
	}

	public int getEndLine() {
		return endLine;
	}

	public int getStartCharInLine() {
		return startCharInLine;
	}

	public int getEndCharInLine() {
		return endCharInLine;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (startLine == -1) {
			if (startLine == endLine) {
				sb.append(startLine).append(':');
				if (startCharInLine == endCharInLine) {
					sb.append(startCharInLine);
				} else {
					sb.append(startCharInLine).append('-').append(endCharInLine);
				}
			} else {
				sb.append(startLine).append(':').append(startCharInLine).append('-').append(endLine).append(':')
						.append(endCharInLine);
			}
			sb.append(' ');
		}
		if (text != null && !"".equals(text)) {
			sb.append('(');
			if (text.length() > 30) {
				sb.append(text.substring(0, 30)).append("...");
			} else {
				sb.append(text);
			}
			sb.append(')');
		}
		return sb.toString();
	}
}
