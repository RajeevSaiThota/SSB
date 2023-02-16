package com.sslweb.automation.test.page.actions.helper;

import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.checkoutpageusingnetbanking.model.CheckoutFlowNetBanking;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.util.Sheet;
import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCheckoutPageNetBankingHelper extends GlobalExceptionHandler {

	// In this class we are performing operations to perform payment through Net
	// Banking
	/*
	 * 1. Add to Cart 2. Click on Cart 3. Click on proceed in Cart Page 4. Add
	 * address 5. Click on Payment page 6. Click on Net Banking 7. Enter Bank Name
	 * 8. Click on Pay Now
	 */

	private WebDriver driver = null;
	private ExcelRepository repository;
	private static final Logger LOG = Logger.getLogger(SSBCheckoutPageNetBankingHelper.class);

	public SSBCheckoutPageNetBankingHelper(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
		this.repository = Objects.requireNonNull(repository,
				"Repository cannot be null to perform publicVerifyDebitCardScenarioHelper class");
	}

	
	// Clicking on Type of payment
	public void ClickonNetBanking() {
		try {
			WebElementOperationsWeb.click(driver, CheckoutFlowNetBanking.getNetBankingClick());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on NetBanking: "
					+ CheckoutFlowNetBanking.getNetBankingClick(), e);
		}
	}
	/*// Sending bank name to the search bar 
	public void writeBankName() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, CheckoutFlowNetBanking.getOtherBanksSearchBar())) {
				WebElementOperationsWeb.sendKeys(driver, CheckoutFlowNetBanking.getOtherBanksSearchBar(), "Dummy Bank");
				WebElementOperationsWeb.park(1);
				CheckoutFlowNetBanking.getOtherBanksSearchBar().sendKeys(Keys.DOWN, Keys.RETURN);
				WebElementOperationsWeb.park(1);

			}
		} catch (Exception e) {
			handleOnException("Error occured while sending Gift Card Number["
					+ CheckoutFlowNetBanking.getOtherBanksSearchBar() + "]", e);
		}
	}*/
	
	public void ClickonBankIcon() {
		try {
			WebElementOperationsWeb.click(driver, CheckoutFlowNetBanking.getBankIconClick());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on NetBanking: "
					+ CheckoutFlowNetBanking.getBankIconClick(), e);
		}
	}

	// Clicking on Pay now
	public void ClickonPayNow() {
		try {
			WebElementOperationsWeb.click(driver, CheckoutFlowNetBanking.getPayNow());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on Redeem Amount: " + CheckoutFlowNetBanking.getPayNow(), e);
		}
	}
	
	// Clicking on Simulate Success
		public void ClickonSimulateSuccess() {
			try {
				WebElementOperationsWeb.click(driver, CheckoutFlowNetBanking.getBankPage());
			} catch (Exception e) {
				handleOnException(
						"Unknown error occured while clicking on Redeem Amount: " + CheckoutFlowNetBanking.getBankPage(), e);
			}
		}

}
