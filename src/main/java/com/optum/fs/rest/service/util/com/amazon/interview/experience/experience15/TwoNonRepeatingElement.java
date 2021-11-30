package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class TwoNonRepeatingElement {
    public static void main(String[] args) {
        int arr[] = {1,1,2,3,4,4};
        getTwoNonRepeating(arr);
    }

    private static void getTwoNonRepeating(int[] arr) {
        int x = 0, y = 0;
        int xor = arr[0];
        for (int i =1;i<arr.length;i++) {
            xor = xor ^ arr[i];
        }
        int setBit = xor & ~(xor - 1);

        for (int j =0;j<arr.length ;j++) {
            if ((arr[j] & setBit)>0) {
                x = x ^ arr[j];
            } else {
                y = y ^arr[j];

            }
        }
        System.out.println(" x : "+x+" y : "+y);
    }
}
