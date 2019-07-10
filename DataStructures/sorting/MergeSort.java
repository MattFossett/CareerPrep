package sorting;

import java.util.ArrayList;

public class MergeSort{
    /**
     * takes 2 sorted halves and merges into one sorted array
     */
    public static void merge(ArrayList<Integer> arr, int left, int middle, int right){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        System.out.println("In merge arr: " + arr);
        int leftI = left; 
        int midI = middle;
        for (int i=0; leftI < middle && midI < right; i++){
        	if (arr.get(leftI) < arr.get(midI)){
        		temp.add(i, arr.get(leftI));
        		leftI++;
        	}
        	else if (arr.get(leftI) >= arr.get(midI)){
        		temp.add(i, arr.get(midI));
        		midI++;
        	}
        }
        while (leftI < middle){
        	temp.add(arr.get(leftI));
        	leftI++;
        }
        while (midI < right){
        	temp.add(arr.get(leftI));
        	midI++;
        }
        System.out.println("in merge: " + temp);
        for (int i : temp){
        	arr.set(left, i);
        	left++;
        }
    }

    public static void mergeSort(ArrayList<Integer> arr, int left, int right){
        if (right > left){
            int middle = (left+right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle+1, right);
            merge(arr, left, middle, right);
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        for (int i=3; i>0; i--){
        	arr.add(i);
        }
    	/*arr.add(38);
    	arr.add(27);
    	arr.add(43);
    	arr.add(3);
    	arr.add(9);
    	arr.add(82);
    	arr.add(10);*/
        System.out.println(arr);
        mergeSort(arr, 0, arr.size());
        System.out.println(arr);

    }
}