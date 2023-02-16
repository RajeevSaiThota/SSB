package com.techouts.sslweb.testscripts.LoginFunctionality;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.loginusinginvalidotp.model.LoginUsingInvalidOTP;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBLoginFunctionalityInvalidOTPAction;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBLoginFunctionalityInvalidOTP extends AbstractTest {

	private SSBLoginFunctionalityInvalidOTPAction ssbLoginActionsblankpassword;
	private static final String TEST_CASE_NAME = "SSB_Login_InvalidOTP";


	public SSBLoginFunctionalityInvalidOTP() {
		new LoginUsingInvalidOTP().init(DRIVER);
		ssbLoginActionsblankpassword = new SSBLoginFunctionalityInvalidOTPAction(DRIVER);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}
	
	@Test(testName = TEST_CASE_NAME, description = "User Login Functionality with invalid OTP ", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyLogout() {
		try {
			
			User emailLogin= CredentialProvider.getUser("E006");

			ssbLoginActionsblankpassword.LoginFunctionalityClick(TEST_CASE_NAME);
			ssbLoginActionsblankpassword.LoginFunctionalityenterUsername(emailLogin.getEmail(),TEST_CASE_NAME);
			ssbLoginActionsblankpassword.LoginFunctionalityClickonProceed(TEST_CASE_NAME);
			ssbLoginActionsblankpassword.LoginFunctionalityEnterPassword(emailLogin.getPassword(),TEST_CASE_NAME);
			ssbLoginActionsblankpassword.LoginFunctionalityClickonLogInButton(TEST_CASE_NAME);
			
			
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "User Login");
			handleOnException("Logout Validation Failed", e);
		}
	}
	
	@AfterMethod()
	public boolean tearDown() {
		return true;
	}
}

