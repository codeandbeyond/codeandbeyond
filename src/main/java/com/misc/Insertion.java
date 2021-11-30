package com.misc;

public class Insertion {

    public static void sort(Integer[] array) {
        int N = array.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j >0 ; j--) {
                if (isLess(array[j], array[j-1]))
                    exchange(array,j,j-1);
            }

        }
        show(array);

    }

    private static void show(Integer[] array) {
        for (Integer i : array) {
            System.out.println(" " + i);
        }
    }

    public static void exchange(Comparable arr[], int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isLess(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}