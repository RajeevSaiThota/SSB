package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBLoginFunctionalityHelper;
import com.sslweb.automation.test.page.actions.helper.SSBMyAccountProfilePageAddingAddressHelper;
import com.sslweb.automation.test.page.actions.helper.SSBMyAccountProfilePageDeleteAddressHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountProfilePageDeletingAddressAction extends GlobalExceptionHandler {

	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBLoginFunctionalityHelper ssbloginflow;
	private SSBMyAccountProfilePageDeleteAddressHelper ssbmyaccountppdeleteaddress;
	private static final Logger LOG = Logger.getLogger(SSBMyAccountProfilePageDeletingAddressAction.class);

	public SSBMyAccountProfilePageDeletingAddressAction(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbloginflow = new SSBLoginFunctionalityHelper(driver);
		ssbmyaccountppdeleteaddress = new SSBMyAccountProfilePageDeleteAddressHelper(driver, repository);
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

	public void NavigatingtoProfilePage(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbmyaccountppdeleteaddress.MouseHoverUserProfile();
			WebElementOperationsWeb.park(5);
			ssbmyaccountppdeleteaddress.ClickonMyProfile();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("Error in navigating profile page", e);
		}
	}

	public void DeletingAddress(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			js.executeScript("window.scrollBy(0,400)", " ");
			WebElementOperationsWeb.park(5);
			ssbmyaccountppdeleteaddress.DeleteAddress();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "DeleteAddress");
			ssbmyaccountppdeleteaddress.ClickonDeleteAddress();
			WebElementOperationsWeb.park(5);
			ssbmyaccountppdeleteaddress.ClickonYes();
			WebElementOperationsWeb.park(2);
			if(!ssbmyaccountppdeleteaddress.DeleteAddressSuccessAlert().contains("Address Deleted Successfully!")) {
				LOG.error("DeleteAddress SuccessAlert is not displayed");
			}
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "DeletingAddress");
		} catch (Exception e) {
			handleOnException("Error in Deleting Address", e);
		}
	}
}
