package org.tyss.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is used for importing the data from property file i.e, which is used to maintain common data
 * @author Richard William
 *
 */


public final class CommonDataUtility {
	
	private Properties properties;
	
	/**
	 * This method is used to load the external file and to convert into to java readbale file
	 * @param filePath
	 */
	
	public void loadPropertyFile(String filePath) {
		
		try {
			FileInputStream fis=new FileInputStream(filePath);
			
			properties=new Properties();
			properties.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

/**
 * This method is used to get the data stored in property file
 * @param key
 * @return
 */


	public String getPropertyData(String key) {
		return properties.getProperty(key).trim();
		
	}
	
}
