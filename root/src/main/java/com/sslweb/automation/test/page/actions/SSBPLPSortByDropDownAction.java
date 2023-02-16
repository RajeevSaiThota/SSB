package com.sslweb.automation.test.page.actions;

import java.util.Objects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBPLPSortByDropDownHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPLPSortByDropDownAction extends GlobalExceptionHandler {
	
	
	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBPLPSortByDropDownHelper ssbplpdropdownhelper;
	
	
	public SSBPLPSortByDropDownAction(WebDriver driver){
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbplpdropdownhelper = new SSBPLPSortByDropDownHelper(driver);
		js = (JavascriptExecutor) driver;
	}
		
	public void ClickonSortByDropDown(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbplpdropdownhelper.ClickonSortby();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void ClickonCategory1(String testCaseName){
		try {
			WebElementOperationsWeb.park(5);
			ssbplpdropdownhelper.ClickonCategory1();
			WebElementOperationsWeb.park(2);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void ClickonCategory2(String testCaseName){
		try {
			WebElementOperationsWeb.park(2);
			ssbplpdropdownhelper.ClickonCategory2();
			WebElementOperationsWeb.park(2);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
}
