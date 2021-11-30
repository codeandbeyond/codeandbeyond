package com.optum.fs.rest.service.util.leetcode;

public class CountBitsToConvertAtoB {
    public static void main(String[] args) {
        int a = 7;
        int b = 10;
        CountBitsToConvertAtoB countBitsToConvertAtoB = new CountBitsToConvertAtoB();
        System.out.println(countBitsToConvertAtoB.countFlips(a ^ b));
    }

    public int countFlips(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) > 0)
                count++;
            n = n >> 1;
        }
        return count;
    }
}
