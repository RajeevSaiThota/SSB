package com.techouts.ssbweb.testscripts.CheckoutPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.checkoutpagenavigationflow.model.CheckoutPageNavigationFlow;
import com.sslweb.automation.checkoutpageusingupi.model.CheckoutPageUsingUPI;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.test.page.actions.SSBCheckoutPageUPIAction;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageUPITest extends AbstractTest {
	
	
		private SSBCheckoutPageUPIAction ssbcheckoutpagenUPI;

		private static final String TEST_CASE_NAME = "SSB_CheckOut_LoginAtCheckout_OrderUsingNetUPI";
		private static final int SERIAL_NO = 4;
		private static final String ID = "7155100";
		
		
		public SSBCheckoutPageUPITest() {
			new CheckoutPageUsingUPI().init(DRIVER);
			new CheckoutPageNavigationFlow().init(DRIVER);
			ssbcheckoutpagenUPI = new SSBCheckoutPageUPIAction(DRIVER, REPOSITORY);
		}

		@BeforeMethod
		public void openShoppersStopPage() {
			getSslPage();
		}
		
		@Test(testName = TEST_CASE_NAME, description = "Checkout Page NetBanking Functionalities check")
		public void verifyCreditcardpayatcheckout() {
			try {
				User mobilelogin= CredentialProvider.getUser("E002");
				ssbcheckoutpagenUPI.NavigatetoCartPage(TEST_CASE_NAME,ID);
				ssbcheckoutpagenUPI.ClickingonProceedNow(TEST_CASE_NAME);
				ssbcheckoutpagenUPI.SigninFlow(TEST_CASE_NAME, mobilelogin.getMobileno(), mobilelogin.getPassword());
				ssbcheckoutpagenUPI.AddingAddress(REGISTRATION_SHEET, TEST_CASE_NAME, SERIAL_NO);
				ssbcheckoutpagenUPI.EnteringUPIDetails(CHECKOUT_PAGE, SERIAL_NO);
			} catch (Exception e) {
				WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "UPI Payment");
				handleOnException("UPI payment Validation Failed", e);
			}
		}
		
		@AfterMethod()
		public boolean tearDown() {
			return true;
		}
	}




