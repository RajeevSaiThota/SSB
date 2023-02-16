package com.sslweb.automation.test.page.actions;

import java.util.Objects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBPLPVerifyProductDetailsHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPLPVerifyProductDetailsFunctionalityAction extends GlobalExceptionHandler {
	
	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBPLPVerifyProductDetailsHelper ssbplpVPDhelper;
	
	
	public SSBPLPVerifyProductDetailsFunctionalityAction(WebDriver driver){
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbplpVPDhelper = new SSBPLPVerifyProductDetailsHelper(driver);
		js = (JavascriptExecutor) driver;
	}
	
	public void MouseHoverProductCard(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			js.executeScript("window.scrollBy(0,400)"," ");
			WebElementOperationsWeb.park(5);
			ssbplpVPDhelper.MouseHover();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Quick View");	
		} catch (Exception e) {
			handleOnException("Not able to Mouse hover on product card", e);
		}
	}
	
	public void FetchProductDetails(String testCaseName){
		try {
			
			WebElementOperationsWeb.park(5);
			ssbplpVPDhelper.QuickView();
			WebElementOperationsWeb.park(5);
			ssbplpVPDhelper.VerifyProductDetails();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "PDP page");	
		} catch (Exception e) {
			handleOnException("Not able to click on product details ", e);
		}
	}
	
}
