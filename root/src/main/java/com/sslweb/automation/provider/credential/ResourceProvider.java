package com.sslweb.automation.provider.credential;

import org.apache.log4j.Logger;

import com.sslweb.automation.repo.ExcelRepository;
import com.sslweb.automation.repo.impl.DefaultExcelRepository;
import com.sslweb.automation.util.PathProvider;

/**
 * 
 * @author sairam.p
 *
 */
public class ResourceProvider {

	private static ResourceProvider resourceProvider = null;
	
	private ExcelRepository repository;
	
	private static final Logger LOG = Logger.getLogger(ResourceProvider.class);
	
	private ResourceProvider() { 
		repository = new DefaultExcelRepository(PathProvider.getTestDataFilePath().toString(), false);
	}
	

	public static ResourceProvider instance(){
		if(resourceProvider == null){
			LOG.info("Initializing ResourceProvider..!");
			resourceProvider = new ResourceProvider();
		}
		return resourceProvider;
	}

	public ExcelRepository getRepository() {
		return repository;
	}
	
}
