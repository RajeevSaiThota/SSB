package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.myaccountprofilepagepersonaldetails.model.PersonalDetailsEdit;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.util.Sheet;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountProfilePageEditingProfileHelper extends GlobalExceptionHandler {

	private WebDriver driver = null;
	private ExcelRepository repository;

	public SSBMyAccountProfilePageEditingProfileHelper(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
		this.repository = Objects.requireNonNull(repository,
				"Repository cannot be null to perform publicVerifyDebitCardScenarioHelper class");
	}

	// Mouse Hovering towards user profile
	public void MouseHoverUserProfile() {
		try {
			WebElementOperationsWeb.waitForElementVisible(driver, 60, PersonalDetailsEdit.getUserProfile());
			WebElementOperationsWeb.mouseOver(driver, PersonalDetailsEdit.getUserProfile());
		} catch (Exception e) {
			handleOnException("Unknown error occured while mouse overing to user profile: "
					+ PersonalDetailsEdit.getUserProfile(), e);
		}
	}

	// Clicking on My profile in user profile
	public void ClickonMyProfile() {
		try {
			WebElementOperationsWeb.click(driver, PersonalDetailsEdit.getMyProfileClick());

		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking MyProfile: " + PersonalDetailsEdit.getMyProfileClick(), e);
		}
	}

	// Clicking on Edit Profile
	public void ClickonEditPersonalDetails() {
		try {
			WebElementOperationsWeb.click(driver, PersonalDetailsEdit.getPersonalDetailsClick());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Add new Address : "
					+ PersonalDetailsEdit.getPersonalDetailsClick(), e);
		}
	}
	public void EditPersonalDetails() {
		try {
			WebElementOperationsWeb.isDisplayed(driver, PersonalDetailsEdit.getPersonalDetailsClick());
		} catch (Exception e) {
			handleOnException("Unknown error occured in displaying EditPersonalDetails button : "
					+ PersonalDetailsEdit.getPersonalDetailsClick(), e);
		}
	}
	// Clicking on X icon 
	public void ClickonXicon() {
		try {
			WebElementOperationsWeb.click(driver, PersonalDetailsEdit.getCancelName());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on X Icon : "
					+ PersonalDetailsEdit.getCancelName(), e);
		}
	}

	// Name Change
	public void sendNewName(String sheetname, String testCaseName, int serialno) {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, PersonalDetailsEdit.getNameBar())) {
				WebElementOperationsWeb.sendKeys(driver, PersonalDetailsEdit.getNameBar(),
						repository.readStringFrom(sheetname, Sheet.Registration.FULL_NAME, serialno));
				WebElementOperationsWeb.park(3);
			} else {
				throw new ShoppersStopBusinessException("Unable to find FullName field in the Checkout Page ["
						+ PersonalDetailsEdit.getNameBar() + "]");
			}
		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "FirstName");
			handleOnException("Error occured while sending FirstName [" + PersonalDetailsEdit.getNameBar() + "]", e);
		}
	}

	// Clicking on Gender
	public void ClickonGender() {
		try {
			WebElementOperationsWeb.click(driver, PersonalDetailsEdit.getGender());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on Gender: " + PersonalDetailsEdit.getGender(), e);
		}
	}

	// Confirming on Make Changes
	public void ClickonMakeChanges() {
		try {
			WebElementOperationsWeb.click(driver, PersonalDetailsEdit.getMakeChanges());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking Make Changes: " + PersonalDetailsEdit.getMakeChanges(), e);
		}
	}

}
