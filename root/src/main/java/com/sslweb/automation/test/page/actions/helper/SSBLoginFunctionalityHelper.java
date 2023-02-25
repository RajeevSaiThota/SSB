package com.sslweb.automation.test.page.actions.helper;

import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.userbackofficeloginfunctionalitycheck.model.SSBBackofficeLoginFunctionality;
import com.sslweb.automation.userloginfunctionalitycheck.model.SSBLoginFunctionality;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.testscripts.db.DataBaseConnect;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;
//import com.sslweb.automation.util.encryption.EncryptDecryptPassword;

public class SSBLoginFunctionalityHelper extends GlobalExceptionHandler {
	// In this class we are performing operations on the web element

	private WebDriver driver = null;
	private static final Logger LOG = Logger.getLogger(SSBLoginFunctionalityHelper.class);
	private DataBaseConnect dataBaseConnect;

	public SSBLoginFunctionalityHelper(WebDriver driver) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
		dataBaseConnect=new DataBaseConnect();
	}

	// TODO
	// Add in locators for respective web elements

	// Clicking on the Signin (Account Locator)
	public void clickOnAccount() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBLoginFunctionality.getSignIn())) {
				WebElementOperationsWeb.click(driver, SSBLoginFunctionality.getSignIn());
			} else {
				LOG.error("Account Element not Found");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Account: " + SSBLoginFunctionality.getSignIn(), e);
		}
	}
	
	
	// Username Title box locator and enter user name
	public void LoginEnterUsername(String token) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBLoginFunctionality.getUserNameTypeIn())) {
				WebElementOperationsWeb.sendKeys(SSBLoginFunctionality.getUserNameTypeIn(), token);
			} else {
				LOG.error("Please enter a valid email or phone number");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Username/Phonenumber Block: "
					+ SSBLoginFunctionality.getUserNameTypeIn(), e);
		}
	}

	// Click on Proceed
	public void LoginProceed() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBLoginFunctionality.getProceedButton())) {
				WebElementOperationsWeb.park(2);
				WebElementOperationsWeb.jsClick(driver, SSBLoginFunctionality.getProceedButton());
			} else {
				LOG.error("Please enter a valid password");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Password Block: "
					+ SSBLoginFunctionality.getProceedButton(), e);
		}
	}


	String otpNum = null;

	public String getOTP(String testCaseName) {
		try {
			otpNum = WebElementOperationsWeb.getAttributeValue(SSBBackofficeLoginFunctionality.getGetOtpNumber());
		
		} catch (Exception e) {
			handleOnException("Error occured while geting otp", e);
		}
		return otpNum;
	}
	
	public void enterOtpByDecrypting(String testCaseName, int arrayNum) {
		try {
		String Decryptotp = decryptusingweb(otpNum);
		WebElementOperationsWeb.park(2);
		WebElementOperationsWeb.handleParentTab(driver,arrayNum);
		WebElementOperationsWeb.park(2);
		List<WebElement> otp = driver.findElements(By.xpath("//input[@type='tel']"));	
		WebElementOperationsWeb.park(2);
		WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "enterOtpByDecrypting");

		for(int i=1; i<otp.size(); i++) {
			WebElementOperationsWeb.sendKeys(otp.get(i), String.valueOf(Decryptotp.charAt(i-1)));
			/*
			 * otp.get(i).click();
			 * otp.get(i).sendKeys(String.valueOf(Decryptotp.charAt(i)));
			 */
		}
	} catch (Exception e) {
		handleOnException("Error occured while decrypting and entering otp", e);
	}
}

