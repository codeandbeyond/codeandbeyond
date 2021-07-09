package com.optum.fs.rest.service.util.leetcode;

public class PalindromePermutation {
    public static void main(String[] args) {
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        palindromePermutation.palindromPermute("madam");
    }

    public boolean palindromPermute(String string) {
        int[] charCount = new int[128];
        int count = 0;
        for (char c : string.toCharArray()) {
            charCount[c]++;
        }

        for (int i = 0; i < 128; i++) {
            count += charCount[i] % 2;
        }
        return count <= 1;
    }
}
