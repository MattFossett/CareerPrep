package tests;

import collections.*;
import java.util.ArrayList;
import java.util.Iterator;
//import <LinkedList>; //TODO HOW TO LINK JAVA FILE IN OTHER DIRECTORY
/**
 * This is a simple file that creates test simply based on string comparison. 
 *  @MattFossett
 */
public class stack_test_driver {
	/**
	 * TEST DRIVER
	 */
	
	public static boolean test(String testName, String actualValue, String expectedValue){
		if (actualValue.equals(expectedValue)){
			System.out.println("=====================================================");
			System.out.println(testName+ ": PASSED");
			System.out.println("=====================================================");
			return true;
		}
		System.err.println("=====================================================");
		System.err.println(testName+ ": FAILED");
		System.err.println("EXPECTED: " + expectedValue);
		System.err.println("RECIEVED: " + actualValue);
		System.err.println("=====================================================");
		
		return false;
	}
	public static void main(String[] args){
		/****************************************************************
		 * TEST 1
		 ****************************************************************/	
		/*Stack<Integer> s = new Stack<Integer>();
		for (int i=0; i<4; ++i){
			s.push(i);
		}
		System.out.println(s);
		*/
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.add(4);
		System.out.println(l);
	}
/**
 * END TEST DRIVER
 */
}
