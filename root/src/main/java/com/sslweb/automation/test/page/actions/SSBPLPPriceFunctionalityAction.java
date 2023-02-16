package com.sslweb.automation.test.page.actions;

import java.util.Objects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBPLPSelectingPriceFilterHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPLPPriceFunctionalityAction extends GlobalExceptionHandler {
	
	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBPLPSelectingPriceFilterHelper ssbplppricefilterhelper;
	
	
	public SSBPLPPriceFunctionalityAction(WebDriver driver){
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbplppricefilterhelper = new SSBPLPSelectingPriceFilterHelper(driver);
		js = (JavascriptExecutor) driver;
	}
	
	public void clickonPriceFilter(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			js.executeScript("window.scrollBy(0,500)"," ");
			WebElementOperationsWeb.park(5);
			ssbplppricefilterhelper.ClickonViewmore();
			WebElementOperationsWeb.park(5);
			ssbplppricefilterhelper.ClickonPriceFilter();
			WebElementOperationsWeb.park(5);
			js.executeScript("window.scrollBy(0,200)"," ");
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("Not able to click on Price Filter", e);
		}
	}
	
	public void ClickonClearAll(String testCaseName){
		try {
			
			WebElementOperationsWeb.park(5);
			js.executeScript("window.scrollBy(0,-500)"," ");
			ssbplppricefilterhelper.ClickonClearAll();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("Not able to click on Price Subcategory Filter", e);
		}
	}
	
}
