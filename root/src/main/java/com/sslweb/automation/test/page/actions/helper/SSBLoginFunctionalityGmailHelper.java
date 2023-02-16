package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.userloginfunctionalitygmail.model.GmailLoginFunctionality;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBLoginFunctionalityGmailHelper extends GlobalExceptionHandler  {
	// In this class we are performing operations on the web element 
	
	private WebDriver driver = null;
	private static final Logger LOG = Logger.getLogger(SSBLoginFunctionalityGmailHelper.class);
	public SSBLoginFunctionalityGmailHelper(WebDriver driver) {
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions");
	}
	
	
	public void clickOnSignin() {
		try {
			WebElementOperationsWeb.click(driver, GmailLoginFunctionality.getSignIn());
			}
		 catch (Exception e) {
			handleOnException("Unknown error occured while clicking Account: "+GmailLoginFunctionality.getSignIn(), e);
		}
	}
	
	// Click on Google icon 
	public void GoogleIcon() {
		try {
			if(WebElementOperationsWeb.isDisplayed(driver,GmailLoginFunctionality.getGmailIconClick())) {
				WebElementOperationsWeb.click(GmailLoginFunctionality.getGmailIconClick());
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Gmail Icon: "+GmailLoginFunctionality.getGmailIconClick(), e);
		}
	}
	
	
	// Enter Email ID
	public void SendEmailid(String testCaseName,String email) {
		try {
			if(WebElementOperationsWeb.isDisplayed(driver,GmailLoginFunctionality.getEmailID())) {
				WebElementOperationsWeb.sendKeys(GmailLoginFunctionality.getEmailID(), email);
			}else {
				LOG.error("Please enter a valid Email");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while sending Email ID : "+GmailLoginFunctionality.getEmailID(), e);
		}
	}
	
	// Click Next 
		public void ClickNext() {
			try {
				if(WebElementOperationsWeb.isDisplayed(driver,GmailLoginFunctionality.getNext())) {
					WebElementOperationsWeb.click(driver, GmailLoginFunctionality.getNext());
				}else {
					LOG.error("Please enter a valid password");
				}
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking on next: "+GmailLoginFunctionality.getNext(), e);
			}
		}
		
	// Enter Password
		public void SendPassword(String testCaseName,String password) {
			try {
				if(WebElementOperationsWeb.isDisplayed(driver,GmailLoginFunctionality.getPassword())) {
					WebElementOperationsWeb.sendKeys(GmailLoginFunctionality.getPassword(), password);
				}else {
					LOG.error("Please enter a valid password");
				}
			} catch (Exception e) {
				handleOnException("Unknown error occured while sending Password : "+GmailLoginFunctionality.getPassword(), e);
			}
		}

}
