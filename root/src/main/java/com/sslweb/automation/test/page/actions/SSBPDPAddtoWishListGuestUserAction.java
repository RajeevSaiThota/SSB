package com.sslweb.automation.test.page.actions;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBLoginFunctionalityHelper;
import com.sslweb.automation.test.page.actions.helper.SSBPDPVerifyDetailsHelper;
import com.sslweb.automation.test.page.actions.helper.SSBRegistrationFunctionalityHelper;
import com.sslweb.automation.userbackofficeloginfunctionalitycheck.model.SSBBackofficeLoginFunctionality;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPDPAddtoWishListGuestUserAction extends GlobalExceptionHandler {

	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBPDPVerifyDetailsHelper ssbpdpverifydetails;
	private SSBRegistrationFunctionalityHelper ssbmyaccountregistrationfunctionality;
	private SSBLoginFunctionalityHelper ssbLoginFunctionalityHelper;

	public SSBPDPAddtoWishListGuestUserAction(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbpdpverifydetails = new SSBPDPVerifyDetailsHelper(driver);
		ssbmyaccountregistrationfunctionality = new SSBRegistrationFunctionalityHelper(driver, repository);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", " ");
		ssbLoginFunctionalityHelper = new SSBLoginFunctionalityHelper(driver); // classname objname = newclass name

	}

	public void NavigateToPDP(String testCaseName, String ID) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			WebElementOperationsWeb.park(3);
			ssbpdpverifydetails.sendProductID(testCaseName, ID);
			WebElementOperationsWeb.park(3);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
			ssbpdpverifydetails.ClickonProductCard();
			WebElementOperationsWeb.park(3);
			WebElementOperationsWeb.windowHandle(driver);

		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}

	public void WishlistIcon(String testCaseName) {
		try {
			WebElementOperationsWeb.park(5);
			ssbpdpverifydetails.WishListIcon();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	/*
	 * public void backofficeGetOtp( String testCaseName) { try {
	 * Thread.sleep(2000); WebElementOperationsWeb.windowHandle(driver);
	 * Thread.sleep(2000);
	 * ssbLoginFunctionalityHelper.backofficeClickOnSearchButton();
	 * Thread.sleep(3000);
	 * ssbLoginFunctionalityHelper.backofficeClickOnMobileNumberInResultsToGetOtp();
	 * Thread.sleep(3000); getOTP(testCaseName); Thread.sleep(2000);
	 * WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName,
	 * "MobileNumber Verification in Backoffice");
	 * 
	 * } catch (Exception e) {
	 * handleOnException("Error occured while getting otp in backoffice", e); } }
	 * String otpNum=null; public String getOTP(String testCaseName) { try { otpNum
	 * = WebElementOperationsWeb.getAttributeValue(SSBBackofficeLoginFunctionality.
	 * getGetOtpNumber());
	 * 
	 * } catch (Exception e) { handleOnException("Error occured while geting otp",
	 * e); } return otpNum; } public void enterOtpByDecrypting(String testCaseName,
	 * int arrayNum) { try { String Decryptotp =decryptusingweb(otpNum);
	 * WebElementOperationsWeb.park(2);
	 * WebElementOperationsWeb.handleParentTab(driver,arrayNum);
	 * WebElementOperationsWeb.park(2); List<WebElement> otp =
	 * driver.findElements(By.xpath("//input[@type='tel']"));
	 * WebElementOperationsWeb.park(2); for(int i=0; i<otp.size(); i++) {
	 * WebElementOperationsWeb.sendKeys(otp.get(i),
	 * String.valueOf(Decryptotp.charAt(i)));
	 * 
	 * otp.get(i).click();
	 * otp.get(i).sendKeys(String.valueOf(Decryptotp.charAt(i)));
	 * 
	 * } } catch (Exception e) {
	 * handleOnException("Error occured while decrypting and entering otp", e); } }
	 * 
	 * public String decryptusingweb(String strToDecrypt) { try {
	 * 
	 * Thread.sleep(5000); ssbpdpverifydetails.sendDecryptText(strToDecrypt);
	 * ssbpdpverifydetails.clickOnDecryptbutton(); WebElementOperationsWeb.park(3);
	 * String decryptedOTP =
	 * driver.findElement(By.cssSelector("fieldset[id='answer'] b")).getText();
	 * System.out.println(decryptedOTP); return decryptedOTP; } catch (Exception e)
	 * { System.out.println("Decrypting is not working as Expected"); } return null;
	 * }
	 */

	/*
	 * public String decryptusingweb(String strToDecrypt) { try {
	 * 
	 * Thread.sleep(5000); sendDecryptText(strToDecrypt); clickOnDecryptbutton();
	 * WebElementOperationsWeb.park(3); String decryptedOTP =
	 * driver.findElement(By.cssSelector("fieldset[id='answer'] b")).getText();
	 * System.out.println(decryptedOTP); return decryptedOTP; } catch (Exception e)
	 * { System.out.println("Decrypting is not working as Expected"); } return null;
	 * }
	 */
	public void loginProceed(String sheetname, int serialNo, String testCaseName) {
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
			// ssbmyaccountregistrationfunctionality.LoginOTP(testCaseName);
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
