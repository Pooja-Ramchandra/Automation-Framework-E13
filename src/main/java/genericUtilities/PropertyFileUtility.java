package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This file consists of generic methods related to property file
 * @author dell
 */
public class PropertyFileUtility {
	/**
	 * This method will read data from property file and return value to caller 
	 * @param key
	 * @return value
	 * @throws IOException 
	 */

	public String readDataFromProperyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("E:\\AdvanceSelenium\\AutomationFramework\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
		
	}

}
