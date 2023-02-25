package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.ssbpdpverifydetails.model.VerifyDetailsPDP;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.userbackofficeloginfunctionalitycheck.model.SSBBackofficeLoginFunctionality;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPDPVerifyDetailsHelper extends GlobalExceptionHandler {

	private WebDriver driver = null;
	private static final Logger LOG = Logger.getLogger(SSBPDPVerifyDetailsHelper.class);

	public SSBPDPVerifyDetailsHelper(WebDriver driver) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
	}
	// Navigation to PDP page from Home Page

	public void sendDecryptText(String decryptValue) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBBackofficeLoginFunctionality.getEnterTextInDecrypt())) {
				WebElementOperationsWeb.sendKeys(SSBBackofficeLoginFunctionality.getEnterTextInDecrypt(), decryptValue);
			} else {
				LOG.error("Please enter a valid decryptValue");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while sending decryptValue "
					+ SSBBackofficeLoginFunctionality.getEnterTextInDecrypt(), e);
			}
		}
	public void clickOnDecryptbutton() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBBackofficeLoginFunctionality.getClickOnDecryptButton())) {
				WebElementOperationsWeb.click(driver, SSBBackofficeLoginFunctionality.getClickOnDecryptButton());
			} else {
				LOG.error("Error in clicking Decrypt button ");
			}
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Decrypt button  "
					+ SSBBackofficeLoginFunctionality.getClickOnDecryptButton(), e);
			}
		}
	// Search Box
	public void sendProductID(String testCaseName, String ID) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, VerifyDetailsPDP.getSearchBarPLP())) {
				WebElementOperationsWeb.enterKeysWithEnter(driver, VerifyDetailsPDP.getSearchBarPLP(), ID);

			} else {
				throw new ShoppersStopBusinessException("Unable to find FullName field in the Checkout Page ["
						+ VerifyDetailsPDP.getSearchBarPLP() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "ProductDetails");
			handleOnException("Error occured while sending FirstName [" + VerifyDetailsPDP.getSearchBarPLP() + "]", e);
		}
	}

	// Clicking on Product card to navigate to PDP
	public void ClickonProductCard() {
		try {
			WebElementOperationsWeb.jsClick(driver, VerifyDetailsPDP.getProductCardClick());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking Product Card: " + VerifyDetailsPDP.getProductCardClick(), e);
		}
	}

	// PDP Page

	// Clicking on Product Image
	public void ClickonProductImage() {
		try {
			WebElementOperationsWeb.click(driver, VerifyDetailsPDP.getProductImageClick());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking Product Image: " + VerifyDetailsPDP.getProductImageClick(),
					e);
		}
	}

	// Clicking on Close Button
	public void ClickonCloseButton() {
		try {
			WebElementOperationsWeb.click(driver, VerifyDetailsPDP.getCloseButton());

		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking CloseButton: " + VerifyDetailsPDP.getCloseButton(),
					e);
		}
	}

	// Product Details Check in PDP

	// Verifying Product Details
	public void VerifyProductDetails() {
		if (!WebElementOperationsWeb.isDisplayed(driver, VerifyDetailsPDP.getProductDetailsCheck())) {
			throw new ShoppersStopBusinessException(
					"Product Details label [" + VerifyDetailsPDP.getProductDetailsCheck() + "] is not displayed");
		}
	}

	public void VerifyProductName() {
		if (!WebElementOperationsWeb.isDisplayed(driver, VerifyDetailsPDP.getProductName())) {
			throw new ShoppersStopBusinessException(
					"Product Name label [" + VerifyDetailsPDP.getProductName() + "] is not displayed");
		}
	}
	
	public void VerifyProductRatings() {
		if (!WebElementOperationsWeb.isDisplayed(driver, VerifyDetailsPDP.getRatings())) {
			throw new ShoppersStopBusinessException(
					"Product Ratings [" + VerifyDetailsPDP.getRatings() + "] is not displayed");
		}
	}
	// Verifying Product Price
	public void VerifyProductPrice() {
		if (!WebElementOperationsWeb.isDisplayed(driver, VerifyDetailsPDP.getProductPriceCheck())) {
			throw new ShoppersStopBusinessException(
					"Product Price label [" + VerifyDetailsPDP.getProductPriceCheck() + "] is not displayed");
		}
	}
	public void VerifyAddToCart() {
		if (!WebElementOperationsWeb.isDisplayed(driver, VerifyDetailsPDP.getAddToCartButton())) {
			throw new ShoppersStopBusinessException(
					"AddToCartButton [" + VerifyDetailsPDP.getAddToCartButton() + "] is not displayed");
		}
	}
	public void VerifyBuyNow() {
		if (!WebElementOperationsWeb.isDisplayed(driver, VerifyDetailsPDP.getBuyNowButton())) {
			throw new ShoppersStopBusinessException(
					"BuyNow Button [" + VerifyDetailsPDP.getBuyNowButton() + "] is not displayed");
		}
	}
	// Verify Easy Returns click

	public void EasyReturnsClick() {
		try {
			WebElementOperationsWeb.click(driver, VerifyDetailsPDP.getEasyReturnsClick());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Easy Returns button: "
					+ VerifyDetailsPDP.getEasyReturnsClick(), e);
		}
	}
	// Verify Authentic product click

	public void AuthenticProductClick() {
		try {
			WebElementOperationsWeb.click(driver, VerifyDetailsPDP.getAuthenticProductClick());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Authentic Product Click: "
					+ VerifyDetailsPDP.getAuthenticProductClick(), e);
		}
	}

	// Exit from Easy returns and Authentication pop up 
	public void CloseOkayButton() {
		try {
			WebElementOperationsWeb.click(driver, VerifyDetailsPDP.getClickingButtonEasyR());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on Okay Button: " + VerifyDetailsPDP.getClickingButtonEasyR(),
					e);
		}
	}

	public void HowtouseClick() {
		try {
			WebElementOperationsWeb.click(driver, VerifyDetailsPDP.getHowtoUseClick());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on Okay Button: " + VerifyDetailsPDP.getHowtoUseClick(), e);
		}
	}
	// WishList Icon
	public void WishListIcon() {
		try {
			WebElementOperationsWeb.click(driver, VerifyDetailsPDP.getWishListIcon());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on Wishlist Button: " + VerifyDetailsPDP.getWishListIcon(), e);
		}
	}

}
