package Practice;

public class GenericMethods {

	public static void main(String[] args) {  //caller function
		 int subt=sub(20,10);
		 System.out.println(subt);
		
		int sum=add(50,20);
		System.out.println(sum);
		
		
	}
	
	public static int add(int a1, int b1) //called generic function
	{
		int d=a1-b1;
		return d;
		
	}
		public static int sub(int a, int b) //called generic function
		{
			int c=a-b;
			return c;
			
		}

	

}
