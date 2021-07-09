package com.optum.fs.rest.service.util.leetcode;

public class Power {
    public static void main(String[] args) {
        Power power = new Power();
        System.out.println(power.power(6, -7));
        power.powerLengthy(22,2);
    }

    public int power(int x, int y) {
        if (y == 0) return 1;
        int temp = power(x, y / 2);
        if (y % 2 == 0) {
            return temp * temp;
        } else {
            if (y > 0) {
                return x * temp * temp;
            } else {
                return (temp * temp) / y;
            }
        }
    }

    public void powerLengthy(int x, int y) {
        if (y == 0) System.out.println(1);
        int[] result = new int[10000];
        int resultSize = 0;
        int temp = x;
        while (temp != 0) {
            result[resultSize] = temp % 10;
            temp /= 10;
            resultSize++;
        }
        for (int i = 2; i <= y; i++) {
            multiply(x, result, resultSize);
        }
    }

    private void multiply(int x, int[] result, int resultSize) {
        int carry = 0;
        for (int i = 0; i < resultSize; i++) {
            int prod = result[i] * x + carry;
            result[i] = prod % 10;
            carry = prod / 10;
        }
        while (carry != 0) {
            result[resultSize] = carry % 10;
            carry = carry / 10;
            resultSize++;
        }
        for(int i=0;i<resultSize;i++){
            System.out.print(result[i]);
        }
    }
}
