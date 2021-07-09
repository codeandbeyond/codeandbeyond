package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

public class LexicographicallySmallest {
    public static void main(String[] args) {
        String s = "abczd";
        System.out.println(smallestString(s));
        String s1 = "abcda";
        System.out.println(smallestString(s1));

    }

    public static String smallestString(String s) {
        int i = 0;
        for (; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                break;
            }
        }
        return s.substring(0, i) + s.substring(i + 1);
    }
}
