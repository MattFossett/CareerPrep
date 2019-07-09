package tests;

import collections.Set;
class tree_test_driver{
    public static void main(String[] args){
        Set<Integer> s = new Set<Integer>();

        s.add(5);
        if (s.add(6)) {
            System.out.println("ohhhh shoot");
        }
        System.out.println( s);

    }
}