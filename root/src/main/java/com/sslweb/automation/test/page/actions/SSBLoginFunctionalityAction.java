package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.loginusinginvalidmobilenumber.model.LoginInvalidMobileNumber;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
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

	public void LoginFunctionalityClick(String testCaseName, String mobileNumber) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityHelper.clickOnAccount();
			WebElementOperationsWeb.park(5);
		} catch (Exception e) {
			handleOnException("Unable to click on Account icon", e);
		}
	}
	public void openNewTab(String testCaseName) {
		try {
			WebElementOperationsWeb.openingNewTab(driver);			
			WebElementOperationsWeb.windowHandle(driver);
			
		} catch (Exception e) {
			handleOnException("Error occured in opening new tab", e);
		}
	}

	public void backofficeLoginFunctionality(String testCaseName,String username, String password) {
		try {

			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityHelper.backofficeLoginEnterUsername(username);
			ssbLoginFunctionalityHelper.backofficeLoginEnterPassword(password);
			ssbLoginFunctionalityHelper.backofficeClickOnLoginButton();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "BackofficeLoginFunctionality");

		} catch (Exception e) {
			handleOnException("Error occured while login to backoffice", e);
		}
	}
	public void LoginFunctionalityusingMobileNumber(String username, String testCaseName) {
		try {
			WebElementOperationsWeb.park(1);
			ssbLoginFunctionalityHelper.LoginEnterUsername(username);
			WebElementOperationsWeb.park(3);
			ssbLoginFunctionalityHelper.LoginProceed();	
			WebElementOperationsWeb.park(3);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Mobile Number Entered");
		} catch (Exception e) {
			handleOnException("Error occured while login to site", e);
		}
	}

	public void backofficeMobileNumberVerication( String testCaseName,String mobileNumber,int arrayNum) {
		try {			
			ssbLoginFunctionalityHelper.backofficeEnterInUserOtpModel("User OTP Model");
			WebElementOperationsWeb.park(3);
			ssbLoginFunctionalityHelper.backofficeClickOnUserOtpModel();
			ssbLoginFunctionalityHelper.backofficeClickOnSearchModel();
			ssbLoginFunctionalityHelper.backofficeEnterMobileNumber(mobileNumber);
			ssbLoginFunctionalityHelper.backofficeClickOnSearchButton();
			ssbLoginFunctionalityHelper.backofficeClickOnMobileNumberInResults();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "MobileNumber Verification in Backoffice");

		} catch (Exception e) {
			handleOnException("Error occured while verifying mobile number in backoffice", e);

		}
	}	
	
	public void backofficeGetOtp( String testCaseName) {
		try {
			Thread.sleep(2000);
			WebElementOperationsWeb.windowHandle(driver);
			Thread.sleep(2000);
			ssbLoginFunctionalityHelper.backofficeClickOnSearchButton();
			Thread.sleep(3000);
			ssbLoginFunctionalityHelper.backofficeClickOnMobileNumberInResultsToGetOtp();
			Thread.sleep(3000);
			ssbLoginFunctionalityHelper.getOTP(testCaseName);
			Thread.sleep(2000);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "MobileNumber Verification in Backoffice");

		} catch (Exception e) {
			handleOnException("Error occured while getting otp in backoffice", e);
		}
	}	
	
	
	public String decryptusingweb(String strToDecrypt) {
		try {		
			Thread.sleep(2000);
			ssbLoginFunctionalityHelper.sendDecryptText(strToDecrypt);
			ssbLoginFunctionalityHelper.clickOnDecryptbutton();
			WebElementOperationsWeb.park(3);
			String decryptedOTP = driver.findElement(By.cssSelector("fieldset[id='answer'] b")).getText();
			System.out.println(decryptedOTP);
			return decryptedOTP;
		} catch (Exception e) {
			System.out.println("Decrypting is not working as Expected");
		}
		return null;
	}
	public void Invalidnumpopup() {
		if (WebElementOperationsWeb.isDisplayed(driver, LoginInvalidMobileNumber.getInvalidNumPopup())) {
			throw new ShoppersStopBusinessException(
					"Sign in [" + LoginInvalidMobileNumber.getInvalidNumPopup() + PopUp_IS_DISPLAYED);
		}
	}

	/*
	 * public void LoginFunctionalityEnterOTP(String testCaseName) { try {
	 * 
	 * WebElementOperationsWeb.park(15);
	 * ssbLoginFunctionalityHelper.enterOtp(testCaseName);
	 * WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName,
	 * "Logged in Successfully"); } catch (Exception e) {
	 * handleOnException("Error occured while entering otp", e); } }
	 */

	public void LoginFunctionalityClickonLogInButton(String testCaseName) {
		try {

			ssbLoginFunctionalityHelper.LogInButtonClick();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Logout Successfull");
		} catch (Exception e) {
			handleOnException("Error occured while clicking login buton", e);
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
			handleOnException("Error occured while doing logout", e);
		}
	}

	public void enterOtp(String testCaseName,int arrayNum) {
		ssbLoginFunctionalityHelper.enterOtpByDecrypting(testCaseName,arrayNum)	;	
	}
	
}
