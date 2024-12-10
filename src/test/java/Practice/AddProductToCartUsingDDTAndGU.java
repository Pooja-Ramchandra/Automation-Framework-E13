package Practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import genericUtilities.SeleniumWaits;


public class AddProductToCartUsingDDTAndGU extends BaseClass {
	

	public static void main(String[] args) throws Exception {
		//Create Object of all required utilities
		ExcelFileUtility eutil=new ExcelFileUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		SeleniumUtility sutil=new SeleniumUtility();
		SeleniumWaits swait=new SeleniumWaits();
//		
//		//read common data from property file  
		String URL= putil.readDataFromProperyFile("url");
		String USERNAME=putil.readDataFromProperyFile("username");
		String PASSWORD=putil.readDataFromProperyFile("password");
		
		//Read Test Data from Excel File
		String PRODUCTNAME =eutil.readDataFromExcel("Products", 1, 2);
		
			//step:1 launch of window
			WebDriver driver=new FirefoxDriver();
			sutil.maximizeWindow(driver);
			swait.implicitWait(driver);
	
			//step:2 load of url
		driver.get(URL);
			
			//step:3 Login of Application
			driver.findElement(By.id("user-name")).sendKeys(USERNAME);
			driver.findElement(By.id("password")).sendKeys(PASSWORD);
			driver.findElement(By.id("login-button")).click();
			
			//step:4 add product to cart
			String productToBeAdded = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).getText();
			driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
	
			//step:5 click on cart icon
           driver.findElement(By.id("add-to-cart")).click();	
		
		//step:6 navigate to cart
           driver.findElement(By.id("shopping_cart_container")).click();
		
		//step:7 validate the product in cart	
           String actProductInCart=driver.findElement(By.className("inventory_item_name")).getText();
		
           if(actProductInCart.equals(productToBeAdded)) 
		{
			System.out.println("PASS");
			System.out.println(actProductInCart);
		}
			else
			{
				System.out.println("FAIL");
				
			}
		
		//step :8 logout of application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		
		 //step:9 close the browser
	   driver.close();
		}
	

	}


