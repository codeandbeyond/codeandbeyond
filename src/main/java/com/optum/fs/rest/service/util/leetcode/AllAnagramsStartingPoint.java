package com.optum.fs.rest.service.util.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllAnagramsStartingPoint {
    public static void main(String[] args) {
        AllAnagramsStartingPoint allAnagramsStartingPoint = new AllAnagramsStartingPoint();
        String s = "cbaebabacd";
        String p = "abc";
//        for (Integer index : allAnagramsStartingPoint.findAnagrams(s, p)) {
//            System.out.print(" Index " + index);
//        }
        allAnagramsStartingPoint.findAnagramsDifferent(s,p);

    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] charCount = new int[26];

        for (int i = 0; i < p.length(); i++) charCount[p.charAt(i) - 'a']++;

        List<Integer> retList = new ArrayList<>();


        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {

            if (charCount[s.charAt(right) - 'a'] >= 1) {
                count--;
            }
            charCount[s.charAt(right) - 'a']--;
            right++;

            if (count == 0) retList.add(left);

            if (right - left == p.length()) {
                if (charCount[s.charAt(left) - 'a'] >= 0) {

                    count++;
                }
                charCount[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return retList;
    }

    public void findAnagramsDifferent(String word, String pat) {
        int[] patCharCount = new int[26];
        int[] wordCharCount = new int[26];
        int numberOfAnagrams = 0;
        int M = pat.length();
        int N = word.length();
        for (int i = 0; i < M; i++) {
            patCharCount[pat.charAt(i) - 'a']++;
            wordCharCount[word.charAt(i) - 'a']++;

        }
        for (int i = M; i < N; i++) {
            if (comapre(wordCharCount, patCharCount)) {
                System.out.print(" Index " + (i - M));
                numberOfAnagrams++;
            }

            wordCharCount[word.charAt(i) - 'a']++;
            wordCharCount[word.charAt(i-M) - 'a']--;
        }
        if (comapre(wordCharCount, patCharCount)) {
            numberOfAnagrams++;
            System.out.print(" Index " + (N - M));
        }
        System.out.println(" Number of Anagrams "+numberOfAnagrams);

    }

    private boolean comapre(int[] wordCharCount, int[] patCharCount) {
        for (int i = 0; i < patCharCount.length; i++) {
            if (patCharCount[i] != wordCharCount[i]) {
                return false;
            }
        }
        return true;
    }
}
