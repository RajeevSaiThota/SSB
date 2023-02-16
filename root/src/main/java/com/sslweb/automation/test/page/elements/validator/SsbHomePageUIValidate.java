package com.sslweb.automation.test.page.elements.validator;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.userloginfunctionalitycheck.model.SSBLoginFunctionality;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SsbHomePageUIValidate extends GlobalExceptionHandler {
	
	// This class is to check if webelements are present on the page, if yes we can perform further actions.
		private WebDriver driver = null;
		private static final String IS_NOT_DISPLAYED = "] is not displayed";

		public SsbHomePageUIValidate(WebDriver driver) {
			this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in SignOutWidgetValidator class");
		}
		
		 //TODO
		 //Change the locators for the elements 
		
		
		private void SSB_Header() {
			if(!WebElementOperationsWeb.isDisplayed(driver, SSBLoginFunctionality.getSignIn())) {
				throw new ShoppersStopBusinessException("Header [" +SSBLoginFunctionality.getSignIn()+ IS_NOT_DISPLAYED);
			} }
/*
		private void SSB_Banner() {
			if(!WebElementOperationsWeb.isDisplayed(driver, LoginFunctionality.getUserAccount())) {
				throw new ShoppersStopBusinessException("Banner [" +LoginFunctionality.getUserAccount()+ IS_NOT_DISPLAYED);
			} }
	
		private void SSB_Footer() {
			if(!WebElementOperationsWeb.isDisplayed(driver, LoginFunctionality.getUserAccount())) {
				throw new ShoppersStopBusinessException("Footer [" +LoginFunctionality.getUserAccount()+ IS_NOT_DISPLAYED);
			} }	

		private void SSB_MainMenuLinks() {
			if(!WebElementOperationsWeb.isDisplayed(driver, LoginFunctionality.getUserAccount())) {
				throw new ShoppersStopBusinessException("Mainmenu Links [" +LoginFunctionality.getUserAccount()+ IS_NOT_DISPLAYED);
			} }	*/

}
