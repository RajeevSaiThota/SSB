package com.techouts.ssbweb.testscripts.PLP;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sslweb.automation.plpsortbydropdown.model.PLPSortbyDropDown;
import com.sslweb.automation.test.AbstractTest;
import com.sslweb.automation.test.page.actions.SSBPLPSortByDropDownAction;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPLPSortByDropDownTest extends AbstractTest  {
	
	private SSBPLPSortByDropDownAction ssbplpdropdownAction;

	private static final String TEST_CASE_NAME = "SSB_PLP_Verify_PrimaryFilter_DropDown_Functionality"; 

	public SSBPLPSortByDropDownTest() {
		new PLPSortbyDropDown().init(DRIVER);
		ssbplpdropdownAction = new SSBPLPSortByDropDownAction(DRIVER);
	}

	@BeforeMethod
	public void openShoppersStopPage() {
		getSslPage();
	}
	
	@Test(testName = TEST_CASE_NAME, description = "Sort By Drop Down")
	public void verifySortByDropDown() {
		try {
			
			ssbplpdropdownAction.ClickonSortByDropDown(TEST_CASE_NAME);
			ssbplpdropdownAction.ClickonCategory1(TEST_CASE_NAME);
			ssbplpdropdownAction.ClickonSortByDropDown(TEST_CASE_NAME);
			ssbplpdropdownAction.ClickonCategory2(TEST_CASE_NAME);	
			
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(DRIVER, TEST_CASE_NAME, "Sort by PLP");
			handleOnException("ClearAll Validation Failed", e);
		}
	}
	
	@AfterMethod()
	public boolean tearDown() {
	return true;
	}
}


