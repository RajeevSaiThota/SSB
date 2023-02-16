package com.sslweb.automation.test.page.actions;

import java.util.Objects;


import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBCheckoutPageNavigationHelper;
import com.sslweb.automation.test.page.actions.helper.SSBCheckoutPageUPIHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageUPIAction extends GlobalExceptionHandler {


	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBCheckoutPageUPIHelper ssbcheckoutupipay;
	private SSBCheckoutPageNavigationHelper ssbcheckoutNavigation;

	public SSBCheckoutPageUPIAction(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbcheckoutupipay = new SSBCheckoutPageUPIHelper(driver, repository);
		ssbcheckoutNavigation = new SSBCheckoutPageNavigationHelper(driver, repository);
		js = (JavascriptExecutor) driver;
	}

	public void NavigatetoCartPage(String testCaseName, String ID) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbcheckoutNavigation.sendProductID(testCaseName, ID);
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.enterByRobot();
			WebElementOperationsWeb.park(10);
			ssbcheckoutNavigation.ClickonAddtoCart();
			WebElementOperationsWeb.park(15);
			ssbcheckoutNavigation.ClickonCartIcon();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void ClickingonProceedNow(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(15);
			ssbcheckoutNavigation.ClickonPlaceorder();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void SigninFlow(String testCaseName, String Mobileno, String OTP) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbcheckoutNavigation.sendMobileno(testCaseName, Mobileno);
			WebElementOperationsWeb.park(5);
			ssbcheckoutNavigation.ClickonProceed();
			WebElementOperationsWeb.park(20);
			//ssbcheckoutNavigation.sendOTP(testCaseName, OTP);
			WebElementOperationsWeb.park(5);
			ssbcheckoutNavigation.ClickonLogin();
			WebElementOperationsWeb.park(20);
			ssbcheckoutNavigation.ClickonPlaceorder();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Signin");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void AddingAddress(String sheetname, String testCaseName, int serialno) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			/* For Creating new Address 
			ssbcheckoutNavigation.ClickonAddnewAddress();
			WebElementOperationsWeb.park(2);
			ssbcheckoutNavigation.sendFullName(sheetname, serialno, testCaseName);
			WebElementOperationsWeb.park(1);
			ssbcheckoutNavigation.sendMobileNumber(sheetname, serialno, testCaseName);
			WebElementOperationsWeb.park(1);
			ssbcheckoutNavigation.sendPincode(sheetname, serialno, testCaseName);
			WebElementOperationsWeb.park(3);
			ssbcheckoutNavigation.sendAddress(sheetname, serialno, testCaseName);
			WebElementOperationsWeb.park(1);
			ssbcheckoutNavigation.ClickonAddDefaultAddress();
			WebElementOperationsWeb.park(1);
			ssbcheckoutNavigation.ClickonAddresstypeHome();
			WebElementOperationsWeb.park(1);
			ssbcheckoutNavigation.ClickonAddnewaddressSelect();
			WebElementOperationsWeb.park(3);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
			WebElementOperationsWeb.park(3);*/
			ssbcheckoutNavigation.ClickonAddressbox();
			WebElementOperationsWeb.park(5);
			ssbcheckoutNavigation.ClickonProceedtoPayment();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void EnteringUPIDetails(String testCaseName, int token) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(15);
			ssbcheckoutupipay.ClickonUPI();
			WebElementOperationsWeb.park(3);
			ssbcheckoutupipay.SendUPIID(testCaseName, token);
			WebElementOperationsWeb.park(3);
			ssbcheckoutupipay.ClickonVerify();
			WebElementOperationsWeb.park(7);
			ssbcheckoutupipay.ClickonPaynow();
			WebElementOperationsWeb.park(15);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
			//ssbcheckoutnetbankingpay.ClickonPayNow();
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	

}
