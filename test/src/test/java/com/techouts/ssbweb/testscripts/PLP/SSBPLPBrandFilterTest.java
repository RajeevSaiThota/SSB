package com.techouts.ssbweb.testscripts.PLP;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.plpbrandfilterfunctionality.model.PLPBrandFilterFunctionality;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBPLPBrandFilterFunctionalityAction;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPLPBrandFilterTest extends AbstractTest  {
	
	private SSBPLPBrandFilterFunctionalityAction ssbplpsizeFilterFunctionalityAction;

	private static final String TEST_CASE_NAME = "SSB_PLP_Verify_PrimaryFilter_Select_Size_Functionality"; 

	public SSBPLPBrandFilterTest() {
		new PLPBrandFilterFunctionality().init(DRIVER);
		ssbplpsizeFilterFunctionalityAction = new SSBPLPBrandFilterFunctionalityAction(DRIVER);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}
	
	@Test(testName = TEST_CASE_NAME, description = "Size filter Check ")
	public void verifySizeFilter() {
		try {
			
			ssbplpsizeFilterFunctionalityAction.ClickonBrandSubcategoryFilter(TEST_CASE_NAME);
			ssbplpsizeFilterFunctionalityAction.ClickonBrandfiltersubcategories(TEST_CASE_NAME);
			
			
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "Member-ID");
			handleOnException("Size filter failed to be clickable", e);
		}
	}
	
	@AfterMethod()
	public boolean tearDown() {
		return true;
	}
}


