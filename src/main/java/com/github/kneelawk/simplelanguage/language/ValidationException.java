package com.github.kneelawk.simplelanguage.language;

public class ValidationException extends LanguageException {
	private static final long serialVersionUID = 1018308924562309962L;

	private Location location;

	public ValidationException(Location location) {
		this.location = location;
	}

	public ValidationException(String message, Location location) {
		super(message);
		this.location = location;
	}

	public ValidationException(Throwable cause, Location location) {
		super(cause);
		this.location = location;
	}

	public ValidationException(String message, Throwable cause, Location location) {
		super(message, cause);
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}
}
