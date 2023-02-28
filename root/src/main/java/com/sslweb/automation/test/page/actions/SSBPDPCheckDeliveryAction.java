package com.sslweb.automation.test.page.actions;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBPDPCheckDeliveryHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPDPCheckDeliveryAction extends GlobalExceptionHandler {

	private static final Logger LOG = Logger.getLogger(SSBPDPCheckDeliveryAction.class);
	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBPDPCheckDeliveryHelper ssbpdpdeliverydetails;

	public SSBPDPCheckDeliveryAction(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbpdpdeliverydetails = new SSBPDPCheckDeliveryHelper(driver, repository);
		js = (JavascriptExecutor) driver;

	}

	public void NavigateToPDP(String testCaseName, String sheetName, int serialNo) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbpdpdeliverydetails.sendProductID(testCaseName,  sheetName,serialNo);
			WebElementOperationsWeb.park(5);
			ssbpdpdeliverydetails.ClickonProductCard();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "NavigateToPDP");
			WebElementOperationsWeb.windowHandle(driver);
			
		} catch (Exception e) {
			handleOnException("Error in navigating to PDP", e);
		}
	}

	public void PDPVerifyDelivery(String testCaseName, String sheetName, int serialNo) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			js.executeScript("window.scrollBy(0,200)", " ");
			ssbpdpdeliverydetails.sendPincode(testCaseName, sheetName,serialNo);
			ssbpdpdeliverydetails.ClickonCheckButton();
			WebElementOperationsWeb.park(5);
			ssbpdpdeliverydetails.VerifyStandardDelivery();
			ssbpdpdeliverydetails.ClickonStandardDeliveryRadioButton();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "VerifyStandardDelivery");
			ssbpdpdeliverydetails.VerifyExpressDelivery();
			ssbpdpdeliverydetails.ClickonExpressDeliveryRadioButton();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "VerifyExpressDelivery");
			ssbpdpdeliverydetails.VerifyPayandPickup();
			ssbpdpdeliverydetails.ClickonPickupRadioButton();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "VerifyPickupRadioButton");

		} catch (Exception e) {
			handleOnException("Error in verifying delivery modes", e);
		}
	}

}
