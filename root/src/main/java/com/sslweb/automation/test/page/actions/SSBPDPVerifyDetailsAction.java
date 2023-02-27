package com.sslweb.automation.test.page.actions;


import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBPDPVerifyDetailsHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;
public class SSBPDPVerifyDetailsAction extends GlobalExceptionHandler {
	
	private static final Logger LOG = Logger.getLogger(SSBPDPVerifyDetailsHelper.class);
	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBPDPVerifyDetailsHelper ssbpdpverifydetails;
	
	
	public SSBPDPVerifyDetailsAction(WebDriver driver){
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbpdpverifydetails = new SSBPDPVerifyDetailsHelper(driver);
		js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,500)"," ");
	}
	
	public void NavigateToPDP(String testCaseName, String ID){
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			// Flow for sending product ID in search bar 
			WebElementOperationsWeb.park(3);
			ssbpdpverifydetails.sendProductID(testCaseName, ID);
			WebElementOperationsWeb.park(3);
			WebElementOperationsWeb.enterByRobot();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "NavigateToPDP");
			ssbpdpverifydetails.ClickonProductCard();
			WebElementOperationsWeb.windowHandle(driver);
		} catch (Exception e) {
			handleOnException("NavigateToPDP failed", e);
		}
	}
	
	public void VerifyProductDetails(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbpdpverifydetails.VerifyProductName();
			ssbpdpverifydetails.VerifyProductRatings();
			ssbpdpverifydetails.VerifyProductPrice();
			ssbpdpverifydetails.VerifyAddToCart();
			ssbpdpverifydetails.VerifyBuyNow();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "ProductDetails");	
		} catch (Exception e) {
			handleOnException("Verifying ProductDetails failed", e);
		}
	}
	
	
	public void PDPVerifyDetails(String testCaseName){
		try {
			WebElementOperationsWeb.park(5);
			ssbpdpverifydetails.ClickonProductImage();
			WebElementOperationsWeb.park(3);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "PDPVerifyDetails");	
			ssbpdpverifydetails.ClickonCloseButton();
			WebElementOperationsWeb.park(2);
			ssbpdpverifydetails.EasyReturnsClick();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "PDPVerifyDetails");
			ssbpdpverifydetails.CloseOkayButton();
			WebElementOperationsWeb.park(2);
			ssbpdpverifydetails.AuthenticProductClick();
			WebElementOperationsWeb.park(2);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "PDPVerifyDetails");
			ssbpdpverifydetails.CloseOkayButton();			
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "PDPVerifyDetails");	
		} catch (Exception e) {
			handleOnException("PDPVerifyDetails failed", e);
		}
	}
	

}
