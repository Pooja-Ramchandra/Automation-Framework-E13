package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage 
{
	//Declaration
     @FindBy(className="inventory_item_name")
     private WebElement productNameLink;
     
     
     //Intilization
     public CartPage(WebDriver driver)
     {
    	 PageFactory.initElements(driver, this);
     }
     
     //Utilization
     public WebElement getProductNameLink() {
		return productNameLink;
	}
	
    //Business Library
	/**
	 *This method will capture the product details for validation
	 * @return
	 */
     public String captureProductInfo()
     {
    	 return productNameLink.getText();
     }
     
     
}
