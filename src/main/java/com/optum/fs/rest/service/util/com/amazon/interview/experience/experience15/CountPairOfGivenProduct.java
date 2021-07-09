package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountPairOfGivenProduct {
    public static void main(String[] args) {
        int arr[] = {10, 20, 9, 40};
        int x = 400;
//        Point p = isProduct(arr, 200);
//        if (p != null) {
//            System.out.println(" Pair is " + p.getX() + " * " + p.getY());
//        }
        Point p1 = isProduct(arr, 360,arr.length);
        if (p1 != null) {
            System.out.println(" Pair is " + p1.getX() + " * " + p1.getY());
        }
    }

    private static Point isProduct(int[] arr, int x) {
        Arrays.sort(arr);
        Point point = null;
        int product = 1;
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            product = arr[l] * arr[r];
            if (product < x) {
                l++;
            } else if (product > x) {
                r--;
            } else {
                point = new Point(arr[l], arr[r]);
                break;
            }
        }
        return point;
    }

    private static Point isProduct(int[] arr, int x, int length) {
        Point p = null;
        Set<Integer> pairHash = new HashSet<Integer>();
        for (int i = 0; i < length; i++) {
            if (arr[i] == 0 && x == 0) {
                return new Point(0, 0);
            } else if (x % arr[i] == 0) {
                if (pairHash.contains(x / arr[i])) {
                    p = new Point(arr[i], x / arr[i]);
                    break;
                }else{
                    pairHash.add(arr[i]);
                }

            } else {
                pairHash.add(arr[i]);
            }

        }
        return p;
    }
}
