package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

public class MinDeletionValidPalindrome {
    public int minInsertions(String s) {
        if (s.length() <= 1) return 0;
        int oddCount = 0;

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            int countOfchar = count[i];
            if (countOfchar != 0 && countOfchar % 2 != 0) {
                oddCount++;
            }
        }
        if (oddCount <= 1) {
            return 0;
        } else if (oddCount % 2 != 0) {
            return oddCount;
        } else {
            return oddCount - 1;

        }

    }

    public static void main(String[] args) {
        MinDeletionValidPalindrome minDeletionValidPalindrome = new MinDeletionValidPalindrome();
       int res =  minDeletionValidPalindrome.minInsertions("leetcode");
        System.out.println(res);

    }
}
