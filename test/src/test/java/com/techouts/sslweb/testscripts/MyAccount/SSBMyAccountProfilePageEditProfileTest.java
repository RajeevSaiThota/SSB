package com.techouts.sslweb.testscripts.MyAccount;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.myaccountprofilepagepersonaldetails.model.MyAccountProfilePagePersonalDetails;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.test.page.actions.SSBMyAccountProfilePageEditingPersonalDetailsAction;
import com.sslweb.automation.userloginfunctionalitycheck.model.UserLoginFunctionalityCheck;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountProfilePageEditProfileTest extends AbstractTest {

	private SSBMyAccountProfilePageEditingPersonalDetailsAction ssbmyaccountppeditpersonalprofile;

	private static final String TEST_CASE_NAME = "SSB_ProfilePage_EditPersonalInfo";
	private static final int SERIAL_NO2 = 6;

	public SSBMyAccountProfilePageEditProfileTest() {
		new UserLoginFunctionalityCheck().init(DRIVER);
		new MyAccountProfilePagePersonalDetails().init(DRIVER);
		ssbmyaccountppeditpersonalprofile = new SSBMyAccountProfilePageEditingPersonalDetailsAction(DRIVER, REPOSITORY);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}

	@Test(testName = TEST_CASE_NAME, description = "My Account Profile Page Editing Profile details ", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyMyProfileEditDetails() {
		try {

			User mobilelogin = CredentialProvider.getUser("E002");
			ssbmyaccountppeditpersonalprofile.SigninFlow(TEST_CASE_NAME, mobilelogin.getMobileno(),
					mobilelogin.getPassword());
			ssbmyaccountppeditpersonalprofile.NavigatingtoProfilePage(TEST_CASE_NAME);
			ssbmyaccountppeditpersonalprofile.EditPersonalDetails(REGISTRATION_SHEET, TEST_CASE_NAME, SERIAL_NO2);
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "My Account Edit Details");
			getSslPage();
			WebElementOperationsWeb.waitForPageLoad(DRIVER, 40);
			LOGIN_ACTIONS.doLogout();
			addRetryTest(new Object() {
			}.getClass().getEnclosingMethod().getName());
			handleOnException("Not able to Edit Details", e);
		}
	}

	@AfterMethod()
	public void tearDown() {
		LOGIN_ACTIONS.doLogout();
	}
}
