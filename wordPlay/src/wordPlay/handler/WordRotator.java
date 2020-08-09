package wordPlay.handler;

import java.util.ArrayList;
import java.util.List;

import wordPlay.util.Results;


/**
 *  WordPlay Handler class  *
 * This class has all the string manipulation methods like rotation and fullStoprotation.
 * @author Shrijeet Rupnar
 * @version 1.0.
 * @since   06-08-2020
 */

public class WordRotator {


	public WordRotator() {

	}


	/**
	 * This is the method which will reverse the given word.
	 * @param word as a string and Number of iteration n
	 * @return reversed word as String
	 * @author  Shrijeet Rupnar
	 * @version 1.0
	 * @since   06-08-2020
	 */

	public String rotation(String toRotate, int n) {

		char[] stringProcess=toRotate.toCharArray();
		int len= toRotate.length()-1;

		while(n>0){
			int j=len;
			char temp=stringProcess[j];
			for(int i=0;j>i;j--){

				stringProcess[j]=stringProcess[j-1];

			}

			stringProcess[j]=temp;
			n--;
		}//while

		String str = new String(stringProcess);
		return str;
	}//rotation



	/**
	 * This is the method will reverse the given word when it has full-stop in it.
	 * @param word as a string and Number of iteration n
	 * @return reversed word as String
	 * @author  Shrijeet Rupnar
	 * @version 1.0
	 * @since   06-08-2020
	 */

	public String fullStoprotation(String toRotate, int n) {


		String toRotate1= toRotate.substring(0,toRotate.length()-1);
		char[] stringProcess=toRotate1.toCharArray();
		int len= toRotate1.length()-1;

		while(n>0){
			int j=len;
			char temp=stringProcess[j];
			for(int i=0;j>i;j--){

				stringProcess[j]=stringProcess[j-1];
			}
			stringProcess[j]=temp;
			n--;
		}//while

		String str = new String(stringProcess);
		str=str+".";
		return str;
	}//fullStoprotation




	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "";
	}

}
