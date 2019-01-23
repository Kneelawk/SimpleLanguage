package com.github.kneelawk.simplelanguage.language;

public class ProgramRuntimeException extends LanguageException {
	private static final long serialVersionUID = 6005750948916114109L;

	private Location location;

	public ProgramRuntimeException(Location location) {
		this.location = location;
	}

	public ProgramRuntimeException(String message, Location location) {
		super(message);
		this.location = location;
	}

	public ProgramRuntimeException(Throwable cause, Location location) {
		super(cause);
		this.location = location;
	}

	public ProgramRuntimeException(String message, Throwable cause, Location location) {
		super(message, cause);
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}
}
