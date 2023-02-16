package com.sslweb.automation.test.handler;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.sslweb.automation.util.Assert;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;

/**
 * 
 * @author sairam.p
 *
 */
public abstract class GlobalExceptionHandler {

	private static final Set<String> PACKAGES ;
	
	static{
		PACKAGES = Arrays.asList(ShoppersStopBusinessException.class.getPackage().getName(), Assert.class.getPackage().getName()).stream().collect(Collectors.toSet());
	}
	
	private boolean isFannieMaeExcep(Throwable throwable){
		return (Objects.nonNull(throwable) && isUsable(throwable));
	}
	
	protected final void handleOnException(String message, Exception exception) {
		throw new ShoppersStopBusinessException(isFannieMaeExcep(exception) ? exception.getMessage() : message);
	}
	
	private boolean isUsable(Throwable cause){
		return PACKAGES.contains(cause.getClass().getPackage().getName());
	} 
}
