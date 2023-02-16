package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.checkoutpageusingcod.model.CheckoutFlowCOD;
//import com.sslweb.automation.checkoutpageusingcod.model.CheckoutFlowCOD;
import com.sslweb.automation.checkoutpageusingdebitcard.model.CheckoutFlowDebitCard;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.util.Sheet;
import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.testscripts.db.DataBaseConnect;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageDebitCardPayHelper extends GlobalExceptionHandler {

	// In this class we are performing operations to make a Debit card payment
	/*
	 * 1. Add to Cart 2. Click on Cart 3. Click on proceed in Cart Page 4. Add
	 * address 5. Click on Payment page 6. Click on Credit/Debit Card 7. Enter Card
	 * Detail 8. Click on Pay
	 */

	private WebDriver driver = null;
	private ExcelRepository repository;
	private static final Logger LOG = Logger.getLogger(SSBCheckoutPageDebitCardPayHelper.class);
	private DataBaseConnect dataBaseConnect;

	public SSBCheckoutPageDebitCardPayHelper(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
		this.repository = Objects.requireNonNull(repository,
				"Repository cannot be null to perform publicVerifyDebitCardScenarioHelper class");
	}

	// Adding to cart, sign in and address is taken from parent class navigation
	// helper

	// Clicking on the Signin (Account Locator)
	public void clickOnAccount() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowDebitCard.getSignIn())) {
				WebElementOperationsWeb.click(driver, CheckoutFlowDebitCard.getSignIn());
			} else {
				LOG.error("Account Element not Found");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Account: " + CheckoutFlowDebitCard.getSignIn(), e);
		}
	}

	// Username Title box locator and enter user name
	public void LoginEnterUsername(String token) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowDebitCard.getUserNameTypeIn())) {
				WebElementOperationsWeb.sendKeys(CheckoutFlowDebitCard.getUserNameTypeIn(), token);
			} else {
				LOG.error("Please enter a valid email or phone number");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Username/Phonenumber Block: "
					+ CheckoutFlowDebitCard.getUserNameTypeIn(), e);
		}
	}

	/*// Method to delete the existing text and send new text 
	public void NewPincode(String token) {
		try {
			
			WebElementOperationsWeb.click(null);
			WebElementOperationsWeb.sendKeys(null, Keys.CONTROL,"a");
			WebElementOperationsWeb.sendKeys(null, Keys.DELETE);
			WebElementOperationsWeb.sendKeys(null, token);
	
			}
		catch (Exception e) {
			handleOnException("Unknown error occured while clicking Username/Phonenumber Block: "
					+ CheckoutFlowDebitCard.getUserNameTypeIn(), e);
		}
	}*/

	// Click on Proceed
	public void LoginProceed() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowDebitCard.getProceedButton())) {
				WebElementOperationsWeb.click(driver, CheckoutFlowDebitCard.getProceedButton());
			} else {
				LOG.error("Please enter a valid password");
			}
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking Password Block: " + CheckoutFlowDebitCard.getProceedButton(),
					e);
		}
	}

	private void sendOtpDB(String testCaseName, String otp) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowDebitCard.getPasswordTypeIn())) {
				WebElementOperationsWeb.sendKeys(driver, CheckoutFlowDebitCard.getPasswordTypeIn(), otp);
				WebElementOperationsWeb.park(3);
			} else {
				throw new ShoppersStopBusinessException(
						"Error occured while sending OTP [" + CheckoutFlowDebitCard.getPasswordTypeIn() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "OTP");
			handleOnException("Error occured while sending OTP [" + CheckoutFlowDebitCard.getPasswordTypeIn() + "]", e);
		}
	}

	// Enter OTP
	public void LoginOTP(String testCaseName, String mobileNumber) {
		try {
			String otpNum = dataBaseConnect.getOTP(mobileNumber);
			// String Decryptotp = decryptusingweb(otpNum);
			// String Decryptotp = EncryptDecryptPassword.decrypt(otpNum);
			// System.out.println(Decryptotp);
			// sendOtpDB(testCaseName, Decryptotp);
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Username/Phonenumber Block: "
					+ CheckoutFlowDebitCard.getPasswordTypeIn(), e);
		}
	}

	// Click on Log in
	public void LogInButtonClick() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowDebitCard.getLogInButton())) {
				WebElementOperationsWeb.click(driver, CheckoutFlowDebitCard.getLogInButton());
			} else {
				LOG.error("Please enter a valid email or phone number");
			}
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking LoginButton Block: " + CheckoutFlowDebitCard.getLogInButton(),
					e);
		}
	}

	// Clicking on product AddToCart
	public void ClickonAddToCartProduct() {
		try {
			//if (WebElementOperationsWeb.isDisplayed(driver,
			// CheckoutFlowDebitCard.getAddToCartProduct())) {
			WebElementOperationsWeb.click(driver, CheckoutFlowDebitCard.getAddToCartProduct());
				//	} else 
				//	{
					//		LOG.error("Please enter a valid email or phone number");
					//}
		} catch (Exception e) {
			handleOnException("Unknown error occured while Adding Product to Cart: "
					+ CheckoutFlowDebitCard.getAddToCartProduct(), e);
		}
	}

	// Clicking on Addtocart
	public void ClickonAddToCartClick() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowDebitCard.getAddToCartClick())) {
				WebElementOperationsWeb.click(driver, CheckoutFlowDebitCard.getAddToCartClick());
			} else {
				LOG.error("Please enter a valid email or phone number");
			}
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking AddToCart: " + CheckoutFlowDebitCard.getAddToCartClick(), e);
		}
	}

	// Clicking on Place order
	public void ClickonPlaceOrder() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowDebitCard.getPlaceOrderClick())) {
				WebElementOperationsWeb.click(driver, CheckoutFlowDebitCard.getPlaceOrderClick());
			} else {
				LOG.error("Please enter a valid email or phone number");
			}
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking Placeorder: " + CheckoutFlowDebitCard.getPlaceOrderClick(),
					e);
		}
	}

	// Click on continue
	public void ClickonContinue() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowDebitCard.getContinueClick())) {
				WebElementOperationsWeb.click(driver, CheckoutFlowDebitCard.getContinueClick());
			} else {
				LOG.error("Please enter a valid email or phone number");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Continue Block: "
					+ CheckoutFlowDebitCard.getContinueClick(), e);
		}
	}

	// Clicking on Type of payment
	public void ClickonDebitcard() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowDebitCard.getCreditCardDebitCardClick())) {
				WebElementOperationsWeb.click(driver, CheckoutFlowDebitCard.getCreditCardDebitCardClick());
			} else {
				LOG.error("Please enter a valid email or phone number");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Credit/Debit Card: "
					+ CheckoutFlowDebitCard.getCreditCardDebitCardClick(), e);
		}
	}

	// Adding Card Details
	// Debit Card Number
	public void writeToCardNumber(String sheetName, int serialNo, String testCaseName) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowDebitCard.getCardDetails())) {
				WebElementOperationsWeb.sendKeys(driver, CheckoutFlowDebitCard.getCardDetails(),
						repository.readStringFrom(sheetName, Sheet.CheckOutPage.CARD_NUMBER, serialNo));
				WebElementOperationsWeb.park(2);
			} else {
				throw new ShoppersStopBusinessException("Unable to find the CreditCard number textbox ["
						+ CheckoutFlowDebitCard.getCardDetails() + "]");
			}
		} catch (Exception e) {
			handleOnException(
					"Error occured while sending CreditCard Number [" + CheckoutFlowDebitCard.getCardDetails() + "]",
					e);
		}
	}

	public void writeNameOnCard(String sheetName, int serialNo, String testCaseName) {
		try {
			// if (WebElementOperationsWeb.isDisplayed(driver,
			// CheckoutFlowDebitCard.getNameonCard())) {
			WebElementOperationsWeb.sendKeys(driver, CheckoutFlowDebitCard.getNameonCard(),
					repository.readStringFrom(sheetName, Sheet.CheckOutPage.NAME_ON_CARD, serialNo));
			WebElementOperationsWeb.park(1);
//			} else {
//				throw new ShoppersStopBusinessException(
//						"Unable to find the Name on Card [" + CheckoutFlowDebitCard.getNameonCard() + "]");
//			}
		} catch (Exception e) {
			handleOnException(
					"Error occured while sending Name On Card [" + CheckoutFlowDebitCard.getNameonCard() + "]", e);
		}
	}

	public void selectExpiryMonth(String sheetName, int serialNo, String testCaseName) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowDebitCard.getValidMonth())) {
				WebElementOperationsWeb.sendKeys(driver, CheckoutFlowDebitCard.getValidMonth(),
						repository.readStringFrom(sheetName, Sheet.CheckOutPage.CARD_MONTH, serialNo));
				WebElementOperationsWeb.park(1);
			} else {
				throw new ShoppersStopBusinessException(
						"Unable to find the Expiry Month [" + CheckoutFlowDebitCard.getValidMonth() + "]");
			}
		} catch (Exception e) {
			handleOnException(
					"Error occured while selecting Expiry month [" + CheckoutFlowDebitCard.getValidMonth() + "]", e);
		}
	}

	public void selectExpiryYear(String sheetName, int serialNo, String testCaseName) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowDebitCard.getValidYear())) {
				WebElementOperationsWeb.sendKeys(driver, CheckoutFlowDebitCard.getValidYear(),
						repository.readStringFrom(sheetName, Sheet.CheckOutPage.CARD_YEAR, serialNo));
				WebElementOperationsWeb.park(1);
			} else {
				throw new ShoppersStopBusinessException(
						"Unable to find the Expiry Year [" + CheckoutFlowDebitCard.getValidYear() + "]");
			}
		} catch (Exception e) {
			handleOnException(
					"Error occured while selecting Expiry Year [" + CheckoutFlowDebitCard.getValidYear() + "]", e);
		}
	}

	public void writeToCvv(String sheetName, int serialNo, String testCaseName) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowDebitCard.getCVV())) {
				WebElementOperationsWeb.sendKeys(driver, CheckoutFlowDebitCard.getCVV(),
						repository.readStringFrom(sheetName, Sheet.CheckOutPage.CVV, serialNo));
				WebElementOperationsWeb.park(1);
			} else {
				throw new ShoppersStopBusinessException(
						"Unable to find the Cvv textbox [" + CheckoutFlowDebitCard.getCVV() + "]");
			}
		} catch (Exception e) {
			handleOnException("Error occured while sending CVV Value [" + CheckoutFlowDebitCard.getCVV() + "]", e);
		}
	}

	// Confirming to add card for future payments
