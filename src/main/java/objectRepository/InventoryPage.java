package objectRepository;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage { //rule1
	//declaration
	//rule 2
	@FindBy(id="react-burger-menu-btn")
	private WebElement menuBtn;
	
	@FindBy(id="logout_sidebar_link")
	private WebElement logoutlnk;
	
	//initialization
	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getHamburgericon() {
		return menuBtn;
	}

	public WebElement getLogoutlnk() {
		return logoutlnk;
	}
	
	//BusinessLibrary
	/**
	 * This method will click on menu bar
	 */
	public void clickonmenubar()
	{
		menuBtn.click();
	}
	/**
	 * This method will click on logout button from the menu bar option
	 */
	public void logoutApp()
	{
		menuBtn.click();
		logoutlnk.click();
	}
	/**
	 * This method is used to capture the dynamic product name and also get the product name and to validate
	 * @param driver
	 * @param PRODUCTNAME
	 * @return
	 */
//.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).getText();
	public String clickOnProductAndCaptureTitle(WebDriver driver,String PRODUCTNAME)
	{
		String ProductTitle = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).getText();
		driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
		return ProductTitle; //use for validation
	}
}
