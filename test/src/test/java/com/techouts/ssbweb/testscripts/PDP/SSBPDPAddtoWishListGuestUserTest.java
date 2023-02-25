package com.techouts.ssbweb.testscripts.PDP;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;

import org.apache.log4j.Logger;

import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.registrationfunctionalitycheck.model.RegistrationFunctionalityCheck;
import com.sslweb.automation.ssbpdpverifydetails.model.SSBPDPVerifyDetails;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBLoginFunctionalityAction;
import com.sslweb.automation.test.page.actions.SSBPDPAddtoWishListGuestUserAction;
import com.sslweb.automation.test.page.actions.helper.SSBLoginFunctionalityHelper;
import com.sslweb.automation.userbackofficeloginfunctionalitycheck.model.UserBackofficeLoginFunctionalityCheck;
import com.sslweb.automation.userloginfunctionalitycheck.model.UserLoginFunctionalityCheck;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPDPAddtoWishListGuestUserTest extends AbstractTest  {
	
	private SSBPDPAddtoWishListGuestUserAction ssbpdpwishlistAction;

	private static final String TEST_CASE_NAME = "SSB_PDP_Verify_AddToWishList_GuestUser"; 
	private static final String ID = "206862480";
	private static final int SERIAL_NO2 = 6;
	private static final Logger LOG = Logger.getLogger(SSBPDPAddtoWishListGuestUserTest.class.getName());
	private SSBLoginFunctionalityAction ssbLoginActions;

	public SSBPDPAddtoWishListGuestUserTest() {
		new SSBPDPVerifyDetails().init(DRIVER);
		new RegistrationFunctionalityCheck().init(DRIVER);
		ssbpdpwishlistAction = new SSBPDPAddtoWishListGuestUserAction(DRIVER, REPOSITORY);
		new UserLoginFunctionalityCheck().init(DRIVER);
		new UserBackofficeLoginFunctionalityCheck().init(DRIVER);		
		ssbLoginActions = new SSBLoginFunctionalityAction(DRIVER);

	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
		WebElementOperationsWeb.captureScreenShotOnPass(DRIVER, TEST_CASE_NAME, "ShopperstopBeautyApplicationOpened");
	}
	
	@Test(testName = TEST_CASE_NAME, description = "Verify Guest User is able to add item to wishlist", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyWishListGuestUser() {
		try {
			User mobilelogin = Objects.requireNonNull(CredentialProvider.getUser("E002"),
					"Mobile Login credential should not be null");

			ssbpdpwishlistAction.NavigateToPDP(TEST_CASE_NAME, ID);
			ssbpdpwishlistAction.WishlistIcon(TEST_CASE_NAME);
			ssbLoginActions.openNewTab(TEST_CASE_NAME);
			getSslBackofficeUrl();
			User backofficelogin = Objects.requireNonNull(CredentialProvider.getUser("E010"),
					"Backoffice Login credential should not be null");
			ssbLoginActions.backofficeLoginFunctionality(TEST_CASE_NAME, backofficelogin.getEmail(), backofficelogin.getPassword());
			ssbLoginActions.backofficeMobileNumberVerication(TEST_CASE_NAME,mobilelogin.getMobileno(),1);
			WebElementOperationsWeb.handleParentTab(DRIVER ,1);
			ssbLoginActions.LoginFunctionalityusingMobileNumber(mobilelogin.getMobileno(), TEST_CASE_NAME);
			ssbLoginActions.backofficeGetOtp(TEST_CASE_NAME);
			getSslDecryptUrl();
			ssbLoginActions.enterOtp(TEST_CASE_NAME,1);
			ssbLoginActions.LoginFunctionalityClickonLogInButton(TEST_CASE_NAME);
						
			
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "Verify WishList Click ");
			getSslPage();
			WebElementOperationsWeb.waitForPageLoad(DRIVER, 40);
			LOGIN_ACTIONS.doLogout();
			addRetryTest(new Object() {}.getClass().getEnclosingMethod().getName());
			handleOnException("Verifyproductaddedtowishlist", e);
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


