package com.techouts.ssbweb.testscripts.CheckoutPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.checkoutpagenavigationflow.model.CheckoutPageNavigationFlow;
import com.sslweb.automation.checkoutpageusingupi.model.CheckoutPageUsingUPI;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.registrationfunctionalitycheck.model.RegistrationFunctionalityCheck;
import com.sslweb.automation.test.page.actions.SSBCheckoutPageGuestUserUPIAction;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageGuestUserUPIPayTest extends AbstractTest {

	private SSBCheckoutPageGuestUserUPIAction ssbcheckoutpageUPIpayguest;

	private static final String TEST_CASE_NAME = "SSB_CheckOut_GuestUser_OrderUsingNetUPI";
	private static final int SERIAL_NO1 = 3; // Adding Address 
	private static final int SERIAL_NO2 = 4; // UPI details Fetch
	private static final int SERIAL_NO3 = 6; // Registration Details Fetch
	private static final String ID = "7155100"; // Product Id

	public SSBCheckoutPageGuestUserUPIPayTest() {
		new CheckoutPageNavigationFlow().init(DRIVER);
		new RegistrationFunctionalityCheck().init(DRIVER);
		new CheckoutPageUsingUPI().init(DRIVER);
		ssbcheckoutpageUPIpayguest = new SSBCheckoutPageGuestUserUPIAction(DRIVER, REPOSITORY);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}

	@Test(testName = TEST_CASE_NAME, description = "Checkout Page UPI Functionalities Guest User check", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyGuestUserUPIpayatcheckout() {
		try {

			ssbcheckoutpageUPIpayguest.NavigatetoCartPage(TEST_CASE_NAME, ID);
			ssbcheckoutpageUPIpayguest.ClickingonProceedNow(TEST_CASE_NAME);
			ssbcheckoutpageUPIpayguest.RegistrationProceed(REGISTRATION_SHEET, SERIAL_NO3, TEST_CASE_NAME);
			ssbcheckoutpageUPIpayguest.RegistrationFormFilling(REGISTRATION_SHEET, TEST_CASE_NAME, SERIAL_NO3);
			ssbcheckoutpageUPIpayguest.AddingAddress(REGISTRATION_SHEET, TEST_CASE_NAME, SERIAL_NO1);
			ssbcheckoutpageUPIpayguest.EnteringUPIDetails(TEST_CASE_NAME, SERIAL_NO2);
			
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "GuestUserRegisterAtCheckout");
			addRetryTest(new Object() {}.getClass().getEnclosingMethod().getName() );
			handleOnException("Guest User Register At Checkout Functionality Failed", e);
		}
	}

	@AfterMethod()
	public boolean tearDown() {
		return true;
	}
}
