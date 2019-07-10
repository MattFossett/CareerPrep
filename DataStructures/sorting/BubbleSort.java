package sorting;

import java.util.ArrayList;

public class BubbleSort {
	
	public static void bubbleSort(ArrayList<Integer> arr){
		boolean isSorted = false;
		int count = 0;
		while(!isSorted){
			isSorted = true;
			for (int i=0; i<arr.size()-1; i++, count++){
				
				if (arr.get(i) > arr.get(i+1)){
					int temp = arr.get(i);
					arr.set(i, arr.get(i+1));
					arr.set(i+1, temp);
					isSorted = false;
				}
				
				System.out.println(count);
			}
		}
		
	}
	
	public static void main(String[] args){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i=100; i>0; i-- ){
			arr.add(i);
		}
		bubbleSort(arr);
		System.out.println(arr);
	}
}
