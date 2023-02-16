package com.techouts.sslweb.testscripts.MyAccount;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.myaccountprofilepageaddingaddress.model.MyAccountProfilePageAddingAddress;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.test.page.actions.SSBMyAccountProfilePageAddingAddressAction;
import com.sslweb.automation.userloginfunctionalitycheck.model.UserLoginFunctionalityCheck;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountProfilePageAddAddressTest extends AbstractTest {

	private SSBMyAccountProfilePageAddingAddressAction ssbmyaccountppaddingaddress;

	private static final String TEST_CASE_NAME = "SSB_ProfilePage_AddNewAddress";
	private static final int SERIAL_NO2 = 6;

	public SSBMyAccountProfilePageAddAddressTest() {
		new UserLoginFunctionalityCheck().init(DRIVER);
		new MyAccountProfilePageAddingAddress().init(DRIVER);
		ssbmyaccountppaddingaddress = new SSBMyAccountProfilePageAddingAddressAction(DRIVER, REPOSITORY);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}

	@Test(testName = TEST_CASE_NAME, description = "My Account Profile Page Adding Address ", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyMyProfileAddAddress() {
		try {

			User mobilelogin = CredentialProvider.getUser("E002");
			ssbmyaccountppaddingaddress.SigninFlow(TEST_CASE_NAME, mobilelogin.getMobileno(),
					mobilelogin.getPassword());
			ssbmyaccountppaddingaddress.NavigatingtoProfilePage(TEST_CASE_NAME);
			ssbmyaccountppaddingaddress.AddingAddress(REGISTRATION_SHEET, TEST_CASE_NAME, SERIAL_NO2);
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "Adding Address in my profile");
			getSslPage();
			WebElementOperationsWeb.waitForPageLoad(DRIVER, 40);
			LOGIN_ACTIONS.doLogout();
			addRetryTest(new Object() {
			}.getClass().getEnclosingMethod().getName());
			handleOnException("ClearAll Validation Failed", e);
		}
	}

	@AfterMethod()
	public void tearDown() {
		LOGIN_ACTIONS.doLogout();
	}
}
