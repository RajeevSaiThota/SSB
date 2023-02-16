package com.techouts.ssbweb.testscripts.CheckoutPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.sslweb.automation.checkoutpagenavigationflow.model.CheckoutPageNavigationFlow;
import com.sslweb.automation.checkoutpageusingdebitcard.model.CheckoutPageUsingDebitCard;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.registrationfunctionalitycheck.model.RegistrationFunctionalityCheck;
import com.sslweb.automation.test.page.actions.SSBCheckoutPageGuestUserDebitCardPayAction;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageGuestNetBankingPayTest extends AbstractTest {

	private SSBCheckoutPageGuestUserDebitCardPayAction ssbcheckoutpagedebitcardpayguest;

	private static final String TEST_CASE_NAME = "SSB_CheckOut_GuestUser_OrderUsingDBCard";
	private static final int SERIAL_NO1 = 3; // Adding Address 
	private static final int SERIAL_NO2 = 1; // Credit card details Fetch 
	private static final int SERIAL_NO3 = 6; // Registration Details Fetch
	private static final String ID = "7155100"; // Product Id

	public SSBCheckoutPageGuestNetBankingPayTest() {
		new CheckoutPageNavigationFlow().init(DRIVER);
		new RegistrationFunctionalityCheck().init(DRIVER);
		new CheckoutPageUsingDebitCard().init(DRIVER);
		ssbcheckoutpagedebitcardpayguest = new SSBCheckoutPageGuestUserDebitCardPayAction(DRIVER, REPOSITORY);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}

	@Test(testName = TEST_CASE_NAME, description = "Checkout Page DebitCard Functionalities Guest User check", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyGuestUserDebitcardpayatcheckout() {
		try {

			ssbcheckoutpagedebitcardpayguest.NavigatetoCartPage(TEST_CASE_NAME, ID);
			ssbcheckoutpagedebitcardpayguest.ClickingonProceedNow(TEST_CASE_NAME);
			ssbcheckoutpagedebitcardpayguest.RegistrationProceed(REGISTRATION_SHEET, SERIAL_NO3, TEST_CASE_NAME);
			ssbcheckoutpagedebitcardpayguest.RegistrationFormFilling(REGISTRATION_SHEET, TEST_CASE_NAME, SERIAL_NO3);
			ssbcheckoutpagedebitcardpayguest.AddingAddress(REGISTRATION_SHEET, TEST_CASE_NAME, SERIAL_NO1);
			ssbcheckoutpagedebitcardpayguest.EnteringDebitCardDetails(CHECKOUT_PAGE, TEST_CASE_NAME, SERIAL_NO2);
			ssbcheckoutpagedebitcardpayguest.DBBankPageSimulateSuccessClick(TEST_CASE_NAME, SERIAL_NO2);
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
