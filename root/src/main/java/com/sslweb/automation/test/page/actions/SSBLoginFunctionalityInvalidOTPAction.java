package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBLoginFunctionalityInvalidOTPHelper;
import com.sslweb.automation.test.page.actions.helper.SSBLoginFunctionalityHelper;
import com.sslweb.automation.test.page.elements.validator.SsbLoginFunctionalityValidate;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBLoginFunctionalityInvalidOTPAction extends GlobalExceptionHandler {

	private static final Logger LOG = Logger.getLogger(SSBLoginFunctionalityInvalidOTPAction.class);
	private WebDriver driver = null;
	private SSBLoginFunctionalityInvalidOTPHelper ssbLoginFunctionalityblankpassword;
	
	public SSBLoginFunctionalityInvalidOTPAction(WebDriver driver){
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbLoginFunctionalityblankpassword = new SSBLoginFunctionalityInvalidOTPHelper(driver);
	}
	
	public void LoginFunctionalityClick(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityblankpassword.clickOnAccount();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void LoginFunctionalityenterUsername(String username, String testCaseName){
		try {
			
			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityblankpassword.LoginEnterUsername(username);;
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void LoginFunctionalityClickonProceed(String testCaseName){
		try {
			
			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityblankpassword.LoginProceed();;
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void LoginFunctionalityEnterPassword(String Password, String testCaseName){
		try {
			
			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityblankpassword.LoginPasswordTypeIn(Password);
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void LoginFunctionalityClickonLogInButton(String testCaseName){
		try {
			
			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityblankpassword.LogInButtonClick();;;
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
}

