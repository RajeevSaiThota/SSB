package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.sslweb.automation.cartpageverifyapplycouponsample.model.CartPageApplyCouponSampleFlow;
import com.sslweb.automation.checkoutpageusingcod.model.CheckoutFlowCOD;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.userloginfunctionalitycheck.model.SSBLoginFunctionality;
import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.testscripts.db.DataBaseConnect;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageCODHelper extends GlobalExceptionHandler {

	// In this class we are performing operations to get discount payment through
	// wallet
	/*
	 * 1. Add to Cart 2. Click on Cart 3. Click on proceed in Cart Page 4. Add
	 * address 5. Click on Payment page 6. Click on Net Banking 7. Enter Bank Name
	 * 8. Click on Pay Now
	 */

	private WebDriver driver = null;
	private static WebDriver driver1;
	private static final Logger LOG = Logger.getLogger(SSBCheckoutPageCODHelper.class);
	private DataBaseConnect dataBaseConnect;
	private ExcelRepository repository;

	public SSBCheckoutPageCODHelper(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
		this.repository = Objects.requireNonNull(repository,
				"Repository cannot be null to perform publicVerifyCODScenarioHelper class");
		//dataBaseConnect=New DataBaseConnect();
	}

	// Clicking on the Signin (Account Locator)
		public void clickOnAccount() {
			try {
				if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCOD.getSignIn())) {
					WebElementOperationsWeb.click(driver, CheckoutFlowCOD.getSignIn());
				} else 
					{
					LOG.error("Account Element not Found");
				}
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking Account: " + CheckoutFlowCOD.getSignIn(), e);
			}
		}
		
		
		// Username Title box locator and enter user name
		public void LoginEnterUsername(String token) {
			try {
				if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCOD.getUserNameTypeIn())) {
					WebElementOperationsWeb.sendKeys(CheckoutFlowCOD.getUserNameTypeIn(), token);
				} else {
					LOG.error("Please enter a valid email or phone number");
				}
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking Username/Phonenumber Block: "
						+ CheckoutFlowCOD.getUserNameTypeIn(), e);
			}
		}

		// Click on Proceed
		public void LoginProceed() {
			try {
				if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCOD.getProceedButton())) {
					WebElementOperationsWeb.click(driver, CheckoutFlowCOD.getProceedButton());
				} else {
					LOG.error("Please enter a valid password");
				}
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking Password Block: "
						+ CheckoutFlowCOD.getProceedButton(), e);
			}
		}

		private void sendOtpDB(String testCaseName, String otp) {
			try {
				if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCOD.getPasswordTypeIn())) {
					WebElementOperationsWeb.sendKeys(driver, CheckoutFlowCOD.getPasswordTypeIn(), otp);
					WebElementOperationsWeb.park(3);
				} else {
					throw new ShoppersStopBusinessException(
							"Error occured while sending OTP [" + CheckoutFlowCOD.getPasswordTypeIn() + "]");
				}
			} catch (Exception e) {
				WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "OTP");
				handleOnException("Error occured while sending OTP [" + CheckoutFlowCOD.getPasswordTypeIn() + "]", e);
			}
		}

		// Enter OTP
		public void LoginOTP(String testCaseName, String mobileNumber) {
			try {
				String otpNum=dataBaseConnect.getOTP(mobileNumber);
				//String Decryptotp = decryptusingweb(otpNum);
				//String Decryptotp = EncryptDecryptPassword.decrypt(otpNum);
				//System.out.println(Decryptotp);
				//sendOtpDB(testCaseName, Decryptotp);
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking Username/Phonenumber Block: "
						+ CheckoutFlowCOD.getPasswordTypeIn(), e);
			}
		}

		// Click on Log in
		public void LogInButtonClick() {
			try {
				if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCOD.getLogInButton())) {
					WebElementOperationsWeb.click(driver, CheckoutFlowCOD.getLogInButton());
				} else {
					LOG.error("Please enter a valid email or phone number");
				}
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking LoginButton Block: "
						+ CheckoutFlowCOD.getLogInButton(), e);
			}
		}
		
		// Clicking on product AddToCart 
		public void ClickonAddToCartProduct() {
			try {
				//if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCOD.getAddToCartProduct())) {
					WebElementOperationsWeb.click(driver,CheckoutFlowCOD.getAddToCartProduct());
//				} else 
//				{
//						LOG.error("Please enter a valid email or phone number");
//				}
			} catch (Exception e) {
				handleOnException("Unknown error occured while Adding Product to Cart: "+CheckoutFlowCOD.getAddToCartProduct(), e);
				}
			}

	   // Clicking on Addtocart
		public void ClickonAddToCartClick() {
		try {
			//if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCOD.getPlaceOrderClick())) {
				WebElementOperationsWeb.click(driver, CheckoutFlowCOD.getAddToCartClick() );
//			} else 
//			{
//				LOG.error("Please enter a valid email or phone number");
//			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking AddToCart: "+CheckoutFlowCOD.getAddToCartClick(), e);
		}
	}
		
		//Clicking on Place order
				public void ClickonPlaceOrder() {
				try {
					if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCOD.getPlaceOrderClick())) {
						WebElementOperationsWeb.click(driver, CheckoutFlowCOD.getPlaceOrderClick() );
					} else {
						LOG.error("Please enter a valid email or phone number");
					}
				} catch (Exception e) {
					handleOnException("Unknown error occured while clicking Placeorder: "+CheckoutFlowCOD.getPlaceOrderClick(), e);
				}
			}
				
		// Click on continue
				public void ClickonContinue() {
					try {
						if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCOD.getContinueClick())) {
							WebElementOperationsWeb.click(driver, CheckoutFlowCOD.getContinueClick());
						} else {
							LOG.error("Please enter a valid email or phone number");
						}
					} catch (Exception e) {
						handleOnException("Unknown error occured while clicking on Continue Block: "
								+ CheckoutFlowCOD.getContinueClick(), e);
					}
				}
						
		// Click on continue
				public void ClickonCOD() {
					try {
						//if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCOD.getCODClick())) {
							WebElementOperationsWeb.click(driver, CheckoutFlowCOD.getCODClick());
//						} else {
//							LOG.error("Please enter a valid email or phone number");
//						}
					} catch (Exception e) {
						handleOnException("Unknown error occured while clicking on COD Block: "
								+ CheckoutFlowCOD.getCODClick(), e);
					}
				}	
				
		// Click on continue
				public void ClickonCODPlaceOrder() {
					try {
						if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCOD.getCODPlaceOrderClick())) {
							WebElementOperationsWeb.click(driver, CheckoutFlowCOD.getCODPlaceOrderClick());
						} else {
							LOG.error("Please enter a valid email or phone number");
						}
					} catch (Exception e) {
						handleOnException("Unknown error occured while clicking on CODPlaceorder Block: "
								+ CheckoutFlowCOD.getCODPlaceOrderClick(), e);
					}
				}
				
				// Click on continue shopping
				public void ClickonContinueShopping() {
					try {
						if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCOD.getContinueShoppingClick())) {
							WebElementOperationsWeb.click(driver, CheckoutFlowCOD.getContinueShoppingClick());
						} else {
							LOG.error("Please enter a valid email or phone number");
						}
					} catch (Exception e) {
						handleOnException("Unknown error occured while clicking on ContinueShopping Block: "
								+ CheckoutFlowCOD.getContinueShoppingClick(), e);
					}
				}
				
				// Click on Log in
				public void Usernamemousehover() {
					try {
						if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCOD.getUserName())) {
							WebElementOperationsWeb.mouseOver(driver, CheckoutFlowCOD.getUserName());
						} else {
							throw new ShoppersStopBusinessException(
									"Error occured in mousehovering profileIcon [" + CheckoutFlowCOD.getUserName() + "]");
						}
					} catch (Exception e) {
						handleOnException("Unknown error occured while Mousehover Block: "
								+ CheckoutFlowCOD.getUserName(), e);
					}
				}

				// Click on Log out
				public void LogOutClick() {
					try {
						if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowCOD.getLogOut())) {
							WebElementOperationsWeb.click(driver, CheckoutFlowCOD.getLogOut());
						} else {
							LOG.error("Please enter a valid email or phone number");
						}
					} catch (Exception e) {
						handleOnException("Unknown error occured while clicking on logout: " + CheckoutFlowCOD.getLogOut(),
								e);
					}
				}
}
