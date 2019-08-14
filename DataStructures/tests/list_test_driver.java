package tests;

import collections.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This is a simple file that creates test simply based on string comparison. 
 *  @MattFossett
 */
public class list_test_driver {
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
		LinkedList<Integer> list = new LinkedList<Integer>();
		test("1: Empty List after Construction", list.toString(), "{ }");
		/****************************************************************
		 * TEST 2
		 ****************************************************************/
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i=0; i<5; ++i){
			arr.add(i);
		}
		list.addAll(arr);
		test("2: List adds all elements of collection", list.toString(), "{ 0, 1, 2, 3, 4 }");
		/****************************************************************
		 * TEST 3
		 ****************************************************************/
		list.remove();//  1, 2, 3, 4
		list.remove(3);// 1, 2, 3
		list.remove(1);// 1, 3
		test("3: Remove specific Elements", list.toString(), "{ 1, 3 }");
		/****************************************************************
		 * TEST 4
		 ****************************************************************/
		for (int i=0; i < 100000; i++){
			list.add(list.size()/2, i);
		}
		for (int i=0; i<100000; i++){
			list.remove();
		}
		test("4: Many add and remove", "" + list.size(), "2");
		/****************************************************************
		 * TEST 5
		 ****************************************************************/
		list.clear();
		for (int i=0; i<500; i++){
			list.add(i);
		}
		list.clear();
		test("5: Clear", list.toString(), "{ }");
		/****************************************************************
		 * TEST 6
		 ****************************************************************/
		for (int i=5; i>0; i--){
			list.add(i);
		}
		String cat = "";
		for (int i : list){
			cat += i;
		}
		test("6: Iterating over list", cat, "54321");
		/****************************************************************
		 * TEST 7
		 ****************************************************************/
		@SuppressWarnings("unchecked")
		LinkedList<Integer> listCopy = (LinkedList<Integer>) list.clone();
		test("7: Copy matches source", listCopy.toString(), list.toString());
		/****************************************************************
		 * TEST 8
		 ****************************************************************/
		LinkedList<String> stringList = new LinkedList<String>();
		stringList.addLast("cat");
		stringList.addLast("dog");
		String str = "giraffe";
		stringList.addLast(str);
		stringList.addLast("elephant");
		stringList.remove(str);
		
		test("8: Removing object", stringList.toString(), "{ cat, dog, elephant }");
		/****************************************************************
		 * TEST 9
		 ****************************************************************/
		list.clear();
		for (int i=0; i<5; i++){
			list.add(0);
		}
		arr.clear();
		arr.add(5);
		arr.add(5);
		arr.add(5);
		list.addAll(3, arr);
		test("9: add collection to middle of list", list.toString(), "{ 0, 0, 0, 5, 5, 5, 0, 0 }");
		/****************************************************************
		 * TEST 10
		 ****************************************************************/
		for (int i=0; i<list.size(); i++){
			list.set(i, -1);
		}
		test("10: Set", list.toString(), "{ -1, -1, -1, -1, -1, -1, -1, -1 }");	
		/****************************************************************
		 * TEST 11
		 ****************************************************************/
		@SuppressWarnings("unchecked")
		LinkedList<Integer> copy = (LinkedList<Integer>) list.clone();
		copy.add(14);
		test("11: Modifying clone does not effect source", ""+(list.toString()!=copy.toString()), "true");
		/****************************************************************
		 * TEST 12
		 ****************************************************************/
		LinkedList<Integer> small = new LinkedList<Integer>();
		for (int i=0; i<5; i++){
			small.add(i);
		}
		Iterator<Integer> i = small.iterator(); //Starts at index 0
		while (i.hasNext()){
			i.next();
		} //Leave off at last element which in this case is 4
		
		test("11: Moving iterator", i.toString(), "4");
		
	}
/**
 * END TEST DRIVER
 */
}
