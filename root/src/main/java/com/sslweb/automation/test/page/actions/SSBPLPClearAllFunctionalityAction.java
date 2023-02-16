package com.sslweb.automation.test.page.actions;

import java.util.Objects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBPLPClearAllFunctionalityHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPLPClearAllFunctionalityAction extends GlobalExceptionHandler {
	// In this Class we are calling methods created in helper class and performing actions 
	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBPLPClearAllFunctionalityHelper ssbclearallfilterFunctionalityHelper;
	
	public SSBPLPClearAllFunctionalityAction(WebDriver driver){
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbclearallfilterFunctionalityHelper = new SSBPLPClearAllFunctionalityHelper(driver);
		js = (JavascriptExecutor) driver;
		
	}
	
	public void clickonfilterCategory(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			js.executeScript("window.scrollBy(0,500)"," ");
			WebElementOperationsWeb.park(5);
			ssbclearallfilterFunctionalityHelper.PLPFilterGender();
			WebElementOperationsWeb.park(5);
			js.executeScript("window.scrollBy(0,200)"," ");
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("Not able to perform click operation", e);
		}
	}
	
	public void ClickonSubcategoryFilters(String testCaseName){
		try {
			
			WebElementOperationsWeb.park(5);
			ssbclearallfilterFunctionalityHelper.PLPselectingCategoryGender1();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException(" Not able to perform click operation", e);
		}
	}
	
	public void ClickClearAll(String testCaseName){
		try {
			
			WebElementOperationsWeb.park(5);
			js.executeScript("window.scrollBy(0,-500)"," ");
			WebElementOperationsWeb.park(5);
			ssbclearallfilterFunctionalityHelper.PLPFilterClearAll();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("Not able to Clear all", e);
		}
	}

}
