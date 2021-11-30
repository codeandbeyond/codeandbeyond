package com.optum.fs.rest.service.util.leetcode;

public class UncommonCharacters {
    public static void main(String[] args) {
        UncommonCharacters uncommonCharacters = new UncommonCharacters();
        String s1 = "geeksforgeeks";
        String str2 = "geeksquiz";
        uncommonCharacters.findUncommon(s1, str2);

    }

    public void findUncommon(String s, String t) {
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a'] = 1;
        }
        for (int j = 0; j < t.length(); j++) {
            if (charCount[t.charAt(j) - 'a'] == 1 || charCount[t.charAt(j) - 'a'] == -1) {
                charCount[t.charAt(j) - 'a'] = -1;
            } else {
                charCount[t.charAt(j) - 'a'] = 2;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (charCount[i] > 0) {
                System.out.print((char) (i + 'a') + " ");
            }
        }


    }
}
