package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.loginusinginvalidmobilenumber.model.LoginInvalidMobileNumber;
import com.sslweb.automation.test.page.actions.helper.SSBLoginFunctionalityHelper;
import com.sslweb.automation.test.page.actions.helper.SSBLoginFunctionalityInvalidMobileNumHelper;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBLoginFunctionalityInvalidMobileNumAction extends GlobalExceptionHandler {

	private WebDriver driver = null;
	private static final String PopUp_IS_DISPLAYED = "] is displayed";
	private SSBLoginFunctionalityInvalidMobileNumHelper ssbLoginFunctionalityInvalidMobileNumHelper;

	public SSBLoginFunctionalityInvalidMobileNumAction(WebDriver driver) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbLoginFunctionalityInvalidMobileNumHelper = new SSBLoginFunctionalityInvalidMobileNumHelper(driver); // classname objname = newclass name 
	}

	public void LoginFunctionalityClick(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityInvalidMobileNumHelper.clickOnAccount();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void LoginFunctionalityusingMobileNumber(String username, String testCaseName) {
		try {

			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityInvalidMobileNumHelper.LoginEnterUsername(username);
//			WebElementOperationsWeb.park(3);
//			ssbLoginFunctionalityInvalidMobileNumHelper.clickOnAccount();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Mobile Number Entered");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void Invalidnumpopup(String testCaseName) {
		try {

			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityInvalidMobileNumHelper.LogInPopUp();
//			WebElementOperationsWeb.park(3);
//			ssbLoginFunctionalityInvalidMobileNumHelper.clickOnAccount();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Mobile Number Entered");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
}