package com.techouts.sslweb.testscripts.LoginFunctionality;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.registrationfunctionalitycheck.model.RegistrationFunctionalityCheck;
import com.sslweb.automation.test.page.actions.SSBRegistrationFunctionalityAction;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBRegistrationFunctionalityTest extends AbstractTest {

	private SSBRegistrationFunctionalityAction ssbregistrationtest;

	private static final String TEST_CASE_NAME = "SSB_Registration";
	private static final int SERIAL_NO2 = 6;

	public SSBRegistrationFunctionalityTest() {
		new RegistrationFunctionalityCheck().init(DRIVER);
		ssbregistrationtest = new SSBRegistrationFunctionalityAction(DRIVER, REPOSITORY);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}

	@Test(testName = TEST_CASE_NAME, description = "New User Registration Functionality ", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyMyRegistrationFunctionality() {
		try {
			User details = CredentialProvider.getUser("E002");
			ssbregistrationtest.NavigationtoRegistration(TEST_CASE_NAME);
			ssbregistrationtest.RegistrationProceed(REGISTRATION_SHEET, SERIAL_NO2, TEST_CASE_NAME);
			ssbregistrationtest.RegistrationFormFilling(REGISTRATION_SHEET, TEST_CASE_NAME, SERIAL_NO2);
		} catch (Exception e) {
//			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "Guest Registration");
//			getSslPage();
//			WebElementOperationsWeb.waitForPageLoad(DRIVER, 40);
//			LOGIN_ACTIONS.doLogout();
//			addRetryTest(new Object() {
//			}.getClass().getEnclosingMethod().getName());
			handleOnException("ClearAll Validation Failed", e);
		}
	}

	@AfterMethod()
	public void tearDown() {
		ssbregistrationtest.RegistrationLogoutFunctionality(TEST_CASE_NAME);
	}
}
