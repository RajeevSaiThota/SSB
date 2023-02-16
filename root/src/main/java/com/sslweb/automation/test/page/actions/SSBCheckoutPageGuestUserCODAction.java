package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBCheckoutPageCODHelper;
import com.sslweb.automation.test.page.actions.helper.SSBCheckoutPageNavigationHelper;
import com.sslweb.automation.test.page.actions.helper.SSBRegistrationFunctionalityHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageGuestUserCODAction extends GlobalExceptionHandler {

	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBCheckoutPageCODHelper ssbcheckoutcodpay;
	private SSBRegistrationFunctionalityHelper ssbmyaccountregistrationfunctionality;
	private SSBCheckoutPageNavigationHelper ssbcheckoutNavigation;

	public SSBCheckoutPageGuestUserCODAction(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbcheckoutcodpay = new SSBCheckoutPageCODHelper(driver, repository);
		ssbmyaccountregistrationfunctionality = new SSBRegistrationFunctionalityHelper(driver, repository);
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

	public void RegistrationProceed(String sheetname, int serialNo, String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			ssbmyaccountregistrationfunctionality.clickOnSignup();
			WebElementOperationsWeb.park(5);
			ssbmyaccountregistrationfunctionality.sendFullName(sheetname, serialNo, testCaseName);
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.sendMobileNumber(sheetname, serialNo, testCaseName);
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.clickOnProceed();
			WebElementOperationsWeb.park(20);
			// ssbmyaccountregistrationfunctionality.LoginOTP(testCaseName);
			WebElementOperationsWeb.park(5);
			ssbmyaccountregistrationfunctionality.VerifyOTP();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void RegistrationFormFilling(String sheetname, String testCaseName, int serialno) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbmyaccountregistrationfunctionality.sendEmail(sheetname, serialno, testCaseName);
			WebElementOperationsWeb.park(2);
			ssbmyaccountregistrationfunctionality.DOBopen();
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.OpenDOBYear();
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.YearSelect();
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.DOBDateSelect();
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.AnniversaryCalendaropen();
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.OpenAnniversaryYear();
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.AnniversaryYearSelect();
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.AnniversaryDateSelect();
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.sendPincode(sheetname, serialno, testCaseName);
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.sendAddress(sheetname, serialno, testCaseName);
			WebElementOperationsWeb.park(3);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.ClickonSave();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void AddingAddress(String sheetname, String testCaseName, int serialno) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
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
			WebElementOperationsWeb.park(3);
			ssbcheckoutNavigation.ClickonAddressbox();
			WebElementOperationsWeb.park(5);
			ssbcheckoutNavigation.ClickonProceedtoPayment();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void PaymentUsingCOD(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(15);
			ssbcheckoutcodpay.ClickonCOD();
			WebElementOperationsWeb.park(3);
			//ssbcheckoutcodpay.ClickonPay();
			WebElementOperationsWeb.park(7);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
			// ssbcheckoutnetbankingpay.ClickonPayNow();
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

}
