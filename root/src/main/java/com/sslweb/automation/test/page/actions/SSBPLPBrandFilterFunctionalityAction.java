package com.sslweb.automation.test.page.actions;

import java.util.Objects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.test.page.actions.helper.SSBPLPSelectingBrandFilterHelper;
//import com.sslweb.automation.test.page.actions.helper.SSBPLPSelectingSizeFilterHelper;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBPLPBrandFilterFunctionalityAction extends GlobalExceptionHandler {
	
	private WebDriver driver = null;
	public JavascriptExecutor js;

	private SSBPLPSelectingBrandFilterHelper ssbplpBrandfilterhelper;
	
	public SSBPLPBrandFilterFunctionalityAction(WebDriver driver){
		this.driver = Objects.requireNonNull(driver, "WebDriver cannot be null to perform actions in AllFieldsDisplayedActions class");
		ssbplpBrandfilterhelper = new SSBPLPSelectingBrandFilterHelper(driver);
		js = (JavascriptExecutor) driver;
	}
	
	public void ClickonBrandSubcategoryFilter(String testCaseName){
		try {
			
			WebElementOperationsWeb.park(5);
			js.executeScript("window.scrollBy(0,500)"," ");
			WebElementOperationsWeb.park(5);
			ssbplpBrandfilterhelper.ClickonBrandFilter();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "Sizefilter");	
		} catch (Exception e) {
			handleOnException("Size filter is not displayed", e);
		}
	}
	
	
	public void ClickonBrandfiltersubcategories(String testCaseName){
		try {
			WebElementOperationsWeb.park(5);
			ssbplpBrandfilterhelper.ClickonBrandFilterSub1();
			WebElementOperationsWeb.park(5);
			// Bug found must try after fixing it 
			ssbplpBrandfilterhelper.ClickonBrandFilterSub2();
			WebElementOperationsWeb.park(5);
			ssbplpBrandfilterhelper.ClickonBrandFilterSub3();
			WebElementOperationsWeb.park(5);
			WebElementOperationsWeb.captureScreenShotOnPass(driver, testCaseName, "BrandSubcategories");	
		} catch (Exception e) {
			handleOnException("Sub Categories in Brand filter are not Displayed", e);
		}
	}
}
