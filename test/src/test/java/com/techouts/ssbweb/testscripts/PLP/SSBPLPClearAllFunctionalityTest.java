package com.techouts.ssbweb.testscripts.PLP;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.plpclearallfunctionality.model.PLPClearAllFunctionality;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBPLPClearAllFunctionalityAction;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPLPClearAllFunctionalityTest extends AbstractTest  {
	
	private SSBPLPClearAllFunctionalityAction ssbplpfilterclearallActions;

	private static final String TEST_CASE_NAME = "SSB_PLP_Verify_Clear_Refinements_Functionality"; 

	public SSBPLPClearAllFunctionalityTest() {
		new PLPClearAllFunctionality().init(DRIVER);
		ssbplpfilterclearallActions = new SSBPLPClearAllFunctionalityAction(DRIVER);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}
	
	@Test(testName = TEST_CASE_NAME, description = "Verifying Clear all functionality")
	public void verifyCLearAllFilterFunctionality() {
		try {			
			
			ssbplpfilterclearallActions.clickonfilterCategory(TEST_CASE_NAME);
			ssbplpfilterclearallActions.ClickonSubcategoryFilters(TEST_CASE_NAME);
			ssbplpfilterclearallActions.ClickClearAll(TEST_CASE_NAME);
			
			
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


