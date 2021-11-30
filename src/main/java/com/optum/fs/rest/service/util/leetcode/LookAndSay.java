package com.optum.fs.rest.service.util.leetcode;

public class LookAndSay {
    public static void main(String[] args) {
        LookAndSay lookAndSay = new LookAndSay();
        System.out.println(lookAndSay.countAndSay(5));

    }

    private String countAndSay(int num) {
        StringBuilder result = new StringBuilder();
        result.append("1");
        for (int i = 0; i < num - 1; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            int count = 1;
            char c = result.charAt(0);
            result.append("a");
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == c) {
                    count++;
                } else {
                    stringBuilder.append("" + count + c);
                    count = 1;
                    c = result.charAt(j);
                }
            }
            result = stringBuilder;
        }
        return result.toString();
    }
}
