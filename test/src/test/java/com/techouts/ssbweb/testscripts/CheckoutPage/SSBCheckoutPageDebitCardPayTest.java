package com.techouts.ssbweb.testscripts.CheckoutPage;

import java.util.Objects;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.checkoutpagenavigationflow.model.CheckoutPageNavigationFlow;
//import com.sslweb.automation.checkoutpageusingcreditcard.model.CheckoutPageUsingCreditCard;
import com.sslweb.automation.checkoutpageusingdebitcard.model.CheckoutPageUsingDebitCard;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.test.page.actions.SSBCheckoutPageDebitCardPayAction;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageDebitCardPayTest extends AbstractTest {

	private SSBCheckoutPageDebitCardPayAction ssbcheckoutpagedebitcardpay;

	private static final String TEST_CASE_NAME = "SSB_CheckOut_LoginAtCheckout_OrderUsingDBCard";
	//private static final int SERIAL_NO1 = 3;
	private static final int SERIAL_NO1 = 1;
	//private static final String ID = "7155100";

	public SSBCheckoutPageDebitCardPayTest() {
		new CheckoutPageNavigationFlow().init(DRIVER);
		new CheckoutPageUsingDebitCard().init(DRIVER);
		ssbcheckoutpagedebitcardpay = new SSBCheckoutPageDebitCardPayAction(DRIVER, REPOSITORY);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}

	@Test(testName = TEST_CASE_NAME, description = "Checkout Page CreditCard Functionalities check")
	public void verifyCreditcardpayatcheckout() {
		try {
			User mobilelogin = Objects.requireNonNull(CredentialProvider.getUser("E002"),
					"Mobile Login credential should not be null");
			
			ssbcheckoutpagedebitcardpay.LoginFunctionalityClick(TEST_CASE_NAME);
			ssbcheckoutpagedebitcardpay.LoginFunctionalityusingMobileNumber(mobilelogin.getMobileno(), TEST_CASE_NAME);
			ssbcheckoutpagedebitcardpay.LoginFunctionalityEnterOTP(TEST_CASE_NAME, mobilelogin.getMobileno());
			ssbcheckoutpagedebitcardpay.LoginFunctionalityClickonLogInButton(TEST_CASE_NAME);
			ssbcheckoutpagedebitcardpay.AddToCartFunctionality(TEST_CASE_NAME);
			ssbcheckoutpagedebitcardpay.EnteringDebitCardDetails(CHECKOUT_PAGE, TEST_CASE_NAME, SERIAL_NO1);
			ssbcheckoutpagedebitcardpay.DBBankPageSimulateSuccessClick(CHECKOUT_PAGE,TEST_CASE_NAME, SERIAL_NO1);
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "Debit Card Default Functionality");
			handleOnException("ClearAll Validation Failed", e);
		}
	}

	@AfterMethod()
	public void tearDown() {
		ssbcheckoutpagedebitcardpay.Logoutfunctionalitycheck(TEST_CASE_NAME); 
	}
}
