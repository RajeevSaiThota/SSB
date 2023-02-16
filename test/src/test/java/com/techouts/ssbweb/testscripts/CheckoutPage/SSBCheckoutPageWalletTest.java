package com.techouts.ssbweb.testscripts.CheckoutPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.checkoutpagenavigationflow.model.CheckoutPageNavigationFlow;
import com.sslweb.automation.checkoutpageusingwallet.model.CheckoutPageUsingWallet;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.test.page.actions.SSBCheckoutPageWalletAction;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageWalletTest extends AbstractTest {
	
	
		private SSBCheckoutPageWalletAction ssbcheckoutpagenwallet;

		private static final String TEST_CASE_NAME = "SSB_CheckOut_LoginAtCheckout_OrderUsingWallet";
		private static final int SERIAL_NO = 4;
		private static final String ID = "7155100";
		private static final String token = "";
		
		
		public SSBCheckoutPageWalletTest() {
			new CheckoutPageUsingWallet().init(DRIVER);
			new CheckoutPageNavigationFlow().init(DRIVER);
			ssbcheckoutpagenwallet = new SSBCheckoutPageWalletAction(DRIVER, REPOSITORY);
		}

		@BeforeMethod
		public void openShoppersStopPage() {
			getSslPage();
		}
		
		@Test(testName = TEST_CASE_NAME, description = "Checkout Page Wallet Functionalities check")
		public void verifyCreditcardpayatcheckout() {
			try {
				User mobilelogin= CredentialProvider.getUser("E002");
				ssbcheckoutpagenwallet.NavigatetoCartPage(TEST_CASE_NAME,ID);
				ssbcheckoutpagenwallet.ClickingonProceedNow(TEST_CASE_NAME);
				ssbcheckoutpagenwallet.SigninFlow(TEST_CASE_NAME, mobilelogin.getMobileno(), mobilelogin.getPassword());
				ssbcheckoutpagenwallet.AddingAddress(REGISTRATION_SHEET, TEST_CASE_NAME, SERIAL_NO);
				ssbcheckoutpagenwallet.EnteringWalletDetails(TEST_CASE_NAME, token);
			} catch (Exception e) {
				WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "Wallet Payment");
				handleOnException("UPI payment Validation Failed", e);
			}
		}
		
		@AfterMethod()
		public boolean tearDown() {
			return true;
		}
	}




