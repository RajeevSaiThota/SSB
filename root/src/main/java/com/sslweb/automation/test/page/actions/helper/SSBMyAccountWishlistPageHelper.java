package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.myaccountwishlistpage.model.MyAccountWishlist;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.repo.ExcelRepository;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountWishlistPageHelper extends GlobalExceptionHandler {

	private WebDriver driver = null;

	public SSBMyAccountWishlistPageHelper(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
	}

	// Mouse Hovering towards user profile
	public void MouseHoverUserProfile() {
		try {
			WebElementOperationsWeb.mouseOver(driver, MyAccountWishlist.getUserProfile());
		} catch (Exception e) {
			handleOnException("Unknown error occured while mouse overing to user profile: "
					+ MyAccountWishlist.getUserProfile(), e);
		}
	}

	// Clicking on Wishlist in user profile
	public void ClickonWishlist() {
		try {
			WebElementOperationsWeb.click(driver, MyAccountWishlist.getWishlistClick());

		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking Wishlist: " + MyAccountWishlist.getWishlistClick(), e);
		}
	}

	// Clicking on UncheckWishlist Bar
	public void ClickonUncheckWishlistBar() {
		try {
			WebElementOperationsWeb.click(driver, MyAccountWishlist.getUncheckWishlistClick());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on UncheckWishlist : "
					+ MyAccountWishlist.getUncheckWishlistClick(), e);
		}
	}


public void ClickonYESBar() {
	try {
		WebElementOperationsWeb.click(driver, MyAccountWishlist.getClickonYES());
	} catch (Exception e) {
		handleOnException("Unknown error occured while clicking on YES : "
				+ MyAccountWishlist.getUncheckWishlistClick(), e);
	}
}

public boolean emptyWishlist() {
	try {
		WebElementOperationsWeb.isDisplayed(driver, MyAccountWishlist.getEmptyWishlist());
		return true;

	} catch (Exception e) {
		System.out.println("Products available in wishlist");
	}
	return true;
}



}

