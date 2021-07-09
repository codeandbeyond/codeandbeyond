package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class CountWaysToReachStair {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(countWays(n+1));
    }

    private static int countWays(int n) {
        if (n == 0 || n == 1)
            return n;
        return countWays(n - 1) + countWays(n - 2);
    }
}
