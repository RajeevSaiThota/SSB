package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBLoginFunctionalityHelper;
import com.sslweb.automation.test.page.actions.helper.SSBMyAccountProfilePageAddingAddressHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountProfilePageAddingAddressAction extends GlobalExceptionHandler {

	private WebDriver driver = null;
	public JavascriptExecutor js;
	private static final Logger LOG = Logger.getLogger(SSBMyAccountProfilePageAddingAddressAction.class);

	private SSBLoginFunctionalityHelper ssbloginflow;
	private SSBMyAccountProfilePageAddingAddressHelper ssbmyaccountppaddaddress;

	public SSBMyAccountProfilePageAddingAddressAction(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbloginflow = new SSBLoginFunctionalityHelper(driver);
		ssbmyaccountppaddaddress = new SSBMyAccountProfilePageAddingAddressHelper(driver, repository);
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
			//ssbloginflow.LoginOTP(otp);
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
			ssbmyaccountppaddaddress.MouseHoverUserProfile();
			WebElementOperationsWeb.park(5);
			ssbmyaccountppaddaddress.ClickonMyProfile();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void AddingAddress(String sheetname, String testCaseName, int serialno) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			js.executeScript("window.scrollBy(0,200)"," ");
			ssbmyaccountppaddaddress.ClickonAddAddress();
			WebElementOperationsWeb.park(2);
			ssbmyaccountppaddaddress.sendFullName(sheetname, serialno, testCaseName);
			WebElementOperationsWeb.park(2);
			ssbmyaccountppaddaddress.sendMobileNumber(sheetname, serialno, testCaseName);
			WebElementOperationsWeb.park(2);
			ssbmyaccountppaddaddress.sendPincode(sheetname, serialno, testCaseName);
			WebElementOperationsWeb.park(2);
			ssbmyaccountppaddaddress.sendAddress(sheetname, serialno, testCaseName);
			WebElementOperationsWeb.park(1);
			ssbmyaccountppaddaddress.ClickonAddDefaultAddress();
			WebElementOperationsWeb.park(1);
			js.executeScript("window.scrollBy(0,400)"," ");
			WebElementOperationsWeb.park(1);
			ssbmyaccountppaddaddress.ClickonAddresstypeHome();
			WebElementOperationsWeb.park(1);
			ssbmyaccountppaddaddress.ClickonAddnewaddressSelect();
			WebElementOperationsWeb.park(3);
			if(!ssbmyaccountppaddaddress.AddAddressSuccessAlert().contains("Address Added Successfully!")) {
				LOG.error("AddAddress SuccessAlert is not displayed");
			}
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

}
