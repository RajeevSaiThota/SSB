package com.sslweb.automation.test.page.actions;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBPDPCheckDeliveryHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPDPCheckDeliveryAction extends GlobalExceptionHandler {

	private static final Logger LOG = Logger.getLogger(SSBPDPCheckDeliveryAction.class);
	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBPDPCheckDeliveryHelper ssbpdpdeliverydetails;

	public SSBPDPCheckDeliveryAction(WebDriver driver) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbpdpdeliverydetails = new SSBPDPCheckDeliveryHelper(driver);
		js = (JavascriptExecutor) driver;

	}

	public void NavigateToPDP(String testCaseName, String ID) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(3);
			ssbpdpdeliverydetails.sendProductID(testCaseName, ID);
			WebElementOperationsWeb.park(3);
			WebElementOperationsWeb.enterByRobot();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
			ssbpdpdeliverydetails.ClickonProductCard();
			WebElementOperationsWeb.park(3);
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void PDPVerifyDelivery(String testCaseName, String pincode) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			js.executeScript("window.scrollBy(0,200)", " ");
			ssbpdpdeliverydetails.sendPincode(testCaseName, pincode);
			ssbpdpdeliverydetails.ClickonChangeButton();
			ssbpdpdeliverydetails.VerifyStandardDelivery();
			WebElementOperationsWeb.park(3);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
			ssbpdpdeliverydetails.VerifyExpressDelivery();
			WebElementOperationsWeb.park(2);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

}
