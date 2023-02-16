package com.techouts.ssbweb.testscripts.CheckoutPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.checkoutpagenavigationflow.model.CheckoutPageNavigationFlow;
import com.sslweb.automation.checkoutpageusingnetbanking.model.CheckoutPageUsingNetBanking;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.dto.credentials.User;
import com.sslweb.automation.provider.credential.CredentialProvider;
import com.sslweb.automation.test.page.actions.SSBCheckoutPageNetBankingAction;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageNetBankingTest extends AbstractTest {
	
	
		private SSBCheckoutPageNetBankingAction ssbcheckoutpagenetbanking;

		private static final String TEST_CASE_NAME = "SSB_CheckOut_GuestUser_OrderUsingNetBanking";
		//private static final int SERIAL_NO = 18;
		private static final int SERIAL_NO = 3;
		private static final String ID = "7155100";
		
		
		public SSBCheckoutPageNetBankingTest() {
			new CheckoutPageUsingNetBanking().init(DRIVER);
			new CheckoutPageNavigationFlow().init(DRIVER);
			ssbcheckoutpagenetbanking = new SSBCheckoutPageNetBankingAction(DRIVER, REPOSITORY);
		}

		@BeforeMethod
		public void openShoppersStopPage() {
			getSslPage();
		}
		
		@Test(testName = TEST_CASE_NAME, description = "Checkout Page NetBanking Functionalities check")
		public void verifyCreditcardpayatcheckout() {
			try {
				User mobilelogin= CredentialProvider.getUser("E002");
				ssbcheckoutpagenetbanking.NavigatetoCartPage(TEST_CASE_NAME,ID);
				ssbcheckoutpagenetbanking.ClickingonProceedNow(TEST_CASE_NAME);
				ssbcheckoutpagenetbanking.SigninFlow(TEST_CASE_NAME, mobilelogin.getMobileno(), mobilelogin.getPassword());
				ssbcheckoutpagenetbanking.AddingAddress(REGISTRATION_SHEET, TEST_CASE_NAME, SERIAL_NO);
				ssbcheckoutpagenetbanking.EnteringNetBankingDetails(TEST_CASE_NAME);
				ssbcheckoutpagenetbanking.BankPageSimulateSuccessClick(TEST_CASE_NAME);
			} catch (Exception e) {
				WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "NetBanking Payment");
				handleOnException("ClearAll Validation Failed", e);
			}
		}
		
		@AfterMethod()
		public boolean tearDown() {
			return true;
		}
	}




