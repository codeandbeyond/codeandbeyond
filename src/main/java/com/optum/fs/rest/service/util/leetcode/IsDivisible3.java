package com.optum.fs.rest.service.util.leetcode;

public class IsDivisible3 {
    public static void main(String[] args) {
        IsDivisible3 isDivisible3 = new IsDivisible3();
        int num = 7;
        isDivisible3.isDivisible(num);
    }

    private boolean isDivisible(int num) {
        if (num < 0) {
            num = -num;
        }
        if (num == 0) {
            return true;
        }
        if (num == 1) {
            return false;
        }
        int odd = 0;
        int even = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                odd++;
            }
            num = num >> 1;
            if (num == 0) break;
            if ((num & 1) == 1) {
                even++;
            }
        }
        return isDivisible(even - odd);
    }
}
