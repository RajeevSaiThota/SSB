package com.sslweb.automation.util;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.sslweb.automation.consts.ShoppersStopConstantsWeb;
import com.sslweb.automation.enums.Browser;
import com.sslweb.automation.registry.Registry;
import com.sslweb.automation.registry.RegistryKey;

/**
 * 
 * @author sairam.p
 *
 */
public final class PathProvider {
	
	private static final Path USER_DIR = Paths.get(System.getProperty("user.dir"));
	private static final String RES_FROM_WORKSPACE = "src/main/resources";

	private static final String CHROME = "chromedriver.exe";
	private static final String FIREFOX = "geckodriver.exe";
	private static final String IE = "IEDriverServer.exe";
	private static final String TESTDATA_DIR_NAME = "testData";
	private static final String LOGS_DIR_NAME = "logs";
	private static final String GEN_DIR_NAME = "gen";
	private static final String REC_DIR_NAME = "recording";
	private static final String MISC_DIR_NAME = "misc";
	private static final String REPORTS_DIR_NAME = "reports";
	private static final String SCREENSHOTS_DIR_NAME = "screenshots";
	private static final String DRIVERS_DIR_NAME = "drivers";
	private static final String DOWNLOADS_NAME = "downloads";
	private static final String DOWNLOADS_FOLDER = "currentFolder";
	
	private static final Logger LOG = Logger.getLogger(PathProvider.class.getName());
	
	private PathProvider() {}
	
	public static Path getForDriver(Browser browser){
		if(Objects.nonNull(browser)) {
			switch (browser) {
			case IE:
				return Paths.get(getForDrivers().toString(),IE);
			case FIREFOX:
				return Paths.get(getForDrivers().toString(),FIREFOX);
			default:
				return Paths.get(getForDrivers().toString(),CHROME);
			}
		}
		return null;
	}
	

	public static Path getForDrivers() {
		return Paths.get(getForResources().toString(), DRIVERS_DIR_NAME);
	}
	
	public static Path getForDownloads() {
		return Paths.get(getForResources().toString(), DOWNLOADS_NAME);
	}
	public static Path getForCurrentFolder() {
		return Paths.get(getForResources().toString(), DOWNLOADS_FOLDER);
	}
	
	public static Path getForResources() {
		return Paths.get(USER_DIR.toString(), RES_FROM_WORKSPACE); // src/main/resources
	}

	public static Path getUserDir() {
		return USER_DIR;
	}
	
	public static Path getForTestData() {
		return Paths.get(getForResources().toString(), TESTDATA_DIR_NAME);
	}
	
	public static Path getForLogs() {
		return Paths.get(getForResources().toString(), LOGS_DIR_NAME);
	}
	
	public static Path getForGenDir() {
		return Paths.get(getForResources().toString(), GEN_DIR_NAME);
	}
	
	public static Path getForRecordingDir() {
		return Paths.get(getForGenDir().toString(), REC_DIR_NAME);
	}
	
	public static Path getForMiscDir() {
		return Paths.get(getForGenDir().toString(), MISC_DIR_NAME);
	}
	
	public static Path getForReportsDir() {
		return Paths.get(getForGenDir().toString(), REPORTS_DIR_NAME);
	}
	
	public static Path getForScreenshotsDir() {
		return Paths.get(getForGenDir().toString(), SCREENSHOTS_DIR_NAME);
	}
	
	public static Path getCurExecScreenshotRootDir(String timestamp) {
		Path path = null;
		if(StringUtils.isNotBlank(timestamp)){
			path = (Path)Registry.getAttribute(RegistryKey.CURRENT_EXE_SNAP_ROOT_PATH);
			if(Objects.isNull(path)){
				path = CommonUtils.genScreenshotDirsForCurrentExe(timestamp);
				Registry.setAttribute(RegistryKey.CURRENT_EXE_SNAP_ROOT_PATH, path);
			}
		}else{
			LOG.error("Program current execution timestamp cannot be empty, it leads to wrong filename generations for the session.");
		}
		return path;
	}
	
	public static Path getTestDataFilePath() {
		return Paths.get(getForTestData().toString(), PropertyUtil.getString(ShoppersStopConstantsWeb.TEST_DATA_WORKBOOK_NAME));
	}
	
	public static String getSslBaseURL() {
		return PropertyUtil.getString(ShoppersStopConstantsWeb.SSL_BASE_URL);
	}
	public static String getUatURL() {
		return PropertyUtil.getString(ShoppersStopConstantsWeb.SSL_UAT_URL);
	}
	
	public static String getDefaultIndividualTestsSheet() {
		return PropertyUtil.getString(ShoppersStopConstantsWeb.REGISTRATION_SHEET);
		}

	public static String getDefaultConfiguredWorkbookName() {
		return PropertyUtil.getString(ShoppersStopConstantsWeb.TEST_DATA_DEFAULT_WORKBOOK_NAME);
	}
	public static String getSslDbURL() {
		return PropertyUtil.getString(ShoppersStopConstantsWeb.SSL_DB_URL);
	}
	public static String getSslDbDriver() {
		return PropertyUtil.getString(ShoppersStopConstantsWeb.SSL_DB_DRIVER);
	}
	public static String getSslDbUserName() {
		return PropertyUtil.getString(ShoppersStopConstantsWeb.SSL_DB_USERNAME);
	}
	public static String getSslDbPassword() {
		return PropertyUtil.getString(ShoppersStopConstantsWeb.SSL_DB_PASSWORD);
	}
	public static String getSslBackofficeUrl() {
		return PropertyUtil.getString(ShoppersStopConstantsWeb.SSL_BACKOFFICE_url);
	}
	public static String getDecryptUrl() {
		return PropertyUtil.getString(ShoppersStopConstantsWeb.DECRYPT_url);
	}
	public static Path getGenPDFReportFilePath(String timestamp) {
		String reportName = null;
		if(StringUtils.isNotBlank(timestamp)) {
			reportName = PropertyUtil.getString(ShoppersStopConstantsWeb.SSL_TEST_REPORT_NAME,ShoppersStopConstantsWeb.DEFAULT_SSL_TEST_REPORT_NAME) + ("-"+ timestamp + ShoppersStopConstantsWeb.DOT_PDF);
		}else {
			LOG.error("Program current execution timestamp cannot be empty, it leads to wrong filename generations for the session.");
		}
		return Paths.get(getForReportsDir().toString(), reportName);
	}
	
	public static String getCSVTestReportFileName(){
		return PropertyUtil.getString(ShoppersStopConstantsWeb.CSV_TEST_REPORT_NAME,"TestReport");
	}
	
	public static String getEncryptionSecretKey() {
		return PropertyUtil.getString(ShoppersStopConstantsWeb.ENCRYPTION_SECRET_KEY);
	}
	
}