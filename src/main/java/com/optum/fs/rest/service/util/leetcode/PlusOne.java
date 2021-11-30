package com.optum.fs.rest.service.util.leetcode;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] result = plusOne.plusOne(new int[]{9});
        for (Integer num : result) {
            System.out.print(num);
        }
    }

    public int[] plusOne(int[] digits) {
        int carry = 1;
        int sum = 0;
        int temp = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + carry;
            carry = sum >= 10 ? 1 : 0;
            temp = sum % 10;
            digits[i] = temp;
        }
        if (carry > 0) {
            if (digits[0] == 9 || digits[0] == 0) {
                int[] newArray = new int[digits.length + 1];
                newArray[0] += carry;
                for (int i = 0; i < digits.length; i++) {

                    newArray[i+1] = digits[i];
                }
                return newArray;
            } else {
                digits[0] += 1;
            }
        }
        return digits;
    }
}
