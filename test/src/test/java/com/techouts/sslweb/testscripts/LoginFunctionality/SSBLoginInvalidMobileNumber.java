package com.techouts.sslweb.testscripts.LoginFunctionality;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.loginusinginvalidmobilenumber.model.LoginusingInvalidMobileNumber;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBLoginFunctionalityInvalidMobileNumAction;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBLoginInvalidMobileNumber extends AbstractTest {

	private SSBLoginFunctionalityInvalidMobileNumAction ssbLoginblankusername;
	private static final String TEST_CASE_NAME = "SSB_Login_InvalidMobileNumber";

	public SSBLoginInvalidMobileNumber() {
		new LoginusingInvalidMobileNumber().init(DRIVER);
		ssbLoginblankusername = new SSBLoginFunctionalityInvalidMobileNumAction(DRIVER);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}

	@Test(testName = TEST_CASE_NAME, description = "User login with invalid mobile number")
	public void verifyLogout() {
		try {
			User mobilelogin = CredentialProvider.getUser("E007");
			ssbLoginblankusername.LoginFunctionalityClick(TEST_CASE_NAME);
			ssbLoginblankusername.LoginFunctionalityusingMobileNumber(mobilelogin.getMobileno(), TEST_CASE_NAME);
			ssbLoginblankusername.Invalidnumpopup(TEST_CASE_NAME);

		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "Blank Username");
			handleOnException("Able to login with invalid mobile number", e);
		}
	}

	@AfterMethod()
	public boolean tearDown() {
		return true;
	}
}
