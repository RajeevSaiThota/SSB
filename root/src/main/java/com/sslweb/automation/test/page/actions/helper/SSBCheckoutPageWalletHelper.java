package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.checkoutpageusingwallet.model.CheckoutFlowWallet;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageWalletHelper extends GlobalExceptionHandler {

	// In this class we are performing operations to get discount payment through
	// wallet
	/*
	 * 1. Add to Cart 2. Click on Cart 3. Click on proceed in Cart Page 4. Add
	 * address 5. Click on Payment page 6. Click on Net Banking 7. Enter Bank Name
	 * 8. Click on Pay Now
	 */

	private WebDriver driver = null;

	public SSBCheckoutPageWalletHelper(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
	}

	// Clicking on Type of payment
	public void ClickonWalletCheckbox() {
		try {
			WebElementOperationsWeb.click(driver, CheckoutFlowWallet.getWalletClick());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on wallet checkbox: " + CheckoutFlowWallet.getWalletClick(),
					e);
		}
	}

	// Sending Wallet OTP
	public void SendWalletOTP(String testCaseName, String token) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowWallet.getEnterWalletOTP())) {
				WebElementOperationsWeb.sendKeys(driver, CheckoutFlowWallet.getEnterWalletOTP(), token);
				WebElementOperationsWeb.park(2);
			} else {
				throw new ShoppersStopBusinessException(
						"Unable to enter OTP textbox [" + CheckoutFlowWallet.getEnterWalletOTP() + "]");
			}
		} catch (Exception e) {
			handleOnException("Error occured while entering OTP [" + CheckoutFlowWallet.getEnterWalletOTP() + "]", e);
		}
	}

	// Clicking on Verify
	public void ClickonVerify() {
		try {
			WebElementOperationsWeb.click(driver, CheckoutFlowWallet.getVerifyAndProceedButton());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on Verify: " + CheckoutFlowWallet.getVerifyAndProceedButton(),
					e);
		}
	}

}
