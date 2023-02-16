package com.sslweb.automation.test.page.elements.validator;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.userloginfunctionalitycheck.model.SSBLoginFunctionality;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SsbLoginFunctionalityValidate extends GlobalExceptionHandler {
	// This class is to check if webelements are present on the page, if yes we can perform further actions.
	private WebDriver driver = null;
	private static final String IS_NOT_DISPLAYED = "] is not displayed";

	public SsbLoginFunctionalityValidate(WebDriver driver) {
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in SignOutWidgetValidator class");
	}
	
	 //TODO
	 //Change the locators for the elements 
	
	
	private void SSB_Login(){
		if(!WebElementOperationsWeb.isDisplayed(driver, SSBLoginFunctionality.getSignIn())) {
			throw new ShoppersStopBusinessException("Sign in [" +SSBLoginFunctionality.getSignIn()+ IS_NOT_DISPLAYED);
		} }
	/*	
	private void SSB_Logout(){
		if(!WebElementOperationsWeb.isDisplayed(driver, LoginFunctionality.getUserAccount())) {
			throw new ShoppersStopBusinessException("Logout [" +LoginFunctionality.getUserAccount()+ IS_NOT_DISPLAYED);
			} }	
	
	private void SSB_Forgot_Password(){
		if(!WebElementOperationsWeb.isDisplayed(driver, LoginFunctionality.getUserAccount())) {
			throw new ShoppersStopBusinessException("Forgot your Password [" +LoginFunctionality.getUserAccount()+ IS_NOT_DISPLAYED);
			} }	
	
	private void SS_Forgot_Password_Verify_Fields(){
		if(!WebElementOperationsWeb.isDisplayed(driver, LoginFunctionality.getUserAccount())) {
			throw new ShoppersStopBusinessException("Sign Up [" +LoginFunctionality.getUserAccount()+ IS_NOT_DISPLAYED);
			} }*/
		
	}

