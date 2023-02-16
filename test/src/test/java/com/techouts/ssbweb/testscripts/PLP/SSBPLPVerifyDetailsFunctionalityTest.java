package com.techouts.ssbweb.testscripts.PLP;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.plpverifydetailsfunctionality.model.PLPVerifyDetailsFunctionality;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBPLPVerifyProductDetailsFunctionalityAction;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPLPVerifyDetailsFunctionalityTest extends AbstractTest  {
	
	private SSBPLPVerifyProductDetailsFunctionalityAction ssbplpverifyproductdetailsAction;

	private static final String TEST_CASE_NAME = "SSB_PLP_Verify_Product_Details"; 

	public SSBPLPVerifyDetailsFunctionalityTest() {
		new PLPVerifyDetailsFunctionality().init(DRIVER);
		ssbplpverifyproductdetailsAction = new SSBPLPVerifyProductDetailsFunctionalityAction(DRIVER);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}
	
	@Test(testName = TEST_CASE_NAME, description = "Verify product details Check ")
	public void verifyProductDetails(){
		try {
			
			ssbplpverifyproductdetailsAction.MouseHoverProductCard(TEST_CASE_NAME);
			ssbplpverifyproductdetailsAction.FetchProductDetails(TEST_CASE_NAME);
			
			
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "Product Details verify");
			handleOnException("Not able to fetch product details", e);
		}
	}
	
	@AfterMethod()
	public boolean tearDown() {
		return true;
	}
}


