package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class SumOfTwoArrarys {
    public static void main(String[] args) {
        SumOfTwoArrarys sumOfTwoArrarys = new SumOfTwoArrarys();
        int a[] = {1, 2, 3, 4};
        int b[] = {4, 8};

        int n = a.length;
        int m = b.length;
        System.out.println(sumOfTwoArrarys.calSum(a, b, n, m));
    }

    private int calSum(int[] a, int[] b, int n, int m) {
        if (n > m) {
            return calSumUtil(a, b, n, m);
        } else {
            return calSumUtil(a, b, m, n);
        }

    }

    private int calSumUtil(int[] a, int[] b, int m, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m - 1;
        int s;
        int ans = 0;
        int sum[] = new int[m];
        int carry = 0;
        while (j >= 0) {
            s = a[i] + b[j] + carry;
            sum[k] = s % 10;
            carry = s / 10;
            i--;
            j--;
            k--;
        }
        while (i >= 0) {
            s = a[i] + carry;
            sum[k] = s % 10;
            carry = s / 10;
            i--;
            k--;
        }
        if (carry == 1) {
            ans = 10;
        }
        for (i = 0; i <= m - 1; i++) {
            ans += sum[i];
            ans *= 10;
        }
        return ans / 10;
    }
}
