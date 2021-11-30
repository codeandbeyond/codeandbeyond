package com.optum.fs.rest.service.util.microsft.comany.preparation;

public class MinimumWindowWithAllTheCharacters {
    public static void main(String[] args) {
    String s = "abcdbcdmncd";
    String t = "cd";
    MinimumWindowWithAllTheCharacters minimumWindowWithAllTheCharacters = new MinimumWindowWithAllTheCharacters();
        System.out.println(minimumWindowWithAllTheCharacters.minWindow(s,t));
    }

    public String minWindow(String s, String t) {
        int[] count = new int[128];
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        int counter = t.length();
        while (end < s.length()) {
            char c = s.charAt(end);
            if (count[c] > 0) {
                counter--;
            }
            count[c]--;
            end++;
            while (counter == 0) {
                if (minLength > (end - start)) {
                    minLength = end - start;
                    minStart = start;
                }
                char c2 = s.charAt(start);
                count[c2]++;
                if (count[c2] > 0) {
                    counter++;
                }
                start++;
            }
        }
        return minLength != Integer.MAX_VALUE ? s.substring(minStart, minStart + minLength) : "";
    }
}
