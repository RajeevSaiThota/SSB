package com.techouts.sslweb.testscripts.MyAccount;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.myaccountorderpagehistorytrackorder.model.MyAccountOrderPageHistoryTrackOrder;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.test.page.actions.SSBMyAccountOrderPageTrackOrderFunctionalityAction;


import com.sslweb.automation.userloginfunctionalitycheck.model.UserLoginFunctionalityCheck;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountOrderPageTrackOrderTest extends AbstractTest {

	private  SSBMyAccountOrderPageTrackOrderFunctionalityAction ssbmyaccountorderpageto;

	private static final String TEST_CASE_NAME = "SSB_Order_OrderDetailsPage_Trackorder";
	

	public SSBMyAccountOrderPageTrackOrderTest() {
		new UserLoginFunctionalityCheck().init(DRIVER);
		new MyAccountOrderPageHistoryTrackOrder().init(DRIVER);
		ssbmyaccountorderpageto = new SSBMyAccountOrderPageTrackOrderFunctionalityAction(DRIVER, REPOSITORY);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}

	@Test(testName = TEST_CASE_NAME, description = "My Account Order Page Tracking an order", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyMyAccountTrackOrder() {
		try {

			User mobilelogin = CredentialProvider.getUser("E002");
			ssbmyaccountorderpageto.SigninFlow(TEST_CASE_NAME, mobilelogin.getMobileno(),
					mobilelogin.getPassword());
			ssbmyaccountorderpageto.NavigatingtoOrderPage(TEST_CASE_NAME);
			ssbmyaccountorderpageto.TrackOrder(TEST_CASE_NAME);
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "Track Order");
			getSslPage();
			WebElementOperationsWeb.waitForPageLoad(DRIVER, 40);
			LOGIN_ACTIONS.doLogout();
			addRetryTest(new Object() {
			}.getClass().getEnclosingMethod().getName());
			handleOnException("Tracking Order Validation Failed", e);
		}
	}

	@AfterMethod()
	public void tearDown() {
		LOGIN_ACTIONS.doLogout();
	}
}
