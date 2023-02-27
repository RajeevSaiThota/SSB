package com.sslweb.automation.test.page.actions;


import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBLoginFunctionalityHelper;
import com.sslweb.automation.test.page.actions.helper.SSBPDPVerifyDetailsHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;
public class SSBPDPAddtoWishListRegisteredUserAction extends GlobalExceptionHandler {
	
	
	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBPDPVerifyDetailsHelper ssbpdpverifydetails;
	private SSBLoginFunctionalityHelper ssbLoginFunctionalityHelper;
	
	
	public SSBPDPAddtoWishListRegisteredUserAction(WebDriver driver){
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbpdpverifydetails = new SSBPDPVerifyDetailsHelper(driver);
		ssbLoginFunctionalityHelper = new SSBLoginFunctionalityHelper(driver);
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
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "NavigateToPDP");
			ssbpdpverifydetails.ClickonProductCard();
			WebElementOperationsWeb.park(3);
			WebElementOperationsWeb.windowHandle(driver);
		} catch (Exception e) {
			handleOnException("Error in navigating to PDP", e);
		}
	}
	
	
	public void WishlistIcon(String testCaseName){
		try {
			WebElementOperationsWeb.park(5);
			ssbpdpverifydetails.WishListIcon();
			ssbpdpverifydetails.WishListCountVerification();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "WishlistIcon");	
		} catch (Exception e) {
			handleOnException("Error in clicking WishlistIcon", e);
		}
	}
	
	public void LoginFunctionalityusingMobileNumber(String username, String testCaseName) {
		try {

			WebElementOperationsWeb.park(3);
			ssbLoginFunctionalityHelper.LoginEnterUsername(username);
			WebElementOperationsWeb.park(3);
			ssbLoginFunctionalityHelper.LoginProceed();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Mobile Number Entered");
		} catch (Exception e) {
			handleOnException("Error in LoginFunctionality using MobileNumber", e);
		}
	}

	public void LoginFunctionalityEnterOTP(String testCaseName, String mobileNumber) {
		try {

			WebElementOperationsWeb.park(15);
//			ssbLoginFunctionalityHelper.LoginOTP(testCaseName, mobileNumber);
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Logged in Successfully");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void LoginFunctionalityClickonLogInButton(String testCaseName) {
		try {

			WebElementOperationsWeb.park(5);
			ssbLoginFunctionalityHelper.LogInButtonClick();
			WebElementOperationsWeb.park(5);
			ssbpdpverifydetails.WishListIcon();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "WishListIcon");
		} catch (Exception e) {
			handleOnException("Error in clicking wishlist icon", e);
		}
	}

	

}
