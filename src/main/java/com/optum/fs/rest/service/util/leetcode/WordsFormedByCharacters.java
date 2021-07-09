package com.optum.fs.rest.service.util.leetcode;

import java.util.Arrays;

public class WordsFormedByCharacters {
    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        System.out.println(countCharacters(words,chars));
    }

    public static int countCharacters(String[] words, String chars) {
        int[] wordFreq = new int[26];
        int[] charFreq = new int[26];
        int count = 0;
        for (char ch : chars.toCharArray()) {
            charFreq[ch - 'a']++;
        }
        for (String word : words) {
            Arrays.fill(wordFreq, 0);
            boolean isValid = true;
            for (char ch : word.toCharArray()) {
                wordFreq[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (charFreq[i] < wordFreq[i]) {
                    isValid = false;
                    break;
                }
            }
            if(isValid) count+=word.length();

        }
        return count;
    }
}
