package com.sslweb.automation.test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IExecutionListener;
import org.testng.annotations.Listeners;



import com.sslweb.automation.ApplicationContext;
import com.sslweb.automation.consts.ShoppersStopConstantsWeb;
import com.sslweb.automation.driver.WebDriverProducer;
import com.sslweb.automation.dto.mail.MailParam;
import com.sslweb.automation.dto.testretry.RetryBook;
//import com.sslweb.automation.elementsfactoryweb.model.ElementsFactoryWeb;
//import com.sslweb.automation.elementsfactoryweb.model.ElementsFactoryWeb;
import com.sslweb.automation.listeners.DefaultRecorder;
import com.sslweb.automation.listeners.PDFReport;
import com.sslweb.automation.listeners.Recorder;
import com.sslweb.automation.login.actions.WebLoginActions;
//import com.sslweb.automation.login.actions.ProfileWidgetLoginWebActions;
//import com.sslweb.automation.login.actions.WebLoginActions;
import com.sslweb.automation.mail.DefaultMailService;
//import com.sslweb.automation.profilewidgeelementsfactoryweb.model.ProfileWidgeElementsFactoryWeb;
//import com.sslweb.automation.profilewidgeelementsfactoryweb.model.ProfileWidgeElementsFactoryWeb;
import com.sslweb.automation.provider.credential.ResourceProvider;
import com.sslweb.automation.registry.Registry;
import com.sslweb.automation.registry.RegistryKey;
import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.repo.impl.DefaultExcelRepository;
import com.sslweb.automation.test.handler.GlobalExceptionHandler;
import com.sslweb.automation.userloginfunctionalitycheck.model.SSBLoginFunctionality;
import com.sslweb.automation.util.CommonUtils;
import com.sslweb.automation.util.PathProvider;
import com.sslweb.automation.util.PropertyUtil;
import com.sslweb.automation.util.exceptions.ShoppersStopBusinessException;

@Listeners( value = {PDFReport.class, Recorder.class})
public class ApplicationContextInitializer extends GlobalExceptionHandler implements IExecutionListener {

	private static final Logger LOG = Logger.getLogger(ApplicationContextInitializer.class);
	public static final WebDriver DRIVER;
	protected static final String DEFAULT_WORKBOOK_NAME;
	protected static final ExcelRepository REPOSITORY;
	protected static final WebLoginActions LOGIN_ACTIONS;
	//protected static final ProfileWidgetLoginWebActions PROFILE_WIDGET_LOGIN_ACTIONS;
	public static final String APPLICATION_NAME;
	private static final String TIMESTAMP;
	public static final ApplicationContext CONTEXT;
	public static final Path DOWNLOADS;
	public static final Path CURRENTFOLDER;
	protected static final String DBURL;
	public static final String DBDRIVER;
	public static final String DB_USERNAME;
	public static final String DB_PASSWORD;

	
	static{
		TIMESTAMP = CommonUtils.getCurExeDirTimestamp();
		CONTEXT = ApplicationContext.getContext();
		CommonUtils.initCurrentExeDirsInspection(TIMESTAMP);
		APPLICATION_NAME = CommonUtils.getApplicationName();
		//CommonUtils.execCMD(CommonUtils.getConfiguredWebDriverKillCommand());
		DEFAULT_WORKBOOK_NAME = PathProvider.getDefaultConfiguredWorkbookName();
		DRIVER = WebDriverProducer.getWebDriver(CommonUtils.getConfiguredDriverBrowser());
		REPOSITORY = ResourceProvider.instance().getRepository();
		DOWNLOADS = PathProvider.getForDownloads();
		CURRENTFOLDER=PathProvider.getForCurrentFolder();
		//WebDriverManager.chromedriver().setup();
		//DRIVER = new ChromeDriver();
		//new ElementsFactoryWeb().init(DRIVER);
		LOGIN_ACTIONS = WebLoginActions.instance(DRIVER);
		//new ProfileWidgeElementsFactoryWeb().init(DRIVER);
		//PROFILE_WIDGET_LOGIN_ACTIONS = ProfileWidgetLoginWebActions.instance(DRIVER);
		DBURL=PathProvider.getSslDbURL();
		DBDRIVER=PathProvider.getSslDbDriver();
		DB_USERNAME=PathProvider.getSslDbUserName();
		DB_PASSWORD=PathProvider.getSslDbPassword();
	}
	
	
	public void init(){
		Registry.setAttribute(RegistryKey.SUITE_START_TIME, new Date());
		Registry.setAttribute(RegistryKey.DEFAULT_CONFIGURED_BROWSER, CommonUtils.getConfiguredDriverBrowser());
		Registry.setAttribute(RegistryKey.MAIL_PARAM, new MailParam());
		Registry.setAttribute(RegistryKey.CURRENT_EXE_SNAP_ROOT_PATH, PathProvider.getCurExecScreenshotRootDir(TIMESTAMP));
		Registry.setAttribute(RegistryKey.PDF_REPORT_FILE_PATH, PathProvider.getGenPDFReportFilePath(TIMESTAMP));
		Registry.setAttribute(ShoppersStopConstantsWeb.RETRY_BOOK, new RetryBook());
		deleteCookies();
	}
	
