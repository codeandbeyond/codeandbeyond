package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

public class MaximumPOssibleNumberWithDigit {
    int MaximumPossible(int num, int digit) {
        if (num == 0) return digit * 10;
        int negative = num < 0 ? -1 : 1;
        int n = num;
        num = Math.abs(num);
        int numOfDisgits = 0;
        while (n != 0) {
            numOfDisgits++;
            n /= 10;
        }
        int position = 1;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i <= numOfDisgits; i++) {
            int newVal = ((num / position) * (position * 10)) + digit * position + (num % position);//276 276/1*1*10+3*1+0 = 2760+3+0 = 2763;
            maxVal = Math.max(maxVal, newVal * negative);
            position = position * 10;
        }
        return maxVal;
    }

    public static void main(String[] args) {
        MaximumPOssibleNumberWithDigit maximumPOssibleNumberWithDigit = new MaximumPOssibleNumberWithDigit();
        int result = maximumPOssibleNumberWithDigit.MaximumPossible(-76, 5);
        System.out.println(result);
    }
}
