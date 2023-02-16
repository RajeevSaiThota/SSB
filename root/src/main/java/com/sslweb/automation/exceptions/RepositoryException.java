package com.sslweb.automation.exceptions;

import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;

/**
 * 
 * @author sairam.p
 *
 */
public class RepositoryException extends ShoppersStopBusinessException {

	private static final long serialVersionUID = 1L;

	public RepositoryException() {}

	public RepositoryException(String message) { super(message);}

	public RepositoryException(Throwable cause) { super(cause); }

	public RepositoryException(String message, Throwable cause) { super(message, cause); }

}
