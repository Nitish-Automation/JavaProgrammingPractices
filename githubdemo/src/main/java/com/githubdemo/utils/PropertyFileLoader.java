package com.githubdemo.utils;

import java.io.IOException;
import java.util.Properties;

import com.githubdemo.operations.Repository;

/*
 * Class to load correct property file based on repository name
 * 'Class' is used to get it from resources
 */

public class PropertyFileLoader {

	public Properties getPoperties(String repositoty, Class<?> cls) throws IOException {
		
		Properties prop = new Properties();
		Repository constants = new Repository();
		
		String propertyfile;
		
		// Check repo prefix to find repo owner and initialize related property file
		if (repositoty.startsWith(constants.NETFILX_REPO_PREFIX)) {
			propertyfile = constants.NETFILX_PROP;
			prop.load(cls.getResourceAsStream(propertyfile));
		}
		
		else if (repositoty.startsWith(constants.GOOGLE_REPO_PREFIX)) {
			propertyfile = constants.GOOGLE_PROP;
			prop.load(cls.getResourceAsStream(propertyfile));
		}
		
		return prop;
	}
	

}
