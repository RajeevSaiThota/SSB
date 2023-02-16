package com.sslweb.automation.login.actions;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.userloginfunctionalitycheck.model.SSBLoginFunctionality;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.util.exceptions.LoginActionException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class WebLoginActions extends GlobalExceptionHandler {

	private static final Logger LOG = Logger.getLogger(WebLoginActions.class);

	private static final String LOGIN_ACTION = "LoginAction";
	private static final String LOGOUT_SUCCESS = "Logout-Successful";
	private static final String LOGOUT_FAIL = "Logout-Failed";
	private WebDriver driver = null;
	private static WebLoginActions loginActions = null;

	private WebLoginActions(WebDriver driver) {
		this.driver = driver;
	}

	public static WebLoginActions instance(WebDriver driver) {
		if (Objects.isNull(loginActions)) {
			loginActions = new WebLoginActions(
					Objects.requireNonNull(driver, "Webdriver cannot not be null to instantiate LoginActions class"));
		}
		return loginActions;
	}
	/*
	 * public void doLogin(String user, String password) { try{ performLogin(user,
	 * password); WebElementOperationsWeb.waitForPageLoad(driver, 50);
	 * WebElementOperationsWeb.captureScreenShotOnPass(driver, LOGIN_ACTION,
	 * LOGIN_SUCCESS); }catch(Exception e){
	 * WebElementOperationsWeb.captureScreenShotOnFail(driver, LOGIN_ACTION,
	 * LOGIN_FAIL); handleOnException("Unknown error occurred while logging-in.",
	 * e); } }
	 * 
	 * private void performLogin(String user, String password) { expandAccount();
	 * clickSigninLink(); sendUsername(Objects.requireNonNull(user,
	 * "Username cannot be null to perform login operation."));
	 * sendPasscode(Objects.requireNonNull(password,
	 * "Password cannot be null to perform login operation.")); doSubmit(); }
	 */

	public void doLogout() {
		try {
			WebElementOperationsWeb.park(10);
			expandAccount();
			WebElementOperationsWeb.park(5);
			clickLogout();
			WebElementOperationsWeb.captureScreenShotOnPass(driver, LOGIN_ACTION, LOGOUT_SUCCESS);

		} catch (Exception e) {
			WebElementOperationsWeb.captureScreenShotOnFail(driver, LOGIN_ACTION, LOGOUT_FAIL);
			handleOnException("Unknown error occurred while logging out.", e);
		}
	}

	private void expandAccount() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBLoginFunctionality.getUserName())) {
				WebElementOperationsWeb.mouseOver(driver, SSBLoginFunctionality.getUserName());
			} else {
				throw new LoginActionException("Unable to perform logout operation due to Account section WebElement:"
						+ SSBLoginFunctionality.getUserName() + " visibility issue");
			}
		} catch (Exception e) {

			throw new LoginActionException(
					"Error occurred while clicking on Account Section to perform logout operation on WebElement:"
							+ SSBLoginFunctionality.getUserName() + e.getMessage());
		}
	}

	private void clickLogout() {
		try {
			if (WebElementOperationsWeb.isDisplayed(driver, SSBLoginFunctionality.getLogOut())) {
				WebElementOperationsWeb.click(SSBLoginFunctionality.getLogOut());
			} else {
				throw new LoginActionException("Unable to click on logout button[WebElement:"
						+ SSBLoginFunctionality.getLogOut() + "] due to visibility issue");
			}
		} catch (Exception e) {
			throw new LoginActionException("Error occurred while performing logout operation on WebElement:"
					+ SSBLoginFunctionality.getLogOut() + e.getMessage());
		}
	}
}
