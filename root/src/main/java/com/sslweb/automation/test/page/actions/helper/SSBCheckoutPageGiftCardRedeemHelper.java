package com.sslweb.automation.test.page.actions.helper;

import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.checkoutpageusinggiftcard.model.CheckoutFlowGiftCard; 
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.util.Sheet;
import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageGiftCardRedeemHelper extends GlobalExceptionHandler {
	
	// In this class we are performing operations to add a gift card with pin and redeem the amount 
	/*
	 * 1. Add to Cart
	 * 2. Click on Cart
	 * 3. Click on proceed in Cart Page
	 * 4. Add address 
	 * 5. Click on Payment page
	 * 6. Click on Gift Card
	 * 7. Enter Card Detail
	 * 8. Check Balance
	 * 9. Enter Pin
	 * 10. Enter Amount to redeem 
	 * 11. Click on redeem amount 
	 */
	
			private WebDriver driver = null;
			private ExcelRepository repository;
			private static final Logger LOG = Logger.getLogger(SSBCheckoutPageGiftCardRedeemHelper.class);
			public SSBCheckoutPageGiftCardRedeemHelper(WebDriver driver, ExcelRepository repository) {
				this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
				this.repository = Objects.requireNonNull(repository, "Repository cannot be null to perform publicVerifyDebitCardScenarioHelper class");
			}
		
			// Clicking on Add to Cart button to add product to the cart
			public void ClickonAddtoCart() {
				try {
						WebElementOperationsWeb.click(driver, CheckoutFlowGiftCard.getAddtoCart());
				} catch (Exception e) {
					handleOnException("Unknown error occured while clicking Add to cart button: "+CheckoutFlowGiftCard.getAddtoCart(), e);
				}
			}
			
			// Clicking on Cart Icon 
			public void ClickonCartIcon() {
				try {
						WebElementOperationsWeb.click(driver,CheckoutFlowGiftCard.getCartIcon());
	
				} catch (Exception e) {
					handleOnException("Unknown error occured while clicking CartIcon: "+CheckoutFlowGiftCard.getCartIcon(), e);
					}
				}

		   // Clicking on Place Order  
			public void ClickonPlaceorder() {
			try {
					WebElementOperationsWeb.click(driver, CheckoutFlowGiftCard.getPlaceOrder());
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking Placeorder: "+CheckoutFlowGiftCard.getPlaceOrder(), e);
			}
		}
			 // Clicking on Add new address to add the address 
			public void ClickonAddnewaddress() {
			try {
					WebElementOperationsWeb.click(driver, CheckoutFlowGiftCard.getAddNewAddress());
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking Add new address: "+CheckoutFlowGiftCard.getAddNewAddress(), e);
			}
		}
			// Adding the address with Fullname, Mobile, Pincode, City, State, Address 
			// Full Name 
			public void sendFullName(String testCaseName) {
				try {
					if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowGiftCard.getName())) {
						WebElementOperationsWeb.sendKeys(driver, CheckoutFlowGiftCard.getName(), "Test T");
						WebElementOperationsWeb.park(3);
					}
					else {
						throw new ShoppersStopBusinessException("Unable to find FullName field in the Checkout Page ["+CheckoutFlowGiftCard.getName() +"]");
					}
				} catch (Exception e) {
					WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "FirstName");
					handleOnException("Error occured while sending FirstName [" + CheckoutFlowGiftCard.getName() +"]", e);
				}
			}
			// Mobile Number
			public void sendMobileNumber(String testCaseName, String mobileNumber) {
				try {
					if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowGiftCard.getMobileNumber())) {
						WebElementOperationsWeb.sendKeys(driver, CheckoutFlowGiftCard.getMobileNumber(), mobileNumber);
						WebElementOperationsWeb.park(3);
					}
					else {
						throw new ShoppersStopBusinessException("Unable to find the MobileNumber field in the Checkout Page ["+ CheckoutFlowGiftCard.getMobileNumber() +"]");
					}
				} catch (Exception e) {
					WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "NotEnteredMobileNumber");
					handleOnException("Error occured while sending Guest User Mobile number [" + CheckoutFlowGiftCard.getMobileNumber() +"]", e);
				}
			}
			// Pincode
			public void sendPincode(String testCaseName) {
				try {
					if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowGiftCard.getPincode())) {
						WebElementOperationsWeb.sendKeys(driver, CheckoutFlowGiftCard.getPincode(), "500034");
						WebElementOperationsWeb.park(3);
					}
					else {
						throw new ShoppersStopBusinessException("Unable to find Pincode field in the Checkout Page ["+CheckoutFlowGiftCard.getPincode() +"]");
					}
				} catch (Exception e) {
					WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "Pincode");
					handleOnException("Error occured while sending Pincode [" + CheckoutFlowGiftCard.getPincode() +"]", e);
				}
			}
			// City
			public void sendCity(String testCaseName) {
				try {
					if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowGiftCard.getCity())) {
						WebElementOperationsWeb.sendKeys(driver, CheckoutFlowGiftCard.getCity(), "Hyderabad");
						WebElementOperationsWeb.park(3);
					}
					else {
						throw new ShoppersStopBusinessException("Unable to find city field in the Checkout Page ["+CheckoutFlowGiftCard.getCity() +"]");
					}
				} catch (Exception e) {
					WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "SendCity");
					handleOnException("Error occured while sending Cityname [" + CheckoutFlowGiftCard.getCity() +"]", e);
				}
			}
			// State
			public void sendState(String testCaseName) {
				try {
					if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowGiftCard.getState())) {
						WebElementOperationsWeb.click(driver, CheckoutFlowGiftCard.getState());
						WebElementOperationsWeb.park(3);
					}
					else {
						throw new ShoppersStopBusinessException("Unable to find State field in the Checkout Page ["+CheckoutFlowGiftCard.getState() +"]");
						}
					} catch (Exception e) {
						WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "SendState");
						handleOnException("Error occured while sending State name [" + CheckoutFlowGiftCard.getState() +"]", e);
					}
				}
						
			// Clicking on Address Type
			public void ClickonStatename() {
				try {
					WebElementOperationsWeb.click(driver, CheckoutFlowGiftCard.getSelectingState());
					} catch (Exception e) {
					handleOnException("Unknown error occured while clicking on Home: "+CheckoutFlowGiftCard.getSelectingState(), e);
					}
				}
			// Address
			public void sendAddress(String testCaseName) {
				try {
					if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowGiftCard.getAddress())) {
						WebElementOperationsWeb.sendKeys(driver, CheckoutFlowGiftCard.getAddress(), "Test");
						WebElementOperationsWeb.park(3);
					}
					else {
						throw new ShoppersStopBusinessException("Unable to find address field in the Checkout Page ["+CheckoutFlowGiftCard.getAddress() +"]");
					}
				} catch (Exception e) {
					WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "SendAddress");
					handleOnException("Error occured while sending Address [" + CheckoutFlowGiftCard.getAddress() +"]", e);
				}
			}
			// Clicking on Default address 
			public void ClickonAddDefaultAddress() {
				try {
						WebElementOperationsWeb.click(driver, CheckoutFlowGiftCard.getCheckasDefaultAddress());
				} catch (Exception e) {
					handleOnException("Unknown error occured while clicking on default address: "+CheckoutFlowGiftCard.getCheckasDefaultAddress(), e);
				}
			}
			// Clicking on Address Type
			public void ClickonAddresstypeHome() {
				try {
						WebElementOperationsWeb.click(driver, CheckoutFlowGiftCard.getHome());
				} catch (Exception e) {
					handleOnException("Unknown error occured while clicking on Home: "+CheckoutFlowGiftCard.getHome(), e);
				}
			}
			
			// Confirming on clicking new address 
			public void ClickonAddnewaddressSelect() {
				try {
						WebElementOperationsWeb.click(driver, CheckoutFlowGiftCard.getAddAddressSelect());
				} catch (Exception e) {
					handleOnException("Unknown error occured while clicking Add new address: "+CheckoutFlowGiftCard.getAddAddressSelect(), e);
				}
			}
			
			// Confirming on Proceed to pay  
			public void ClickonProceedtoPayment() {
				try {
						WebElementOperationsWeb.click(driver, CheckoutFlowGiftCard.getContinuetoPaymentPage());
					} catch (Exception e) {
						handleOnException("Unknown error occured while clicking Payment: "+CheckoutFlowGiftCard.getContinuetoPaymentPage(), e);
					}
				}
			
			// Clicking on Type of payment
			public void ClickonGiftcardOption() {
				try {
						WebElementOperationsWeb.click(driver, CheckoutFlowGiftCard.getGiftCardClick());
					} catch (Exception e) {
								handleOnException("Unknown error occured while clicking on Credit/Debit Card: "+CheckoutFlowGiftCard.getGiftCardClick(), e);
					}
				}	
			
			//Gift Card button click 
			public void ClickonGiftCardButton() {
				try {
						WebElementOperationsWeb.click(driver, CheckoutFlowGiftCard.getGiftCardButtonClick());
											
				} catch (Exception e) {
					handleOnException("Error occured while clicking on Gift Card button [" +  CheckoutFlowGiftCard.getGiftCardButtonClick() +"]", e);
				}
			}
			
			public void writeGiftCardNum(String sheetName, int serialNo) {
				try {
					if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowGiftCard.getGiftCardNumber() )) {
						WebElementOperationsWeb.sendKeys(driver, CheckoutFlowGiftCard.getGiftCardNumber(), repository.readStringFrom(sheetName, Sheet.CheckOutPage.GIFTCARD_EGV_NUMBER, serialNo));
						WebElementOperationsWeb.park(1);
					}
					else {
						throw new ShoppersStopBusinessException("Unable to find the Card Number block["+ CheckoutFlowGiftCard.getGiftCardNumber() +"]");
					}
				} catch (Exception e) {
					handleOnException("Error occured while sending Gift Card Number[" + CheckoutFlowGiftCard.getGiftCardNumber() +"]", e);
				}
			}
			
			// Checking Balance 
			public void CheckCardBalance() {
				try {
					if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowGiftCard.getCheckBalance())) {
						WebElementOperationsWeb.click(driver, CheckoutFlowGiftCard.getCheckBalance());
						WebElementOperationsWeb.park(1);
					}
					else {
						throw new ShoppersStopBusinessException("Unable to find the Check Balance ["+ CheckoutFlowGiftCard.getCheckBalance() +"]");
					}
				} catch (Exception e) {
					handleOnException("Error occured while selecting Check Balance [" + CheckoutFlowGiftCard.getCheckBalance() +"]", e);
				}
			}
			
			public void writeToPin(String sheetName, int serialNo) {
				try {
					if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowGiftCard.getPinNumber())) {
						WebElementOperationsWeb.sendKeys(driver, CheckoutFlowGiftCard.getPinNumber(), repository.readStringFrom(sheetName, Sheet.CheckOutPage.EGV_GIFTCARD_PIN, serialNo));
						WebElementOperationsWeb.park(1);
					}
					else {
						throw new ShoppersStopBusinessException("Unable to find the Pin textbox ["+ CheckoutFlowGiftCard.getPinNumber() +"]");
					}
				} catch (Exception e) {
					handleOnException("Error occured while sending pin Value [" + CheckoutFlowGiftCard.getPinNumber() +"]", e);
				}
			}

			// Entering amount to redeem 
				public void WriteRedeemAmount(String sheetName, int serialNo) {
				try {
						WebElementOperationsWeb.sendKeys(driver, CheckoutFlowGiftCard.getRedeemAmount(), repository.readStringFrom(sheetName, Sheet.CheckOutPage.REDEEM_AMOUNT, serialNo));
					} catch (Exception e) {
					handleOnException("Unknown error occured while Redeem Amount: "+CheckoutFlowGiftCard.getRedeemAmount(), e);
					}
				}
						
			// Clicking on Redeem now 
				public void ClickonRedeemNow() {
				try {
					WebElementOperationsWeb.click(driver, CheckoutFlowGiftCard.getRedeemAmount());
				} catch (Exception e) {
					handleOnException("Unknown error occured while clicking on Redeem Amount: "+CheckoutFlowGiftCard.getRedeemAmount(), e);
				}
			}			
			 
}
