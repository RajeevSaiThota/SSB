package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.myaccountprofilepageaddingaddress.model.ProfilePageAddingAddress;
import com.sslweb.automation.myaccountprofilepagedeletingaddress.model.ProfilePageDeletingAddress;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.repo.ExcelRepository;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountProfilePageDeleteAddressHelper extends GlobalExceptionHandler {

	private WebDriver driver = null;

	public SSBMyAccountProfilePageDeleteAddressHelper(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
	}

	// Mouse Hovering towards user profile
	public void MouseHoverUserProfile() {
		try {
			WebElementOperationsWeb.mouseOver(driver, ProfilePageDeletingAddress.getUserProfile());
		} catch (Exception e) {
			handleOnException("Unknown error occured while mouse overing to user profile: "
					+ ProfilePageDeletingAddress.getUserProfile(), e);
		}
	}

	// Clicking on My Profile in user profile
	public void ClickonMyProfile() {
		try {
			WebElementOperationsWeb.click(driver, ProfilePageDeletingAddress.getMyProfileClick());

		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking MyProfile: " + ProfilePageDeletingAddress.getMyProfileClick(),
					e);
		}
	}
	public void DeleteAddress() {
		try {
			WebElementOperationsWeb.isDisplayed(driver, ProfilePageDeletingAddress.getDeleteAddress());
		} catch (Exception e) {
			handleOnException("Address are not available for this user : "
					+ ProfilePageDeletingAddress.getDeleteAddress(), e);
		}
	}
	// Clicking on Delete Address
	public void ClickonDeleteAddress() {
		try {
			WebElementOperationsWeb.click(driver, ProfilePageDeletingAddress.getDeleteAddress());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Delete Address : "
					+ ProfilePageDeletingAddress.getDeleteAddress(), e);
		}
	}

	// clicking on confirmation

	public void ClickonYes() {
		try {
			WebElementOperationsWeb.click(driver, ProfilePageDeletingAddress.getClickingYes());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Yes button: "
					+ ProfilePageDeletingAddress.getClickingYes(), e);
		}
	}

	String AddressDeleteSuccessAlert=null;
	public String DeleteAddressSuccessAlert() {
		try {
			AddressDeleteSuccessAlert=WebElementOperationsWeb.getText(driver, ProfilePageDeletingAddress.getDeleteAddressSuccessAlert());
		}catch (Exception e) {
			handleOnException("Unknown error occured while verifying success alert: "
					+ ProfilePageDeletingAddress.getDeleteAddressSuccessAlert(), e);
		}
		return AddressDeleteSuccessAlert;
	}
}
