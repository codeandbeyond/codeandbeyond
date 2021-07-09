package com.optum.fs.rest.service.util.leetcode;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
    public  static String countAndSay(int n) {
        StringBuilder s = new StringBuilder("1");
        for (int i = 0; i < n-1; ++i) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char c = s.charAt(0);
            s.append("a"); // dummy to collect the last;
            for (int j = 1; j < s.length(); ++j) {
                if (s.charAt(j) == c) {
                    count++;
                } else {
                    sb.append("" + count + c);
                    count = 1;
                    c = s.charAt(j);
                }
            }
            s = sb;
        }
        return s.toString();
    }
}

