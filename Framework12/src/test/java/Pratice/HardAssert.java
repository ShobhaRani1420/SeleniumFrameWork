package Pratice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {

	@Test
	public void createContact()
	{
		System.out.println("step1");
		System.out.println("step2");
		//HardAssert
		Assert.assertEquals("A", "B");
		System.out.println("step3");
		System.out.println("step4");
		System.out.println("step5");
	}
	
	@Test
	public void modifyContact()
	{
		System.out.println("step6");
		System.out.println("step7");
		System.out.println("step8");
	}
	
/*	@Test
	public void create()
	{
		String expname="shobha";
		String actname="shobha";
		Assert.assertEquals(expname, actname);
	}*/
	
	
	
	
	
	
}
