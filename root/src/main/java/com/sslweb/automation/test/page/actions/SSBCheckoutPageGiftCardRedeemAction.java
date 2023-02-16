package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBCheckoutPageGiftCardRedeemHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageGiftCardRedeemAction extends GlobalExceptionHandler {
	
	private static final Logger LOG = Logger.getLogger(SSBCheckoutPageGiftCardRedeemAction.class);
	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBCheckoutPageGiftCardRedeemHelper ssbcheckoutgiftcardredeem;
	
	public SSBCheckoutPageGiftCardRedeemAction(WebDriver driver, ExcelRepository repository){
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbcheckoutgiftcardredeem = new SSBCheckoutPageGiftCardRedeemHelper(driver, repository);
		js = (JavascriptExecutor) driver;
	}
	
	public void NavigatintoCartPage(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(15);
			ssbcheckoutgiftcardredeem.ClickonAddtoCart();
			WebElementOperationsWeb.park(5);
			ssbcheckoutgiftcardredeem.ClickonCartIcon();
			WebElementOperationsWeb.park(2);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void ClickingonProceedNow(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			js.executeScript("window.scrollBy(0,450)"," ");
			WebElementOperationsWeb.park(5);
			ssbcheckoutgiftcardredeem.ClickonPlaceorder();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void AddingAddress(String testCaseName, String mobilenumber){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbcheckoutgiftcardredeem.ClickonAddnewaddress();
			WebElementOperationsWeb.park(2);
			ssbcheckoutgiftcardredeem.sendFullName(testCaseName);
			WebElementOperationsWeb.park(1);
			ssbcheckoutgiftcardredeem.sendMobileNumber(testCaseName, mobilenumber);
			WebElementOperationsWeb.park(1);
			ssbcheckoutgiftcardredeem.sendPincode(testCaseName);
			WebElementOperationsWeb.park(1);
			ssbcheckoutgiftcardredeem.sendCity(testCaseName);
			WebElementOperationsWeb.park(1);
			js.executeScript("window.scrollBy(0,150)"," ");
			WebElementOperationsWeb.park(1);
			ssbcheckoutgiftcardredeem.sendState(testCaseName);
			WebElementOperationsWeb.park(3);
			ssbcheckoutgiftcardredeem.ClickonStatename();
			WebElementOperationsWeb.park(3);
			ssbcheckoutgiftcardredeem.sendAddress(testCaseName);
			WebElementOperationsWeb.park(1);
			ssbcheckoutgiftcardredeem.ClickonAddDefaultAddress();
			WebElementOperationsWeb.park(1);
			ssbcheckoutgiftcardredeem.ClickonAddresstypeHome();
			WebElementOperationsWeb.park(1);
			ssbcheckoutgiftcardredeem.ClickonAddnewaddressSelect();
			WebElementOperationsWeb.park(3);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
			WebElementOperationsWeb.park(5);
			ssbcheckoutgiftcardredeem.ClickonProceedtoPayment();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void EnteringGiftCardDetails(String sheetname, String testCaseName, int serialno){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(15);
			ssbcheckoutgiftcardredeem.ClickonGiftcardOption();;
			WebElementOperationsWeb.park(2);
			js.executeScript("window.scrollBy(0,600)"," ");
			WebElementOperationsWeb.park(5);
			ssbcheckoutgiftcardredeem.ClickonGiftCardButton();
			WebElementOperationsWeb.park(5);
			ssbcheckoutgiftcardredeem.writeGiftCardNum(sheetname, serialno);
			WebElementOperationsWeb.park(2);
			ssbcheckoutgiftcardredeem.CheckCardBalance();
			WebElementOperationsWeb.park(2);
			ssbcheckoutgiftcardredeem.writeToPin(sheetname, serialno);
			WebElementOperationsWeb.park(2);
			ssbcheckoutgiftcardredeem.WriteRedeemAmount(sheetname, serialno);
			WebElementOperationsWeb.park(1);
			js.executeScript("window.scrollBy(0,100)"," ");
			WebElementOperationsWeb.park(1);
			ssbcheckoutgiftcardredeem.ClickonRedeemNow();;
			WebElementOperationsWeb.park(2);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
			WebElementOperationsWeb.park(5);
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
}
