package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBPLPSelectingCategoryFilterHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPLPCategoryFilterFunctionalityAction extends GlobalExceptionHandler {
	
	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBPLPSelectingCategoryFilterHelper ssbplpcategoryfilterhelper;
	
	public SSBPLPCategoryFilterFunctionalityAction(WebDriver driver){
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbplpcategoryfilterhelper = new SSBPLPSelectingCategoryFilterHelper(driver);
		js = (JavascriptExecutor) driver;
	}
		
	public void ClickonCategoryFilter(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbplpcategoryfilterhelper.ClickonCategoryFilter();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "CategoryDisplayed");	
		} catch (Exception e) {
			handleOnException("Not able to perform click operation on Category Filter", e);
		}
	}
	
	
	public void ClickonSubcategories(String testCaseName){
		try {
			WebElementOperationsWeb.park(5);
			js.executeScript("window.scrollBy(0,300)"," ");
			WebElementOperationsWeb.park(5);
			ssbplpcategoryfilterhelper.ClickonCategoryFilterSub1();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "SubCategorysDisplayed");	
		} catch (Exception e) {
			handleOnException("Not able to click on subcategories in category filter", e);
		}
	}
	
}
