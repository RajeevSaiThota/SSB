package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import com.sslweb.automation.plpverifydetailsfunctionality.model.VerifyDetailsFunctionality;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPLPVerifyProductDetailsHelper extends GlobalExceptionHandler {
	
	// In this class we are performing operations on the PLP page to verify details  
	
			private WebDriver driver = null;
			public SSBPLPVerifyProductDetailsHelper(WebDriver driver) {
				this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
			}
			
			// Mousehover to the product card
			public void MouseHover() {
				try {
						WebElementOperationsWeb.mouseOver(driver, VerifyDetailsFunctionality.getMouseHoverProductCard());
				} catch (Exception e) {
					handleOnException("Unknown error occured while mouse hovering on the product card: "+VerifyDetailsFunctionality.getMouseHoverProductCard(), e);
				}
			}
			
			// Clicking on Quick View
			public void QuickView() {
				try {
					WebElementOperationsWeb.click(driver, VerifyDetailsFunctionality.getQuickViewClick());
	
				} catch (Exception e) {
					handleOnException("Unknown error occured while clicking price filter sub 1: "+VerifyDetailsFunctionality.getQuickViewClick(), e);
					}
			}

		   // Clicking on product details 
			public void VerifyProductDetails() {
				try {
					WebElementOperationsWeb.click(driver, VerifyDetailsFunctionality.getViewProductClick());
					} 
				catch (Exception e) {
					handleOnException("Unknown error occured while clicking Price filter sub 2: "+VerifyDetailsFunctionality.getViewProductClick(), e);
				}
			}
						
}
