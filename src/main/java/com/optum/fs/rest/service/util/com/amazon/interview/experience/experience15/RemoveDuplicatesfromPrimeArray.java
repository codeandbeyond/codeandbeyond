package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import java.util.Arrays;

public class RemoveDuplicatesfromPrimeArray {
    public static void main(String[] args) {
        int[] vect = {3, 5, 7, 2, 2, 5, 7, 7};
        RemoveDuplicatesfromPrimeArray removeDuplicatesfromPrimeArray = new RemoveDuplicatesfromPrimeArray();
       // removeDuplicatesfromPrimeArray.removeDuplicates(vect);
        removeDuplicatesfromPrimeArray.removeDuplicatesWithProd(vect);
    }

    private void removeDuplicates(int[] arr) {
        Arrays.sort(arr);
        int first = 1;
        for (int i = 1; i < arr.length; i++)
            if (arr[i] != arr[i - 1]) {
                arr[first++] = arr[i];
            }
    }
    private void removeDuplicatesWithProd(int[] arr) {
       int index = 1;
       int prod = arr[0];
       for(int i = 1;i<arr.length;i++){
           if(prod%arr[i]!=0){
               arr[index++] = arr[i];
               prod=prod*arr[i];
           }
       }
    }
}
