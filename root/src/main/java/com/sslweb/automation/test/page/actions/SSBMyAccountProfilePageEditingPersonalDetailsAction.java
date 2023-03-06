package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBLoginFunctionalityHelper;
import com.sslweb.automation.test.page.actions.helper.SSBMyAccountProfilePageAddingAddressHelper;
import com.sslweb.automation.test.page.actions.helper.SSBMyAccountProfilePageDeleteAddressHelper;
import com.sslweb.automation.test.page.actions.helper.SSBMyAccountProfilePageEditingProfileHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountProfilePageEditingPersonalDetailsAction extends GlobalExceptionHandler {

	private WebDriver driver = null;
	private ExcelRepository repository;
	public JavascriptExecutor js;

	private SSBLoginFunctionalityHelper ssbloginflow;
	private SSBMyAccountProfilePageEditingProfileHelper ssbmyaccountppeditprofiledetails;

	public SSBMyAccountProfilePageEditingPersonalDetailsAction(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		this.repository = Objects.requireNonNull(repository,
				"Repository cannot be null to perform publicVerifyDebitCardScenarioHelper class");
		ssbloginflow = new SSBLoginFunctionalityHelper(driver);
		ssbmyaccountppeditprofiledetails = new SSBMyAccountProfilePageEditingProfileHelper(driver, repository);
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
			WebElementOperationsWeb.park(10);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void NavigatingtoProfilePage(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(10);
			ssbmyaccountppeditprofiledetails.MouseHoverUserProfile();
			WebElementOperationsWeb.park(5);
			ssbmyaccountppeditprofiledetails.ClickonMyProfile();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void EditPersonalDetails(String sheetname,String testCaseName, int serialno) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(10);
			// js.executeScript("window.scrollBy(0,400)", " ");
			// WebElementOperationsWeb.park(5);
			ssbmyaccountppeditprofiledetails.ClickonEditPersonalDetails();
			WebElementOperationsWeb.park(5);
			ssbmyaccountppeditprofiledetails.ClickonXicon();
			WebElementOperationsWeb.park(5);
			ssbmyaccountppeditprofiledetails.sendNewName(sheetname, testCaseName,serialno);
			WebElementOperationsWeb.park(5);
			ssbmyaccountppeditprofiledetails.ClickonGender();
			WebElementOperationsWeb.park(5);
			js.executeScript("window.scrollBy(0,400)", " ");
			WebElementOperationsWeb.park(5);
			ssbmyaccountppeditprofiledetails.ClickonMakeChanges();
			WebElementOperationsWeb.park(5);
			ssbmyaccountppeditprofiledetails.EditPersonalDetails();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
}
