package GenericUtility;

import java.util.Random;

/**
 * 
 *its Developed using java libaries. which used to handle RAndom numbers 
 * @author POOJA P R
 *
 */

public class JavaUtility {
	public int getRandomNumber(){
		Random rd=new Random();
		int random = rd.nextInt(1000);
		return random;
	}

}

 

