package com.techouts.sslweb.testscripts.LoginFunctionality;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBLoginFunctionalityAction;
import com.sslweb.automation.test.page.actions.SSBLoginFunctionalityGmailAction;
import com.sslweb.automation.userloginfunctionalitygmail.model.UserLoginFunctionalityGmail;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBLoginFunctionalityGmailTest extends AbstractTest {

	private SSBLoginFunctionalityAction ssbLoginActions;
	private SSBLoginFunctionalityGmailAction ssbgmailLoginActions;
	private static final String TEST_CASE_NAME = "SSB_Login_UsingGmail";
	
	public SSBLoginFunctionalityGmailTest() {
		new UserLoginFunctionalityGmail().init(DRIVER);
		ssbgmailLoginActions = new SSBLoginFunctionalityGmailAction(DRIVER);
		ssbLoginActions = new SSBLoginFunctionalityAction(DRIVER);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}
	
	@Test(testName = TEST_CASE_NAME, description = "User Login Functionality using gmail", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyLogin() {
		try {
			
			User gmaillogin= CredentialProvider.getUser("E008");

			ssbgmailLoginActions.LoginFunctionalityClick(TEST_CASE_NAME);
			ssbgmailLoginActions.LoginusingGmail(TEST_CASE_NAME, gmaillogin.getEmail(), gmaillogin.getPassword());	
			
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "User Login");
			handleOnException("Login Validation Failed", e);
		}
	}
	
	@AfterMethod()
	public void tearDown() {
		ssbLoginActions.Logoutfunctionalitycheck(TEST_CASE_NAME);
	}
}

