package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.loginusinginvalidmobilenumber.model.LoginInvalidMobileNumber;
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
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	public void openNewTab(String testCaseName, String mobileNumber) {
		try {
			WebElementOperationsWeb.openingNewTab(driver);
			
			WebElementOperationsWeb.windowHandle(driver);
			
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	public void verifyingMobileNumberAvailability(String testCaseName, String mobileNumber) {
		try {
			
	
			WebElementOperationsWeb.sendKeys(driver.findElement(By.xpath("//input[@name='j_username']")), "saibhavani.p@techouts.com");
			
			WebElementOperationsWeb.sendKeys(driver.findElement(By.xpath("//input[@name='j_password']")), "sai@123");
			
			Thread.sleep(2000);
			
			WebElementOperationsWeb.click(driver.findElement(By.xpath("//button[text()='Login']")));		
			Thread.sleep(2000);

			WebElementOperationsWeb.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Filter Tree entries']")), "User OTP Model");
			Thread.sleep(2000);

			WebElementOperationsWeb.click(driver.findElement(By.xpath("//span[text()='User OTP Model']")));
			Thread.sleep(2000);

			WebElementOperationsWeb.click(driver.findElement(By.xpath("//button[@title='Switch search mode']")));
			
			WebElementOperationsWeb.sendKeys(driver.findElement(By.xpath("//span[text()='Mobile']/following::td[2]/div/input")), mobileNumber);
			
			WebElementOperationsWeb.click(driver.findElement(By.xpath("//button[text()='Search']")));
			Thread.sleep(2000);

			try {
			
			if(driver.findElement(By.xpath("//span[text()='MOBILE']")).isDisplayed()) {
				
				WebElementOperationsWeb.click(driver.findElement(By.xpath("//img[@title='Delete']")));
				
				WebElementOperationsWeb.click(driver.findElement(By.xpath("//button[text()='Yes']")));
				Thread.sleep(2000);

				WebElementOperationsWeb.handleParentTab(driver);
			} }
			
			catch(Exception e){
				
				WebElementOperationsWeb.handleParentTab(driver);
			}
			
			
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void backofficeLoginFunctionality(String testCaseName,String username, String password) {
		try {

			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityHelper.LoginEnterUsername(username);
			WebElementOperationsWeb.park(3);
			ssbLoginFunctionalityHelper.LoginProceed();
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	public void LoginFunctionalityusingMobileNumber(String username, String testCaseName) {
		try {

			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityHelper.LoginEnterUsername(username);
			WebElementOperationsWeb.park(3);
			ssbLoginFunctionalityHelper.LoginProceed();
			//ssbLoginFunctionalityHelper.LoginOTP(testCaseName, username);
			//LoginFunctionalityEnterOTP(testCaseName, username);
			
			/*
			 * WebElementOperationsWeb.openWebPage(driver,
			 * "https://test4.shopper-stop.in/backoffice/login.zul");
			 * 
			 * WebElementOperationsWeb.sendKeys(driver.findElement(By.xpath(
			 * "//input[@id='pQWVn']")), "saibhavani.p@techouts.com");
			 * 
			 * WebElementOperationsWeb.sendKeys(driver.findElement(By.xpath(
			 * "//input[@id='pQWVs']")), "sai@123");
			 * 
			 * WebElementOperationsWeb.click(driver.findElement(By.xpath(
			 * "//button[text()='Login']")));
			 * 
			 * WebElementOperationsWeb.sendKeys(driver.findElement(By.xpath(
			 * "//input[@id='t5zPsa']")), "User OTP Model");
			 * 
			 * WebElementOperationsWeb.click(driver.findElement(By.
			 * xpath("//span[text()='User OTP Model']")));
			 * 
			 * WebElementOperationsWeb.click(driver.findElement(By.xpath(
			 * "//button[@id='t5zP9f']")));
			 * 
			 * WebElementOperationsWeb.sendKeys(driver.findElement(By.xpath(
			 * "//input[@id='t5zPw02']")), username);
			 * 
			 * WebElementOperationsWeb.click(driver.findElement(By.xpath(
			 * "//button[text()='Search']")));
			 * 
			 * WebElementOperationsWeb.click(driver.findElement(By.xpath(
			 * "//span[text()='MOBILE']")));
			 * 
			 * String otpNum = WebElementOperationsWeb.getText(driver,
			 * driver.findElement(By.xpath("//input[@id='t5zP2s2']")));
			 * 
			 * String Decryptotp = ssbLoginFunctionalityHelper.decryptusingweb(otpNum);
			 */
			
			//System.out.println(Decryptotp);
			
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Mobile Number Entered");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void Invalidnumpopup() {
		if (WebElementOperationsWeb.isDisplayed(driver, LoginInvalidMobileNumber.getInvalidNumPopup())) {
			throw new ShoppersStopBusinessException(
					"Sign in [" + LoginInvalidMobileNumber.getInvalidNumPopup() + PopUp_IS_DISPLAYED);
		}
	}

	public void LoginFunctionalityEnterOTP(String testCaseName, String mobileNumber) {
		try {

			WebElementOperationsWeb.park(15);
			ssbLoginFunctionalityHelper.LoginOTP(testCaseName, mobileNumber);
			//WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Logged in Successfully");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void LoginFunctionalityClickonLogInButton(String testCaseName) {
		try {

			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityHelper.LogInButtonClick();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Logout Successfull");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
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
			handleOnException("All Fields Displayed not able found", e);
		}
	}
}
