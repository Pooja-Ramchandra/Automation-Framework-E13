package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author dell
 */
public class SeleniumWaits {
	/**
	 * This method will add implicit wait for 10seconds
	 * @param driver
	 */

	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitforElementToBeVisible(WebDriver driver ,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will add explicit wait for 10seconds
	 * @param driver
	 * @throws InterruptedException
	 */
	public void explicitwait(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(100);
	}
	/**
	 * This method to handle the dropdown by using index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) 
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method to handle the dropdown by using value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value)
	{
		Select s= new Select(element);
		s.selectByValue(value);
		
	}
	/**
	 *This method to handle the dropdown by using visibletext
	 * @param visibleText
	 * @param element
	 */
	public void handleDropDown(String visibleText, WebElement element)
	{
		Select s= new Select(element);
		s.selectByVisibleText(visibleText);
	}
	/**
	 * This method to handle the dropdown by using index
	 * @param element
	 * @param index
	 */
	public void handledeselectDropDown(WebElement element, int index)
	{
		Select s= new Select(element);
		s.deselectByIndex(index);
		
	}
	/**
	 * This method to handle the dropdown by using value
	 * @param element
	 * @param value
	 */
	public void handledeslectDropDown(WebElement element,  String value)
	{
		Select s= new Select(element);
		s.deselectByValue(value);
	}
	/**
	 *This method to handle the dropdown by using visibletext
	 * @param driver
	 * @param element
	 */
	public void handledeslectDropDown(String visibleText,WebElement element)
	{
		Select s= new Select(element);
		s.deselectByValue(visibleText);
	}
	/**
	 * This method to handle action class by moving the element into the target element 
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver,WebElement element) 
	{
		Actions act=new Actions(driver);
		act.moveToElement(element);
		
	}
	/**
	 * This method to handle action class by right click the element 
	 * @param driver
	 * @param element
	 */
	
	public void rightClickAction(WebDriver driver,WebElement element) 
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
		
	}
	/**
	 * This method to handle action class by drag and dropping the element
	 * @param driver
	 * @param element
	 */
	public void dragdropAction(WebDriver driver,WebElement element) 
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(element, element).perform();
		
	}
	/**
	 * This method to handle action class by click and hold of the target element
	 * @param driver
	 * @param element
	 */

	public void clickholdAction(WebDriver driver,WebElement element) 
	{
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
		
	}
	/**
	 * This method to handle action class double click method
	 * @param driver
	 * @param element
	 */
	public void doubleclickAction(WebDriver driver,WebElement element) 
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
		
	}
	/**
	 * This method will handle the scroll down action
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element) 
	{
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
		}
	
	/**
	 * This method will accept the alert popup 
	 * @param driver
	 * @param element
	 */
	public void acceptAlert(WebDriver driver, WebElement element)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will dismiss the alert popup 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will capture the alert text and return it to caller
	 * @param driver
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will handle the frame by frameindex
	 * @param driver
	 * @param frameIndex
	 */
	public void handleframe(WebDriver driver,int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
/**
 *  This method will handle the frame by frameId or name
 * @param driver
 * @param frameIDOrName
 */
	public void handleframe(WebDriver driver,String frameIDOrName)
	{
		driver.switchTo().frame(frameIDOrName);
	}
	
	
	/**
	 *  This method will handle the frame by frame element
	 * @param driver
	 * @param frameElement
	 */
	public void handleframe(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	/**
	 * This method will handle frame to return to default content
	 * @param driver
	 */
	public void handleframe(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * 
	 * @param element
	 * @param driver
	 */
	public void handleframe(WebElement element,WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * 
	 * @param driver
	 * @param WindowID
	 */
	public void handleWindow(WebDriver driver , String WindowID)
	{
		driver.switchTo().window(WindowID);
	}
	/**
	 * This method will capture the screenshot
	 * @param driver
	 * @param screenshotName
	 * @throws IOException 
	 */
	public String captureScreenshot(WebDriver driver, String screenshotName) throws IOException
    {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("E:\\AdvanceSelenium\\AutomationFramework\\Screenshots"+screenshotName+".png");
        FileHandler.copy(src, dst);   
        
        return dst.getAbsolutePath();//Attach to Extends Reports
    
    }
}

