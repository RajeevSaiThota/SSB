package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.loginusinginvalidmobilenumber.model.LoginInvalidMobileNumber;
import com.sslweb.automation.test.page.actions.helper.SSBLoginResendOTPFunctionalityHelper;

import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBLoginResendOTPFunctionalityAction extends GlobalExceptionHandler {

	private WebDriver driver = null;
	private static final String PopUp_IS_DISPLAYED = "] is displayed";
	private SSBLoginResendOTPFunctionalityHelper ssbLoginResendOTPFunctionalityHelper;

	public SSBLoginResendOTPFunctionalityAction(WebDriver driver) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbLoginResendOTPFunctionalityHelper = new SSBLoginResendOTPFunctionalityHelper(driver); // classname objname = newclass name 
	}

	public void LoginFunctionalityClick(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbLoginResendOTPFunctionalityHelper.clickOnAccount();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void LoginFunctionalityusingMobileNumber(String username, String testCaseName) {
		try {

			WebElementOperationsWeb.park(5);
			ssbLoginResendOTPFunctionalityHelper.LoginEnterUsernameMobileNum(username);
			WebElementOperationsWeb.park(3);
			ssbLoginResendOTPFunctionalityHelper.LoginProceed();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Mobile Number Entered");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void Invalidnumpopup() {
		if (WebElementOperationsWeb.isDisplayed(driver, LoginInvalidMobileNumber.getInvalidNumPopup())) {
			throw new ShoppersStopBusinessException(
					"Sign in [" + LoginInvalidMobileNumber.getInvalidNumPopup() + PopUp_IS_DISPLAYED);
		}
	}

	public void LoginFunctionalityEnterOTP(String testCaseName, String mobileNumber) {
		try {

			WebElementOperationsWeb.park(30);
			//ssbLoginFunctionalityHelper.LoginOTP(testCaseName, mobileNumber);
			//WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Logged in Successfully");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void LoginFunctionalityClickonResendOTPButton(String testCaseName) {
		try {

			WebElementOperationsWeb.park(5);
			ssbLoginResendOTPFunctionalityHelper.LogInResendOTPButtonClick();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Logout Successfull");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void Invalidnumpopup1() {
		if (WebElementOperationsWeb.isDisplayed(driver, LoginInvalidMobileNumber.getInvalidNumPopup())) {
			throw new ShoppersStopBusinessException(
					"Sign in [" + LoginInvalidMobileNumber.getInvalidNumPopup() + PopUp_IS_DISPLAYED);
		}
	}
	
	public void LoginFunctionalityEnterResendOTP(String testCaseName, String mobileNumber) {
		try {

			WebElementOperationsWeb.park(16);
			//ssbLoginFunctionalityHelper.LoginOTP(testCaseName, mobileNumber);
			//WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Logged in Successfully");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void LoginFunctionalityClickonVerifyOTPButton(String testCaseName) {
		try {

			WebElementOperationsWeb.park(5);
			ssbLoginResendOTPFunctionalityHelper.LogInButtonClick();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Logout Successfull");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void Logoutfunctionalitycheck(String testCaseName) {
		try {

			WebElementOperationsWeb.park(5);
			ssbLoginResendOTPFunctionalityHelper.Usernamemousehover();
			WebElementOperationsWeb.park(5);
			ssbLoginResendOTPFunctionalityHelper.LogOutClick();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
}
