package com.optum.fs.rest.service.util.leetcode;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        longestRepeatingCharacterReplacement.characterReplacement("AABABBA", 2);
    }

    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int left = 0;
        int charCount[] = new int[26];
        int maxCount = 0;
        int n = s.length();

        for (int right = 0; right < n; right++) {
            charCount[s.charAt(right) - 'A']++;
            char lastChar = s.charAt(right);
            maxCount = Math.max(maxCount, charCount[lastChar - 'A']);

            while (right - left - maxCount + 1 > k) {
                charCount[s.charAt(left)-'A']--;
                left++;
            }
            maxLength = Math.max(right - left + 1, maxLength);
        }
        return maxLength;

    }

}
