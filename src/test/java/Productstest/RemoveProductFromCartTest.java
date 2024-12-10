package Productstest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import genericUtilities.BaseClass;

@Listeners(genericUtilities.ListenerImplementation.class)
public class RemoveProductFromCartTest extends BaseClass 
{
	@Test(groups="RegressionSuite")
	public void RemoveProductsFromCartTest()
	{
		System.out.println("Product removed");
	}
	

	
}
