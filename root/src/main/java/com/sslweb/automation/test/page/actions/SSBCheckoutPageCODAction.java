package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.loginusinginvalidmobilenumber.model.LoginInvalidMobileNumber;
import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBCheckoutPageCODHelper;
import com.sslweb.automation.test.page.actions.helper.SSBCheckoutPageNavigationHelper;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageCODAction extends GlobalExceptionHandler {

	private WebDriver driver = null;
	private static final String PopUp_IS_DISPLAYED = "] is displayed";
	public JavascriptExecutor js;

	private SSBCheckoutPageCODHelper ssbcheckoutcodpay;
	private SSBCheckoutPageNavigationHelper ssbcheckoutNavigation;

	public SSBCheckoutPageCODAction(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbcheckoutcodpay = new SSBCheckoutPageCODHelper(driver, repository);
		ssbcheckoutNavigation = new SSBCheckoutPageNavigationHelper(driver, repository);
		js = (JavascriptExecutor) driver;
	}

	public void LoginFunctionalityClick(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbcheckoutcodpay.clickOnAccount();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void LoginFunctionalityusingMobileNumber(String username, String testCaseName) {
		try {

			WebElementOperationsWeb.park(5);
			ssbcheckoutcodpay.LoginEnterUsername(username);
			WebElementOperationsWeb.park(3);
			ssbcheckoutcodpay.LoginProceed();
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

			WebElementOperationsWeb.park(30);
			//ssbLoginFunctionalityHelper.LoginOTP(testCaseName, mobileNumber);
			//WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Logged in Successfully");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void LoginFunctionalityClickonLogInButton(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbcheckoutcodpay.LogInButtonClick();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Logout Successfull");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void AddToCartFunctionality(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbcheckoutcodpay.ClickonAddToCartProduct();
			WebElementOperationsWeb.park(5);
			ssbcheckoutcodpay.ClickonAddToCartClick();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Logout Successfull");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}	

	public void PaymentUsingCOD(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			js.executeScript("window.scrollBy(0,100)"," ");
			WebElementOperationsWeb.park(5);
			ssbcheckoutcodpay.ClickonPlaceOrder();
			WebElementOperationsWeb.park(5);
			ssbcheckoutcodpay.ClickonContinue();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			js.executeScript("window.scrollBy(0,400)"," ");
			WebElementOperationsWeb.park(5);
			ssbcheckoutcodpay.ClickonCOD();
			WebElementOperationsWeb.park(5);
			ssbcheckoutcodpay.ClickonCODPlaceOrder();
			WebElementOperationsWeb.park(5);
			ssbcheckoutcodpay.ClickonContinueShopping();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
			// ssbcheckoutnetbankingpay.ClickonPayNow();
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void Logoutfunctionalitycheck(String testCaseName) {
		try {
			WebElementOperationsWeb.park(5);
			ssbcheckoutcodpay.Usernamemousehover();
			WebElementOperationsWeb.park(5);
			ssbcheckoutcodpay.LogOutClick();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

}
