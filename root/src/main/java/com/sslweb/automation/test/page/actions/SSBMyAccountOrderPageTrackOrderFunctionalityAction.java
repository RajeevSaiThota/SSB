package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBLoginFunctionalityHelper;
import com.sslweb.automation.test.page.actions.helper.SSBMyAccountOrderPageTrackOrderHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountOrderPageTrackOrderFunctionalityAction extends GlobalExceptionHandler {

	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBLoginFunctionalityHelper ssbloginflow;
	private SSBMyAccountOrderPageTrackOrderHelper ssbmyaccountorderpagetrackorder;

	public SSBMyAccountOrderPageTrackOrderFunctionalityAction(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbloginflow = new SSBLoginFunctionalityHelper(driver);
		ssbmyaccountorderpagetrackorder = new SSBMyAccountOrderPageTrackOrderHelper(driver, repository);
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

	public void NavigatingtoOrderPage(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbmyaccountorderpagetrackorder.MouseHoverUserProfile();
			WebElementOperationsWeb.park(5);
			ssbmyaccountorderpagetrackorder.ClickonMyOrders();
			WebElementOperationsWeb.park(5);
			if(!ssbmyaccountorderpagetrackorder.MyAccountBreadCrumb().equals("My Orders")) {
				System.out.println("User not navigated to Myorders page");
			}
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void TrackOrder(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbmyaccountorderpagetrackorder.ClickonProductCard();
			WebElementOperationsWeb.park(5);
			js.executeScript("window.scrollBy(0,400)", " ");
			WebElementOperationsWeb.park(5);
			ssbmyaccountorderpagetrackorder.ClickonTrackOrder();
			WebElementOperationsWeb.park(5);
			ssbmyaccountorderpagetrackorder.ClickonCloseIcon();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
}
