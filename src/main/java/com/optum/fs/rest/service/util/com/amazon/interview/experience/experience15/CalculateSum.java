package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;


import java.util.Set;
import java.util.TreeSet;

public class CalculateSum {
    public static void main(String[] args) {

        int arr1[] = {1, 2};
        int size1 = arr1.length;
        int arr2[] = {3, 4};
        int size2 = arr2.length;

        int N = 3;
        int res = calculateSetOfSum(arr1, size1, arr2, size2, N);
        if (res == -1)
            System.out.println("N'th term doesn't exists in set");
        else
            System.out.println("N'th element in the set of sums is "
                    + res);
    }

    private static int calculateSetOfSum(int[] arr1, int size1, int[] arr2, int size2, int n) {
        Set<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                set.add(arr1[i] + arr2[j]);
            }
        }
        if (set.size() < n)
            return -1;
        return (Integer) set.toArray()[n - 1];
    }
}
