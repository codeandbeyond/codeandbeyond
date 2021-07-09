package com.optum.fs.rest.service.util.leetcode;

import java.util.Arrays;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        System.out.println(firstUniqueCharacter.firstUniqChar("lovelove"));
    }

    public int firstUniqChar(String s) {
        int[] charIndex = new int[26];
        Arrays.fill(charIndex, -1);
        for (int i = 0; i < s.length(); i++) {
            if (charIndex[s.charAt(i) - 'a'] == -1) {
                charIndex[s.charAt(i) - 'a'] = i;
            } else {
                charIndex[s.charAt(i) - 'a'] = -2;
            }
        }
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (charIndex[i] >= 0) {
                minIndex = Math.min(minIndex, charIndex[i]);
            }
        }
        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }
}
