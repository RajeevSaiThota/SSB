package com.techouts.ssbweb.testscripts.PLP;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.plpcategoryfilterfunctionality.model.PLPCategoryFilterFunctionality;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBPLPCategoryFilterFunctionalityAction;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPLPCategoryFilterTest extends AbstractTest  {
	
	private SSBPLPCategoryFilterFunctionalityAction ssbplpCategoryFilterFunctionalityAction;

	private static final String TEST_CASE_NAME = "SSB_PLP_Verify_PrimaryFilter_Select_Category_Functionality"; 

	public SSBPLPCategoryFilterTest() {
		new PLPCategoryFilterFunctionality().init(DRIVER);
		ssbplpCategoryFilterFunctionalityAction = new SSBPLPCategoryFilterFunctionalityAction(DRIVER);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}
	
	@Test(testName = TEST_CASE_NAME, description = "Category Filter")
	public void verifyColorFilter() {
		try {
			ssbplpCategoryFilterFunctionalityAction.ClickonCategoryFilter(TEST_CASE_NAME);
			ssbplpCategoryFilterFunctionalityAction.ClickonSubcategories(TEST_CASE_NAME);
			
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "FilterCategory");
			handleOnException("Category Filter Validation Failed", e);
		}
	}
	
	@AfterMethod()
	public boolean tearDown() {
		return true;
	}
}


