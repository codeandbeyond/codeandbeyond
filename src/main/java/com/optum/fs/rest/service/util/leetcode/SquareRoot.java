package com.optum.fs.rest.service.util.leetcode;

public class SquareRoot {
    public static void main(String[] args) {
        SquareRoot squareRoot = new SquareRoot();
        System.out.println(squareRoot.squareRoot(10, 3));
    }

    public float squareRoot(int number, int precision) {
        double ans = 0;
        int start = 0;
        int end = number;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid * mid == number) {
                ans = mid;
                break;
            } else if (mid * mid < number) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        double increment = 0.1;
        for (int i = 0; i < precision; i++) {
            while (ans * ans <= number) {
                ans += increment;
            }
            ans = ans - increment;
            increment = increment / 10;
        }
        return (float) ans;
    }
}
