package com.techouts.ssbweb.testscripts.CartPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.cartpagedefaultfunctionality.model.CartPageDefaultFunctionality;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBCartPageDefaultFunctionalityAction;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCartPageDefaultFunctionalitiesTest extends AbstractTest   {

	private SSBCartPageDefaultFunctionalityAction ssbcartpageflowtest;

	private static final String TEST_CASE_NAME = "SSB_CartPage_Public_Verify_Cart_Page_Default_Functionality"; 

	public SSBCartPageDefaultFunctionalitiesTest() {
		new CartPageDefaultFunctionality().init(DRIVER);
		ssbcartpageflowtest = new SSBCartPageDefaultFunctionalityAction(DRIVER);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}
	
	@Test(testName = TEST_CASE_NAME, description = "Cart Page Default Functionalities check")
	public void verifyCartPageDefaultFunctionalities() {
		try {

			ssbcartpageflowtest.ClickOnProductClick(TEST_CASE_NAME);
			ssbcartpageflowtest.ClickonAddToCartProduct(TEST_CASE_NAME);
			ssbcartpageflowtest.ClickonAddToCartClick(TEST_CASE_NAME);
			ssbcartpageflowtest.ClickonApplyCouponIcon(TEST_CASE_NAME);
			ssbcartpageflowtest.ClickonApplyCouponClick(TEST_CASE_NAME);
			ssbcartpageflowtest.ClickonRemoveCoupon(TEST_CASE_NAME);
			ssbcartpageflowtest.ClickonChangeClick(TEST_CASE_NAME);
			/*ssbcartpageflowtest.ClickingonSecondConnect(TEST_CASE_NAME);
			ssbcartpageflowtest.ClickingonGiftWrap(TEST_CASE_NAME);
			ssbcartpageflowtest.ClickingonPlaceOrder(TEST_CASE_NAME);*/		
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

