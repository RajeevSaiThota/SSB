package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBLoginFunctionalityHelper;
import com.sslweb.automation.test.page.actions.helper.SSBMyAccountBeautyProfilePageHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountBeautyProfileFunctionalityAction extends GlobalExceptionHandler {

	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBLoginFunctionalityHelper ssbloginflow;
	private SSBMyAccountBeautyProfilePageHelper ssbmyaccountbeautyprofilepage;

	public SSBMyAccountBeautyProfileFunctionalityAction(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbloginflow = new SSBLoginFunctionalityHelper(driver);
		ssbmyaccountbeautyprofilepage = new SSBMyAccountBeautyProfilePageHelper(driver, repository);
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

	public void NavigatingtoBeautyProfilePage(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbmyaccountbeautyprofilepage.MouseHoverUserProfile();
			WebElementOperationsWeb.park(5);
			ssbmyaccountbeautyprofilepage.ClickonBeautyProfile();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "BeautyProfilePage");
		} catch (Exception e) {
			handleOnException("Error in navigating to BeautyProfilePage", e);
		}
	}

	public void CatogeryFunctionality(String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			//WebElementOperationsWeb.park(5);
			ssbmyaccountbeautyprofilepage.ClickonReDoProfile();
			WebElementOperationsWeb.park(5);
			ssbmyaccountbeautyprofilepage.ClickonGetStarted();
			WebElementOperationsWeb.park(5);
			ssbmyaccountbeautyprofilepage.ClickonDRYCatogery();
			WebElementOperationsWeb.park(5);
			//js.executeScript("window.scrollBy(0,200)"," ");
			WebElementOperationsWeb.park(3);
			ssbmyaccountbeautyprofilepage.ClickonMYSKINTONE();
			WebElementOperationsWeb.park(5);
			ssbmyaccountbeautyprofilepage.ClickonFAIRCatogery();
			WebElementOperationsWeb.park(5);
			ssbmyaccountbeautyprofilepage.ClickonMAKEUPPERSONALITY();
			WebElementOperationsWeb.park(5);
			ssbmyaccountbeautyprofilepage.ClickonPOPPRINCESCatogery();
			WebElementOperationsWeb.park(5);
			ssbmyaccountbeautyprofilepage.ClickonClickonHAIRTYPE();
			WebElementOperationsWeb.park(5);
			ssbmyaccountbeautyprofilepage.ClickonSTRAIGHTCatogery();
			WebElementOperationsWeb.park(5);
			ssbmyaccountbeautyprofilepage.ClickonFRAGRANCES();
			WebElementOperationsWeb.park(5);
			ssbmyaccountbeautyprofilepage.ClickonFLORALCatogery();
			WebElementOperationsWeb.park(5);
			ssbmyaccountbeautyprofilepage.ClickonDONE();
			WebElementOperationsWeb.park(5);
			ssbmyaccountbeautyprofilepage.ClickonCHECKTHEMOUT();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "CatogeryFunctionality");
		} catch (Exception e) {
			handleOnException("Error in verifying beauty categories", e);
		}
	}
}
