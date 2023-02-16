package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.cartpagedefaultfunctionality.model.CartPageFlow;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCartPageDefaultFunctionalityHelper extends GlobalExceptionHandler {
	
	// In this class we are performing operations on the PLP page Brand Functionality 
	
			private WebDriver driver = null;
			private static final Logger LOG = Logger.getLogger(SSBCartPageDefaultFunctionalityHelper.class);
			public SSBCartPageDefaultFunctionalityHelper(WebDriver driver) {
				this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
			}
		
			// Clicking on CatogoryClick
			public void ClickonCatogoryClick() {
				try {
						WebElementOperationsWeb.mouseOver(driver, CartPageFlow.getCatogoryClick());
				} catch (Exception e) {
					handleOnException("Unknown error occured while clicking Category: "+CartPageFlow.getCatogoryClick(), e);
				}
			}
			
			// Clicking on MakeUpClick
			public void ClickonMakeUpClick() {
				try {
						WebElementOperationsWeb.mouseOver(driver,CartPageFlow.getMakeUpClick());
	
				} catch (Exception e) {
					handleOnException("Unknown error occured while clicking MakeUp: "+CartPageFlow.getMakeUpClick(), e);
					}
				}

		   // Clicking on product
			public void ClickonProductClick() {
			try {
					WebElementOperationsWeb.click(driver, CartPageFlow.getProductClick());
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking Product: "+CartPageFlow.getProductClick(), e);
			}
		}
			 // Clicking on AddToCartProduct 
			public void ClickonAddToCartProduct() {
			try {
					WebElementOperationsWeb.click(driver, CartPageFlow.getAddToCartProduct());
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking AddToCartProduct: "+CartPageFlow.getAddToCartProduct(), e);
			}
		}
			 // Clicking on AddToCart
			public void ClickonAddToCartClick() {
			try {
					WebElementOperationsWeb.click(driver, CartPageFlow.getAddToCartClick());
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking AddToCartClick: "+CartPageFlow.getAddToCartClick(), e);
			}
		}				
			// Clicking on ApplyCouponIcon
			public void ClickonApplyCouponIcon() {
				try {
					WebElementOperationsWeb.click(driver, CartPageFlow.getApplyCouponIcon());
				} catch (Exception e) {
				handleOnException("Unknown error occured while clicking ApplyCouponIcon: "+CartPageFlow.getApplyCouponIcon(), e);
			}
		}
			// Clicking on ApplyCouponClick
		    public void ClickonApplyCouponClick() {
				try {
					WebElementOperationsWeb.click(driver, CartPageFlow.getApplyCouponClick());
				} catch (Exception e) {
				handleOnException("Unknown error occured while clicking ApplyCouponClick: "+CartPageFlow.getApplyCouponClick(), e);
			}
		}
		 // Clicking on RemoveCoupon
		    public void ClickonRemoveCoupon() {
				try {
					WebElementOperationsWeb.click(driver, CartPageFlow.getRemoveCoupon());
				} catch (Exception e) {
				handleOnException("Unknown error occured while clicking RemoveCoupon: "+CartPageFlow.getRemoveCoupon(), e);
			}
		}

		 // Clicking on ChangeClick
		    public void ClickonChangeClick() {
				try {
					WebElementOperationsWeb.click(driver, CartPageFlow.getChangeClick());
				} catch (Exception e) {
				handleOnException("Unknown error occured while clicking ChangeClick: "+CartPageFlow.getChangeClick(), e);
			}
		}

}
