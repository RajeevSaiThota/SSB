package com.sslweb.automation.testcase.service;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.sslweb.automation.consts.ShoppersStopConstantsWeb;
import com.sslweb.automation.dto.testcase.SuiteResult;
import com.sslweb.automation.dto.testcase.TestCaseResult;
import com.sslweb.automation.registry.Registry;
import com.sslweb.automation.registry.RegistryKey;

/**
 * 
 * @author sairam.p
 *
 */
public class SuiteResultCaptureService {

	private static SuiteResultCaptureService captureService = null;
	private SuiteResultCaptureService(){}
	
	/**
	 * This method initializing SuiteResultCaptureService
	 * @return captureService
	 */
	public static SuiteResultCaptureService instance(){
		if(Objects.isNull(captureService)) {
			captureService = new SuiteResultCaptureService();
		}
		return captureService;
	}
	
	/**
	 * It will add failed test case result in the suite result 
	 * @param testCaseName name of the Test Script 
	 * @param comment	Give a string
	 * @param description Give a string
	 */
	public void addFailedTestResult(String testCaseName, String comment, String description) {
		getSuiteResult().setTestCaseResult(getTestCaseResult(testCaseName, ShoppersStopConstantsWeb.FALSE, comment, description));
	}
	
	/**
	 * It will add passed test case result in the suite result
	 * @param testCaseName name of the Test Script
	 * @param description Give a string
	 */
	public void addPassedTestResult(String testCaseName, String description) {
		getSuiteResult().setTestCaseResult(getTestCaseResult(testCaseName, ShoppersStopConstantsWeb.TRUE, null, description));
	}
	
	/**
	 * It will add skipped test case result in the suite result
	 * @param testCaseName name of the Test Script
	 * @param description Give a string
	 */
	public void addSkippedTestResult(String testCaseName, String description) {
		TestCaseResult test = new TestCaseResult(testCaseName, false, description);
		test.setSkipped(true);
		getSuiteResult().setTestCaseResult(test);
	}
	
	private TestCaseResult getTestCaseResult(String testCaseName, boolean isPassed, String faileReason, String desc) {
		return StringUtils.isNotBlank(faileReason) ? new TestCaseResult(testCaseName, isPassed, faileReason, desc) : new TestCaseResult(testCaseName, isPassed, desc);
	}
	
	private SuiteResult getSuiteResult() {
		SuiteResult suiteResult = (SuiteResult)Registry.getAttribute(RegistryKey.TEST_SUITE_RESULT);
		if(Objects.isNull(suiteResult)) {
			suiteResult = new SuiteResult();
			Registry.setAttribute(RegistryKey.TEST_SUITE_RESULT, suiteResult);
		}
		return suiteResult;
	}
}
