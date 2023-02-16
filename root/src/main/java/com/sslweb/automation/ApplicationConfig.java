package com.sslweb.automation;

import com.sslweb.automation.util.CommonUtils;
import com.sslweb.automation.util.PropertyUtil;

/**
 * 
 * @author sairam.p
 *
 */
public final class ApplicationConfig {

	private final boolean isRecordingEnabled;
	private final String appName;
	
	ApplicationConfig() {
		isRecordingEnabled = PropertyUtil.getBoolean("is.scripts-recording.enabled", false);
		appName = CommonUtils.getApplicationName();
	}

	public boolean isRecordingEnabled() {
		return isRecordingEnabled;
	}

	public String getAppName() {
		return appName;
	}
}