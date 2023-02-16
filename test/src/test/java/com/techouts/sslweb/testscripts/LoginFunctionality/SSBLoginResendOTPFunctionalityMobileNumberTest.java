package com.techouts.sslweb.testscripts.LoginFunctionality;

import java.util.Objects;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBLoginResendOTPFunctionalityAction;
import com.sslweb.automation.userloginresendotpfunctionalitycheck.model.UserLoginResendOTPFunctionalityCheck;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBLoginResendOTPFunctionalityMobileNumberTest extends AbstractTest {

	private SSBLoginResendOTPFunctionalityAction ssbLoginActions;
	private static final String TEST_CASE_NAME = "Resend OTP Login Functionality using Mobile Number";

	public SSBLoginResendOTPFunctionalityMobileNumberTest() {
		new UserLoginResendOTPFunctionalityCheck().init(DRIVER);
		ssbLoginActions = new SSBLoginResendOTPFunctionalityAction(DRIVER);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}

	@Test(testName = TEST_CASE_NAME, description = "Resend OTP User Login Functionality ")
	public void verifyLogin() {
		try {

			User mobilelogin = Objects.requireNonNull(CredentialProvider.getUser("E002"),
					"Mobile Login credential should not be null");

			ssbLoginActions.LoginFunctionalityClick(TEST_CASE_NAME);
			ssbLoginActions.LoginFunctionalityusingMobileNumber(mobilelogin.getMobileno(), TEST_CASE_NAME);
			ssbLoginActions.LoginFunctionalityEnterOTP(TEST_CASE_NAME, mobilelogin.getMobileno());
			ssbLoginActions.LoginFunctionalityClickonResendOTPButton(TEST_CASE_NAME);
			ssbLoginActions.LoginFunctionalityEnterResendOTP(TEST_CASE_NAME, mobilelogin.getMobileno());
			ssbLoginActions.LoginFunctionalityClickonVerifyOTPButton(TEST_CASE_NAME);
			//ssbLoginActions.Logoutfunctionalitycheck(TEST_CASE_NAME);
		} catch (Exception e) {
//			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "VerifyMobileLogin");
//			getSslPage();
//			WebElementOperationsWeb.waitForPageLoad(DRIVER, 40);
//			LOGIN_ACTIONS.doLogout();
//			addRetryTest(new Object() {
//			}.getClass().getEnclosingMethod().getName());
			handleOnException("Error occured while Login with MobileNumber", e);

		}
	}

	@AfterMethod()
	public void tearDown() {
		ssbLoginActions.Logoutfunctionalitycheck(TEST_CASE_NAME);
	}
}
