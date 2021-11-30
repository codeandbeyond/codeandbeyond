package com.optum.fs.rest.service.util.leetcode;

public class GeneartingPalindromeLessThanN {
    public static void main(String[] args) {
        int n = 12;
        GeneartingPalindromeLessThanN geneartingPalindromeLessThanN = new GeneartingPalindromeLessThanN();
        geneartingPalindromeLessThanN.generate(n);
    }

    private void generate(int n) {
        int number;
        for (int j = 0; j < 2; j++) {
            int i = 1;
            while ((number = createPalindrome(i, 10, j % 2)) < n) {
                System.out.print(number+" ");
                i++;
            }
        }
    }

    private int createPalindrome(int input, int base, int isOdd) {
        int n = input;
        int palin = input;

        // checks if number of digits is odd or even
        // if odd then neglect the last digit of input in
        // finding reverse as in case of odd number of
        // digits middle element occur once
        if (isOdd == 1)
            n /= base;

        // Creates palindrome by just appending reverse
        // of number to itself
        while (n > 0) {
            palin = palin * base + (n % base);
            n /= base;
        }
        return palin;
    }
}
