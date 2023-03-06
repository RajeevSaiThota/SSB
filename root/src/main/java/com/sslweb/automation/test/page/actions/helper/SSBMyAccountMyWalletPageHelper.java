package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.myaccountmywalletpage.model.MyWalletPage;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.util.Sheet;
import com.sslweb.automation.repo.ExcelRepository;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountMyWalletPageHelper extends GlobalExceptionHandler {

	private WebDriver driver = null;
	private ExcelRepository repository;

	public SSBMyAccountMyWalletPageHelper(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
		this.repository = Objects.requireNonNull(repository,
				"Repository cannot be null to perform publicVerifyDebitCardScenarioHelper class");
	}

	// Mouse Hovering towards user profile
	public void MouseHoverUserProfile() {
		try {
			WebElementOperationsWeb.mouseOver(driver, MyWalletPage.getUserProfile());
		} catch (Exception e) {
			handleOnException("Unknown error occured while mouse overing to user profile: "
					+ MyWalletPage.getUserProfile(), e);
		}
	}

	// Clicking on My wallet in user profile
	public void ClickonMyWallet() {
		try {
			WebElementOperationsWeb.click(driver, MyWalletPage.getMyWalletClick());

		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking MyWallet: " + MyWalletPage.getMyWalletClick(), e);
		}
	}

	// Clicking on Enter Card Number
	public void ClickonEnterCardNumber(String sheetName, int serialNo) {
		try {
			WebElementOperationsWeb.sendKeys(driver, MyWalletPage.getEnterCardNumberClick(),
					repository.readStringFrom(sheetName, Sheet.CheckOutPage.GIFTCARD_EGV_NUMBER, serialNo));
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Enter Card Number : "
					+ MyWalletPage.getEnterCardNumberClick(), e);
		}
	}

	// clicking on a Enter Pin

	public void ClickonEnterPin(String sheetName, int serialNo) {
		try {
			WebElementOperationsWeb.sendKeys(driver, MyWalletPage.getEnterPinClick(),
					repository.readStringFrom(sheetName, Sheet.CheckOutPage.EGV_GIFTCARD_PIN, serialNo));
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on Enter Pin selection : " + MyWalletPage.getEnterPinClick(),
					e);
		}
	}
	
	// Clicking on Check Balance
		public void ClickonCheckBalance() {
			try {
				WebElementOperationsWeb.click(driver, MyWalletPage.getCheckBalenceClick());

			} catch (Exception e) {
				handleOnException(
						"Unknown error occured while clicking check balance: " + MyWalletPage.getCheckBalenceClick(), e);
			}
		}

		
		public void TotalBalanceVerification() {
			try {
				WebElementOperationsWeb.isDisplayed(driver, MyWalletPage.getTotalBalance());

			} catch (Exception e) {
				handleOnException(
						"Unknown error occured in displaying Total balance: " + MyWalletPage.getTotalBalance(), e);
			}
		}	
		
}
