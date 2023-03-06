package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBLoginFunctionalityHelper;
import com.sslweb.automation.test.page.actions.helper.SSBMyAccountMyWalletPageHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountMyWalletPageFunctionalityAction extends GlobalExceptionHandler {

	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBLoginFunctionalityHelper ssbloginflow;
	private SSBMyAccountMyWalletPageHelper ssbmyaccountmywalletpage;

	public SSBMyAccountMyWalletPageFunctionalityAction(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbloginflow = new SSBLoginFunctionalityHelper(driver);
		ssbmyaccountmywalletpage = new SSBMyAccountMyWalletPageHelper(driver, repository);
		js = (JavascriptExecutor) driver;
	}

	public void SigninFlow(String testCaseName, String mobileno, String otp) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbloginflow.clickOnAccount();
			WebElementOperationsWeb.park(5);
			ssbloginflow.LoginEnterUsername(mobileno);
			WebElementOperationsWeb.park(5);
			ssbloginflow.LoginProceed();
			WebElementOperationsWeb.park(20);
			// ssbloginflow.LoginOTP(otp);
			WebElementOperationsWeb.park(5);
			ssbloginflow.LogInButtonClick();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void NavigatingtoMyWalletPage(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbmyaccountmywalletpage.MouseHoverUserProfile();
			WebElementOperationsWeb.park(5);
			ssbmyaccountmywalletpage.ClickonMyWallet();
			WebElementOperationsWeb.park(5);
			ssbmyaccountmywalletpage.TotalBalanceVerification();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "MyWalletPage");
		} catch (Exception e) {
			handleOnException("Error in navigating to MyWalletPage", e);
		}
	}

	public void CardDetailsFunctionality(String sheetname, String testCaseName, int serialNo) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			js.executeScript("window.scrollBy(0,500)"," ");
			WebElementOperationsWeb.park(5);
			ssbmyaccountmywalletpage.ClickonEnterCardNumber(sheetname, serialNo);
			WebElementOperationsWeb.park(5);
			ssbmyaccountmywalletpage.ClickonEnterPin(sheetname, serialNo);
			WebElementOperationsWeb.park(5);
			ssbmyaccountmywalletpage.ClickonCheckBalance();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "CardDetailsFunctionality");
		} catch (Exception e) {
			handleOnException("Error in navigating to CardDetailsFunctionality", e);
		}
	}
}
