package com.techouts.ssbweb.testscripts.PLP;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.plpbasicfilterfunctionality.model.PLPBasicFilterFunctionality;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBPLPBasicFilterFunctionalityAction;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPLPBasicFilterTest extends AbstractTest  {
	
	private SSBPLPBasicFilterFunctionalityAction ssbplpbasicFilterFunctionalityAction;

	private static final String TEST_CASE_NAME = "SSB_PLP_Verify_PrimaryFilter_Select_Best Seller_Featured_ED_Functionality"; 

	public SSBPLPBasicFilterTest() {
		new PLPBasicFilterFunctionality().init(DRIVER);
		ssbplpbasicFilterFunctionalityAction = new SSBPLPBasicFilterFunctionalityAction(DRIVER);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}
	
	@Test(testName = TEST_CASE_NAME, description = "Basic Filter Functionality includes BS,ED and Featured")
	public void verifyBrandFilter() {
		try {
			
			ssbplpbasicFilterFunctionalityAction.clickonViewMoretoExpand(TEST_CASE_NAME);
			ssbplpbasicFilterFunctionalityAction.ClickonBasicfunctionality(TEST_CASE_NAME);
			ssbplpbasicFilterFunctionalityAction.Clearall(TEST_CASE_NAME);			
			
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


