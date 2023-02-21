package com.sslweb.automation.test.page.actions.helper;

import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.userloginfunctionalitycheck.model.SSBLoginFunctionality;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.testscripts.db.DataBaseConnect;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;
//import com.sslweb.automation.util.encryption.EncryptDecryptPassword;

public class SSBLoginFunctionalityHelper extends GlobalExceptionHandler {
	// In this class we are performing operations on the web element

	private WebDriver driver = null;
	private static WebDriver driver1;
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
				WebElementOperationsWeb.click(driver, SSBLoginFunctionality.getProceedButton());
			} else {
				LOG.error("Please enter a valid password");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Password Block: "
					+ SSBLoginFunctionality.getProceedButton(), e);
		}
	}

	private void sendOtpDB(String testCaseName, String otp) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBLoginFunctionality.getPasswordTypeIn())) {
				WebElementOperationsWeb.sendKeys(driver, SSBLoginFunctionality.getPasswordTypeIn(), otp);
				WebElementOperationsWeb.park(3);
			} else {
				throw new ShoppersStopBusinessException(
						"Error occured while sending OTP [" + SSBLoginFunctionality.getPasswordTypeIn() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "OTP");
			handleOnException("Error occured while sending OTP [" + SSBLoginFunctionality.getPasswordTypeIn() + "]", e);
		}
	}

	// Enter OTP
	public void LoginOTP(String testCaseName, String mobileNumber) {
		try {
			//String otpNum=dataBaseConnect.getOTP(mobileNumber);
			
			System.out.println("------>>>>LoginOTP method Execution Started<<<<----");
			
			//JavascriptExecutor executor = (JavascriptExecutor) driver;
			//executor.executeScript("window.open()");
			
			WebElementOperationsWeb.windowHandle(driver);
			
			//driver.get("https://test4.shopper-stop.in/backoffice/login.zul");
			
			//WebElementOperationsWeb.sendKeys(driver.findElement(By.xpath("//input[@name='j_username']")), "saibhavani.p@techouts.com");
			
			//WebElementOperationsWeb.sendKeys(driver.findElement(By.xpath("//input[@name='j_password']")), "sai@123");
			
			Thread.sleep(2000);
			
			//WebElementOperationsWeb.click(driver.findElement(By.xpath("//button[text()='Login']")));		
			
			//WebElementOperationsWeb.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Filter Tree entries']")), "User OTP Model");
			
			//WebElementOperationsWeb.click(driver.findElement(By.xpath("//span[text()='User OTP Model']")));
			
			//WebElementOperationsWeb.click(driver.findElement(By.xpath("//button[@title='Switch search mode']")));
			
			//WebElementOperationsWeb.sendKeys(driver.findElement(By.xpath("//span[text()='Mobile']/following::td[2]/div/input")), mobileNumber);
			
			WebElementOperationsWeb.click(driver.findElement(By.xpath("//button[text()='Search']")));
			
			WebElementOperationsWeb.click(driver.findElement(By.xpath("//span[text()='MOBILE']")));
			
			String otpNum = WebElementOperationsWeb.getAttributeValue(driver.findElement(By.xpath("//span[text()='OTP']/following::div[3]/input")));
						
			//WebElementOperationsWeb.click(driver.findElement(By.xpath("//img[@title='Delete']")));
			
			//WebElementOperationsWeb.click(driver.findElement(By.xpath("//button[text()='Yes']")));
			
			System.out.println("---->>OTP from BO is<<----- " +otpNum);
			
			String Decryptotp = decryptusingweb(otpNum);
			//String Decryptotp = EncryptDecryptPassword.decrypt(otpNum);
			//System.out.println(Decryptotp);
			//sendOtpDB(testCaseName, Decryptotp);
			
			Thread.sleep(2000);
			
			WebElementOperationsWeb.handleParentTab(driver);
			
			List<WebElement> otp = driver.findElements(By.xpath("//input[@type='tel']"));
			
			for(int i=0; i<otp.size(); i++) {
				
				otp.get(i).sendKeys(String.valueOf(Decryptotp.charAt(i)));
				//WebElementOperationsWeb.sendKeys(otp, Decryptotp.charAt(i));
			}
			
						
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Username/Phonenumber Block: "
					+ SSBLoginFunctionality.getPasswordTypeIn(), e);
		}
	}

	// Click on Log in
	public void LogInButtonClick() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBLoginFunctionality.getLogInButton())) {
				WebElementOperationsWeb.click(driver, SSBLoginFunctionality.getLogInButton());
			} else {
				LOG.error("Please enter a valid email or phone number");
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
			
			//JavascriptExecutor executor = (JavascriptExecutor) driver;
			//executor.executeScript("window.open()");
						
			//driver1 = new HtmlUnitDriver();
			//driver1.get("https://md5decrypt.net/en/Sha256/#answer");
			//WebElementOperationsWeb.park(5);
			
			driver.get("https://md5decrypt.net/en/Sha256/#answer");
			
			Thread.sleep(2000);
			
			WebElement element = driver.findElement(By.xpath("//textarea[@id='hash_input']"));
			element.sendKeys(strToDecrypt);
			driver.findElement(By.xpath("//input[@name='decrypt']")).click();
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

}
