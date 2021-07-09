package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);//Minimum of last 2 cost+current cost time complexity = O(n) space complexity O(1)
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
