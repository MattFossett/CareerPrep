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
		 * TEST 1: Pushing onto stack
		 ****************************************************************/	
		Stack<Integer> s = new Stack<Integer>();
		for (int i=0; i<4; ++i){
			s.push(i);
		}
		test("TEST 1: Pushing onto stack", s.toString(), "{ 0, 1, 2, [ 3 ]}");
		/****************************************************************
		 * TEST 2
		 ****************************************************************/	
		while (!s.empty()){
			s.pop();
		}
		test("Test 2: Popped all elements", s.toString(), "{ }");
		/****************************************************************
		 * TEST 3
		 ****************************************************************/	 
		Stack<String> reverse = new Stack<String>();
		String str = "Hello world!";
		for (int i=0; i<str.length(); i++){
			reverse.push("" + str.charAt(i));
		}
		str = "";
		while (!reverse.empty()){
			str += reverse.pop();
		}
		test("Test 3: Reverse string", str, "!dlrow olleH");
		/****************************************************************
		 * TEST 4
		 ****************************************************************/	
		for (int i=0; i<10; i++){
			reverse.push("Hello");
		}
		test("Test 5: Size", reverse.size(), 10);
	}
/**
 * END TEST DRIVER
 */
}
