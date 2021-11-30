package com.optum.fs.rest.service.util.leetcode;

public class IsAlienLanguageSorted {
    public static void main(String[] args) {
        IsAlienLanguageSorted isAlienLanguageSorted = new IsAlienLanguageSorted();
        String[] words = {"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        isAlienLanguageSorted.isAlienSorted(words, order);
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] charMap = new int[26];

        for (int i = 0; i < 26; i++) {
            charMap[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i], charMap) > 0) {
                return false;
            }
        }
        return true;
    }

    private int compare(String word1, String word2, int[] charMap) {
        int i = 0;
        int j = 0;

        int cmp = 0;
        while (i < word1.length() && j < word2.length() && cmp == 0) {

            cmp = charMap[word1.charAt(i) - 'a'] - charMap[word2.charAt(j) - 'a'];
            i++;
            j++;
        }
        if (cmp == 0) {
            return word1.length() - word2.length();
        } else {
            return cmp;
        }

    }
}
