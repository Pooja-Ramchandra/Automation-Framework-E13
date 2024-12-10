package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;


/**
 * This classes consists of basic configuration annotations of testNG
 */
public class BaseClass 
{
	public static WebDriver sdriver;
	public ExcelFileUtility eutil=new ExcelFileUtility();
	public PropertyFileUtility putil=new PropertyFileUtility();
	public SeleniumUtility sutil= new SeleniumUtility();
	public SeleniumWaits swait= new SeleniumWaits();
	
	public WebDriver driver;
	
	@BeforeSuite(/*groups= {"Smoke" , "RegressionSuite"}*/)
	public void bsConfig()
	{
		System.out.println("====== Database Connection Successfull =====");
	}

//	@Parameters("browser")
//	@BeforeTest
	@BeforeClass(alwaysRun= true)
	public void bcConfig(/*String PARAMETERVALUE*/) throws IOException
	{
		//this part is used for compatibility testing
//		if(PARAMETERVALUE.equalsIgnoreCase("Firefox"))
//		{
//		driver=new FirefoxDriver();
//		}
//		else if(PARAMETERVALUE.equalsIgnoreCase("Chrome"))
//		{
//			 driver=new ChromeDriver(); 
//		}
//		else
//		{
//			driver=new ChromeDriver();
//		}
		
		
//	
		String URL = putil.readDataFromProperyFile("url");
		driver= new FirefoxDriver();
		sutil.maximizeWindow(driver);
		swait.implicitWait(driver);
		
		 driver.get(URL);
		System.out.println("=========== Browser launch successful =======");
	}
	
	@BeforeMethod
	public void bmConfig() throws IOException
	{
		String USERNAME = putil.readDataFromProperyFile("username");
		String PASSWORD = putil.readDataFromProperyFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("===== Login to App successful ======");
	}
	
	@AfterMethod(alwaysRun= true)
	public void amConfig()
	{
		InventoryPage ip=new InventoryPage(driver);
		ip.logoutApp();
		System.out.println("====== Logout of App successful =======");
	}
	
	//@AfterTest
	@AfterClass(alwaysRun= true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("===== Browser closure successful ======");
	}
	
	
	@AfterSuite(alwaysRun= true)
	public void asConfig()
	{
		System.out.println("===== Database Connection successful ======");
		
		
	}
	}


