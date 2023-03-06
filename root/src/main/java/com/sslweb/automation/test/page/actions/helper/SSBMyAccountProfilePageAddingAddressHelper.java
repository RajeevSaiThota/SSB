package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.myaccountprofilepageaddingaddress.model.ProfilePageAddingAddress;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.util.Sheet;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountProfilePageAddingAddressHelper extends GlobalExceptionHandler {

	private WebDriver driver = null;
	private ExcelRepository repository;

	public SSBMyAccountProfilePageAddingAddressHelper(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
		this.repository = Objects.requireNonNull(repository,
				"Repository cannot be null to perform publicVerifyDebitCardScenarioHelper class");
	}

	// Mouse Hovering towards user profile
	public void MouseHoverUserProfile() {
		try {
			WebElementOperationsWeb.mouseOver(driver, ProfilePageAddingAddress.getUserProfile());
		} catch (Exception e) {
			handleOnException("Unknown error occured while mouse overing to user profile: "
					+ ProfilePageAddingAddress.getUserProfile(), e);
		}
	}

	// Clicking on My profile in user profile
	public void ClickonMyProfile() {
		try {
			WebElementOperationsWeb.click(driver, ProfilePageAddingAddress.getMyProfileClick());

		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking MyProfile: " + ProfilePageAddingAddress.getMyProfileClick(),
					e);
		}
	}

	// Clicking on Add New Address
	public void ClickonAddAddress() {
		try {
			WebElementOperationsWeb.click(driver, ProfilePageAddingAddress.getAddingAddress());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Add new Address : "
					+ ProfilePageAddingAddress.getAddingAddress(), e);
		}
	}

	// Address flow

	// Adding the address with Fullname, Mobile, Pincode, City, State, Address
	// Full Name
	public void sendFullName(String sheetname, int serialNo, String testCaseName) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, ProfilePageAddingAddress.getName())) {
				WebElementOperationsWeb.sendKeys(driver, ProfilePageAddingAddress.getName(),
						repository.readStringFrom(sheetname, Sheet.Registration.FULL_NAME, serialNo));
				WebElementOperationsWeb.park(3);
			} else {
				throw new ShoppersStopBusinessException("Unable to find FullName field in the Checkout Page ["
						+ ProfilePageAddingAddress.getName() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "FirstName");
			handleOnException("Error occured while sending FirstName [" + ProfilePageAddingAddress.getName() + "]", e);
		}
	}

	// Mobile Number
	public void sendMobileNumber(String sheetname, int serialNo, String testCaseName) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, ProfilePageAddingAddress.getMobileNumber())) {
				WebElementOperationsWeb.sendKeys(driver, ProfilePageAddingAddress.getMobileNumber(),
						repository.readStringFrom(sheetname, Sheet.Registration.MOBILE_NUMBER, serialNo));
				WebElementOperationsWeb.park(3);
			} else {
				throw new ShoppersStopBusinessException("Unable to find the MobileNumber field in the Checkout Page ["
						+ ProfilePageAddingAddress.getMobileNumber() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "NotEnteredMobileNumber");
			handleOnException("Error occured while sending Guest User Mobile number ["
					+ ProfilePageAddingAddress.getMobileNumber() + "]", e);
		}
	}

	// Pincode
	public void sendPincode(String sheetname, int serialNo, String testCaseName) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, ProfilePageAddingAddress.getPincode())) {
				WebElementOperationsWeb.sendKeys(driver, ProfilePageAddingAddress.getPincode(),
						repository.readStringFrom(sheetname, Sheet.Registration.PINCODE, serialNo));
				WebElementOperationsWeb.park(3);
			} else {
				throw new ShoppersStopBusinessException("Unable to find Pincode field in the Checkout Page ["
						+ ProfilePageAddingAddress.getPincode() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "Pincode");
			handleOnException("Error occured while sending Pincode [" + ProfilePageAddingAddress.getPincode() + "]", e);
		}
	}

	// Address
	public void sendAddress(String sheetname, int serialNo, String testCaseName) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, ProfilePageAddingAddress.getAddress())) {
				WebElementOperationsWeb.sendKeys(driver, ProfilePageAddingAddress.getAddress(),
						repository.readStringFrom(sheetname, Sheet.Registration.ADDRESS, serialNo));
				WebElementOperationsWeb.park(3);
			} else {
				throw new ShoppersStopBusinessException("Unable to find address field in the Checkout Page ["
						+ ProfilePageAddingAddress.getAddress() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "SendAddress");
			handleOnException("Error occured while sending Address [" + ProfilePageAddingAddress.getAddress() + "]", e);
		}
	}

	// Clicking on Default address
	public void ClickonAddDefaultAddress() {
		try {
			WebElementOperationsWeb.click(driver, ProfilePageAddingAddress.getCheckasDefaultAddress());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on default address: "
					+ ProfilePageAddingAddress.getCheckasDefaultAddress(), e);
		}
	}

	// Clicking on Address Type
	public void ClickonAddresstypeHome() {
		try {
			WebElementOperationsWeb.click(driver, ProfilePageAddingAddress.getHome());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Home: " + ProfilePageAddingAddress.getHome(), e);
		}
	}

	// Confirming on clicking new address
	public void ClickonAddnewaddressSelect() {
		try {
			WebElementOperationsWeb.click(driver, ProfilePageAddingAddress.getAddAddressSelect());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Add new address: "
					+ ProfilePageAddingAddress.getAddAddressSelect(), e);
		}
	}

	// Selecting the address

	public void ClickonAddressbox() {
		try {
			WebElementOperationsWeb.click(driver, ProfilePageAddingAddress.getAddAddressSelect());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Add address button: "
					+ ProfilePageAddingAddress.getAddAddressSelect(), e);
		}
	}
	
	String AddressAddedSuccessAlert=null;
	public String AddAddressSuccessAlert() {
		try {
		AddressAddedSuccessAlert=WebElementOperationsWeb.getText(driver, ProfilePageAddingAddress.getAddAddressSuccessAlert());
		}catch (Exception e) {
			handleOnException("Unknown error occured while verifying success alert: "
					+ ProfilePageAddingAddress.getAddAddressSuccessAlert(), e);
		}
		return AddressAddedSuccessAlert;
	}

}
