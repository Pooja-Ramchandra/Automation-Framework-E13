package Practice;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {

	
		
		public void test()
		{
			System.out.println("step 1");
			Assert.assertEquals(0,1);
			System.out.println("step 2");
			System.out.println("step 3");
			
			
		}

		public void testSoft()
		{
			SoftAssert sa=new SoftAssert();
			Assert.assertEquals(0,1);
			System.out.println("step 2");
			Assert.assertTrue(false);
			System.out.println("step 3");

			sa.assertAll();
		}
	}


