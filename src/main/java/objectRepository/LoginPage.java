package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//rule 1

		//rule2
		@FindBy(id = "user-name") 
		private WebElement userNameEdt;
		
		@FindBy(id = "password") 
		private WebElement passwordEdt;
		
		@FindBy(id = "login-button") 
		private WebElement loginBtn;
		
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public WebElement getUserNameEdt() {
			return userNameEdt;
			
		}
		public WebElement getpasswordEdt() {
			return passwordEdt;
			
		}
		public WebElement getLoginBtn() {
			return loginBtn ;
			
		}

		
		//BusinessLibrary-business logic in generic method
		public void loginToApp(String USERNAME,String PASSWORD)
		{
			userNameEdt.sendKeys(USERNAME);
			passwordEdt.sendKeys(PASSWORD);
			loginBtn.click();
		}
		

	}


