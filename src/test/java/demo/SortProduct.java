package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SortProduct {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Actions a=new Actions(driver);
		driver.findElement(By.xpath("//div//span[@class='select_container']")).click();
		driver.findElement(By.xpath("//SPAN[normalize-space(.)='Name (A to Z)Name (A to Z)Name (Z to A)Price (low to high)Price (high to low)']")).click();

	}

}
