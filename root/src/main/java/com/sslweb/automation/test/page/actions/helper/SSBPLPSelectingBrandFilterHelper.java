package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.plpbrandfilterfunctionality.model.BrandFilterFunctionality;
//import com.sslweb.automation.plpsizefilterfunctionality.model.SizeFilterFunctionality;
//import com.sslweb.automation.plpsizefilterfunctionality.model.SizeFilterFunctionality;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPLPSelectingBrandFilterHelper extends GlobalExceptionHandler {
	
	// In this class we are performing operations on the PLP page brand Functionality 
	
			private WebDriver driver = null;
			public SSBPLPSelectingBrandFilterHelper(WebDriver driver) {
				this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
			}
		
			
			// Clicking on the a Size filter category
			public void ClickonBrandFilter() {
				try {
						WebElementOperationsWeb.click(driver, BrandFilterFunctionality.getBrandCategorySelection());
	
				} catch (Exception e) {
					handleOnException("Unknown error occured while clicking brand filter: "+BrandFilterFunctionality.getBrandCategorySelection(), e);
					}
				}

		   // Clicking on the Size filter sub category 1
			public void ClickonBrandFilterSub1() {
			try {
					WebElementOperationsWeb.click(driver, BrandFilterFunctionality.getBrandSelection1());
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking on subcategory in brand filter mini: "+BrandFilterFunctionality.getBrandSelection1(), e);
			}
		}
						
			// Clicking on the Size filter sub category 2
			public void ClickonBrandFilterSub2() {
				try {
					WebElementOperationsWeb.click(driver, BrandFilterFunctionality.getBrandSelection2());
				} catch (Exception e) {
				handleOnException("Unknown error occured while clicking on subcategory in brand filter Value set: "+BrandFilterFunctionality.getBrandSelection2(), e);
			}
		}
			// Clicking on the Size filter sub category 3
			public void ClickonBrandFilterSub3() {
				try {
				WebElementOperationsWeb.click(driver, BrandFilterFunctionality.getBrandSelection3());
				} catch (Exception e) {
					handleOnException("Unknown error occured while clicking on subcategory in brand filter Full size: "+BrandFilterFunctionality.getBrandSelection3(), e);
			}
		}


}
