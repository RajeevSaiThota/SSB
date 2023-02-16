package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBRegistrationFunctionalityHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBRegistrationFunctionalityAction extends GlobalExceptionHandler {

	private WebDriver driver = null;
	public JavascriptExecutor js;


	private SSBRegistrationFunctionalityHelper ssbmyaccountregistrationfunctionality;

	public SSBRegistrationFunctionalityAction(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbmyaccountregistrationfunctionality = new SSBRegistrationFunctionalityHelper(driver, repository);
		js = (JavascriptExecutor) driver;
	}

	public void NavigationtoRegistration(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbmyaccountregistrationfunctionality.clickOnSignin();
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.clickOnSignup();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void RegistrationProceed(String sheetname, int serialNo, String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbmyaccountregistrationfunctionality.sendFullName(sheetname, serialNo, testCaseName);
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.sendMobileNumber(sheetname, serialNo, testCaseName);
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.clickOnProceed();
			WebElementOperationsWeb.park(40);
			//ssbmyaccountregistrationfunctionality.LoginOTP(testCaseName);
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
			WebElementOperationsWeb.park(5);
			ssbmyaccountregistrationfunctionality.DOBopen();
			WebElementOperationsWeb.park(5);
			ssbmyaccountregistrationfunctionality.OpenDOBYear();
			WebElementOperationsWeb.park(5);
			ssbmyaccountregistrationfunctionality.YearSelect();
			WebElementOperationsWeb.park(6);
			ssbmyaccountregistrationfunctionality.DOBDateSelect();
			WebElementOperationsWeb.park(5);
			ssbmyaccountregistrationfunctionality.AnniversaryCalendaropen();
			WebElementOperationsWeb.park(5);
			ssbmyaccountregistrationfunctionality.OpenAnniversaryYear();
			WebElementOperationsWeb.park(5);
			ssbmyaccountregistrationfunctionality.AnniversaryYearSelect();
			WebElementOperationsWeb.park(5);
			ssbmyaccountregistrationfunctionality.AnniversaryDateSelect();
			WebElementOperationsWeb.park(5);
			ssbmyaccountregistrationfunctionality.sendPincode(sheetname, serialno, testCaseName);
			WebElementOperationsWeb.park(5);
			ssbmyaccountregistrationfunctionality.sendAddress(sheetname, serialno, testCaseName);
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
			WebElementOperationsWeb.park(5);
			ssbmyaccountregistrationfunctionality.ClickonSave();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	public void RegistrationLogoutFunctionality(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbmyaccountregistrationfunctionality.Usernamemousehover();
			WebElementOperationsWeb.park(5);
			ssbmyaccountregistrationfunctionality.LogOutClick();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		}catch(Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

}
