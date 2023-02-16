package com.sslweb.automation.util.exceptions;

import org.apache.log4j.Logger;

import com.sslweb.automation.util.PropertyUtil;

/**
 * 
 * @author sairam.p
 *
 */
public class ShoppersStopBusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger(ShoppersStopBusinessException.class);
	protected static final boolean LOG_ENABLED = PropertyUtil.getBoolean("exception-context.logging.enabled", true);
	
	public ShoppersStopBusinessException() {
		//This is a non parameterized constructor
	}

	public ShoppersStopBusinessException(String message) {
		super(message);
		if(LOG_ENABLED) {
			LOG.error(message);
		}
	}

	public ShoppersStopBusinessException(Throwable cause) {
		this(cause.getMessage());
		if(LOG_ENABLED) {
			LOG.error(cause);
		}
	}

	public ShoppersStopBusinessException(String message, Throwable cause) {
		this(message);
		if(LOG_ENABLED) {
			LOG.error(message,cause);
		}
	}
}
