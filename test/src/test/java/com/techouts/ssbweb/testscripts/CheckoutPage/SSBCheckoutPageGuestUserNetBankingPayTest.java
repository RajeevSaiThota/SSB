package com.techouts.ssbweb.testscripts.CheckoutPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.checkoutpagenavigationflow.model.CheckoutPageNavigationFlow;
import com.sslweb.automation.checkoutpageusingnetbanking.model.CheckoutPageUsingNetBanking;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.registrationfunctionalitycheck.model.RegistrationFunctionalityCheck;
import com.sslweb.automation.test.page.actions.SSBCheckoutPageGuestUserNetBankingAction;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageGuestUserNetBankingPayTest extends AbstractTest {

	private SSBCheckoutPageGuestUserNetBankingAction ssbcheckoutpageNetbankingpayguest;

	private static final String TEST_CASE_NAME = "SSB_CheckOut_GuestUser_OrderUsingNetBanking";
	private static final int SERIAL_NO1 = 3; // Adding Address 
	private static final int SERIAL_NO3 = 6; // Registration Details Fetch
	private static final String ID = "7155100"; // Product Id

	public SSBCheckoutPageGuestUserNetBankingPayTest() {
		new CheckoutPageNavigationFlow().init(DRIVER);
		new RegistrationFunctionalityCheck().init(DRIVER);
		new CheckoutPageUsingNetBanking().init(DRIVER);
		ssbcheckoutpageNetbankingpayguest = new SSBCheckoutPageGuestUserNetBankingAction(DRIVER, REPOSITORY);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}

	@Test(testName = TEST_CASE_NAME, description = "Checkout Page NetBanking Functionalities Guest User check", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyGuestUserNetBankingpayatcheckout() {
		try {

			ssbcheckoutpageNetbankingpayguest.NavigatetoCartPage(TEST_CASE_NAME, ID);
			ssbcheckoutpageNetbankingpayguest.ClickingonProceedNow(TEST_CASE_NAME);
			ssbcheckoutpageNetbankingpayguest.RegistrationProceed(REGISTRATION_SHEET, SERIAL_NO3, TEST_CASE_NAME);
			ssbcheckoutpageNetbankingpayguest.RegistrationFormFilling(REGISTRATION_SHEET, TEST_CASE_NAME, SERIAL_NO3);
			ssbcheckoutpageNetbankingpayguest.AddingAddress(REGISTRATION_SHEET, TEST_CASE_NAME, SERIAL_NO1);
			ssbcheckoutpageNetbankingpayguest.EnteringNetBankingDetails(TEST_CASE_NAME);
			ssbcheckoutpageNetbankingpayguest.BankPageSimulateSuccessClick(TEST_CASE_NAME);
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
