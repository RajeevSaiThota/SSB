package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.loginusinginvalidmobilenumber.model.LoginInvalidMobileNumber;
import com.sslweb.automation.test.page.actions.helper.SSBLoginFunctionalityHelper;

import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBLoginFunctionalityAction extends GlobalExceptionHandler {

	private WebDriver driver = null;
	private static final String PopUp_IS_DISPLAYED = "] is displayed";
	private SSBLoginFunctionalityHelper ssbLoginFunctionalityHelper;

	public SSBLoginFunctionalityAction(WebDriver driver) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbLoginFunctionalityHelper = new SSBLoginFunctionalityHelper(driver); // classname objname = newclass name 
	}

	public void LoginFunctionalityClick(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityHelper.clickOnAccount();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void LoginFunctionalityusingMobileNumber(String username, String testCaseName) {
		try {

			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityHelper.LoginEnterUsername(username);
			WebElementOperationsWeb.park(3);
			ssbLoginFunctionalityHelper.LoginProceed();
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

			WebElementOperationsWeb.park(15);
			//ssbLoginFunctionalityHelper.LoginOTP(testCaseName, mobileNumber);
			//WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Logged in Successfully");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void LoginFunctionalityClickonLogInButton(String testCaseName) {
		try {

			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityHelper.LogInButtonClick();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Logout Successfull");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void Logoutfunctionalitycheck(String testCaseName) {
		try {

			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityHelper.Usernamemousehover();
			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityHelper.LogOutClick();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
}
