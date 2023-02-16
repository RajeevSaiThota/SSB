package com.techouts.sslweb.testscripts.MyAccount;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.myaccountmywalletpage.model.MyAccountMyWalletPage;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.test.page.actions.SSBMyAccountMyWalletPageFunctionalityAction;



import com.sslweb.automation.userloginfunctionalitycheck.model.UserLoginFunctionalityCheck;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountMyWalletPageFunctionalityTest extends AbstractTest {

	private  SSBMyAccountMyWalletPageFunctionalityAction ssbmyaccountmywalletpage;

	private static final String TEST_CASE_NAME = "SSB_My_Wallet_Page";
	private static final int SERIAL_NO1 = 12;

	public SSBMyAccountMyWalletPageFunctionalityTest() {
		new UserLoginFunctionalityCheck().init(DRIVER);
		new MyAccountMyWalletPage().init(DRIVER);
		ssbmyaccountmywalletpage = new SSBMyAccountMyWalletPageFunctionalityAction(DRIVER, REPOSITORY);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}

	@Test(testName = TEST_CASE_NAME, description = "My Account Order Page Filter Functionality", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyMyWalletPageFunctionality() {
		try {

			User mobilelogin = CredentialProvider.getUser("E002");
			ssbmyaccountmywalletpage.SigninFlow(TEST_CASE_NAME, mobilelogin.getMobileno(),
					mobilelogin.getPassword());
			ssbmyaccountmywalletpage.NavigatingtoMyWalletPage(TEST_CASE_NAME);
			ssbmyaccountmywalletpage.CardDetailsFunctionality(CHECKOUT_PAGE, TEST_CASE_NAME, SERIAL_NO1);
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "My Wallet Page");
			getSslPage();
			WebElementOperationsWeb.waitForPageLoad(DRIVER, 40);
			LOGIN_ACTIONS.doLogout();
			addRetryTest(new Object() {
			}.getClass().getEnclosingMethod().getName());
			handleOnException("Filter Orders Validation Failed", e);
		}
	}

	@AfterMethod()
	public void tearDown() {
		LOGIN_ACTIONS.doLogout();
	}
	
}
