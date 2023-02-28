package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.ssbpdpcheckdelivery.model.VerifyDeliveryCheck;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.SSBPDPCheckDeliveryAction;
import com.sslweb.automation.util.Sheet;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPDPCheckDeliveryHelper extends GlobalExceptionHandler {

	private WebDriver driver = null;
	private ExcelRepository repository;

	private static final Logger LOG = Logger.getLogger(SSBPDPCheckDeliveryHelper.class);

	public SSBPDPCheckDeliveryHelper(WebDriver driver,ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
		this.repository = Objects.requireNonNull(repository, "Repository cannot be null ");

	}
	// Navigation to PDP page from Home Page

	// Search Box
	public void sendProductID(String testCaseName, String sheetName, int serialNo) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, VerifyDeliveryCheck.getSearchBarPLP())) {
				WebElementOperationsWeb.enterKeysWithEnter(driver, VerifyDeliveryCheck.getSearchBarPLP(),repository.readStringFrom(sheetName, Sheet.PdpPage.PRODUCT_CODE, serialNo) );

			} else {
				throw new ShoppersStopBusinessException("Unable to find FullName field in the Checkout Page ["
						+ VerifyDeliveryCheck.getSearchBarPLP() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "ProductDetails");
			handleOnException("Error occured while sending FirstName [" + VerifyDeliveryCheck.getSearchBarPLP() + "]",
					e);
		}
	}

	// Clicking on Product card to navigate to PDP
	public void ClickonProductCard() {
		try {
			WebElementOperationsWeb.jsClick(driver, VerifyDeliveryCheck.getProductCardClick());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking Product Card: " + VerifyDeliveryCheck.getProductCardClick(),
					e);
		}
	}

	// Delivery Check

	// Clicking on Pincode
	public void sendPincode(String testCaseName, String sheetName, int serialNo) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, VerifyDeliveryCheck.getDeliveryCheckBar())) {
				VerifyDeliveryCheck.getDeliveryCheckBar().clear();
				String clear=Keys.CONTROL+"A"+Keys.BACK_SPACE;
				//VerifyDeliveryCheck.getDeliveryCheckBar().click();
				VerifyDeliveryCheck.getDeliveryCheckBar().sendKeys(clear);
				VerifyDeliveryCheck.getDeliveryCheckBar().sendKeys(repository.readStringFrom(sheetName, Sheet.PdpPage.POST_CODE, serialNo));

				//WebElementOperationsWeb.sendKeys(driver, VerifyDeliveryCheck.getDeliveryCheckBar(), pincode);

			} else {
				throw new ShoppersStopBusinessException(
						"Unable to find Pincode bar  [" + VerifyDeliveryCheck.getDeliveryCheckBar() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "Pincode Check");
			handleOnException("Error occured while sending pincode [" + VerifyDeliveryCheck.getDeliveryCheckBar() + "]",
					e);
		}
	}

	// Clicking on Change Button
	public void ClickonChangeButton() {
		try {
			WebElementOperationsWeb.click(driver, VerifyDeliveryCheck.getChangeButton());

		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking ChangeButton: " + VerifyDeliveryCheck.getChangeButton(), e);
		}
	}
	public void ClickonCheckButton() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, VerifyDeliveryCheck.getCheckButton())) {
			WebElementOperationsWeb.click(driver, VerifyDeliveryCheck.getCheckButton());
			}
			else if (WebElementOperationsWeb.isDisplayed(driver, VerifyDeliveryCheck.getChangeButton())) {
				WebElementOperationsWeb.click(driver, VerifyDeliveryCheck.getChangeButton());
			}
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking CheckButton: " + VerifyDeliveryCheck.getCheckButton(), e);
		}
	}
	// Verifying Standard Delivery
	public void VerifyStandardDelivery() {
		if (WebElementOperationsWeb.isDisplayed(driver, VerifyDeliveryCheck.getStandardDelivery())) {
		} else {
			throw new ShoppersStopBusinessException(
					"Delivery Details label [" + VerifyDeliveryCheck.getStandardDelivery() + "] is not displayed");
		}
	}

	// Verifying Express Delivery
	public void VerifyExpressDelivery() {
		if (WebElementOperationsWeb.isDisplayed(driver, VerifyDeliveryCheck.getExpressDelivery())) {
		} else {
			throw new ShoppersStopBusinessException(
					"Delivery Details label [" + VerifyDeliveryCheck.getExpressDelivery() + "] is not displayed");
		}
	}

	// Verifying PayandPickup
	public void VerifyPayandPickup() {
		if (WebElementOperationsWeb.isDisplayed(driver, VerifyDeliveryCheck.getPayandPickUp())) {
		} else {
			throw new ShoppersStopBusinessException(
					"Delivery Details label [" + VerifyDeliveryCheck.getPayandPickUp() + "] is not displayed");
		}
	}
	public void ClickonStandardDeliveryRadioButton() {
		try {
			WebElementOperationsWeb.click(driver, VerifyDeliveryCheck.getStandardDeliveryRadioBtn());

		} catch (Exception e) {
			LOG.error("StandardDelivery Radio Button is not clickable");
			}
	}
	public void ClickonExpressDeliveryRadioButton() {
		try {
			WebElementOperationsWeb.click(driver, VerifyDeliveryCheck.getExpressDeliveryRadioBtn());

		} catch (Exception e) {
			LOG.error("ExpressDelivery Radio Button is not clickable");
		}
	}
	public void ClickonPickupRadioButton() {
		try {
			WebElementOperationsWeb.click(driver, VerifyDeliveryCheck.getPickupRadioBtn());

		} catch (Exception e) {
			LOG.error("Pickup Radio Button is not clickable");
		}
	}
}