	private void deleteCookies(){
		if(PropertyUtil.getBoolean("delete.domain-cookies.before.tests-start", true)){
			try{
				getSslPage();
				DRIVER.manage().deleteAllCookies();
			}catch(Exception e){
				LOG.error("Unknown error occurred whie deleting all the cookies for the ShoppersStop base Domain.",e);
			}
		}
	}
	
	protected static void getPage(String url) {
		DRIVER.get(url);
	}
	
	protected void getSslPage() {
		try {
			DRIVER.get(PathProvider.getSslBaseURL());
		} catch (Exception e) {
			throw new ShoppersStopBusinessException("Unable To Open Application Page", e);
		}
	}
	
	protected void getSslDbUrl() {
		try {
			DRIVER.get(PathProvider.getSslDbURL());
		} catch (Exception e) {
			throw new ShoppersStopBusinessException("Unable To Open Application Page", e);
		}
	}
	protected void getSslDbDriver() {
		try {
			DRIVER.get(PathProvider.getSslDbDriver());
		} catch (Exception e) {
			throw new ShoppersStopBusinessException("Unable To Open Application Page", e);
		}
	}
	protected void getSslDbUserName() {
		try {
			DRIVER.get(PathProvider.getSslDbUserName());
		} catch (Exception e) {
			throw new ShoppersStopBusinessException("Unable To Open Application Page", e);
		}
	}
	protected void getSslDbPassword() {
		try {
			DRIVER.get(PathProvider.getSslDbPassword());
		} catch (Exception e) {
			throw new ShoppersStopBusinessException("Unable To Open Application Page", e);
		}
	}
	protected void getSslBackofficeUrl() {
		try {
			DRIVER.get(PathProvider.getSslBackofficeUrl());
		} catch (Exception e) {
			throw new ShoppersStopBusinessException("Unable To Open Application Page", e);
		}
	}
	protected void getSslDecryptUrl() {
		try {
			DRIVER.get(PathProvider.getDecryptUrl());
		} catch (Exception e) {
			throw new ShoppersStopBusinessException("Unable To Open Application Page", e);
		}
	}
	public void destroy(){
		LOG.debug("Performing post execution operation and Destroying all the initialized content.");
		Registry.setAttribute(RegistryKey.SUITE_END_TIME, new Date());
		WebDriverProducer.closeAll();
		((DefaultExcelRepository)REPOSITORY).closeBookQuitely();
		new DefaultMailService().build().transport();
		stopCapturer();
		CommonUtils.killProcesses();
		Registry.removeAll();
	}

	protected static WebDriver getDriver(){
		return DRIVER;
	}
	
	private void stopCapturer(){
		try {
			if(ShoppersStopConstantsWeb.IS_RECORDING_ENABLED) {
				DefaultRecorder.instance().stop();
			}
		} catch (IOException e) {
			LOG.error("Error occurred while closing the capturer",e);
		}
	}
	
	public static ExcelRepository getExcelRepository(){
		return REPOSITORY;
	}
	
	protected void addRetryTest(String name){
		((RetryBook)Registry.getAttribute(ShoppersStopConstantsWeb.RETRY_BOOK)).createTest(name);
	}
	
	
	@Override
	public void onExecutionStart() {
		LOG.debug("ShoppersStop execution started.... initializing all the application dependencies.");
		init();
	}

	@Override
	public void onExecutionFinish() {
		LOG.debug("ShoppersStop execution finished.... destroying all the initializations.");
		destroy();
	}

}
