package com.github.kneelawk.simplelanguage.language;

public class LanguageException extends Exception {
	private static final long serialVersionUID = 2419680967150077539L;

	public LanguageException() {
	}

	public LanguageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LanguageException(String message, Throwable cause) {
		super(message, cause);
	}

	public LanguageException(String message) {
		super(message);
	}

	public LanguageException(Throwable cause) {
		super(cause);
	}

}
