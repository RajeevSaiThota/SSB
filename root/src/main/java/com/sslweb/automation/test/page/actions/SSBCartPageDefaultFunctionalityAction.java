package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBCartPageDefaultFunctionalityHelper;
import com.sslweb.automation.test.page.actions.helper.SSBPLPSelectingBrandFilterHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCartPageDefaultFunctionalityAction extends GlobalExceptionHandler {
	
	private static final Logger LOG = Logger.getLogger(SSBCartPageDefaultFunctionalityAction.class);
	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBCartPageDefaultFunctionalityHelper ssbCartPagedefaultfunctionality;
	//private  SSBPLPClearAllFunctionality ssbLoginFunctionalityValidator;
	
	public SSBCartPageDefaultFunctionalityAction(WebDriver driver){
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbCartPagedefaultfunctionality = new SSBCartPageDefaultFunctionalityHelper(driver);
		js = (JavascriptExecutor) driver;
		//ssbclearallfilterFunctionalityHelper = new SSBPLPClearAllFunctionalityHelper(driver);
	}
	
	public void ClickOnProductClick(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbCartPagedefaultfunctionality.ClickonCatogoryClick();
			WebElementOperationsWeb.park(5);
			ssbCartPagedefaultfunctionality.ClickonMakeUpClick();
			WebElementOperationsWeb.park(5);
			ssbCartPagedefaultfunctionality.ClickonProductClick();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void ClickonAddToCartProduct(String testCaseName){
		try {
			
			WebElementOperationsWeb.park(5);
			js.executeScript("window.scrollBy(0,200)"," ");
			WebElementOperationsWeb.park(5);
			ssbCartPagedefaultfunctionality.ClickonAddToCartProduct();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void ClickonAddToCartClick(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 100);
			WebElementOperationsWeb.park(5);
			ssbCartPagedefaultfunctionality.ClickonAddToCartClick();
			WebElementOperationsWeb.park(2);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void ClickonApplyCouponIcon(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbCartPagedefaultfunctionality.ClickonApplyCouponIcon();
			WebElementOperationsWeb.park(4);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void ClickonApplyCouponClick(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(4);
			ssbCartPagedefaultfunctionality.ClickonApplyCouponClick();
			WebElementOperationsWeb.park(4);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void ClickonRemoveCoupon(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(4);
			ssbCartPagedefaultfunctionality.ClickonRemoveCoupon();
			WebElementOperationsWeb.park(4);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void ClickonChangeClick(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(4);
			ssbCartPagedefaultfunctionality.ClickonChangeClick();
			WebElementOperationsWeb.park(4);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
}
