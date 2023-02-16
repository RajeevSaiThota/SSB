package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.plpcategoryfilterfunctionality.model.categoryFilterFunctionality;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPLPSelectingCategoryFilterHelper extends GlobalExceptionHandler {
	
	// In this class we are performing operations on the PLP page Brand Functionality 
	
			private WebDriver driver = null;
			public SSBPLPSelectingCategoryFilterHelper(WebDriver driver) {
				this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
			}
		
			// Clicking on the filter category
			public void ClickonCategoryFilter() {
				try {
						WebElementOperationsWeb.click(driver, categoryFilterFunctionality.getCategorySelection());
	
				} catch (Exception e) {
					handleOnException("Unknown error occured while clicking Category: "+categoryFilterFunctionality.getCategorySelection(), e);
					}
				}

		   // Clicking on the Category filter sub category 1
			public void ClickonCategoryFilterSub1() {
			try {
					WebElementOperationsWeb.click(driver, categoryFilterFunctionality.getCategorySelection1());
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking Makeup : "+categoryFilterFunctionality.getCategorySelection1(), e);
			}
		}
}
