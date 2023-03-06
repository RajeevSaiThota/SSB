package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.myaccountorderpagehistoryfilter.model.OrderPageFilter;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.repo.ExcelRepository;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountOrderPageHistoryFilterHelper extends GlobalExceptionHandler {

	private WebDriver driver = null;

	public SSBMyAccountOrderPageHistoryFilterHelper(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
	}

	// Mouse Hovering towards user profile
	public void MouseHoverUserProfile() {
		try {
			WebElementOperationsWeb.mouseOver(driver, OrderPageFilter.getUserProfile());
		} catch (Exception e) {
			handleOnException("Unknown error occured while mouse overing to user profile: "
					+ OrderPageFilter.getUserProfile(), e);
		}
	}

	// Clicking on My orders in user profile
	public void ClickonMyOrders() {
		try {
			WebElementOperationsWeb.click(driver, OrderPageFilter.getMyOrdersClick());

		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking MyOrders: " + OrderPageFilter.getMyOrdersClick(), e);
		}
	}

	// Clicking on Filter Bar
	public void ClickonFilterBar() {
		try {
			WebElementOperationsWeb.click(driver, OrderPageFilter.getFilterBarClick());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Filter Bar : "
					+ OrderPageFilter.getFilterBarClick(), e);
		}
	}
	String breadcrumb=null;
	public String MyAccountBreadCrumb() {
		try {
			breadcrumb=WebElementOperationsWeb.getText(driver, OrderPageFilter.getMyAccountBreadCrumb());
		
		}
		 catch (Exception e) {
				handleOnException("Unknown error occured while getting breadCrumb text : "
						+ OrderPageFilter.getMyAccountBreadCrumb(), e);
			}
		return breadcrumb;
	}
	// clicking on a filter

	public void ClickonFilterSelect() {
		try {
			WebElementOperationsWeb.click(driver, OrderPageFilter.getFilterSelection());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on filter selection : " + OrderPageFilter.getFilterSelection(),
					e);
		}
	}

}
