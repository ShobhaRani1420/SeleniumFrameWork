package Pratice;

import org.testng.annotations.Test;


public class TestNGPratice {

	
		   //method1
	@Test
		public void createContact()
		{
		System.out.println("created");
		//int[] arr= {1,2,3};
		//System.out.println(arr[5]);
		}
		
		//method2
	@Test (invocationCount = 2)
		public void modifycontact()
		{
			System.out.println("modified");
		}
		
		//method3
	@Test (dependsOnMethods = "createContact")
      public void deletecontact()
     {
	 System.out.println("deleted");
       }
	  }


