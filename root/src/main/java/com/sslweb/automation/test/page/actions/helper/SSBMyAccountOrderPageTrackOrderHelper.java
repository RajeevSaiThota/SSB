package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.myaccountorderpagehistorytrackorder.model.OrderPageTrackOrder;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.repo.ExcelRepository;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountOrderPageTrackOrderHelper extends GlobalExceptionHandler {

	private WebDriver driver = null;

	public SSBMyAccountOrderPageTrackOrderHelper(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
	}

	// Mouse Hovering towards user profile
	public void MouseHoverUserProfile() {
		try {
			WebElementOperationsWeb.mouseOver(driver, OrderPageTrackOrder.getUserProfile());
		} catch (Exception e) {
			handleOnException("Unknown error occured while mouse overing to user profile: "
					+ OrderPageTrackOrder.getUserProfile(), e);
		}
	}

	// Clicking on My orders in user profile
	public void ClickonMyOrders() {
		try {
			WebElementOperationsWeb.click(driver, OrderPageTrackOrder.getMyOrdersClick());

		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking MyOrders: " + OrderPageTrackOrder.getMyOrdersClick(), e);
		}
	}

	// Clicking on Product Card
	public void ClickonProductCard() {
		try {
			WebElementOperationsWeb.click(driver, OrderPageTrackOrder.getProductCardClick());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on product card : "
					+ OrderPageTrackOrder.getProductCardClick(), e);
		}
	}
	String breadcrumb=null;
	public String MyAccountBreadCrumb() {
		try {
			breadcrumb=WebElementOperationsWeb.getText(driver, OrderPageTrackOrder.getMyAccountBreadCrumb());
		
		}
		 catch (Exception e) {
				handleOnException("Unknown error occured while getting breadCrumb text : "
						+ OrderPageTrackOrder.getMyAccountBreadCrumb(), e);
			}
		return breadcrumb;
	}
	// clicking on Track Order

	public void ClickonTrackOrder() {
		try {
			WebElementOperationsWeb.click(driver, OrderPageTrackOrder.getTrackOrderClick());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on Track Order: " + OrderPageTrackOrder.getTrackOrderClick(),
					e);
		}
	}

	// clicking on Close Icon

	public void ClickonCloseIcon() {
		try {
			WebElementOperationsWeb.click(driver, OrderPageTrackOrder.getCloseIcon());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on close icon: " + OrderPageTrackOrder.getCloseIcon(), e);
		}
	}

}
