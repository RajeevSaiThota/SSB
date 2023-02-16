package com.sslweb.automation.test.page.actions;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBPLPBasicFilterFunctionalityHelper;
import com.sslweb.automation.test.page.actions.helper.SSBPLPSelectingPriceFilterHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;
public class SSBPLPBasicFilterFunctionalityAction extends GlobalExceptionHandler {
	
	private static final Logger LOG = Logger.getLogger(SSBPLPSelectingPriceFilterHelper.class);
	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBPLPBasicFilterFunctionalityHelper ssbplpbasicfilterhelper;
	//private  SSBPLPClearAllFunctionality ssbLoginFunctionalityValidator;
	
	public SSBPLPBasicFilterFunctionalityAction(WebDriver driver){
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbplpbasicfilterhelper = new SSBPLPBasicFilterFunctionalityHelper(driver);
		js = (JavascriptExecutor) driver;
		//ssbclearallfilterFunctionalityHelper = new SSBPLPClearAllFunctionalityHelper(driver);
	}
	
	public void clickonViewMoretoExpand(String testCaseName){
		try {
			WebElementOperationsWeb.waitForPageLoad(driver, 60);
			js.executeScript("window.scrollBy(0,200)"," ");
			WebElementOperationsWeb.park(10);
			ssbplpbasicfilterhelper.ClickonViewmore();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	public void ClickonBasicfunctionality(String testCaseName){
		try {
			
			//driver.manage().timeouts().implicitlyWait(0, null)
			js.executeScript("window.scrollBy(0,200)"," ");
			//ssbplpbasicfilterhelper.ClickonBestSeller(testCaseName);;
			WebElementOperationsWeb.park(5);
			ssbplpbasicfilterhelper.ClickonFeatured(testCaseName);
			//WebElementOperationsWeb.park(7);
			//ssbplpbasicfilterhelper.ClickonED(testCaseName);
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	
	
	public void Clearall(String testCaseName){
		try {
			WebElementOperationsWeb.park(5);
			js.executeScript("window.scrollBy(0,-800)"," ");
			ssbplpbasicfilterhelper.PLPFilterClearAll();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "AllFieldsDisplayed");	
		} catch (Exception e) {
			handleOnException("All Fields Displayed not able found", e);
		}
	}
	

}
