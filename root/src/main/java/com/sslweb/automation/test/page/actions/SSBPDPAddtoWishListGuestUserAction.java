package com.sslweb.automation.test.page.actions;


import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBPDPVerifyDetailsHelper;
import com.sslweb.automation.test.page.actions.helper.SSBRegistrationFunctionalityHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;
public class SSBPDPAddtoWishListGuestUserAction extends GlobalExceptionHandler {
	
	
	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBPDPVerifyDetailsHelper ssbpdpverifydetails;
	private SSBRegistrationFunctionalityHelper ssbmyaccountregistrationfunctionality;
	
	
	public SSBPDPAddtoWishListGuestUserAction(WebDriver driver, ExcelRepository repository){
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbpdpverifydetails = new SSBPDPVerifyDetailsHelper(driver);
		ssbmyaccountregistrationfunctionality = new SSBRegistrationFunctionalityHelper(driver, repository);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)"," ");
	}
	
	public void NavigateToPDP(String testCaseName, String ID){
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(3);
			ssbpdpverifydetails.sendProductID(testCaseName, ID);
			WebElementOperationsWeb.park(3);
			WebElementOperationsWeb.enterByRobot();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
			ssbpdpverifydetails.ClickonProductCard();
			WebElementOperationsWeb.park(3);	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	
	public void WishlistIcon(String testCaseName){
		try {
			WebElementOperationsWeb.park(5);
			ssbpdpverifydetails.WishListIcon();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void RegistrationProceed(String sheetname, int serialNo, String testCaseName) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			ssbmyaccountregistrationfunctionality.clickOnSignup();
			WebElementOperationsWeb.park(5);
			ssbmyaccountregistrationfunctionality.sendFullName(sheetname, serialNo, testCaseName);
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.sendMobileNumber(sheetname, serialNo, testCaseName);
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.clickOnProceed();
			WebElementOperationsWeb.park(20);
			//ssbmyaccountregistrationfunctionality.LoginOTP(testCaseName);
			WebElementOperationsWeb.park(5);
			ssbmyaccountregistrationfunctionality.VerifyOTP();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void RegistrationFormFilling(String sheetname, String testCaseName, int serialno) {
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(5);
			ssbmyaccountregistrationfunctionality.sendEmail(sheetname, serialno, testCaseName);
			WebElementOperationsWeb.park(2);
			ssbmyaccountregistrationfunctionality.DOBopen();
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.OpenDOBYear();
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.YearSelect();
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.DOBDateSelect();
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.AnniversaryCalendaropen();
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.OpenAnniversaryYear();
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.AnniversaryYearSelect();
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.AnniversaryDateSelect();
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.sendPincode(sheetname, serialno, testCaseName);
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.sendAddress(sheetname, serialno, testCaseName);
			WebElementOperationsWeb.park(3);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
			WebElementOperationsWeb.park(3);
			ssbmyaccountregistrationfunctionality.ClickonSave();
			WebElementOperationsWeb.park(5);
			ssbpdpverifydetails.WishListIcon();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

}
	