/*
 * public void enterOtp(String testCaseName) { try { String Decryptotp =
 * decryptusingweb(getOTP(testCaseName));
 * WebElementOperationsWeb.handleParentTab(driver); List<WebElement> otp =
 * driver.findElements(By.xpath("//input[@type='tel']"));
 * 
 * for(int i=0; i<otp.size(); i++) {
 * 
 * otp.get(i).sendKeys(String.valueOf(Decryptotp.charAt(i))); } } catch
 * (Exception e) { handleOnException("All Fields Displayed not able found", e);
 * } }
 */
	
	// Enter OTP
	
	  public void LoginOTP(String testCaseName, String mobileNumber,int arrayNum) { try {
	  
	  System.out.println("------>>>>LoginOTP method Execution Started<<<<----");
	  WebElementOperationsWeb.windowHandle(driver); Thread.sleep(2000);
	  
	  WebElementOperationsWeb.click(driver.findElement(By.xpath(
	  "//button[text()='Search']"))); Thread.sleep(2000);
	  
	  WebElementOperationsWeb.click(driver.findElement(By.xpath(
	  "//span[text()='MOBILE']"))); Thread.sleep(2000);
	  
	  String otpNum =
	  WebElementOperationsWeb.getAttributeValue(driver.findElement(By.xpath(
	  "//span[text()='OTP']/following::div[3]/input")));
	  
	  //WebElementOperationsWeb.click(driver.findElement(By.xpath( "//img[@title='Delete']")));
	  
	  //WebElementOperationsWeb.click(driver.findElement(By.xpath(  "//button[text()='Yes']")));
	  
	  System.out.println("---->>OTP from BO is<<----- " +otpNum);
	  
	  String Decryptotp = decryptusingweb(otpNum);
	  //String Decryptotp =	  EncryptDecryptPassword.decrypt(otpNum); //System.out.println(Decryptotp);
	  //sendOtpDB(testCaseName, Decryptotp);
	  
	  Thread.sleep(2000);
	  
	  WebElementOperationsWeb.handleParentTab(driver,arrayNum); Thread.sleep(2000);
	  
	  List<WebElement> otp = driver.findElements(By.xpath("//input[@type='tel']"));
	  
	  for(int i=0; i<otp.size(); i++) {
	  
	  otp.get(i).sendKeys(String.valueOf(Decryptotp.charAt(i)));
	  //WebElementOperationsWeb.sendKeys(otp, Decryptotp.charAt(i)); }
	  
	  
	  }} catch (Exception e) {
	  handleOnException("Unknown error occured while clicking Username/Phonenumber Block: "
	  + SSBLoginFunctionality.getPasswordTypeIn(), e); } }
	 

	// Click on Log in
	public void LogInButtonClick() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBLoginFunctionality.getLogInButton())) {
				WebElementOperationsWeb.click(driver, SSBLoginFunctionality.getLogInButton());
			} else {
				LOG.error("Error in clicking login button");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking LoginButton Block: "
					+ SSBLoginFunctionality.getLogInButton(), e);
		}
	}

	// Click on Log in
	public void Usernamemousehover() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBLoginFunctionality.getUserName())) {
				WebElementOperationsWeb.mouseOver(driver, SSBLoginFunctionality.getUserName());
			} else {
				throw new ShoppersStopBusinessException(
						"Error occured in mousehovering profileIcon [" + SSBLoginFunctionality.getUserName() + "]");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while Mousehover Block: "
					+ SSBLoginFunctionality.getUserName(), e);
		}
	}
	
	public String decryptusingweb(String strToDecrypt) {
		try {
			
			Thread.sleep(5000);			
			sendDecryptText(strToDecrypt);
			clickOnDecryptbutton();
			WebElementOperationsWeb.park(3);
			String decryptedOTP = driver.findElement(By.cssSelector("fieldset[id='answer'] b")).getText();
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
	
	public void backofficeLoginEnterUsername(String userName) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBBackofficeLoginFunctionality.getUserName())) {
				WebElementOperationsWeb.sendKeys(SSBBackofficeLoginFunctionality.getUserName(), userName);
			} else {
				LOG.error("Please enter a valid email");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while sending Username "
					+ SSBBackofficeLoginFunctionality.getUserName(), e);
		}
	}
   
	public void backofficeLoginEnterPassword(String password) {
	try {
		if (WebElementOperationsWeb.isDisplayed(driver, SSBBackofficeLoginFunctionality.getPassword())) {
			WebElementOperationsWeb.sendKeys(SSBBackofficeLoginFunctionality.getPassword(), password);
		} else {
			LOG.error("Please enter a valid password");
		}
	} catch (Exception e) {
		handleOnException("Unknown error occured while sending password "
				+ SSBBackofficeLoginFunctionality.getPassword(), e);
		}
	}
	
	public void backofficeClickOnLoginButton() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBBackofficeLoginFunctionality.getLoginButton())) {
				WebElementOperationsWeb.click(driver, SSBBackofficeLoginFunctionality.getLoginButton());
			} else {
				LOG.error("Error in clicking login button");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking login button "
					+ SSBBackofficeLoginFunctionality.getLoginButton(), e);
			}
		}

	public void backofficeEnterInUserOtpModel(String searchValue) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBBackofficeLoginFunctionality.getSendKeysOnUserOtpModel())) {
				WebElementOperationsWeb.sendKeys(SSBBackofficeLoginFunctionality.getSendKeysOnUserOtpModel(), searchValue);
			} else {
				LOG.error("Please enter a valid searchValue");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while sending searchValue "
					+ SSBBackofficeLoginFunctionality.getSendKeysOnUserOtpModel(), e);
			}
		}
	
	public void backofficeClickOnUserOtpModel() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBBackofficeLoginFunctionality.getClickOnUserOtpModel())) {
				WebElementOperationsWeb.click(driver, SSBBackofficeLoginFunctionality.getClickOnUserOtpModel());
			} else {
				LOG.error("Error in clicking UserOtpModel");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking UserOtpModel "
					+ SSBBackofficeLoginFunctionality.getClickOnUserOtpModel(), e);
			}
		}
	
	public void backofficeClickOnSearchModel() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBBackofficeLoginFunctionality.getClickOnSearchModel())) {
				WebElementOperationsWeb.click(driver, SSBBackofficeLoginFunctionality.getClickOnSearchModel());
			} else {
				LOG.error("Error in clicking SearchModel");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking SearchModel "
					+ SSBBackofficeLoginFunctionality.getClickOnSearchModel(), e);
			}
		}
	
	public void backofficeEnterMobileNumber(String mobileNumber) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBBackofficeLoginFunctionality.getEnterMobileNumber())) {
				WebElementOperationsWeb.sendKeys(SSBBackofficeLoginFunctionality.getEnterMobileNumber(), mobileNumber);
			} else {
				LOG.error("Please enter a valid mobileNumber");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while sending mobileNumber "
					+ SSBBackofficeLoginFunctionality.getEnterMobileNumber(), e);
			}
		}
	
	public void backofficeClickOnSearchButton() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBBackofficeLoginFunctionality.getClickOnSearchButton())) {
				WebElementOperationsWeb.click(driver, SSBBackofficeLoginFunctionality.getClickOnSearchButton());
			} else {
				LOG.error("Error in clicking Search button");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Search button "
					+ SSBBackofficeLoginFunctionality.getClickOnSearchButton(), e);
			}
		}
	
	public void backofficeClickOnMobileNumberInResults() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBBackofficeLoginFunctionality.getMobileNumberInResults())) {
				backofficeClickOnMobileNumberInResultsToGetOtp();
				backofficeClickOnDeletebutton();
				backofficeClickOnYesbutton();
				} else {
				LOG.info("Mobilenumber not available in results ");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Mobilenumber in results  "
					+ SSBBackofficeLoginFunctionality.getMobileNumberInResults(), e);
			}
		}
	
	public void backofficeClickOnMobileNumberInResultsToGetOtp() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBBackofficeLoginFunctionality.getMobileNumberInResults())) {
				WebElementOperationsWeb.jsClick(driver, SSBBackofficeLoginFunctionality.getMobileNumberInResults());
			} else {
				LOG.error("Error in clicking MobileNumber ");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking MobileNumber  "
					+ SSBBackofficeLoginFunctionality.getMobileNumberInResults(), e);
			}
		}
	
	public void backofficeClickOnDeletebutton() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBBackofficeLoginFunctionality.getClickOnDeleteButton())) {
				WebElementOperationsWeb.click(driver, SSBBackofficeLoginFunctionality.getClickOnDeleteButton());
			} else {
				LOG.error("Error in clicking Delete button ");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Delete button  "
					+ SSBBackofficeLoginFunctionality.getClickOnDeleteButton(), e);
			}
		}
	
	public void backofficeClickOnYesbutton() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBBackofficeLoginFunctionality.getClickOnYesButton())) {
				WebElementOperationsWeb.click(driver, SSBBackofficeLoginFunctionality.getClickOnYesButton());
			} else {
				LOG.error("Error in clicking Yes button ");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Yes button  "
					+ SSBBackofficeLoginFunctionality.getClickOnYesButton(), e);
			}
		}
	public void sendDecryptText(String decryptValue) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBBackofficeLoginFunctionality.getEnterTextInDecrypt())) {
				WebElementOperationsWeb.sendKeys(SSBBackofficeLoginFunctionality.getEnterTextInDecrypt(), decryptValue);
			} else {
				LOG.error("Please enter a valid decryptValue");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while sending decryptValue "
					+ SSBBackofficeLoginFunctionality.getEnterTextInDecrypt(), e);
			}
		}
	public void clickOnDecryptbutton() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBBackofficeLoginFunctionality.getClickOnDecryptButton())) {
				WebElementOperationsWeb.click(driver, SSBBackofficeLoginFunctionality.getClickOnDecryptButton());
			} else {
				LOG.error("Error in clicking Decrypt button ");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Decrypt button  "
					+ SSBBackofficeLoginFunctionality.getClickOnDecryptButton(), e);
			}
		}
}
