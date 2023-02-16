package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.userloginresendotpfunctionalitycheck.model.SSBLoginResendOTPFunctionality;
import com.sslweb.automation.util.encryption.DecryptionWeb;
import com.sslweb.automation.util.encryption.EncryptDecryptPassword;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.testscripts.db.DataBaseConnect;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;
//import com.sslweb.automation.util.encryption.EncryptDecryptPassword;

public class SSBLoginResendOTPFunctionalityHelper extends GlobalExceptionHandler {
	// In this class we are performing operations on the web element

	private WebDriver driver = null;
	private static WebDriver driver1;
	private static final Logger LOG = Logger.getLogger(SSBLoginResendOTPFunctionalityHelper.class);
	private DataBaseConnect dataBaseConnect;

	public SSBLoginResendOTPFunctionalityHelper(WebDriver driver) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
		dataBaseConnect=new DataBaseConnect();
	}

	// TODO
	// Add in locators for respective web elements

	// Clicking on the Signin (Account Locator)
	public void clickOnAccount() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBLoginResendOTPFunctionality.getSignIn())) {
				WebElementOperationsWeb.click(driver, SSBLoginResendOTPFunctionality.getSignIn());
			} else {
				LOG.error("Account Element not Found");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Account: " + SSBLoginResendOTPFunctionality.getSignIn(), e);
		}
	}
	
	
	// Username Title box locator and enter user name
	public void LoginEnterUsernameMobileNum(String token) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBLoginResendOTPFunctionality.getUserNameTypeIn())) {
				WebElementOperationsWeb.sendKeys(SSBLoginResendOTPFunctionality.getUserNameTypeIn(), token);
			} else {
				LOG.error("Please enter a valid email or phone number");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Username/Phonenumber Block: "
					+ SSBLoginResendOTPFunctionality.getUserNameTypeIn(), e);
		}
	}

	// Click on Proceed
	public void LoginProceed() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBLoginResendOTPFunctionality.getProceedButton())) {
				WebElementOperationsWeb.click(driver, SSBLoginResendOTPFunctionality.getProceedButton());
			} else {
				LOG.error("Please enter a valid password");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Password Block: "
					+ SSBLoginResendOTPFunctionality.getProceedButton(), e);
		}
	}

	private void sendOtpDB(String testCaseName, String otp) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBLoginResendOTPFunctionality.getResendOTPTypeIn())) {
				WebElementOperationsWeb.sendKeys(driver, SSBLoginResendOTPFunctionality.getResendOTPTypeIn(), otp);
				WebElementOperationsWeb.park(3);
			} else {
				throw new ShoppersStopBusinessException(
						"Error occured while sending OTP [" + SSBLoginResendOTPFunctionality.getResendOTPTypeIn() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "OTP");
			handleOnException("Error occured while sending OTP [" + SSBLoginResendOTPFunctionality.getResendOTPTypeIn() + "]", e);
		}
	}

	// Enter OTP
	public void LoginOTP(String testCaseName, String mobileNumber) {
		try {
			String otpNum=dataBaseConnect.getOTP(mobileNumber);
			String Decryptotp = decryptusingweb(otpNum);
			//String Decryptotp = EncryptDecryptPassword.decrypt(otpNum);
			System.out.println(Decryptotp);
			//sendOtpDB(testCaseName, Decryptotp);
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Username/Phonenumber Block: "
					+ SSBLoginResendOTPFunctionality.getResendOTPTypeIn(), e);
		}
	}
	
	//resend OTP
	public void LogInResendOTPButtonClick() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBLoginResendOTPFunctionality.getResendOTPTypeIn())) {
				WebElementOperationsWeb.click(driver, SSBLoginResendOTPFunctionality.getResendOTPTypeIn());
			} else {
				LOG.error("Please enter a valid otp");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking ResendOTPButton Block: "
					+ SSBLoginResendOTPFunctionality.getLogInButton(), e);
		}
	}

	// Click on Log in
	public void LogInButtonClick() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBLoginResendOTPFunctionality.getLogInButton())) {
				WebElementOperationsWeb.click(driver, SSBLoginResendOTPFunctionality.getLogInButton());
			} else {
				LOG.error("Please enter a valid email or phone number");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking LoginButton Block: "
					+ SSBLoginResendOTPFunctionality.getLogInButton(), e);
		}
	}

	// Click on Log in
	public void Usernamemousehover() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBLoginResendOTPFunctionality.getUserName())) {
				WebElementOperationsWeb.mouseOver(driver, SSBLoginResendOTPFunctionality.getUserName());
			} else {
				throw new ShoppersStopBusinessException(
						"Error occured in mousehovering profileIcon [" + SSBLoginResendOTPFunctionality.getUserName() + "]");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while Mousehover Block: "
					+ SSBLoginResendOTPFunctionality.getUserName(), e);
		}
	}
	
	public static String decryptusingweb(String strToDecrypt) {
		try {
			driver1 = new HtmlUnitDriver();
			driver1.get("https://md5decrypt.net/en/Sha256/#answer");
			WebElementOperationsWeb.park(5);
			WebElement element = driver1.findElement(By.xpath("//textarea[@id='hash_input']"));
			element.sendKeys(strToDecrypt);
			driver1.findElement(By.xpath("//input[@name='decrypt']")).click();
			WebElementOperationsWeb.park(3);
			String decryptedOTP = driver1.findElement(By.cssSelector("fieldset[id='answer'] b")).getText();
			System.out.println(decryptedOTP);
			return decryptedOTP;
		} catch (Exception e) {
			System.out.println("Decrypting is not working as Expected");
		}
		return null;
	}

	// Click on Log out
	public void LogOutClick() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBLoginResendOTPFunctionality.getLogOut())) {
				WebElementOperationsWeb.click(driver, SSBLoginResendOTPFunctionality.getLogOut());
			} else {
				LOG.error("Please enter a valid email or phone number");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on logout: " + SSBLoginResendOTPFunctionality.getLogOut(),
					e);
		}
	}

}
