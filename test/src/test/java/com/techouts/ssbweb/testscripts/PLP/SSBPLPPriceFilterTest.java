package com.techouts.ssbweb.testscripts.PLP;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.plppricefilterfunctionality.model.PLPPriceFilterFunctionality;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBPLPPriceFunctionalityAction;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPLPPriceFilterTest extends AbstractTest  {
	
	private SSBPLPPriceFunctionalityAction ssbplppriceFilterFunctionalityAction;

	private static final String TEST_CASE_NAME = "SSB_PLP_Verify_PrimaryFilter_Select_Price_Functionality"; 

	public SSBPLPPriceFilterTest() {
		new PLPPriceFilterFunctionality().init(DRIVER);
		ssbplppriceFilterFunctionalityAction = new SSBPLPPriceFunctionalityAction(DRIVER);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}
	
	@Test(testName = TEST_CASE_NAME, description = "Price Filter")
	public void verifyBrandFilter() {
		try {
			
			ssbplppriceFilterFunctionalityAction.clickonPriceFilter(TEST_CASE_NAME);
			ssbplppriceFilterFunctionalityAction.ClickonClearAll(TEST_CASE_NAME);
			
			
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "Member-ID");
			handleOnException("ClearAll Validation Failed", e);
		}
	}
	
	@AfterMethod()
	public boolean tearDown() {
		return true;
	}
}


