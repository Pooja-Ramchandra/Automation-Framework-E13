package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class AddtocartUsingDDT {

	public static void main(String[] args) throws IOException {
		
		//read data from test data file
		FileInputStream fis=new FileInputStream("E:\\AdvanceSelenium\\AutomationFramework\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//read input from the excelsheet
		FileInputStream fise=new FileInputStream("E:\\AdvanceSelenium\\AutomationFramework\\src\\test\\resources\\Testadata.xlsx");
	Workbook wb = WorkbookFactory.create(fise);
	Sheet s= wb.getSheet("Products");
	Row rw=s.getRow(1);
	Cell c1=rw.getCell(2);
	String PRODUCTNAME=c1.getStringCellValue();
	
		//step:1 launch of window
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
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
	driver.findElement(By.className("shopping_cart_link")).click();
	
	//step:7 validate the product in cart
	String actProductInCart= driver.findElement(By.className("inventory_item_name")).getText();
		
	if(actProductInCart.equals(productToBeAdded)) {
		System.out.println("PASS");
		System.out.println(actProductInCart);
	}
		else
		{
			System.out.println("FAIL");
			
		}
	
	//step:8 Logout of Application
	driver.findElement(By.id("react-burger-menu-btn")).click();
	driver.findElement(By.linkText("Logout")).click();
	

	//step:9 close the browser
 driver.close();
	}
	}


