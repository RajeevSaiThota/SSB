package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sslweb.automation.plpclearallfunctionality.model.FilterCLearAllFunctionality;
import com.sslweb.automation.plpverifydetailsfunctionality.model.VerifyDetailsFunctionality;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPLPClearAllFunctionalityHelper extends GlobalExceptionHandler{
	
	// In this class we are performing operations on the PLP page Clear All Functionality 
	
		private WebDriver driver = null;
		private static final Logger LOG = Logger.getLogger(SSBLoginFunctionalityHelper.class);
		public SSBPLPClearAllFunctionalityHelper(WebDriver driver) {
			this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
		}
		
		// Clicking on the a filter category(Product Highlight)
		public void PLPFilterGender() {
			try {
				WebElementOperationsWeb.click(driver, FilterCLearAllFunctionality.getProductCard());
				WebElementOperationsWeb.windowHandle(driver);
				if(WebElementOperationsWeb.isDisplayed(driver, FilterCLearAllFunctionality.getGenderFilter())) {
					WebElementOperationsWeb.click(driver, FilterCLearAllFunctionality.getGenderFilter());
				}else
					{
					LOG.error("Filter Element not Found");
				}
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking Gender Filter: "+FilterCLearAllFunctionality.getGenderFilter(), e);
			}
		}
		
		// Selecting Products in Gender filter

		public void PLPselectingCategoryGender1() {
			try {
				WebElementOperationsWeb.click(driver, FilterCLearAllFunctionality.getGenderWomanClick());				
				} catch (Exception e) {
				handleOnException("Unknown error occured while clicking subcategory: "+FilterCLearAllFunctionality.getGenderWomanClick(), e);
			}
		}
		
		
		// Performing Clear All operation 

		public void PLPFilterClearAll() {
			try {
					WebElementOperationsWeb.click(driver, FilterCLearAllFunctionality.getClearAll());
				}
			 catch (Exception e) {
				handleOnException("Unknown error occured while clicking Clear All: "+FilterCLearAllFunctionality.getClearAll(), e);
			}
		}
		
		public void verifyFiltersEnabled() {
			
			try {
				WebElement filter = FilterCLearAllFunctionality.getGenderWomanClick();
				filter.isEnabled();
				
			} catch (Exception e) {
				handleOnException("Unknown error occured while verifying filter enabled functionality: "+FilterCLearAllFunctionality.getGenderWomanClick(), e);
			}
		}
		

}
