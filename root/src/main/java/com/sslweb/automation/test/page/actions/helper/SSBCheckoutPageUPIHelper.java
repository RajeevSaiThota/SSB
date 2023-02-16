package com.sslweb.automation.test.page.actions.helper;


import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.checkoutpageusingupi.model.CheckoutFlowUPI;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.util.Sheet;
import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageUPIHelper extends GlobalExceptionHandler {

	// In this class we are performing operations to perform payment through Net
	// Banking
	/*
	 * 1. Add to Cart 2. Click on Cart 3. Click on proceed in Cart Page 4. Add
	 * address 5. Click on Payment page 6. Click on Net Banking 7. Enter Bank Name
	 * 8. Click on Pay Now
	 */

	private WebDriver driver = null;
	private ExcelRepository repository;
	private static final Logger LOG = Logger.getLogger(SSBCheckoutPageUPIHelper.class);

	public SSBCheckoutPageUPIHelper(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
		this.repository = Objects.requireNonNull(repository,
				"Repository cannot be null to perform publicVerifyDebitCardScenarioHelper class");
	}

	// Clicking on Type of payment
	public void ClickonUPI() {
		try {
			WebElementOperationsWeb.click(driver, CheckoutFlowUPI.getUPIClick());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on UPI: " + CheckoutFlowUPI.getUPIClick(), e);
		}
	}

	// Sending UPI ID
	public void SendUPIID(String sheetName, int token) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowUPI.getEnterUPI())) {
				WebElementOperationsWeb.sendKeys(driver, CheckoutFlowUPI.getEnterUPI(),
						repository.readStringFrom(sheetName, Sheet.CheckOutPage.EMAIL, token));
				WebElementOperationsWeb.park(2);
			} else {
				throw new ShoppersStopBusinessException(
						"Unable to find the UPI Id textbox [" + CheckoutFlowUPI.getEnterUPI() + "]");
			}
		} catch (Exception e) {
			handleOnException("Error occured while sending UPI Id [" + CheckoutFlowUPI.getEnterUPI() + "]", e);
		}
	}

	// Clicking on Verify UPI ID
	public void ClickonVerify() {
		try {
			WebElementOperationsWeb.click(driver, CheckoutFlowUPI.getVerifyButton());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Verify: " + CheckoutFlowUPI.getVerifyButton(),
					e);
		}
	}

	// Clicking on Simulate Success
	public void ClickonPaynow() {
		try {
			WebElementOperationsWeb.click(driver, CheckoutFlowUPI.getPayNowClick());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Paynow: " + CheckoutFlowUPI.getPayNowClick(), e);
		}
	}

}
