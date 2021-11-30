package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

public class FairIndex {
    public  int fairIndex(int a[], int b[]){
        // WRITE YOUR BRILLIANT CODE HERE
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < a.length; i++) {
            sumA += a[i];
            sumB += b[i];
        }
        int count = 0;
        int tempA = a[0];
        int tempB = b[0];
        for (int i = 1; i < a.length; i++) {
            if (i != 1 && tempA == tempB && 2 * tempA == sumA && 2 * tempB == sumB) {
                count++;
            }
            tempA += a[i];
            tempB += b[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {4, -1, 0, 3};
        int[] b = {-2, 5, 0, 3};
        FairIndex fairIndex = new FairIndex();
        fairIndex.fairIndex(a,b);
    }
}
