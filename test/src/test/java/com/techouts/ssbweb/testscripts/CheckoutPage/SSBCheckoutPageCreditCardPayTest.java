package com.techouts.ssbweb.testscripts.CheckoutPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.cartpagedefaultfunctionality.model.CartPageDefaultFunctionality;
import com.sslweb.automation.checkoutpagenavigationflow.model.CheckoutPageNavigationFlow;
import com.sslweb.automation.checkoutpageusingcreditcard.model.CheckoutPageUsingCreditCard;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.test.page.actions.SSBCheckoutPageCreditCardPayAction;
import com.techouts.ssbweb.testscripts.retry.DefaultRetryAnalyzer;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageCreditCardPayTest extends AbstractTest {

	private SSBCheckoutPageCreditCardPayAction ssbcheckoutpagecreditcardpay;

	private static final String TEST_CASE_NAME = "SSB_CheckOut_LoginAtCheckout_OrderUsingDBCard";
	private static final int SERIAL_NO1 = 3;
	private static final int SERIAL_NO2 = 2;
	private static final String ID = "7155100";

	public SSBCheckoutPageCreditCardPayTest() {
		new CheckoutPageNavigationFlow().init(DRIVER);
		new CheckoutPageUsingCreditCard().init(DRIVER);
		ssbcheckoutpagecreditcardpay = new SSBCheckoutPageCreditCardPayAction(DRIVER, REPOSITORY);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}

	@Test(testName = TEST_CASE_NAME, description = "Checkout Page CreditCard Functionalities check", retryAnalyzer = DefaultRetryAnalyzer.class)
	public void verifyCreditcardpayatcheckout() {
		try {

			User mobilelogin = CredentialProvider.getUser("E002");
			ssbcheckoutpagecreditcardpay.NavigatetoCartPage(TEST_CASE_NAME, ID);
			ssbcheckoutpagecreditcardpay.ClickingonProceedNow(TEST_CASE_NAME);
			ssbcheckoutpagecreditcardpay.SigninFlow(TEST_CASE_NAME, mobilelogin.getMobileno(),
					mobilelogin.getPassword());
			ssbcheckoutpagecreditcardpay.AddingAddress(REGISTRATION_SHEET, TEST_CASE_NAME, SERIAL_NO1);
			ssbcheckoutpagecreditcardpay.EnteringCreditCardDetails(CHECKOUT_PAGE, TEST_CASE_NAME, SERIAL_NO2);
			ssbcheckoutpagecreditcardpay.CCBankPageSimulateSuccessClick(TEST_CASE_NAME, SERIAL_NO2);
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "Cart Page Default Functionality");
			handleOnException("ClearAll Validation Failed", e);
		}
	}

	@AfterMethod()
	public boolean tearDown() {
		return true;
	}
}