//	public void ClickonSaveCard() {
//		try {
//			WebElementOperationsWeb.click(driver, CheckoutFlowDebitCard.getSaveCard());
//		} catch (Exception e) {
//			handleOnException("Unknown error occured while clicking Payment: " + CheckoutFlowDebitCard.getSaveCard(),
//					e);
//		}
//	}

	// Clicking on Pay now
	public void ClickonPaynow() {
		try {
			WebElementOperationsWeb.click(driver, CheckoutFlowDebitCard.getPaynow());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on Credit/Debit Card: " + CheckoutFlowDebitCard.getPaynow(),
					e);
		}
	}

	public void selectSamulateOTP(String sheetName, int serialNo, String testCaseName) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowDebitCard.getDBCardOTP())) {
				WebElementOperationsWeb.sendKeys(driver, CheckoutFlowDebitCard.getDBCardOTP(),
						repository.readStringFrom(sheetName, Sheet.CheckOutPage.JUSPAYOTP, serialNo));
				WebElementOperationsWeb.park(1);
			} else {
				throw new ShoppersStopBusinessException(
						"Unable to find the Expiry Year [" + CheckoutFlowDebitCard.getDBCardOTP() + "]");
			}
		} catch (Exception e) {
			handleOnException(
					"Error occured while selecting Expiry Year [" + CheckoutFlowDebitCard.getDBCardOTP() + "]", e);
		}
	}

