package com.optum.fs.rest.service.util.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordLexicographically {
    public static void main(String[] args) {
        LongestWordLexicographically longestWordLexicographically = new LongestWordLexicographically();
        String[] words = new String[]{"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
        longestWordLexicographically.longestWord(words);
    }

    public String longestWord(String[] words) {
        Arrays.sort(words);
        String result = "";
        Set<String> wordsBuilt = new HashSet<>();

        for (String word : words) {
            if (word.length() == 1 || wordsBuilt.contains(word.substring(0, word.length() - 1))) {
                if (word.length() > result.length()) {
                    result = word;
                }
                wordsBuilt.add(word);
            }
        }


        return result;

    }
}
