package com.techouts.ssbweb.testscripts.CheckoutPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.checkoutpagenavigationflow.model.CheckoutPageNavigationFlow;
import com.sslweb.automation.checkoutpageusingcod.model.CheckoutPageUsingCOD;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.registrationfunctionalitycheck.model.RegistrationFunctionalityCheck;
import com.sslweb.automation.test.page.actions.SSBCheckoutPageGuestUserCODAction;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageGuestUserCODPayTest extends AbstractTest {

	private SSBCheckoutPageGuestUserCODAction ssbcheckoutpagecodpayguest;

	private static final String TEST_CASE_NAME = "SSB_CheckOut_GuestUser_OrderUsingNetCOD";
	private static final int SERIAL_NO1 = 3; // Adding Address 
	private static final int SERIAL_NO3 = 6; // Registration Details Fetch
	private static final String ID = "7155100"; // Product Id

	public SSBCheckoutPageGuestUserCODPayTest() {
		new CheckoutPageNavigationFlow().init(DRIVER);
		new RegistrationFunctionalityCheck().init(DRIVER);
		new CheckoutPageUsingCOD().init(DRIVER);
		ssbcheckoutpagecodpayguest = new SSBCheckoutPageGuestUserCODAction(DRIVER, REPOSITORY);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}

	@Test(testName = TEST_CASE_NAME, description = "Checkout Page COD Functionalities Guest User check", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyGuestUserCODpayatcheckout() {
		try {

			ssbcheckoutpagecodpayguest.NavigatetoCartPage(TEST_CASE_NAME, ID);
			ssbcheckoutpagecodpayguest.ClickingonProceedNow(TEST_CASE_NAME);
			ssbcheckoutpagecodpayguest.RegistrationProceed(REGISTRATION_SHEET, SERIAL_NO3, TEST_CASE_NAME);
			ssbcheckoutpagecodpayguest.RegistrationFormFilling(REGISTRATION_SHEET, TEST_CASE_NAME, SERIAL_NO3);
			ssbcheckoutpagecodpayguest.AddingAddress(REGISTRATION_SHEET, TEST_CASE_NAME, SERIAL_NO1);
			ssbcheckoutpagecodpayguest.PaymentUsingCOD(TEST_CASE_NAME);
			
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
