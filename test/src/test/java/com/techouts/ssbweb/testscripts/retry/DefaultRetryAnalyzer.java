package com.techouts.ssbweb.testscripts.retry;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.sslweb.automation.consts.ShoppersStopConstantsWeb;
import com.sslweb.automation.dto.testretry.RetryBook;
import com.sslweb.automation.dto.testretry.Test;
import com.sslweb.automation.registry.Registry;
import com.sslweb.automation.util.PropertyUtil;

public class DefaultRetryAnalyzer implements IRetryAnalyzer {
	
	private static final Logger LOG = Logger.getLogger(DefaultRetryAnalyzer.class.getName());
	
	@Override
	public boolean retry(ITestResult result) {
		boolean isRetriable = false;
		Arrays.asList(result.getParameters()).stream().filter(Objects::nonNull).forEach(LOG::info);
		RetryBook book = (RetryBook)Registry.getAttribute(ShoppersStopConstantsWeb.RETRY_BOOK);
		Optional<Test> optional = book.getTest(result.getName());
		if(optional.isPresent() && optional.get().getRetryCount() < PropertyUtil.getInt("test.default.retry-count", 1)){
			optional.get().incremetCount();
			isRetriable = true;
		}
		return isRetriable;
	}
}
