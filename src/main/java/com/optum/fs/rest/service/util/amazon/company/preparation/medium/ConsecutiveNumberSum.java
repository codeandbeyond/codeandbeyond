package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

public class ConsecutiveNumberSum {
    public int consecutiveNumbersSum(int N) {
        int sum = 0, ans = 0;
        for(int i = 1; sum < N; i++) {
            sum += i;
            if (((N-sum) % i) == 0)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
