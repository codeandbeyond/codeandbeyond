package com.optum.fs.rest.service.util.leetcode;

public class MinimumCostPathRightDown {
    public static void main(String[] args) {

        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        MinimumCostPathRightDown minimumCostPathRightDown = new MinimumCostPathRightDown();
        minimumCostPathRightDown.minCostPath(cost, 2, 2);
    }

    private void minCostPath(int[][] cost, int m, int n) {
        int[][] totalCost = new int[m + 1][n + 1];
        totalCost[0][0] = cost[0][0];

        for (int i = 1; i <= m; i++) {
            totalCost[i][0] = totalCost[i - 1][0] + cost[i][0];
        }
        for (int j = 1; j <= m; j++) {
            totalCost[0][j] = totalCost[0][j - 1] + cost[0][j];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                totalCost[i][j] = Math.min(totalCost[i - 1][j - 1], Math.min(totalCost[i - 1][j], totalCost[i][j - 1])) + cost[i][j];
            }
        }
        System.out.println(totalCost[m][n]);
    }
}
