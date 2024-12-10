package genericUtilities;

import org.openqa.selenium.WebDriver;

/**
 * 
 * @author dell
 */
public class SeleniumUtility {
	/**
	 * This method is used maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used minimize the window
	 * @param driver
	 */

	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
}
