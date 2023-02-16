package com.sslweb.automation.test;



import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.sslweb.automation.util.Sheet;

/**
 * 
 * @author sairam.p
 *
 */
public abstract class AbstractTest extends ApplicationContextInitializer implements AbstractPerformer {
	
	private static final Logger LOG = Logger.getLogger(AbstractTest.class);

	public static final String REGISTRATION_SHEET = Sheet.Registration.class.getSimpleName();
	public static final String PLP_SHEET = Sheet.PlpPage.class.getSimpleName();
	public static final String PDP_SHEET = Sheet.PdpPage.class.getSimpleName();
	public static final String PERSONALSHOPPERS_SHEET = Sheet.PersonalShoppers.class.getSimpleName();
	public static final String FOOTER_SHEET = Sheet.Footer.class.getSimpleName();
	public static final String HOMEPAGE_SHEET = Sheet.HomePage.class.getSimpleName();
	public static final String MY_ACCOUNT_PAGE = Sheet.MyAccount.class.getSimpleName();
	public static final String MY_PROFILE = Sheet.MyProfile.class.getSimpleName();
	public static final String CARTPAGE_SHEET = Sheet.CartPage.class.getSimpleName();
	public static final String CHECKOUT_PAGE = Sheet.CheckOutPage.class.getSimpleName();
	
	@Override
	public void init(){
		LOG.debug("TestNG Suite execution started....!");
	}
	
	@Override
	public void destroy(){
		LOG.debug("TestNG Suite execution finished....!");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		this.init();
	}
	
	@AfterSuite
	public void afterSuite() {
		this.destroy();
	}
}