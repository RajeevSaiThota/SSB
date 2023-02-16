package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.plpbasicfilterfunctionality.model.BasicFilterFunctionality;
import com.sslweb.automation.plpclearallfunctionality.model.FilterCLearAllFunctionality;
import com.sslweb.automation.plppricefilterfunctionality.model.PriceFilterFunctionality;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPLPSelectingPriceFilterHelper extends GlobalExceptionHandler {
	
	// In this class we are performing operations on the PLP page Price Functionality 
	
			private WebDriver driver = null;
			private static final Logger LOG = Logger.getLogger(SSBPLPSelectingPriceFilterHelper.class);
			public SSBPLPSelectingPriceFilterHelper(WebDriver driver) {
				this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
			}
			
			public void ClickonViewmore() {
				try {
					WebElementOperationsWeb.click(driver, PriceFilterFunctionality.getViewMoreSelection());
					
				} catch (Exception e) {
					handleOnException("Unknown error occured while clicking on view more: "+BasicFilterFunctionality.getViewMore(), e);
				}
			}
			
			
			
			
			// Clicking on the Price filter category
			public void ClickonPriceFilter() {
				try {
					//if(WebElementOperationsWeb.isDisplayed(driver, FilterCLearAllFunctionality.getGenderFilter())) {
						WebElementOperationsWeb.click(driver, PriceFilterFunctionality.getPriceCategorySelection());
					//}
				} catch (Exception e) 
				{
					handleOnException("Unknown error occured while clicking on price filter: "+PriceFilterFunctionality.getPriceCategorySelection(), e);
				}
			}
			
			// Clicking on Clean Up 
			public void ClickonClearAll() {
				try {
					WebElementOperationsWeb.click(driver, PriceFilterFunctionality.getClearAll());
					} 
				catch (Exception e) {
					handleOnException("Unknown error occured while clicking Clear All: "+PriceFilterFunctionality.getClearAll(), e);
					}
			}
						
}
