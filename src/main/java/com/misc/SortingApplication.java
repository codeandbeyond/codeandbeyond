package com.misc;

public class SortingApplication {
    public static void main(String[] args) {
        Integer[] arr= new Integer[]{34, 21, 63, 312, 90, 67, 2, 1,};
       /* com.misc.Selection.sort(arr);*/
        /*com.misc.Insertion.sort(arr);*/
        MergeSort.sort(arr);
        System.out.println(" --------------------- ");
        MergeSort.sortBU(arr);



    }
}
