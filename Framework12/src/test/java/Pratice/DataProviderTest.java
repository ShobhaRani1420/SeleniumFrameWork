package Pratice;

import java.util.EventObject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



	public class DataProviderTest {
		@Test(dataProvider="dataProvider_test")
			public void bookTicket(String src,String dst)
			{
				System.out.println("Book titckets from "+src+" to "+dst+"");
			}

			@DataProvider
			public Object[][] dataProvider_test()
			{
				Object[][] objArr=new Object[5][2];
				objArr[0][0]="Bangalore";
				objArr[0][1]="goa";
				
				objArr[1][0]="Bangalore";
				objArr[1][1]="mysore";
				return objArr;
	}
	
	
	
	
	
	
	
	
	
}
