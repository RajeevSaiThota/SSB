package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.loginusinginvalidmobilenumber.model.LoginInvalidMobileNumber;
import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBCheckoutPageDebitCardPayHelper;
import com.sslweb.automation.test.page.actions.helper.SSBCheckoutPageNavigationHelper;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageDebitCardPayAction extends GlobalExceptionHandler {

	private WebDriver driver = null;
	private static final String PopUp_IS_DISPLAYED = "] is displayed";
	public JavascriptExecutor js;

	private SSBCheckoutPageNavigationHelper ssbcheckoutNavigation;
	private SSBCheckoutPageDebitCardPayHelper ssbcheckoutdebitcardpay;

	public SSBCheckoutPageDebitCardPayAction(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbcheckoutdebitcardpay = new SSBCheckoutPageDebitCardPayHelper(driver, repository);
		ssbcheckoutNavigation = new SSBCheckoutPageNavigationHelper(driver, repository);
		js = (JavascriptExecutor) driver;
	}

	public void LoginFunctionalityClick(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbcheckoutdebitcardpay.clickOnAccount();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void LoginFunctionalityusingMobileNumber(String username, String testCaseName) {
		try {

			WebElementOperationsWeb.park(5);
			ssbcheckoutdebitcardpay.LoginEnterUsername(username);
			WebElementOperationsWeb.park(3);
			ssbcheckoutdebitcardpay.LoginProceed();
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
			ssbcheckoutdebitcardpay.LogInButtonClick();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Logout Successfull");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void AddToCartFunctionality(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(7);
			// Insert the method NewPincode 
			ssbcheckoutdebitcardpay.ClickonAddToCartProduct();
			WebElementOperationsWeb.park(8);
			ssbcheckoutdebitcardpay.ClickonAddToCartClick();
			WebElementOperationsWeb.park(7);
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(7);
			ssbcheckoutdebitcardpay.ClickonPlaceOrder();
			WebElementOperationsWeb.park(7);
			ssbcheckoutdebitcardpay.ClickonContinue();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Logout Successfull");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}	

	public void EnteringDebitCardDetails(String sheetname, String testCaseName, int serialno) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(15);
			ssbcheckoutdebitcardpay.ClickonDebitcard();
			WebElementOperationsWeb.park(5);
			//js.executeScript("window.scrollBy(0,900)", " ");
			//WebElementOperationsWeb.park(5);
			ssbcheckoutdebitcardpay.writeToCardNumber(sheetname, serialno, testCaseName);
			WebElementOperationsWeb.park(5);
			ssbcheckoutdebitcardpay.writeNameOnCard(sheetname, serialno, testCaseName);
			WebElementOperationsWeb.park(5);
			ssbcheckoutdebitcardpay.selectExpiryMonth(sheetname, serialno,testCaseName);
			WebElementOperationsWeb.park(5);
			ssbcheckoutdebitcardpay.selectExpiryYear(sheetname, serialno,testCaseName);
			WebElementOperationsWeb.park(5);
			ssbcheckoutdebitcardpay.writeToCvv(sheetname, serialno, testCaseName);
			WebElementOperationsWeb.park(5);
			//ssbcheckoutdebitcardpay.ClickonSaveCard();
			//WebElementOperationsWeb.park(3);
			ssbcheckoutdebitcardpay.ClickonPaynow();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
			WebElementOperationsWeb.park(5);
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void DBBankPageSimulateSuccessClick(String sheetname, String testCaseName, int Serialno) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
			WebElementOperationsWeb.park(5);
			ssbcheckoutdebitcardpay.selectSamulateOTP(testCaseName, Serialno, sheetname );
			WebElementOperationsWeb.park(5);
			ssbcheckoutdebitcardpay.ClickonSubmitSuccess();
			WebElementOperationsWeb.park(10);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("Failure occured while payment", e);
		}
	}
	
	public void Logoutfunctionalitycheck(String testCaseName) {
		try {
			WebElementOperationsWeb.park(5);
			ssbcheckoutdebitcardpay.Usernamemousehover();
			WebElementOperationsWeb.park(5);
			ssbcheckoutdebitcardpay.LogOutClick();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
}
