package com.sslweb.automation.test.page.actions.helper;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sslweb.automation.myaccountbeautyprofilepage.model.MyAccountBeautyProfile;
import com.sslweb.automation.plpclearallfunctionality.model.FilterCLearAllFunctionality;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.repo.ExcelRepository;
import com.techouts.sslweb.webelement.ops.WebElementOperationsWeb;

public class SSBMyAccountBeautyProfilePageHelper extends GlobalExceptionHandler {

	private WebDriver driver = null;
	private static final Logger LOG = Logger.getLogger(SSBLoginFunctionalityHelper.class);
	public SSBMyAccountBeautyProfilePageHelper(WebDriver driver, ExcelRepository repository) {
		this.driver = Objects.requireNonNull(driver,
				"WebDriver cannot be null to perform actions in ProfileIconWidge Actions Helper class");
	}

	// Mouse Hovering towards user profile
	public void MouseHoverUserProfile() {
		try {
			WebElementOperationsWeb.mouseOver(driver, MyAccountBeautyProfile.getUserProfile());
		} catch (Exception e) {
			handleOnException("Unknown error occured while mouse overing to user profile: "
					+ MyAccountBeautyProfile.getUserProfile(), e);
		}
	}

	// Clicking on My orders in user profile
	public void ClickonBeautyProfile() {
		try {
			WebElementOperationsWeb.click(driver, MyAccountBeautyProfile.getBeautyProfileClick());

		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking BeautyProfile: " + MyAccountBeautyProfile.getBeautyProfileClick(), e);
		}
	}
	
	//Clicking on Re-Do Profile
	
	public void ClickonReDoProfile() {
		try {
			
				WebElementOperationsWeb.click(driver, MyAccountBeautyProfile.getReDoProfileClick());
			
			
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking Gender Filter: "+FilterCLearAllFunctionality.getGenderFilter(), e);
		}
	}

	// Clicking on GetStarted Bar
	public void ClickonGetStarted() {
		try {
			WebElementOperationsWeb.click(driver, MyAccountBeautyProfile.getClickOnGetStarted());
		} catch (Exception e) {
			handleOnException("Unknown error occured while clicking on GetStarted : "
					+ MyAccountBeautyProfile.getClickOnGetStarted(), e);
		}
	}

	// clicking on a Dry Catogery

	public void ClickonDRYCatogery() {
		try {
			WebElementOperationsWeb.click(driver, MyAccountBeautyProfile.getClickonDRYCatogery());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on DRYCatogery selection : " + MyAccountBeautyProfile.getClickonDRYCatogery(),
					e);
		}
	}
	
	//clicking on my skin tone
	
	public void ClickonMYSKINTONE() {
		try {
			WebElementOperationsWeb.click(driver, MyAccountBeautyProfile.getClickonMYSKINTONE());
		} catch (Exception e) {
			handleOnException(
					"Unknown error occured while clicking on myskintone selection : " + MyAccountBeautyProfile.getClickonMYSKINTONE(),
					e);
		}
	}
	
	//clicking on fair catogery
	
		public void ClickonFAIRCatogery() {
			try {
				WebElementOperationsWeb.click(driver, MyAccountBeautyProfile.getClickonFAIRCatogery());
			} catch (Exception e) {
				handleOnException(
						"Unknown error occured while clicking on faircatogery selection : " + MyAccountBeautyProfile.getClickonFAIRCatogery(),
						e);
			}
		}
		
		//clicking on make up personality
		
			public void ClickonMAKEUPPERSONALITY() {
				try {
					WebElementOperationsWeb.click(driver, MyAccountBeautyProfile.getClickonMAKEUPPERSONALITY());
				} catch (Exception e) {
					handleOnException(
							"Unknown error occured while clicking on makeuppersonality selection : " + MyAccountBeautyProfile.getClickonMAKEUPPERSONALITY(),
							e);
				}
			}
			
			//clicking on POPPRINCESCatogery
			
			public void ClickonPOPPRINCESCatogery() {
				try {
					WebElementOperationsWeb.click(driver, MyAccountBeautyProfile.getClickonPOPPRINCESCatogery());
				} catch (Exception e) {
					handleOnException(
							"Unknown error occured while clicking on POPPRINCESCatogery selection : " + MyAccountBeautyProfile.getClickonPOPPRINCESCatogery(),
							e);
				}
			}
			
			//clicking on ClickonHAIRTYPE
			
			public void ClickonClickonHAIRTYPE() {
				try {
					WebElementOperationsWeb.click(driver, MyAccountBeautyProfile.getClickonHAIRTYPE());
				} catch (Exception e) {
					handleOnException(
							"Unknown error occured while clicking on ClickonHAIRTYPE selection : " + MyAccountBeautyProfile.getClickonHAIRTYPE(),
							e);
				}
			}	
			
			//clicking on STRAIGHTCatogery
			
			public void ClickonSTRAIGHTCatogery() {
				try {
					WebElementOperationsWeb.click(driver, MyAccountBeautyProfile.getClickonSTRAIGHTCatogery());
				} catch (Exception e) {
					handleOnException(
							"Unknown error occured while clicking on STRAIGHTCatogery selection : " + MyAccountBeautyProfile.getClickonSTRAIGHTCatogery(),
							e);
				}
			}	
			
			//clicking on FRAGRANCES
			
			public void ClickonFRAGRANCES() {
				try {
					WebElementOperationsWeb.click(driver, MyAccountBeautyProfile.getClickonFRAGRANCES());
				} catch (Exception e) {
					handleOnException(
							"Unknown error occured while clicking on FRAGRANCES selection : " + MyAccountBeautyProfile.getClickonFRAGRANCES(),
							e);
				}
			}
			
			//clicking on FLORALCatogery
			
			public void ClickonFLORALCatogery() {
				try {
					WebElementOperationsWeb.click(driver, MyAccountBeautyProfile.getClickonFLORALCatogery());
				} catch (Exception e) {
					handleOnException(
							"Unknown error occured while clicking on FLORALCatogery selection : " + MyAccountBeautyProfile.getClickonFLORALCatogery(),
							e);
				}
			}	
			
			//clicking on DONE
			
			public void ClickonDONE() {
				try {
					WebElementOperationsWeb.click(driver, MyAccountBeautyProfile.getClickonDONE());
				} catch (Exception e) {
					handleOnException(
							"Unknown error occured while clicking on DONE selection : " + MyAccountBeautyProfile.getClickonDONE(),
							e);
				}
			}	
			
			//clicking on CHECKTHEMOUT
			
			public void ClickonCHECKTHEMOUT() {
				try {
					WebElementOperationsWeb.click(driver, MyAccountBeautyProfile.getClickonCHECKTHEMOUT());
				} catch (Exception e) {
					handleOnException(
							"Unknown error occured while clicking on DONE selection : " + MyAccountBeautyProfile.getClickonCHECKTHEMOUT(),
							e);
				}
			}	

}
