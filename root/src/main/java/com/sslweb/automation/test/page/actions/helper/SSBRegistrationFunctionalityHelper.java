package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.userloginfunctionalitycheck.model.SSBLoginFunctionality;
import com.sslweb.automation.registrationfunctionalitycheck.model.HomePage;
import com.sslweb.automation.registrationfunctionalitycheck.model.RegistrationFunctionality;
import com.sslweb.automation.util.encryption.EncryptDecryptPassword;
import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.util.Sheet;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBRegistrationFunctionalityHelper extends GlobalExceptionHandler {
	// In this class we are performing operations on the web element

	private WebDriver driver = null;
	private static WebDriver driver1;
	private ExcelRepository repository;
	private static final Logger LOG = Logger.getLogger(SSBRegistrationFunctionalityHelper.class);

	public SSBRegistrationFunctionalityHelper(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
		this.repository = Objects.requireNonNull(repository,
				"Repository cannot be null to perform publicVerifyDebitCardScenarioHelper class");
	}

	// Registration form navigation
	// Clicking on the Signin (Account Locator)
	public void clickOnSignin() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, HomePage.getSignIn())) {
				WebElementOperationsWeb.click(driver, HomePage.getSignIn());
			} else {
				LOG.error("Account Element not Found");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Account: " + HomePage.getSignIn(), e);
		}
	}

	// Clicking on the Signup
	public void clickOnSignup() {
		try {

			WebElementOperationsWeb.click(driver, HomePage.getSignUp());

		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on signup: " + HomePage.getSignUp(), e);
		}
	}

	// Registration form filling

	// Username Title box locator and enter user name
	public void sendFullName(String sheetname, int serialNo, String testCaseName) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, RegistrationFunctionality.getUserName())) {
				WebElementOperationsWeb.sendKeys(driver, RegistrationFunctionality.getUserName(),
						repository.readStringFrom(sheetname, Sheet.Registration.FULL_NAME, serialNo));
				WebElementOperationsWeb.park(3);
			} else {
				throw new ShoppersStopBusinessException("Unable to find FullName field in the Checkout Page ["
						+ RegistrationFunctionality.getUserName() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "FirstName");
			handleOnException("Error occured while sending FirstName [" + RegistrationFunctionality.getUserName() + "]",
					e);
		}
	}

	// Mobile Number
	public void sendMobileNumber(String sheetname, int serialNo, String testCaseName) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, RegistrationFunctionality.getPhone())) {
				WebElementOperationsWeb.sendKeys(driver, RegistrationFunctionality.getPhone(),
						repository.readStringFrom(sheetname, Sheet.Registration.MOBILE_NUMBER, serialNo));
				WebElementOperationsWeb.park(3);
			} else {
				throw new ShoppersStopBusinessException("Unable to find the MobileNumber field in the Checkout Page ["
						+ RegistrationFunctionality.getPhone() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "NotEnteredMobileNumber");
			handleOnException("Error occured while sending Guest User Mobile number ["
					+ RegistrationFunctionality.getPhone() + "]", e);
		}
	}

	// Clicking on Proceed
	public void clickOnProceed() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, RegistrationFunctionality.getProceedButton())) {
				WebElementOperationsWeb.click(driver, RegistrationFunctionality.getProceedButton());
			} else {
				LOG.error("Proceed button not Found");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on proceed button: "
					+ RegistrationFunctionality.getProceedButton(), e);
		}
	}

	// Enter OTP
	public void LoginOTP(String OTP) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, RegistrationFunctionality.getOTP())) {
				WebElementOperationsWeb.sendKeys(RegistrationFunctionality.getOTP(), OTP);
			} else {
				LOG.error("Please enter a valid OTP");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while entering OTP: " + RegistrationFunctionality.getOTP(), e);
		}
	}

	// Verify OTP
	public void VerifyOTP() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, RegistrationFunctionality.getVerifyOTP())) {
				WebElementOperationsWeb.click(driver, RegistrationFunctionality.getVerifyOTP());
				;
			} else {
				LOG.error("Verify Otp not clickable");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while entering OTP: " + RegistrationFunctionality.getVerifyOTP(),
					e);
		}
	}

	// Registration Form filling

	// Entering Email ID
	public void sendEmail(String sheetname, int serialNo, String testCaseName) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, RegistrationFunctionality.getEmailID())) {
				WebElementOperationsWeb.sendKeys(driver, RegistrationFunctionality.getEmailID(),
						repository.readStringFrom(sheetname, Sheet.Registration.EMAIL, serialNo));
				WebElementOperationsWeb.park(3);
			} else {
				throw new ShoppersStopBusinessException(
						"Unable to find Email ID field [" + RegistrationFunctionality.getEmailID() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "FirstName");
			handleOnException("Error occured while sending Email ID [" + RegistrationFunctionality.getEmailID() + "]",
					e);
		}
	}

	// DOB Calender open
	public void DOBopen() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, RegistrationFunctionality.getDOBCalenderOpen())) {
				WebElementOperationsWeb.click(driver, RegistrationFunctionality.getDOBCalenderOpen());
				;
			} else {
				LOG.error("DOB Calender not clickable");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on DOB calender: "
					+ RegistrationFunctionality.getDOBCalenderOpen(), e);
		}
	}

	// Year Open
	public void OpenDOBYear() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, RegistrationFunctionality.getYearOpen())) {
				WebElementOperationsWeb.click(driver, RegistrationFunctionality.getYearOpen());
				;
			} else {
				LOG.error("Year not clickable");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on year " + RegistrationFunctionality.getYearOpen(),
					e);
		}
	}

	// Year Select
	public void YearSelect() {
		try {
			//if (WebElementOperationsWeb.isDisplayed(driver, RegistrationFunctionality.getYearSelect())) 
			{
				WebElementOperationsWeb.click(driver, RegistrationFunctionality.getYearSelect());
				;
			} {
				LOG.error("Year not clickable");
			}
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on year: " + RegistrationFunctionality.getYearSelect(), e);
		}  
	}

	// DOB date Select
	public void DOBDateSelect() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, RegistrationFunctionality.getDateSelect())) {
				WebElementOperationsWeb.click(driver, RegistrationFunctionality.getDateSelect());
				;
			} else {
				LOG.error("Date not clickable");
			}
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on date: " + RegistrationFunctionality.getDateSelect(), e);
		}
	}

	// Anniversary Calendar open
	public void AnniversaryCalendaropen() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, RegistrationFunctionality.getAniversaryCalenderOpen())) {
				WebElementOperationsWeb.click(driver, RegistrationFunctionality.getAniversaryCalenderOpen());
				;
			} else {
				LOG.error("Anniversary Calender not clickable");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Aniversary calender: "
					+ RegistrationFunctionality.getAniversaryCalenderOpen(), e);
		}
	}

	// Anniversary Year Open
	public void OpenAnniversaryYear() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, RegistrationFunctionality.getAYearOpen())) {
				WebElementOperationsWeb.click(driver, RegistrationFunctionality.getAYearOpen());
				;
			} else {
				LOG.error("Year not clickable");
			}
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on year " + RegistrationFunctionality.getAYearOpen(), e);
		}
	}

	// Anniversary Year Select
	public void AnniversaryYearSelect() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, RegistrationFunctionality.getAYearSelect())) {
				WebElementOperationsWeb.click(driver, RegistrationFunctionality.getAYearSelect());
				;
			} else {
				LOG.error("Year not clickable");
			}
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on year: " + RegistrationFunctionality.getAYearSelect(), e);
		}
	}

	// Anniversary date Select
	public void AnniversaryDateSelect() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, RegistrationFunctionality.getADateSelect())) {
				WebElementOperationsWeb.click(driver, RegistrationFunctionality.getADateSelect());
				;
			} else {
				LOG.error("Date not clickable");
			}
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on date: " + RegistrationFunctionality.getADateSelect(), e);
		}
	}

	// Enter pincode

	public void sendPincode(String sheetname, int serialNo, String testCaseName) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, RegistrationFunctionality.getPincode())) {
				WebElementOperationsWeb.sendKeys(driver, RegistrationFunctionality.getPincode(),
						repository.readStringFrom(sheetname, Sheet.Registration.PINCODE, serialNo));
				WebElementOperationsWeb.park(3);
			} else {
				throw new ShoppersStopBusinessException(
						"Unable to find Pincode field [" + RegistrationFunctionality.getPincode() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "FirstName");
			handleOnException("Error occured while sending Pincode [" + RegistrationFunctionality.getPincode() + "]",
					e);
		}
	}

	// Entering Address
	public void sendAddress(String sheetname, int serialNo, String testCaseName) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, RegistrationFunctionality.getAddress())) {
				WebElementOperationsWeb.sendKeys(driver, RegistrationFunctionality.getAddress(),
						repository.readStringFrom(sheetname, Sheet.Registration.ADDRESS, serialNo));
				WebElementOperationsWeb.park(3);
			} else {
				throw new ShoppersStopBusinessException(
						"Unable to find Address field [" + RegistrationFunctionality.getAddress() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "FirstName");
			handleOnException("Error occured while sending Address [" + RegistrationFunctionality.getAddress() + "]",
					e);
		}
	}

	// click on save
	public void ClickonSave() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, RegistrationFunctionality.getSave())) {
				WebElementOperationsWeb.click(driver, RegistrationFunctionality.getSave());
				;
			} else {
				LOG.error("Save button is not clickable");
			}
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while Clicking on save button : " + RegistrationFunctionality.getSave(), e);
		}
	}
	
	// mouseover action
		public void Usernamemousehover() {
			try {
				if (WebElementOperationsWeb.isDisplayed(driver, RegistrationFunctionality.getUserName1())) {
					WebElementOperationsWeb.mouseOver(driver, RegistrationFunctionality.getUserName1());
				} else {
					throw new ShoppersStopBusinessException(
							"Error occured in mousehovering profileIcon [" + RegistrationFunctionality.getUserName1() + "]");
				}
			} catch (Exception e) {
				handleOnException("Unknown error occured while Mousehover Block: "
						+ RegistrationFunctionality.getUserName1(), e);
			}
		}
		
		public static String decryptusingweb(String strToDecrypt) {
			try {
				driver1 = new HtmlUnitDriver();
				driver1.get("https://md5decrypt.net/en/Sha256/#answer");
				WebElementOperationsWeb.park(5);
				WebElement element = driver1.findElement(By.xpath("//textarea[@id='hash_input']"));
				element.sendKeys(strToDecrypt);
				driver1.findElement(By.xpath("//input[@name='decrypt']")).click();
				WebElementOperationsWeb.park(3);
				String decryptedOTP = driver1.findElement(By.cssSelector("fieldset[id='answer'] b")).getText();
				System.out.println(decryptedOTP);
				return decryptedOTP;
			} catch (Exception e) {
				System.out.println("Decrypting is not working as Expected");
			}
			return null;
		}

		// Click on Log out
		public void LogOutClick() {
			try {
				if (WebElementOperationsWeb.isDisplayed(driver, RegistrationFunctionality.getLogOut())) {
					WebElementOperationsWeb.click(driver, RegistrationFunctionality.getLogOut());
				} else {
					LOG.error("Please enter a valid email or phone number");
				}
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking on logout: " + RegistrationFunctionality.getLogOut(),
						e);
			}
		}

}
