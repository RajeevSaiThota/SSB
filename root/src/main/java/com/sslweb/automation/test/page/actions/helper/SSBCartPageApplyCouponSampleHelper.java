package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.cartpageverifyapplycouponsample.model.CartPageApplyCouponSampleFlow;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.userloginfunctionalitycheck.model.SSBLoginFunctionality;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBCartPageApplyCouponSampleHelper extends GlobalExceptionHandler {
	
	// In this class we are performing operations on the PLP page Brand Functionality 
	
			private WebDriver driver = null;
			private static final Logger LOG = Logger.getLogger(SSBCartPageApplyCouponSampleHelper.class);
			public SSBCartPageApplyCouponSampleHelper(WebDriver driver) {
				this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
			}
			// Click on Log in
			public void L1categorymousehover() {
				try {
					WebElementOperationsWeb.mouseOver(driver, CartPageApplyCouponSampleFlow.getCatogoryClick());
					
				} catch (Exception e) {
					handleOnException("Unknown error occured while Mousehover Block: "
							+ CartPageApplyCouponSampleFlow.getCatogoryClick(), e);
				}
			}
			
			/*//Clicking on Category 
			public void ClickOnCategoryClick() {
				try {
						WebElementOperationsWeb.click(driver, CartPageApplyCouponSampleFlow.getCategoryClick());
				} catch (Exception e) {
					handleOnException("Unknown error occured while clicking Product: "+CartPageApplyCouponSampleFlow.getCategoryClick(), e);
				}
			}*/
			
			// Click on Log in
			public void L2Catogorymousehover() {
				try {
					
				WebElementOperationsWeb.mouseOver(driver, CartPageApplyCouponSampleFlow.getMakeUpClick());
							
				} catch (Exception e) {
					handleOnException("Unknown error occured while Mousehover Block: "
							+ CartPageApplyCouponSampleFlow.getMakeUpClick(), e);
				}
			}
			
			/*//Clicking on MakeUp 
			public void ClickOnMakeupClick() {
				try {
						WebElementOperationsWeb.click(driver, CartPageApplyCouponSampleFlow.getMakeupClick());
				} catch (Exception e) {
					handleOnException("Unknown error occured while clicking Product: "+CartPageApplyCouponSampleFlow.getMakeupClick(), e);
				}
			}*/
			
			//Clicking on product 
			public void ClickOnProductClick() {
				try {
						WebElementOperationsWeb.click(driver, CartPageApplyCouponSampleFlow.getProductClick());
				} catch (Exception e) {
					handleOnException("Unknown error occured while clicking Product: "+CartPageApplyCouponSampleFlow.getProductClick(), e);
				}
			}
			
			// Clicking on product AddToCart 
			public void ClickonAddToCartProduct() {
				try {
						WebElementOperationsWeb.click(driver,CartPageApplyCouponSampleFlow.getAddToCartProduct());
	
				} catch (Exception e) {
					handleOnException("Unknown error occured while Adding Product to Cart: "+CartPageApplyCouponSampleFlow.getAddToCartProduct(), e);
					}
				}

		   // Clicking on Addtocart
			public void ClickonAddToCartClick() {
			try {
					WebElementOperationsWeb.click(driver, CartPageApplyCouponSampleFlow.getAddToCartClick() );
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking AddToCart: "+CartPageApplyCouponSampleFlow.getAddToCartClick(), e);
			}
		}
			 // Clicking on ApplyCouponIcon
			public void ClickonApplyCouponIcon1() {
			try {
					WebElementOperationsWeb.click(driver, CartPageApplyCouponSampleFlow.getApplyCouponIcon1());
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking ApplycouponIcon: "+CartPageApplyCouponSampleFlow.getApplyCouponIcon1(), e);
			}
		}
			// Clicking on ApplyCoupon  
			public void ClickonApplyCouponClick1() {
			try {
					WebElementOperationsWeb.click(driver, CartPageApplyCouponSampleFlow.getApplyCouponClick1());
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking ApplyCoupon: "+CartPageApplyCouponSampleFlow.getApplyCouponClick1(), e);
			}
		}
			// Clicking on RemoveCoupon  
			public void ClickonRemoveCoupon1() {
			try {
					WebElementOperationsWeb.click(driver, CartPageApplyCouponSampleFlow.getRemoveCoupon1());
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking coupon: "+CartPageApplyCouponSampleFlow.getRemoveCoupon1(), e);
			}
		}
			// Clicking on ApplyCoupon 
			public void ClickonApplyCouponIcon2() {
			try {
					WebElementOperationsWeb.click(driver, CartPageApplyCouponSampleFlow.getApplyCouponIcon2());
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking CouponIcon: "+CartPageApplyCouponSampleFlow.getApplyCouponIcon2(), e);
			}
		}
			
			// Clicking on ApplyCoupon 
			public void ClickonApplyCouponClick2() {
			try {
					 WebElementOperationsWeb.click(driver, CartPageApplyCouponSampleFlow.getApplyCouponClick2());
			} catch (Exception e) {
				 handleOnException("Unknown error occured while clicking Coupon: "+CartPageApplyCouponSampleFlow.getApplyCouponClick2(), e);
			}
		}
			// Clicking on Remove coupon
			public void ClickonRemoveCoupon2() {
			try {
					 WebElementOperationsWeb.click(driver, CartPageApplyCouponSampleFlow.getRemoveCoupon2());
			} catch (Exception e) {
				 handleOnException("Unknown error occured while clicking remove coupon: "+CartPageApplyCouponSampleFlow.getRemoveCoupon2(), e);
			}
		}
						
}
