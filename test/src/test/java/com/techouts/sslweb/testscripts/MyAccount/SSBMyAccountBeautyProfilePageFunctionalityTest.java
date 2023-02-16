package com.techouts.sslweb.testscripts.MyAccount;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.myaccountbeautyprofilepage.model.MyAccountBeautyProfilePage;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.test.page.actions.SSBMyAccountBeautyProfileFunctionalityAction;



import com.sslweb.automation.userloginfunctionalitycheck.model.UserLoginFunctionalityCheck;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountBeautyProfilePageFunctionalityTest extends AbstractTest {

	private  SSBMyAccountBeautyProfileFunctionalityAction ssbmyaccountbeautyprofilepage;

	private static final String TEST_CASE_NAME = "SSB_Beauty_Profile";
	

	public SSBMyAccountBeautyProfilePageFunctionalityTest() {
		new UserLoginFunctionalityCheck().init(DRIVER);
		new MyAccountBeautyProfilePage().init(DRIVER);
		ssbmyaccountbeautyprofilepage = new SSBMyAccountBeautyProfileFunctionalityAction(DRIVER, REPOSITORY);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}

	@Test(testName = TEST_CASE_NAME, description = "My Account Beauty Profile Functionality", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyBeautyProfilePageFunctionality() {
		try {

			User mobilelogin = CredentialProvider.getUser("E002");
			ssbmyaccountbeautyprofilepage.SigninFlow(TEST_CASE_NAME, mobilelogin.getMobileno(),
					mobilelogin.getPassword());
			ssbmyaccountbeautyprofilepage.NavigatingtoBeautyProfilePage(TEST_CASE_NAME);
			ssbmyaccountbeautyprofilepage.CatogeryFunctionality(TEST_CASE_NAME);
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "Beauty Profile page");
			getSslPage();
			WebElementOperationsWeb.waitForPageLoad(DRIVER, 40);
			LOGIN_ACTIONS.doLogout();
			addRetryTest(new Object() {
			}.getClass().getEnclosingMethod().getName());
			handleOnException("Beauty Profile Validation Failed", e);
		}
	}

	@AfterMethod()
	public void tearDown() {
		LOGIN_ACTIONS.doLogout();
	}
	
}
