package com.techouts.ssbweb.testscripts.CheckoutPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.checkoutpagenavigationflow.model.CheckoutPageNavigationFlow;
import com.sslweb.automation.checkoutpageusingcreditcard.model.CheckoutPageUsingCreditCard;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.registrationfunctionalitycheck.model.RegistrationFunctionalityCheck;
import com.sslweb.automation.test.page.actions.SSBCheckoutPageGuestUserCreditCardPayAction;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageGuestUserCreditCardPayTest extends AbstractTest {

	private SSBCheckoutPageGuestUserCreditCardPayAction ssbcheckoutpagecreditcardpayguest;

	private static final String TEST_CASE_NAME = "SSB_CheckOut_GuestUser_OrderUsingCC";
	private static final int SERIAL_NO1 = 3; // Adding Address 
	private static final int SERIAL_NO2 = 2; // Credit card details Fetch 
	private static final int SERIAL_NO3 = 6; // Registration Details Fetch
	private static final String ID = "7155100"; // Product ID

	public SSBCheckoutPageGuestUserCreditCardPayTest() {
		new CheckoutPageNavigationFlow().init(DRIVER);
		new RegistrationFunctionalityCheck().init(DRIVER);
		new CheckoutPageUsingCreditCard().init(DRIVER);
		ssbcheckoutpagecreditcardpayguest = new SSBCheckoutPageGuestUserCreditCardPayAction(DRIVER, REPOSITORY);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}

	@Test(testName = TEST_CASE_NAME, description = "Checkout Page CreditCard Functionalities Guest User check", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyGuestUserCreditcardpayatcheckout() {
		try {

			ssbcheckoutpagecreditcardpayguest.NavigatetoCartPage(TEST_CASE_NAME, ID);
			ssbcheckoutpagecreditcardpayguest.ClickingonProceedNow(TEST_CASE_NAME);
			ssbcheckoutpagecreditcardpayguest.RegistrationProceed(REGISTRATION_SHEET, SERIAL_NO3, TEST_CASE_NAME);
			ssbcheckoutpagecreditcardpayguest.RegistrationFormFilling(REGISTRATION_SHEET, TEST_CASE_NAME, SERIAL_NO3);
			ssbcheckoutpagecreditcardpayguest.AddingAddress(REGISTRATION_SHEET, TEST_CASE_NAME, SERIAL_NO1);
			ssbcheckoutpagecreditcardpayguest.EnteringCreditCardDetails(CHECKOUT_PAGE, TEST_CASE_NAME, SERIAL_NO2);
			ssbcheckoutpagecreditcardpayguest.CCBankPageSimulateSuccessClick(TEST_CASE_NAME, SERIAL_NO2);
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "RegisterAtCheckout");
			addRetryTest(new Object() {}.getClass().getEnclosingMethod().getName() );
			handleOnException("RegisterAtCheckout Functionality Failed", e);
		}
	}

	@AfterMethod()
	public boolean tearDown() {
		return true;
	}
}
