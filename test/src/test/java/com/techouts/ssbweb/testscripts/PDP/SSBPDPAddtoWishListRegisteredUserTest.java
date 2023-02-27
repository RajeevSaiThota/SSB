package com.techouts.ssbweb.testscripts.PDP;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;

import org.apache.log4j.Logger;

import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.ssbpdpverifydetails.model.SSBPDPVerifyDetails;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBLoginFunctionalityAction;
import com.sslweb.automation.test.page.actions.SSBPDPAddtoWishListRegisteredUserAction;
import com.sslweb.automation.userbackofficeloginfunctionalitycheck.model.UserBackofficeLoginFunctionalityCheck;
import com.sslweb.automation.userloginfunctionalitycheck.model.UserLoginFunctionalityCheck;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPDPAddtoWishListRegisteredUserTest extends AbstractTest  {
	
	private SSBPDPAddtoWishListRegisteredUserAction ssbpdpwishlistAction;

	private static final String TEST_CASE_NAME = "SSB_PDP_Verify_AddToWishList_RegisteredUser"; 
	private static final String ID = "206862480";
	private static final Logger LOG = Logger.getLogger(SSBPDPAddtoWishListRegisteredUserTest.class.getName());
	private SSBLoginFunctionalityAction ssbLoginActions;

	public SSBPDPAddtoWishListRegisteredUserTest() {
		new SSBPDPVerifyDetails().init(DRIVER);
		new UserLoginFunctionalityCheck().init(DRIVER);
		ssbpdpwishlistAction = new SSBPDPAddtoWishListRegisteredUserAction(DRIVER);
		ssbLoginActions = new SSBLoginFunctionalityAction(DRIVER);
		new UserLoginFunctionalityCheck().init(DRIVER);
		new UserBackofficeLoginFunctionalityCheck().init(DRIVER);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
		WebElementOperationsWeb.captureScreenShotOnPass(DRIVER, TEST_CASE_NAME, "ShopperstopBeautyApplicationOpened");
	}
	
	@Test(testName = TEST_CASE_NAME, description = "Verify Registered User is able to add item to wishlist", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyWishListRegisteredUser() {
		try {
			User mobilelogin = Objects.requireNonNull(CredentialProvider.getUser("E002"),
					"Mobile Login credential should not be null");
			ssbLoginActions.LoginFunctionalityClick(TEST_CASE_NAME, mobilelogin.getMobileno());
			ssbLoginActions.openNewTab(TEST_CASE_NAME);
			getSslBackofficeUrl();
			User backofficelogin = Objects.requireNonNull(CredentialProvider.getUser("E010"),
					"Backoffice Login credential should not be null");
			ssbLoginActions.backofficeLoginFunctionality(TEST_CASE_NAME, backofficelogin.getEmail(), backofficelogin.getPassword());
			ssbLoginActions.backofficeMobileNumberVerication(TEST_CASE_NAME,mobilelogin.getMobileno(),0);
			WebElementOperationsWeb.handleParentTab(DRIVER ,0);
			ssbLoginActions.LoginFunctionalityusingMobileNumber(mobilelogin.getMobileno(), TEST_CASE_NAME);
			ssbLoginActions.backofficeGetOtp(TEST_CASE_NAME);
			getSslDecryptUrl();
			ssbLoginActions.enterOtp(TEST_CASE_NAME,0,0);
			ssbLoginActions.LoginFunctionalityClickonLogInButton(TEST_CASE_NAME);
			ssbpdpwishlistAction.NavigateToPDP(TEST_CASE_NAME, ID);
			ssbpdpwishlistAction.WishlistIcon(TEST_CASE_NAME);
			
			
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "Verify WishList Click ");
			getSslPage();
			WebElementOperationsWeb.waitForPageLoad(DRIVER, 40);
			LOGIN_ACTIONS.doLogout();
			addRetryTest(new Object() {}.getClass().getEnclosingMethod().getName());
			handleOnException("VerifyProductDetailsFailed", e);
		}
	}
	
	@AfterMethod()
	public void tearDown() {
		try {
			LOGIN_ACTIONS.doLogout();

		} catch (Exception e2) {
			LOG.info("Unable to logout");
		}
	}

}


