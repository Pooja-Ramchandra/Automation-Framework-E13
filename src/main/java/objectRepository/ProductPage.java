package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	//declaration
	@FindBy(id="add-to-cart")
	private WebElement addtocartbtn;
	
	@FindBy(id="shopping_cart_container")
	private WebElement cartContainerBtn;

	//initialization
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getCartContainerBtn() {
		return cartContainerBtn;
	}

	
	public WebElement getAddtocartbtn() {
		return addtocartbtn;
	}
	
	//BusinessLibrary
	/**
	 * This method is used to click the cart button
	 */
	public void clickoncartbtn()
	{
		addtocartbtn.click();
	}
	/**
	 * this method is used to click on cart link
	 */

	public void clickcartContainerlnk ()
	{
		cartContainerBtn.click();
	}
}
