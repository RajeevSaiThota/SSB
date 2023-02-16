package com.sslweb.automation.util.exceptions;

/**
 * 
 * @author sairam.p
 *
 */
public class AccountException extends ShoppersStopBusinessException {
	
	private static final long serialVersionUID = 1L;

	public AccountException() {
		super();
	}

	public AccountException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountException(String message) {
		super(message);
	}

	public AccountException(Throwable cause) {
		super(cause);
	}
}
