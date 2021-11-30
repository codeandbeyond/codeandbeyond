package com.optum.fs.rest.service.util.leetcode;

public class SameFirstDigitLastDigitCount {
    public static void main(String[] args) {
        int start = 5, end = 40;
        SameFirstDigitLastDigitCount sameFirstDigitLastDigitCount = new SameFirstDigitLastDigitCount();
        System.out.print(sameFirstDigitLastDigitCount.getCountWithSameStartAndEnd(start,
                end));
    }

    private int getCountWithSameStartAndEnd(int start, int end) {
        if (start > end) return -1;
        int startCount = getCountWithRange(start-1);
        int endCount = getCountWithRange(end);
        return endCount - startCount;
    }

    private int getCountWithRange(int x) {
        if (x < 10) return x;
        int result = 0;
        int tens = x / 10;
        int lastDigit = x % 10;
        int firstDigit;
        while (x >= 10) {
            x /= 10;
        }
        firstDigit = x;

        result += tens + 9;
        if (firstDigit > lastDigit) {
            result--;
        }
        return result;
    }
}
