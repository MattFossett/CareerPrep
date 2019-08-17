package tests;

import collections.Array;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;

public class array_test_driver{
    /**
	 * TEST DRIVER
	 */
	public static boolean test(String testName, String actualValue, String expectedValue){
		if (actualValue.equals(expectedValue)){
			System.out.println("===============================================================");
			System.out.println(testName+ ": PASSED");
			System.out.println("===============================================================");
			return true;
		}
		System.err.println("===============================================================");
		System.err.println(testName+ ": FAILED");
		System.err.println("EXPECTED: " + expectedValue);
		System.err.println("RECIEVED: " + actualValue);
		System.err.println("===============================================================");
		
		return false;
	}


    public static void main(String[] args){
        /****************************************************************
		 * TEST 1
		 ****************************************************************/
        Array<String> s = new Array<String>();
        s.add("Hello!");
		test("1: Add string to array", s.toString(), "{ Hello! }");
        /****************************************************************
		 * TEST 2
		 ****************************************************************/
        s.remove(0);
        test("2: Remove only entry", s.toString(), "{ }");
         /****************************************************************
		 * TEST 3
		 ****************************************************************/
        for (int i=0; i<5; i++){
            s.add(i+"");
        }
        test("3: Add many elements", s.toString(), "{ 0, 1, 2, 3, 4 }");
         /****************************************************************
		 * TEST 4
		 ****************************************************************/
        s.remove(2);
        s.remove(0);
        s.set(2, 5+"");
        test("4: Remove and set value", s.toString(), "{ 1, 3, 5 }");
         /****************************************************************
		 * TEST 5
		 ****************************************************************/
        s.add(1, 2+"");
        s.add(3, 4+"");
        test("5: Add into middle", s.toString(), "{ 1, 2, 3, 4, 5 }");
         /****************************************************************
		 * TEST 6
		 ****************************************************************/
        s.removeRange(1, 4);
        test("6: Remove range", s.toString(), "{ 1, 5 }");
         /****************************************************************
		 * TEST 7
		 ****************************************************************/
        for (int i=0; i<100000; i++){
            s.add(s.size()/2, i+" ");
        }
        test("7: many adds to middle size check", s.size()+"", "100002");
         /****************************************************************
		 * TEST 8
		 ****************************************************************/
        String one_five = s.get(0) + " " + s.get(s.size()-1);
        
        test("8: Ensure front and back remain same", one_five, "1 5");
        /****************************************************************
		 * TEST 9
		 ****************************************************************/
        s.clear();
        test("9: Clear the array", s.toString(), "{ }");
        /****************************************************************
		 * TEST 10
		 ****************************************************************/
        for (int i=0; i<5; i++){
            s.add(i+"");
        }
        String hello = "Hello!";
        s.add(2, hello);
        test("10: Index of object", s.indexOf(hello)+"", "2");
        /****************************************************************
		 * TEST 11
		 ****************************************************************/
        s.clear();
        s.add("0");
        s.add("5");
        LinkedList<String> list = new LinkedList<String>();
        for (int i=1; i<5; i++) list.add(i+"");
        s.addAll(1, list);
        test("11: Add Different collection to middle of list", s.toString(), "{ 0, 1, 2, 3, 4, 5 }");
        /****************************************************************
		 * TEST 12
		 ****************************************************************/
        s.removeRange(1, 5);
        list.clear();
        list.add(50+"");
        s.addAll(1, list);
        test("12: Add Small collection to middle of list", s.toString(), "{ 0, 50, 5 }");
        /****************************************************************
		 * TEST 13
		 ****************************************************************/
        test("13: Correct size", s.size()+"", "3");
        /****************************************************************
		 * TEST 14
		 ****************************************************************/
        list.clear();
        for (int i=0; i<100000; i++) list.add(i+"");
        s.addAll(2, list);
        test("14: Correct size", s.size()+"", "100003");
        /****************************************************************
		 * TEST 15
		 ****************************************************************/
        s.clear();
        long before = System.currentTimeMillis();
        for (int i=0; i<10000; i++){
            s.add(0, i+"");
        }
        long after = System.currentTimeMillis();
        long time1 = after-before;
        System.out.println("No trim: " + time1);

        s.clear();
        before = System.currentTimeMillis();
        for (int i=0; i<10000; i++){
            s.add(0, i+"");
            s.trimToSize();
        }
        after = System.currentTimeMillis();
        long time2 = after-before;
        System.out.println("   trim: " + time2);
        test("15: Adding while always trimming to size is slower", (time1<time2)+"", "true");
        /****************************************************************
		 * TEST 17
		 ****************************************************************/




    }
}
