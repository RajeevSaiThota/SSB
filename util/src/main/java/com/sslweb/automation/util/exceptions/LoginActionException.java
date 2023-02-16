package com.sslweb.automation.util.exceptions;

/**
 * 
 * @author sairam.p
 *
 */
public class LoginActionException extends ShoppersStopBusinessException {

	private static final long serialVersionUID = 1L;

	public LoginActionException() {
		super();
	}

	public LoginActionException(String message, Throwable cause) { super(message, cause); }

	public LoginActionException(String message) { super(message); }

	public LoginActionException(Throwable cause) { super(cause); }

}
