package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.sslweb.automation.loginusinginvalidmobilenumber.model.LoginInvalidMobileNumber;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.userloginfunctionalitycheck.model.SSBLoginFunctionality;
import com.sslweb.automation.util.encryption.DecryptionWeb;
import com.sslweb.automation.util.encryption.EncryptDecryptPassword;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.testscripts.db.DataBaseConnect;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;
//import com.sslweb.automation.util.encryption.EncryptDecryptPassword;

public class SSBLoginFunctionalityInvalidMobileNumHelper extends GlobalExceptionHandler {
	// In this class we are performing operations on the web element

	private WebDriver driver = null;
	private static WebDriver driver1;
	private static final Logger LOG = Logger.getLogger(SSBLoginFunctionalityInvalidMobileNumHelper.class);
	private DataBaseConnect dataBaseConnect;

	public SSBLoginFunctionalityInvalidMobileNumHelper(WebDriver driver) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
		dataBaseConnect=new DataBaseConnect();
	}

	// TODO
	// Add in locators for respective web elements

	// Clicking on the Signin (Account Locator)
	public void clickOnAccount() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, LoginInvalidMobileNumber.getSignIn())) {
				WebElementOperationsWeb.click(driver, LoginInvalidMobileNumber.getSignIn());
			} else {
				LOG.error("Account Element not Found");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Account: " + LoginInvalidMobileNumber.getSignIn(), e);
		}
	}
	
	
	// Username Title box locator and enter user name
	public void LoginEnterUsername(String token) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, LoginInvalidMobileNumber.getUserNameTypeIn())) {
				WebElementOperationsWeb.sendKeys(LoginInvalidMobileNumber.getUserNameTypeIn(), token);
			} else {
				LOG.error("Please enter a valid email or phone number");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Username/Phonenumber Block: "
					+ LoginInvalidMobileNumber.getUserNameTypeIn(), e);
		}
	}

		// Click on Log in
	public void LogInPopUp() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, LoginInvalidMobileNumber.getInvalidNumPopup())) {
				WebElementOperationsWeb.click(driver, LoginInvalidMobileNumber.getInvalidNumPopup());
			} else {
				LOG.error("Please enter a valid email or phone number");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking LoginButton Block: "
					+ LoginInvalidMobileNumber.getInvalidNumPopup(), e);
		}
	}
}
