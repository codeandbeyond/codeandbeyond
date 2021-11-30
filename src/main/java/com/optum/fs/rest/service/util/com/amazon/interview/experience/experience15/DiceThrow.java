package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class DiceThrow {
    public static void main(String[] args) {
       System.out.println(findWaysDP(6, 6, 72));
        System.out.println("GFG"+findWaysGfg(6, 6, 72));
        //System.out.println(findWays(12, 6, 1020));
        System.out.println(findWaysDP(4, 2, 1));
        System.out.println(findWaysDP(2, 2, 3));
        System.out.println(findWaysDP(6, 3, 8));
        System.out.println(findWaysDP(4, 2, 5));
        System.out.println(findWaysDP(4, 3, 5));

    }

    private static int findWays(int m, int n, int sum) {

        if (sum < 1)
            return 0;
        if (n == 1)
            return 1;
        int countways = 0;
        for (int i = 1; i <= m; i++) {
            countways += findWays(m, n - 1, sum - i);
        }
        return countways;
    }

    private static int findWaysDP(int m, int n, int sum) {
        int dp[][] = new int[n + 1][sum + 1];
        for (int i = 1; i <= m && i <= sum; i++) {
            dp[1][i] = 1;
        }
        for(int i=2;i<=n;i++){
            for(int j=1;j<=sum;j++){
                for(int k=1;k<=m && k<j;k++){
                    dp[i][j] = dp[i][j]+dp[i-1][j-k];
                }
            }
        }

//        for(int i = 0; i< n+1; i++){
//            for(int j = 0; j< sum+1; j++)
//                System.out.print(dp[i][j] + " ");
//            System.out.println();
//        }
        return dp[n][sum];
    }
    public static long findWaysGfg(int m, int n, int x){

    /* Create a table to store the results of subproblems.
    One extra row and column are used for simplicity
    (Number of dice is directly used as row index and sum is directly used as column index).
    The entries in 0th row and 0th column are never used. */
        long[][] table = new long[n+1][x+1];

        /* Table entries for only one dice */
        for(int j = 1; j <= m && j <= x; j++)
            table[1][j] = 1;

    /* Fill rest of the entries in table using recursive relation
    i: number of dice, j: sum */
        for(int i = 2; i <= n;i ++){
            for(int j = 1; j <= x; j++){
                for(int k = 1; k < j && k <= m; k++)
                    table[i][j] += table[i-1][j-k];
            }
        }

        /* Uncomment these lines to see content of table
        for(int i = 0; i< n+1; i++){
            for(int j = 0; j< x+1; j++)
                System.out.print(dt[i][j] + " ");
            System.out.println();
        } */

        return table[n][x];
    }

}
