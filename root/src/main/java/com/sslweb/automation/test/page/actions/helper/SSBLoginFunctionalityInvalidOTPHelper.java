package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.loginusinginvalidotp.model.LoginInvalidOTP;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBLoginFunctionalityInvalidOTPHelper extends GlobalExceptionHandler  {
	// In this class we are performing operations on the web element 
	
	private WebDriver driver = null;
	private static final Logger LOG = Logger.getLogger(SSBLoginFunctionalityInvalidOTPHelper.class);
	public SSBLoginFunctionalityInvalidOTPHelper(WebDriver driver) {
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
	}
	// TODO
	// Add in locators for respective web elements 
	
	// Clicking on the Signin (Account Locator)
	public void clickOnAccount() {
		try {
			if(WebElementOperationsWeb.isDisplayed(driver,LoginInvalidOTP.getSignIn())) {
				WebElementOperationsWeb.click(driver, LoginInvalidOTP.getSignIn());
			}else {
				LOG.error("Account Element not Found");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Account: "+LoginInvalidOTP.getSignIn(), e);
		}
	}
	
	// Title box locator and enter mobile number
	public void LoginEnterUsername(String token) {
		try {
			if(WebElementOperationsWeb.isDisplayed(driver,LoginInvalidOTP.getUserNameTypeIn())) {
				WebElementOperationsWeb.sendKeys(LoginInvalidOTP.getUserNameTypeIn(), token);
			}else {
				LOG.error("Please enter a valid email or phone number");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Username/Phonenumber Block: "+LoginInvalidOTP.getUserNameTypeIn(), e);
		}
	}
	
	// Click on Proceed 
	public void LoginProceed() {
		try {
			if(WebElementOperationsWeb.isDisplayed(driver,LoginInvalidOTP.getProceedButton())) {
				WebElementOperationsWeb.click(driver, LoginInvalidOTP.getProceedButton());
			}else {
				LOG.error("Please enter a valid Email");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Username/Phonenumber Block: "+LoginInvalidOTP.getProceedButton(), e);
		}
	}
	
	// Enter Password
	public void LoginPasswordTypeIn(String token) {
		try {
			if(WebElementOperationsWeb.isDisplayed(driver,LoginInvalidOTP.getPasswordTypeIn())) {
				WebElementOperationsWeb.sendKeys(LoginInvalidOTP.getPasswordTypeIn(), token);
			}else {
				LOG.error("Please enter a validOTP");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Username/Phonenumber Block: "+LoginInvalidOTP.getPasswordTypeIn(), e);
		}
	}
	
	// Click on Verify 
	public void LogInButtonClick() {
		try {
			if(WebElementOperationsWeb.isDisplayed(driver,LoginInvalidOTP.getLogInButton())) {
				WebElementOperationsWeb.click(driver, LoginInvalidOTP.getLogInButton());
			}else {
				LOG.error("Please enter a valid OTP");
			}
		} catch (Exception e) {
			handleOnException("Unknown error while clicking on verify OTP: "+LoginInvalidOTP.getLogInButton(), e);
		}
	}
	/*
	// Click on Login Button (Locator for Login button)
	public void BlankPassword(String token) {
		try {
			if(WebElementOperationsWeb.isDisplayed(driver,LoginFunctionality.getUserAccount())) {
				WebElementOperationsWeb.click(driver, LoginFunctionality.getUserAccount());
			}else {
				LOG.error("Please enter a valid password");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Username/Phonenumber Block: "+LoginFunctionality.getUserAccount(), e);
		}
	}
	
	public void Logout() {
		try {
			if(WebElementOperationsWeb.isDisplayed(driver,LoginFunctionality.getUserAccount())) {
				WebElementOperationsWeb.click(driver, LoginFunctionality.getUserAccount());
			}else {
				LOG.error("User Logged out");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Username/Phonenumber Block: "+LoginFunctionality.getUserAccount(), e);
		}
	}
	
	public void ForgotPassword() {
		try {
			if(WebElementOperationsWeb.isDisplayed(driver,LoginFunctionality.getUserAccount())) {
				WebElementOperationsWeb.click(driver, LoginFunctionality.getUserAccount());
			}else {
				LOG.error("Forgot Password");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Username/Phonenumber Block: "+LoginFunctionality.getUserAccount(), e);
		}
	}
	
	public void ForgotPasswordVerifyfields() {
		try {
			if(WebElementOperationsWeb.isDisplayed(driver,LoginFunctionality.getUserAccount())) {
				WebElementOperationsWeb.click(driver, LoginFunctionality.getUserAccount());
			}else {
				LOG.error("Forgot Password");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Username/Phonenumber Block: "+LoginFunctionality.getUserAccount(), e);
		}
	}*/
	


}
