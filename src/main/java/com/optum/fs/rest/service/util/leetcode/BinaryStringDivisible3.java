package com.optum.fs.rest.service.util.leetcode;

public class BinaryStringDivisible3 {
    public static void main(String[] args) {
        BinaryStringDivisible3 binaryStringDivisible3 = new BinaryStringDivisible3();
        String string = "010101";
        //binaryStringDivisible3.isDivisible(string);
        binaryStringDivisible3.isDivisibleByN(string,3);
    }

    private void isDivisible(String string) {
        char nextDigit;
        int currentMod = 0;
        int i = 0;
        while (i < string.length()) {
            nextDigit = string.charAt(i);
            if (nextDigit == '0') {
                currentMod = (2 * (currentMod % 3)) % 3;
            } else {
                currentMod = (2 * (currentMod % 3) + 1) % 3;
            }

            i++;
        }
        if (currentMod == 0) {
            System.out.println("Divisible");

        }
    }
    private void isDivisibleByN(String string,int n) {
        char nextDigit;
        int currentMod = 0;
        int i = 0;
        while (i < string.length()) {
            nextDigit = string.charAt(i);
            if (nextDigit == '0') {
                currentMod = (2 * (currentMod % n)) % n;
            } else {
                currentMod = (2 * (currentMod % n) + 1) % n;
            }

            i++;
        }
        if (currentMod == 0) {
            System.out.println("Divisible");

        }else{
            System.out.println("Not divisible by "+n);
        }
    }
}
