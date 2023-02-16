package com.techouts.ssbweb.testscripts.CartPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.cartpageverifyapplycouponsample.model.CartPageVerifyApplyCouponSample;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBCartPageApplyCouponSampleAction;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCartPageApplyCouponSampleTest extends AbstractTest   {

	private  SSBCartPageApplyCouponSampleAction ssbcartpageApplyCouponSample;

	private static final String TEST_CASE_NAME = "SSB_CartPage_Private_Verify_CartPage_ApplyCoupon_Functionality"; 

	public SSBCartPageApplyCouponSampleTest() {
		new CartPageVerifyApplyCouponSample().init(DRIVER);
		ssbcartpageApplyCouponSample = new SSBCartPageApplyCouponSampleAction(DRIVER);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}
	
	@Test(testName = TEST_CASE_NAME, description = "Verfiying Apply Coupon Functionality")
	public void verifyCartPageDefaultFunctionalities() {
		try {

			ssbcartpageApplyCouponSample.ClickOnProductClick(TEST_CASE_NAME);
			ssbcartpageApplyCouponSample.ClickonAddToCartProduct(TEST_CASE_NAME);
			ssbcartpageApplyCouponSample.ClickonAddToCartClick(TEST_CASE_NAME);
			ssbcartpageApplyCouponSample.ClickonApplyCouponIcon1(TEST_CASE_NAME);
			ssbcartpageApplyCouponSample.ClickonApplyCouponClick1(TEST_CASE_NAME);
			ssbcartpageApplyCouponSample.ClickonRemoveCoupon1(TEST_CASE_NAME);
			ssbcartpageApplyCouponSample.ClickonApplyCouponIcon2(TEST_CASE_NAME);
			ssbcartpageApplyCouponSample.ClickonApplyCouponClick2(TEST_CASE_NAME);
			ssbcartpageApplyCouponSample.ClickonRemoveCoupon2(TEST_CASE_NAME);
			
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "ApplyCoupon");
			handleOnException("ClearAll Validation Failed", e);
		}
	}
	
	@AfterMethod()
	public boolean tearDown() {
		return true;
	}
}

