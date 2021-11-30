package com.optum.fs.rest.service.util.microsft.comany.preparation;

public class MinimumDeletionCost {
    public static void main(String[] args) {
        MinimumDeletionCost minimumDeletionCost = new MinimumDeletionCost();
         String s = "aabaa";
         int[] cost = {1,2,3,4,1};
        minimumDeletionCost.minCost(s,cost);
    }
    public int minCost(String s, int[] cost) {
        int n = s.length();
        int result = 0;
        for (int i=1; i<n; i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                result = result + Math.min(cost[i], cost[i-1]);
                cost[i] = Math.max(cost[i], cost[i-1]);
            }
        }
        return result;
    }
}
