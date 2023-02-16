package com.techouts.sslweb.testscripts.LoginFunctionality;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.test.AbstractTest;
//import com.sslweb.automation.test.page.actions.SSBLoginFunctionalityAction;
import com.sslweb.automation.test.page.actions.SSBLoginFunctionalityFacebookAction;
import com.sslweb.automation.userloginfunctionalityfacebook.model.UserLoginFunctionalityFacebook;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBLoginFunctionalityFacebookTest extends AbstractTest {

	//private SSBLoginFunctionalityAction ssbLoginActions;
	private SSBLoginFunctionalityFacebookAction ssbfacebookLoginActions;
	private static final String TEST_CASE_NAME = "SSB_Login_UsingFacebook";
	
	public SSBLoginFunctionalityFacebookTest() {
		new UserLoginFunctionalityFacebook().init(DRIVER);
		ssbfacebookLoginActions = new SSBLoginFunctionalityFacebookAction(DRIVER);
		//ssbLoginActions = new SSBLoginFunctionalityAction(DRIVER);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}
	
	@Test(testName = TEST_CASE_NAME, description = "User Login Functionality using facebook", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyLogin() {
		try {
			
			User gmaillogin= CredentialProvider.getUser("E009");

			ssbfacebookLoginActions.LoginFunctionalityClick(TEST_CASE_NAME);
			ssbfacebookLoginActions.LoginusingFacebook(TEST_CASE_NAME, gmaillogin.getEmail(), gmaillogin.getPassword());
			//ssbfacebookLoginActions.Logoutfunctionalitycheck(TEST_CASE_NAME);
			
		} catch (Exception e) {
//			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "User Login");
//			getSslPage();
//			WebElementOperationsWeb.waitForPageLoad(DRIVER, 40);
//			LOGIN_ACTIONS.doLogout();
//			addRetryTest(new Object() {
//			}.getClass().getEnclosingMethod().getName());
			handleOnException("Login Validation Failed", e);
		}
	}
	
	@AfterMethod()
	public void tearDown() {
		ssbfacebookLoginActions.Logoutfunctionalitycheck(TEST_CASE_NAME);
	}
}

