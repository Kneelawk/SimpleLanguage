grammar SimpleLanguageSystem;

@header {
	package com.github.kneelawk.simplelanguage.language;
}

program
:
	line
	(
		SEPERATOR line
	)* SEPERATOR?
;

line
:
	expression
;

expression
:
	unary_expression
	| parenthesis_expression
	| number
	| variable
	| declaration
	| assignment
	| binary_expression
;

binary_expression
:
	(
		binary_operand OPERATOR
	)+ binary_operand
;

binary_operand
:
	unary_expression
	| parenthesis_expression
	| number
	| variable
	| declaration
	| assignment
;

unary_expression
:
	OPERATOR expression
;

parenthesis_expression
:
	OPEN_PARENTHESIS expression CLOSE_PARENTHESIS
;

number
:
	NUMBER
;

variable
:
	STRING
;

declaration
:
	VAR STRING EQUALS expression
;

assignment
:
	STRING EQUALS expression
;

OPEN_PARENTHESIS
:
	'('
;

CLOSE_PARENTHESIS
:
	')'
;

EQUALS
:
	'='
;

VAR
:
	'var'
;

SEPERATOR
:
	';'
;

OPERATOR
:
	[+\-*/^]
;

NUMBER
:
	(
		DIGIT+
		| DIGIT* '.' DIGIT+
	) 'i'?
;

fragment
DIGIT
:
	[0-9]
;

STRING
:
	[a-zA-Z] [a-zA-Z0-9]*
;

COMMENT
:
	'#' ~[\n\r]* -> skip
;

WHITESPACE
:
	[ \t\r\n] -> skip
;