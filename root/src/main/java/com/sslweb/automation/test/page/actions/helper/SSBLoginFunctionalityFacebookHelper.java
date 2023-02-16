package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.userloginfunctionalitycheck.model.SSBLoginFunctionality;
import com.sslweb.automation.userloginfunctionalityfacebook.model.FacebookLoginFunctionality;
import com.sslweb.automation.userloginresendotpfunctionalitycheck.model.SSBLoginResendOTPFunctionality;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBLoginFunctionalityFacebookHelper extends GlobalExceptionHandler  {
	// In this class we are performing operations on the web element 
	
	private WebDriver driver = null;
	private static final Logger LOG = Logger.getLogger(SSBLoginFunctionalityFacebookHelper.class);
	public SSBLoginFunctionalityFacebookHelper(WebDriver driver) {
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions");
	}
	
	
	public void clickOnSignin() {
		try {
			WebElementOperationsWeb.click(driver, FacebookLoginFunctionality.getSignIn());
			}
		 catch (Exception e) {
			handleOnException("Unknown error occured while clicking Account: "+FacebookLoginFunctionality.getSignIn(), e);
		}
	}
	
	// Click on Facebook icon icon 
	public void FacebookIcon() {
		try {
			if(WebElementOperationsWeb.isDisplayed(driver,FacebookLoginFunctionality.getFacebookIconClick())) {
				WebElementOperationsWeb.click(FacebookLoginFunctionality.getFacebookIconClick());
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on facebook Icon: "+FacebookLoginFunctionality.getFacebookIconClick(), e);
		}
	}
	
	
	// Enter Email ID
	public void SendEmailid(String testCaseName,String email) {
		try {
			if(WebElementOperationsWeb.isDisplayed(driver,FacebookLoginFunctionality.getEmailID())) {
				WebElementOperationsWeb.sendKeys(FacebookLoginFunctionality.getEmailID(), email);
			}else {
				LOG.error("Please enter a valid Email");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while sending Email ID : "+FacebookLoginFunctionality.getEmailID(), e);
		}
	}
	
	
		
	// Enter Password
		public void SendPassword(String testCaseName,String password) {
			try {
				if(WebElementOperationsWeb.isDisplayed(driver,FacebookLoginFunctionality.getPassword())) {
					WebElementOperationsWeb.sendKeys(FacebookLoginFunctionality.getPassword(), password);
				}else {
					LOG.error("Please enter a valid password");
				}
			} catch (Exception e) {
				handleOnException("Unknown error occured while sending Password : "+FacebookLoginFunctionality.getPassword(), e);
			}
		}
		
		// Click Login 
				public void ClickLogin() {
					try {
						if(WebElementOperationsWeb.isDisplayed(driver,FacebookLoginFunctionality.getLoginButton())) {
							WebElementOperationsWeb.click(driver, FacebookLoginFunctionality.getLoginButton());
						}else {
							LOG.error("Login not working");
						}
					} catch (Exception e) {
						handleOnException("Unknown error occured while clicking on Login: "+FacebookLoginFunctionality.getLoginButton(), e);
					}
				}
				
				// Click on Log in
				public void Usernamemousehover() {
					try {
						if (WebElementOperationsWeb.isDisplayed(driver, FacebookLoginFunctionality.getUserName())) {
							WebElementOperationsWeb.mouseOver(driver, FacebookLoginFunctionality.getUserName());
						} else {
							throw new ShoppersStopBusinessException(
									"Error occured in mousehovering profileIcon [" + FacebookLoginFunctionality.getUserName() + "]");
						}
					} catch (Exception e) {
						handleOnException("Unknown error occured while Mousehover Block: "
								+ FacebookLoginFunctionality.getUserName(), e);
					}
				}
				
				// Click on Log out
				public void LogOutClick() {
					try {
						if (WebElementOperationsWeb.isDisplayed(driver, SSBLoginFunctionality.getLogOut())) {
							WebElementOperationsWeb.click(driver, SSBLoginFunctionality.getLogOut());
						} else {
							LOG.error("Please enter a valid email or phone number");
						}
					} catch (Exception e) {
						handleOnException("Unknown error occured while clicking on logout: " + SSBLoginFunctionality.getLogOut(),
								e);
					}
				}

}
