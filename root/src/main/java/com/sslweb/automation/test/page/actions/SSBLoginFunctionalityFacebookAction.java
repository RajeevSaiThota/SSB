package com.sslweb.automation.test.page.actions;

import java.util.Objects;


import org.openqa.selenium.WebDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.loginusinginvalidmobilenumber.model.LoginInvalidMobileNumber;
import com.sslweb.automation.test.page.actions.helper.SSBLoginFunctionalityFacebookHelper;
import com.sslweb.automation.test.page.actions.helper.SSBLoginFunctionalityGmailHelper;
import com.sslweb.automation.test.page.actions.helper.SSBLoginFunctionalityHelper;


import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBLoginFunctionalityFacebookAction extends GlobalExceptionHandler {


	private WebDriver driver = null;
	private SSBLoginFunctionalityFacebookHelper ssbLoginFunctionalityfacebookHelper;
	
	
	public SSBLoginFunctionalityFacebookAction(WebDriver driver){
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbLoginFunctionalityfacebookHelper = new SSBLoginFunctionalityFacebookHelper(driver);
	}
	
	public void LoginFunctionalityClick(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityfacebookHelper.clickOnSignin();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void LoginusingFacebook(String testCaseName, String email, String Password){
		try {
			
			ssbLoginFunctionalityfacebookHelper.FacebookIcon();;
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.windowHandle(driver);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Gmail login page");
			WebElementOperationsWeb.park(3);
			ssbLoginFunctionalityfacebookHelper.SendEmailid(testCaseName, email);
			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityfacebookHelper.SendPassword(testCaseName, Password);
			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityfacebookHelper.ClickLogin();
			//WebElementOperationsWeb.waitForPageLoad(driver,60);
			WebElementOperationsWeb.park(5);
			//WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "LoginSuccess");
//			WebElementOperationsWeb.handleParentTab(driver);	
		} catch (Exception e) {
//			WebElementOperationsWeb.handleParentTab(driver);
			handleOnException("Error occured while login with Gmail", e);
		}
	}
	public void Logoutfunctionalitycheck(String testCaseName) {
		try {

			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityfacebookHelper.Usernamemousehover();
			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityfacebookHelper.LogOutClick();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
}

