package tests;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Vector;

public class speed_test{

    public static void main(String[] args){
        long before = System.currentTimeMillis();
		collections.LinkedList<Integer> custom = new collections.LinkedList<Integer>();
		for (int j=0; j<100000; j++){
			custom.add(0, j);
		}
		//custom.clear();
		long after = System.currentTimeMillis();
		System.out.println("Custom Time: " + (after-before) + " Size: "  + custom.size());
		
		before = System.currentTimeMillis();
		LinkedList<Integer> java = new LinkedList<Integer>();
		for (int j=0; j<100000; j++){
			java.add(0, j);
		}
		//java.clear();
		after = System.currentTimeMillis();

        System.out.println("Java Time:   " + (after-before) + " Size: "  + java.size());

        before = System.currentTimeMillis();
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int j=0; j<100000; j++){
			al.add(0, j);
		}
		//al.clear();
		after = System.currentTimeMillis();

        System.out.println("Array Time:  " + (after-before) + " Size: "  + al.size());
        
        before = System.currentTimeMillis();
		Vector<Integer> v = new Vector<Integer>();
		for (int j=0; j<100000; j++){
			v.add(0, j);
		}
		//v.clear();
		after = System.currentTimeMillis();

        System.out.println("Vector Time: " + (after-before) + " Size: "  + v.size());
        before = System.currentTimeMillis();
        for (int i=0; i<100; i++){
            System.gc();
        }
        after = System.currentTimeMillis();
        System.out.println("GC Time: " + (after-before) + " Size: ");
    }

}