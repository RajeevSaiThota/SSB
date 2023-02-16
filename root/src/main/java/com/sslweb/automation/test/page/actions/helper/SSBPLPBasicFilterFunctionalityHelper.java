package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.sslweb.automation.plpclearallfunctionality.model.FilterCLearAllFunctionality;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.plpbasicfilterfunctionality.model.BasicFilterFunctionality;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPLPBasicFilterFunctionalityHelper extends GlobalExceptionHandler{
	
	// In this class we are performing operations on the PLP page Clear All Functionality 
	
		private WebDriver driver = null;
		private static final Logger LOG = Logger.getLogger(SSBLoginFunctionalityHelper.class);
		public SSBPLPBasicFilterFunctionalityHelper(WebDriver driver) {
			this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
		}
		
		public void ClickonViewmore() {
			try {
				if(WebElementOperationsWeb.isDisplayed(driver, BasicFilterFunctionality.getViewMore())) {
					WebElementOperationsWeb.click(driver, BasicFilterFunctionality.getViewMore());
				}else {
					LOG.error("Viewmore not expanding");
				}
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking on view more: "+BasicFilterFunctionality.getViewMore(), e);
			}
		}
		
		public void ClickonBestSeller(String testCaseName) {
			try {
				if (WebElementOperationsWeb.isDisplayed(driver,  BasicFilterFunctionality.getBestSeller())) {
				 WebElementOperationsWeb.click(driver, BasicFilterFunctionality.getBestSeller());
				}else {
					throw new ShoppersStopBusinessException("Error occured in displaying Best seller["+ BasicFilterFunctionality.getBestSeller() +"]");		}
			} catch (Exception e) {
				WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "scroll");
				handleOnException("Error occured in clicking on Best seller ["+ BasicFilterFunctionality.getBestSeller()+"]",e);
			}
		}
		
		public void ClickonFeatured(String testCaseName) {
			try {
				if (WebElementOperationsWeb.isDisplayed(driver,  BasicFilterFunctionality.getFeatured())) {
					 WebElementOperationsWeb.click(driver, BasicFilterFunctionality.getFeatured());
					}else {
						throw new ShoppersStopBusinessException("Error occured in displaying featured ["+ BasicFilterFunctionality.getFeatured() +"]");		}
				} catch (Exception e) {
					WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "scroll");
					handleOnException("Error occured in clicking featured["+ BasicFilterFunctionality.getFeatured()+"]",e);
				}
			}
		
		public void ClickonED(String testCaseName) {
			try {
				if (WebElementOperationsWeb.isDisplayed(driver,  BasicFilterFunctionality.getExpressDelivery())) {
					 WebElementOperationsWeb.click(driver, BasicFilterFunctionality.getExpressDelivery());
					}else {
						throw new ShoppersStopBusinessException("Error occured in displaying Estimated Delivery ["+ BasicFilterFunctionality.getExpressDelivery() +"]");		}
				} catch (Exception e) {
					WebElementOperationsWeb.captureScreenShotOnFail(driver, testCaseName, "scroll");
					handleOnException("Error occured in clicking ED ["+ BasicFilterFunctionality.getExpressDelivery()+"]",e);
				}
			}

		
		// Performing Clear All operation 

		public void PLPFilterClearAll() {
			try {
					WebElementOperationsWeb.click(driver, BasicFilterFunctionality.getClearAllClick());
				
			} catch (Exception e) {
				handleOnException("Unknown error occured while clicking on clear all: "+BasicFilterFunctionality.getClearAllClick(), e);
			}
		}
		
		

}
