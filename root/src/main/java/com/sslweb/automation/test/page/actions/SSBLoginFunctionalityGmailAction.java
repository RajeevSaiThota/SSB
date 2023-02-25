package com.sslweb.automation.test.page.actions;

import java.util.Objects;


import org.openqa.selenium.WebDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.loginusinginvalidmobilenumber.model.LoginInvalidMobileNumber;
import com.sslweb.automation.test.page.actions.helper.SSBLoginFunctionalityGmailHelper;
import com.sslweb.automation.test.page.actions.helper.SSBLoginFunctionalityHelper;


import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBLoginFunctionalityGmailAction extends GlobalExceptionHandler {


	private WebDriver driver = null;
	private SSBLoginFunctionalityGmailHelper ssbLoginFunctionalitygmailHelper;
	
	
	public SSBLoginFunctionalityGmailAction(WebDriver driver){
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbLoginFunctionalitygmailHelper = new SSBLoginFunctionalityGmailHelper(driver);
	}
	
	public void LoginFunctionalityClick(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalitygmailHelper.clickOnSignin();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void LoginusingGmail(String testCaseName, String email, String Password){
		try {
			
			ssbLoginFunctionalitygmailHelper.GoogleIcon();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.windowHandle(driver);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Gmail login page");
			WebElementOperationsWeb.park(3);
			ssbLoginFunctionalitygmailHelper.SendEmailid(testCaseName, email);
			WebElementOperationsWeb.park(10);
			ssbLoginFunctionalitygmailHelper.ClickNext();
			WebElementOperationsWeb.park(10);
			ssbLoginFunctionalitygmailHelper.ClickNext();
			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalitygmailHelper.SendPassword(testCaseName, Password);
			WebElementOperationsWeb.park(1);
			ssbLoginFunctionalitygmailHelper.ClickNext();
			WebElementOperationsWeb.waitForPageLoad(driver,60);
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "LoginSuccess");
//			WebElementOperationsWeb.handleParentTab(driver);	
		} catch (Exception e) {
//			WebElementOperationsWeb.handleParentTab(driver);
			handleOnException("Error occured while login with Gmail", e);
		}
	}
	
}

