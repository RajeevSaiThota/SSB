package com.techouts.ssbweb.testscripts.PDP;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;


import com.sslweb.automation.ssbpdpverifydetails.model.SSBPDPVerifyDetails;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBPDPVerifyDetailsAction;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPDPVErifyDetailsTest extends AbstractTest  {
	
	private SSBPDPVerifyDetailsAction ssbpdpverifydetailsAction;

	private static final String TEST_CASE_NAME = "SSB_PDP_VerifyDetails"; 
	private static final int SERIAL_NO = 1;

	// private static final String ID = Mention ID to send in search;
	private static final Logger LOG = Logger.getLogger(SSBPDPVErifyDetailsTest.class.getName());

	public SSBPDPVErifyDetailsTest() {
		new SSBPDPVerifyDetails().init(DRIVER);
		ssbpdpverifydetailsAction = new SSBPDPVerifyDetailsAction(DRIVER,REPOSITORY);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
		WebElementOperationsWeb.captureScreenShotOnPass(DRIVER, TEST_CASE_NAME, "ShopperstopBeautyApplicationOpened");
	}
	
	@Test(testName = TEST_CASE_NAME, description = "Verify Details in PDP page", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyPDPDetails() {
		try {
			
			ssbpdpverifydetailsAction.NavigateToPDP(TEST_CASE_NAME,PDP_SHEET,SERIAL_NO);
			ssbpdpverifydetailsAction.VerifyProductDetails(TEST_CASE_NAME);
			ssbpdpverifydetailsAction.PDPVerifyDetails(TEST_CASE_NAME);			
			
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "VerifyProductDetails");
			getSslPage();
			WebElementOperationsWeb.waitForPageLoad(DRIVER, 40);
			LOGIN_ACTIONS.doLogout();
			addRetryTest(new Object() {}.getClass().getEnclosingMethod().getName());
			handleOnException("VerifyProductDetailsFailed", e);
		}
	}
	
	@AfterMethod()
	public void tearDown() {
		try {
			LOGIN_ACTIONS.doLogout();

		} catch (Exception e2) {
			LOG.info("Unable to logout");
		}
	}

}


