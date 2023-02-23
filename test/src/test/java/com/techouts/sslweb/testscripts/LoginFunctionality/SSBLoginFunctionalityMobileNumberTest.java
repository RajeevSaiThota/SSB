package com.techouts.sslweb.testscripts.LoginFunctionality;

import java.util.Objects;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBLoginFunctionalityAction;
import com.sslweb.automation.userbackofficeloginfunctionalitycheck.model.UserBackofficeLoginFunctionalityCheck;
import com.sslweb.automation.userloginfunctionalitycheck.model.UserLoginFunctionalityCheck;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBLoginFunctionalityMobileNumberTest extends AbstractTest {

	private SSBLoginFunctionalityAction ssbLoginActions;
	private static final String TEST_CASE_NAME = "Login Functionality using Mobile Number";

	public SSBLoginFunctionalityMobileNumberTest() {
		new UserLoginFunctionalityCheck().init(DRIVER);
		new UserBackofficeLoginFunctionalityCheck().init(DRIVER);
		ssbLoginActions = new SSBLoginFunctionalityAction(DRIVER);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}

	@Test(testName = TEST_CASE_NAME, description = "User Login Functionality ")
	public void verifyLogin() {
		try {

			User mobilelogin = Objects.requireNonNull(CredentialProvider.getUser("E002"),
					"Mobile Login credential should not be null");

			ssbLoginActions.LoginFunctionalityClick(TEST_CASE_NAME, mobilelogin.getMobileno());
			ssbLoginActions.openNewTab(TEST_CASE_NAME, mobilelogin.getMobileno());
			getSslBackofficeUrl();
			User backofficelogin = Objects.requireNonNull(CredentialProvider.getUser("E010"),
					"Backoffice Login credential should not be null");
			ssbLoginActions.backofficeLoginFunctionality(TEST_CASE_NAME, backofficelogin.getEmail(), backofficelogin.getPassword());
			ssbLoginActions.backofficeMobileNumberVerication(TEST_CASE_NAME,mobilelogin.getMobileno());
			ssbLoginActions.LoginFunctionalityusingMobileNumber(mobilelogin.getMobileno(), TEST_CASE_NAME);
			ssbLoginActions.backofficeGetOtp(TEST_CASE_NAME);
			getSslDecryptUrl();
			ssbLoginActions.enterOtp(TEST_CASE_NAME);
			ssbLoginActions.LoginFunctionalityClickonLogInButton(TEST_CASE_NAME);
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "VerifyMobileLogin");
			getSslPage();
			WebElementOperationsWeb.waitForPageLoad(DRIVER, 40);
			LOGIN_ACTIONS.doLogout();
			addRetryTest(new Object() {
			}.getClass().getEnclosingMethod().getName());
			handleOnException("Error occured while Login with MobileNumber", e);
		}
	}

	@AfterMethod()
	public void tearDown() {
		LOGIN_ACTIONS.doLogout();
	}
}
