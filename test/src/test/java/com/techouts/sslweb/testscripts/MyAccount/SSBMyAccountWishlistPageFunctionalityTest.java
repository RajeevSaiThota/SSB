package com.techouts.sslweb.testscripts.MyAccount;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.myaccountwishlistpage.model.MyAccountWishlistPage;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.test.page.actions.SSBMyAccountWishlistPageFunctionalityAction;



import com.sslweb.automation.userloginfunctionalitycheck.model.UserLoginFunctionalityCheck;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountWishlistPageFunctionalityTest extends AbstractTest {

	private  SSBMyAccountWishlistPageFunctionalityAction ssbmyaccountwishlistpage;

	private static final String TEST_CASE_NAME = "SSB_Wishlist";
	

	public SSBMyAccountWishlistPageFunctionalityTest() {
		new UserLoginFunctionalityCheck().init(DRIVER);
		new MyAccountWishlistPage().init(DRIVER);
		ssbmyaccountwishlistpage = new SSBMyAccountWishlistPageFunctionalityAction(DRIVER, REPOSITORY);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}

	@Test(testName = TEST_CASE_NAME, description = "My Account Order Page Filter Functionality", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyOrderPageFilterFunctionality() {
		try {

			User mobilelogin = CredentialProvider.getUser("E002");
			ssbmyaccountwishlistpage.SigninFlow(TEST_CASE_NAME, mobilelogin.getMobileno(),
					mobilelogin.getPassword());
			ssbmyaccountwishlistpage.NavigatingtoWishlistPage(TEST_CASE_NAME);
			ssbmyaccountwishlistpage.FilterFunctionality(TEST_CASE_NAME);
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "Wishlist page");
			getSslPage();
			WebElementOperationsWeb.waitForPageLoad(DRIVER, 40);
			LOGIN_ACTIONS.doLogout();
			addRetryTest(new Object() {
			}.getClass().getEnclosingMethod().getName());
			handleOnException("Wishlist Page Validation Failed", e);
		}
	}

	@AfterMethod()
	public void tearDown() {
		LOGIN_ACTIONS.doLogout();
	}
	
}
