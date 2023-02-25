package com.techouts.ssbweb.testscripts.CheckoutPage;

import java.util.Objects;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.checkoutpageusingcod.model.CheckoutPageUsingCOD;
import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBCheckoutPageCODAction;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageCODTest extends AbstractTest {

	private SSBCheckoutPageCODAction ssbcheckoutpagencod;

	private static final String TEST_CASE_NAME = "SSB_CheckOut_LoginAtCheckout_OrderUsingCOD";
	//private static final int SERIAL_NO = 3; // Adding Address
	//private static final String ID = "7155100"; // Product ID 

	public SSBCheckoutPageCODTest() {
		new CheckoutPageUsingCOD().init(DRIVER);
		//new CheckoutPageNavigationFlow().init(DRIVER);
		ssbcheckoutpagencod = new SSBCheckoutPageCODAction(DRIVER, REPOSITORY);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}

	@Test(testName = TEST_CASE_NAME, description = "Checkout Page COD Functionalities check")
	public void verifyCODpayatcheckout() {
		try {
			User mobilelogin = Objects.requireNonNull(CredentialProvider.getUser("E002"),
					"Mobile Login credential should not be null");

			ssbcheckoutpagencod.LoginFunctionalityClick(TEST_CASE_NAME);
			ssbcheckoutpagencod.LoginFunctionalityusingMobileNumber(mobilelogin.getMobileno(), TEST_CASE_NAME);
			ssbcheckoutpagencod.LoginFunctionalityEnterOTP(TEST_CASE_NAME, mobilelogin.getMobileno());
			ssbcheckoutpagencod.LoginFunctionalityClickonLogInButton(TEST_CASE_NAME);
			ssbcheckoutpagencod.AddToCartFunctionality(TEST_CASE_NAME);
			ssbcheckoutpagencod.PaymentUsingCOD(TEST_CASE_NAME);
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "VerifyMobileLogin");
//			getSslPage();
//			WebElementOperationsWeb.waitForPageLoad(DRIVER, 40);
//			ssbcheckoutpagencod.Logoutfunctionalitycheck(TEST_CASE_NAME);
//			addRetryTest(new Object() {
//			}.getClass().getEnclosingMethod().getName());
			handleOnException("Error occured while Login with MobileNumber", e);
		}
	}

	@AfterMethod()
	public void tearDown() {
		ssbcheckoutpagencod.Logoutfunctionalitycheck(TEST_CASE_NAME); 
	}
}