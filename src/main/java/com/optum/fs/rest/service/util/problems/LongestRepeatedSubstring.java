package com.optum.fs.rest.service.util.problems;

public class LongestRepeatedSubstring {
    public static void main(String[] args) {
        /*String text = "to be or not to be";*/
        String text = "banana";
        text = text.replaceAll("\\s+", "");
        int n = text.length();
        SuffixArray sa = new SuffixArray(text);
        String lrs = "";
        for (int i = 0; i < n - 1; i++) {
            int length = sa.lcp(i);
            if (length > lrs.length()) {
                // lrs = sa.select(i).substring(0, length);
                lrs = text.substring(sa.index(i), sa.index(i) + length);
            }
        }
        System.out.println(lrs);
    }

}
