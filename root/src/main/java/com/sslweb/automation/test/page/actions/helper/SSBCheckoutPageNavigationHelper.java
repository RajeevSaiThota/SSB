package com.sslweb.automation.test.page.actions.helper;


import java.util.Objects;


import org.openqa.selenium.WebDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.checkoutpagenavigationflow.model.NavigationFlowCheckout;
import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.util.Sheet;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageNavigationHelper extends GlobalExceptionHandler {

	// In this class we are performing operations to make a creditcard payment
	/*
	 * 1. Add to Cart 2. Click on Cart 3. Click on proceed in Cart Page 4. Add
	 * address 5. Click on Payment page 6. Click on Credit/Debit Card 7. Enter Card
	 * Detail 8. Click on Pay
	 */

	private WebDriver driver = null;
	private ExcelRepository repository;

	public SSBCheckoutPageNavigationHelper(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
		this.repository = Objects.requireNonNull(repository,
				"Repository cannot be null to perform publicVerifyDebitCardScenarioHelper class");
	}
	
	// Search Box
	public void sendProductID(String testCaseName, String ID) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, NavigationFlowCheckout.getSearchBarPLP())) {
				WebElementOperationsWeb.sendKeys(driver, NavigationFlowCheckout.getSearchBarPLP(), ID);

			} else {
				throw new ShoppersStopBusinessException("Unable to find FullName field in the Checkout Page ["
						+ NavigationFlowCheckout.getSearchBarPLP() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "ProductDetails");
			handleOnException(
					"Error occured while sending FirstName [" + NavigationFlowCheckout.getSearchBarPLP() + "]", e);
		}
	}

	// Clicking on Add to Cart button to add product to the cart
	public void ClickonAddtoCart() {
		try {
			WebElementOperationsWeb.click(driver, NavigationFlowCheckout.getAddtoCart());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking Add to cart button: " + NavigationFlowCheckout.getAddtoCart(),
					e);
		}
	}

	// Clicking on Cart Icon will redirect to cart page
	public void ClickonCartIcon() {
		try {
			WebElementOperationsWeb.click(driver, NavigationFlowCheckout.getCartIcon());

		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking CartIcon: " + NavigationFlowCheckout.getCartIcon(),
					e);
		}
	}

	// Cart Page
	// Clicking on Place Order as registered user
	public void ClickonPlaceorder() {
		try {
			WebElementOperationsWeb.click(driver, NavigationFlowCheckout.getPlaceOrder());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking Placeorder: " + NavigationFlowCheckout.getPlaceOrder(), e);
		}
	}

	// Signin flow

	// Sending Mobile Number
	public void sendMobileno(String testCaseName, String mobileno) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, NavigationFlowCheckout.getUserNameTypeIn())) {
				WebElementOperationsWeb.sendKeys(driver, NavigationFlowCheckout.getUserNameTypeIn(), mobileno);
			} else {
				throw new ShoppersStopBusinessException("Unable to find mobile number field in signin Page ["
						+ NavigationFlowCheckout.getUserNameTypeIn() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "mobileno");
			handleOnException(
					"Error occured while sending FirstName [" + NavigationFlowCheckout.getUserNameTypeIn() + "]", e);
		}
	}

	public void ClickonProceed() {
		try {
			WebElementOperationsWeb.click(driver, NavigationFlowCheckout.getProceedButton());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on proceed button: "
					+ NavigationFlowCheckout.getProceedButton(), e);
		}
	}

	public void sendOTP(String testCaseName, String serialno) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, NavigationFlowCheckout.getOTP())) {
				WebElementOperationsWeb.sendKeys(driver, NavigationFlowCheckout.getOTP(), serialno);
			} else {
				throw new ShoppersStopBusinessException(
						"Unable to enter OTP [" + NavigationFlowCheckout.getOTP() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "OTP");
			handleOnException("Error occured while sending FirstName [" + NavigationFlowCheckout.getOTP() + "]", e);
		}
	}

	public void ClickonLogin() {
		try {
			WebElementOperationsWeb.click(driver, NavigationFlowCheckout.getLogInButton());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on Login button: " + NavigationFlowCheckout.getLogInButton(),
					e);
		}
	}
	// Address Page

	public void ClickonAddnewAddress() {
		try {
			WebElementOperationsWeb.click(driver, NavigationFlowCheckout.getAddNewAddress());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Addnewaddress button: "
					+ NavigationFlowCheckout.getAddNewAddress(), e);
		}
	}

	// Adding the address with Fullname, Mobile, Pincode, City, State, Address
	// Full Name
	public void sendFullName(String sheetname, int serialNo, String testCaseName) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, NavigationFlowCheckout.getName())) {
				WebElementOperationsWeb.sendKeys(driver, NavigationFlowCheckout.getName(), repository.readStringFrom(sheetname, Sheet.Registration.FULL_NAME, serialNo));
				WebElementOperationsWeb.park(3);
			} else {
				throw new ShoppersStopBusinessException("Unable to find FullName field in the Checkout Page ["
						+ NavigationFlowCheckout.getName() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "FirstName");
			handleOnException("Error occured while sending FirstName [" + NavigationFlowCheckout.getName() + "]", e);
		}
	}

	// Mobile Number
	public void sendMobileNumber(String sheetname, int serialNo, String testCaseName) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, NavigationFlowCheckout.getMobileNumber())) {
				WebElementOperationsWeb.sendKeys(driver, NavigationFlowCheckout.getMobileNumber(),repository.readStringFrom(sheetname, Sheet.Registration.MOBILE_NUMBER, serialNo));
				WebElementOperationsWeb.park(3);
			} else {
				throw new ShoppersStopBusinessException("Unable to find the MobileNumber field in the Checkout Page ["
						+ NavigationFlowCheckout.getMobileNumber() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "NotEnteredMobileNumber");
			handleOnException("Error occured while sending Guest User Mobile number ["
					+ NavigationFlowCheckout.getMobileNumber() + "]", e);
		}
	}

	// Pincode
	public void sendPincode(String sheetname, int serialNo, String testCaseName) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, NavigationFlowCheckout.getPincode())) {
				WebElementOperationsWeb.sendKeys(driver, NavigationFlowCheckout.getPincode(), repository.readStringFrom(sheetname, Sheet.Registration.EMAIL, serialNo));
				WebElementOperationsWeb.park(3);
			} else {
				throw new ShoppersStopBusinessException("Unable to find Pincode field in the Checkout Page ["
						+ NavigationFlowCheckout.getPincode() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "Pincode");
			handleOnException("Error occured while sending Pincode [" + NavigationFlowCheckout.getPincode() + "]", e);
		}
	}

	// Address
	public void sendAddress(String sheetname, int serialNo, String testCaseName) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, NavigationFlowCheckout.getAddress())) {
				WebElementOperationsWeb.sendKeys(driver, NavigationFlowCheckout.getAddress(), repository.readStringFrom(sheetname, Sheet.Registration.ADDRESS, serialNo));
				WebElementOperationsWeb.park(3);
			} else {
				throw new ShoppersStopBusinessException("Unable to find address field in the Checkout Page ["
						+ NavigationFlowCheckout.getAddress() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "SendAddress");
			handleOnException("Error occured while sending Address [" + NavigationFlowCheckout.getAddress() + "]", e);
		}
	}

	// Clicking on Default address
	public void ClickonAddDefaultAddress() {
		try {
			WebElementOperationsWeb.click(driver, NavigationFlowCheckout.getCheckasDefaultAddress());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on default address: "
					+ NavigationFlowCheckout.getCheckasDefaultAddress(), e);
		}
	}

	// Clicking on Address Type
	public void ClickonAddresstypeHome() {
		try {
			WebElementOperationsWeb.click(driver, NavigationFlowCheckout.getHome());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Home: " + NavigationFlowCheckout.getHome(), e);
		}
	}

	// Confirming on clicking new address
	public void ClickonAddnewaddressSelect() {
		try {
			WebElementOperationsWeb.click(driver, NavigationFlowCheckout.getAddAddressSelect());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Add new address: "
					+ NavigationFlowCheckout.getAddAddressSelect(), e);
		}
	}

	// Selecting the address

	public void ClickonAddressbox() {
		try {
			WebElementOperationsWeb.click(driver, NavigationFlowCheckout.getAddressSelectButton());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Add address button: "
					+ NavigationFlowCheckout.getAddressSelectButton(), e);
		}
	}

	// Confirming on Proceed to pay
	public void ClickonProceedtoPayment() {
		try {
			WebElementOperationsWeb.click(driver, NavigationFlowCheckout.getContinuetoPaymentPage());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Payment: "
					+ NavigationFlowCheckout.getContinuetoPaymentPage(), e);
		}
	}

}
