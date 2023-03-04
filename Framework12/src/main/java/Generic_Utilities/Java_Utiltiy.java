package Generic_Utilities;

import java.util.Random;

public class Java_Utiltiy {

	public int getRanDomNum()
	{
		Random ran=new Random();
		int ranNum = ran.nextInt(10000);
		return ranNum;
		
	}
}
