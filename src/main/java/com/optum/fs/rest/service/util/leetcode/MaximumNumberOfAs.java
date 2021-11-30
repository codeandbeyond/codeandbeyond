package com.optum.fs.rest.service.util.leetcode;

import java.util.Arrays;

public class MaximumNumberOfAs {
    public static void main(String[] args) {
        MaximumNumberOfAs maximumNumberOfAs = new MaximumNumberOfAs();
        int n = 8 ;
        int[] maxSolution = new int[n];
        Arrays.fill(maxSolution,-1);
        int ans = maximumNumberOfAs.findMax(n, Integer.MIN_VALUE, maxSolution);
        System.out.println(ans);

    }

    public int findMax(int n, int maxSoFar, int[] maxSolution) {
        int maxWithThis;
        int multiPlier = 2;
        if (n < 7) {
            return n;
        }

        for (int i = n - 3; i >= 0; i--) {
            if (maxSolution[i] == -1) {
                maxSolution[i] = findMax(i, maxSoFar, maxSolution);
            }
            maxWithThis = multiPlier * maxSolution[i];
            maxSoFar = Math.max(maxSoFar, maxWithThis);
            multiPlier++;
        }
        return maxSoFar;


    }
}
