package Productstest;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;
import objectRepository.ProductPage;

@Listeners(genericUtilities.ListenerImplementation.class)
public class AddProductToCartTest extends BaseClass {

	@Test
	public void tc_001_AddProductToCartTest() throws IOException
	{
		
	//since we are extending the baseclass object creation of excel and common data file is not required
	//Create Object of all required utilities
//			ExcelFileUtility eutil=new ExcelFileUtility();
//			PropertyFileUtility putil=new PropertyFileUtility();
//			SeleniumUtility sutil=new SeleniumUtility();
//			
//			//read common data from property file  
//			String URL= putil.readDataFromProperyFile("url");
//			String USERNAME=putil.readDataFromProperyFile("username");
//			String PASSWORD=putil.readDataFromProperyFile("password");
//			
			//Read Test Data from Excel File
			String PRODUCTNAME =eutil.readDataFromExcel("Products", 1, 2);
			
				//step:1 launch of window
//				WebDriver driver=new FirefoxDriver();
//				sutil.maximizeWindow(driver);
//				sutil.minimizeWindow(driver);
//				
//				//step:2 load of url
  //      			driver.get(URL);
//				
//				//step:3 Login of Application				
//				LoginPage lp =new LoginPage(driver);
//				lp.loginToApp(USERNAME, PASSWORD);
		
				//step:4 navigate to inventory page and click on  product 
				InventoryPage ip=new InventoryPage(driver);
				String productToBeAddedToCart = ip.clickOnProductAndCaptureTitle(driver, PRODUCTNAME);	
				
				
				//step:5 navigate to product page and click on add to product 
				ProductPage pr=new ProductPage(driver);
				pr.clickoncartbtn();
			
			//step:6 navigate to product
			pr.clickcartContainerlnk();
			
			//exception example
		//	Assert.fail();

			
			//step:7 validate the product in cart
			CartPage cp= new CartPage(driver);
			String actproductCartInfo = cp.captureProductInfo();
			
	//for validation we are using soft assert			
//			if(actproductCartInfo.equals(productToBeAddedToCart)) 
//			{
//				System.out.println("PASS");
//				System.out.println(actproductCartInfo);
//			}
//				else
//				{
//					System.out.println("FAIL");
//					
//				}
			
			AssertJUnit.assertEquals(actproductCartInfo,productToBeAddedToCart);
			System.out.println(actproductCartInfo + "--> Product Added");
	
			
			//step :8 logout of application
//			ip.logoutApp();
//			System.out.println("Logout Successful");

		}

}
