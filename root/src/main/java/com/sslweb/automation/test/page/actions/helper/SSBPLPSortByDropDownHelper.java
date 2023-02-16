package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;


import org.openqa.selenium.WebDriver;

import com.sslweb.automation.plpsortbydropdown.model.SortbyDropDownFunctionality;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPLPSortByDropDownHelper extends GlobalExceptionHandler {
	
	// In this class we are performing operations on the PLP page sort by drop down
	
			private WebDriver driver = null;
		
			public SSBPLPSortByDropDownHelper(WebDriver driver) {
				this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
			}
		
			// Clicking on the a Sort By drop down 
			public void ClickonSortby() {
				try {
						WebElementOperationsWeb.click(driver, SortbyDropDownFunctionality.getDropDownClick());
	
				} catch (Exception e) {
					handleOnException("Unknown error occured while clicking on Sortby: "+SortbyDropDownFunctionality.getDropDownClick(), e);
					}
				}

		   // Clicking on the WebElement in the drop down
			public void ClickonCategory1() {
			try {
					WebElementOperationsWeb.click(driver, SortbyDropDownFunctionality.getDropDownCategory1());
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking on sort by category: "+SortbyDropDownFunctionality.getDropDownCategory1(), e);
			}
		}
						
			// Clicking on the WebElement in the drop down
			public void ClickonCategory2() {
			try {
				WebElementOperationsWeb.click(driver, SortbyDropDownFunctionality.getDropDownCategory2());
			} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on sort by category: "+SortbyDropDownFunctionality.getDropDownCategory2(), e);
			}
		}

}
