package com.techouts.sslweb.testscripts.MyAccount;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.myaccountprofilepagedeletingaddress.model.MyAccountProfilePageDeletingAddress;
import com.sslweb.automation.provider.credential.CredentialProvider;

import com.sslweb.automation.test.page.actions.SSBMyAccountProfilePageDeletingAddressAction;

import com.sslweb.automation.userloginfunctionalitycheck.model.UserLoginFunctionalityCheck;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountProfilePageDeleteAddressTest extends AbstractTest {

	private SSBMyAccountProfilePageDeletingAddressAction ssbmyaccountppdeletingaddress;

	private static final String TEST_CASE_NAME = "SSB_ProfilePage_DeleteAddress";

	public SSBMyAccountProfilePageDeleteAddressTest() {
		new UserLoginFunctionalityCheck().init(DRIVER);
		new MyAccountProfilePageDeletingAddress().init(DRIVER);
		ssbmyaccountppdeletingaddress = new SSBMyAccountProfilePageDeletingAddressAction(DRIVER, REPOSITORY);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}

	@Test(testName = TEST_CASE_NAME, description = "My Account Profile Page Deleting Address ", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyMyProfileDeleteAddress() {
		try {

			User mobilelogin = CredentialProvider.getUser("E002");
			ssbmyaccountppdeletingaddress.SigninFlow(TEST_CASE_NAME, mobilelogin.getMobileno(),
					mobilelogin.getPassword());
			ssbmyaccountppdeletingaddress.NavigatingtoProfilePage(TEST_CASE_NAME);
			ssbmyaccountppdeletingaddress.DeletingAddress(TEST_CASE_NAME);
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "Delete Address");
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
