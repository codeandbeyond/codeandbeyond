package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

public class CountRunsWithNballs {
    long ans = 0;

    public static void main(String[] args) {
        CountRunsWithNballs countRunsWithNballs =new CountRunsWithNballs();
        System.out.println("Possible scores "+countRunsWithNballs.count(9));
    }
    public long count(int n) {
        if (n == 0) {
            return 0;
        }
        ans += 1 + count(n - 1);
        ans += 2 + count(n - 1);
        ans += 3 + count(n - 1);
        return ans;
    }
}
