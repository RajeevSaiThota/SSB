package com.techouts.ssbweb.testscripts.PDP;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import org.apache.log4j.Logger;


import com.sslweb.automation.registrationfunctionalitycheck.model.RegistrationFunctionalityCheck;
import com.sslweb.automation.ssbpdpverifydetails.model.SSBPDPVerifyDetails;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBPDPAddtoWishListGuestUserAction;

import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPDPAddtoWishListGuestUserTest extends AbstractTest  {
	
	private SSBPDPAddtoWishListGuestUserAction ssbpdpwishlistAction;

	private static final String TEST_CASE_NAME = "SSB_PDP_Verify_AddToWishList_GuestUser"; 
	private static final String ID = "204749888";
	private static final int SERIAL_NO2 = 6;
	private static final Logger LOG = Logger.getLogger(SSBPDPAddtoWishListGuestUserTest.class.getName());

	public SSBPDPAddtoWishListGuestUserTest() {
		new SSBPDPVerifyDetails().init(DRIVER);
		new RegistrationFunctionalityCheck().init(DRIVER);
		ssbpdpwishlistAction = new SSBPDPAddtoWishListGuestUserAction(DRIVER, REPOSITORY);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
		WebElementOperationsWeb.captureScreenShotOnPass(DRIVER, TEST_CASE_NAME, "ShopperstopBeautyApplicationOpened");
	}
	
	@Test(testName = TEST_CASE_NAME, description = "Verify Guest User is able to add item to wishlist", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyWishListGuestUser() {
		try {
			
			ssbpdpwishlistAction.NavigateToPDP(TEST_CASE_NAME, ID);
			ssbpdpwishlistAction.WishlistIcon(TEST_CASE_NAME);
			ssbpdpwishlistAction.RegistrationProceed(REGISTRATION_SHEET, SERIAL_NO2, TEST_CASE_NAME);
			ssbpdpwishlistAction.RegistrationFormFilling(REGISTRATION_SHEET, TEST_CASE_NAME, SERIAL_NO2);
			
			
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