//	public void writeDBCardOTP(String sheetName, int serialNo) {
//		try {
//			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowDebitCard.getDBCardOTP())) {
//				WebElementOperationsWeb.sendKeys(driver, CheckoutFlowDebitCard.getDBCardOTP(),
//						repository.readStringFrom(sheetName, Sheet.CheckOutPage.PASSWORD, serialNo));
//				WebElementOperationsWeb.park(1);
//			} else {
//				throw new ShoppersStopBusinessException(
//						"Unable to find the OTP textbox [" + CheckoutFlowDebitCard.getDBCardOTP() + "]");
//			}
//		} catch (Exception e) {
//			handleOnException(
//					"Error occured while sending Card OTP Value [" + CheckoutFlowDebitCard.getDBCardOTP() + "]", e);
//		}
//	}

	// Clicking on Submit redirects to payment successfull page
	public void ClickonSubmitSuccess() {
		try {
			WebElementOperationsWeb.click(driver, CheckoutFlowDebitCard.getSubmitSuccess());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Submit Success: "
					+ CheckoutFlowDebitCard.getSubmitSuccess(), e);
		}
	}

	// Click on Log in
	public void Usernamemousehover() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowDebitCard.getUserName())) {
				WebElementOperationsWeb.mouseOver(driver, CheckoutFlowDebitCard.getUserName());
			} else {
				throw new ShoppersStopBusinessException(
						"Error occured in mousehovering profileIcon [" + CheckoutFlowDebitCard.getUserName() + "]");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while Mousehover Block: " + CheckoutFlowCOD.getUserName(), e);
		}
	}

	// Click on Log out
	public void LogOutClick() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowDebitCard.getLogOut())) {
				WebElementOperationsWeb.click(driver, CheckoutFlowDebitCard.getLogOut());
			} else {
				LOG.error("Please enter a valid email or phone number");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on logout: " + CheckoutFlowDebitCard.getLogOut(),
					e);
		}
	}

}
