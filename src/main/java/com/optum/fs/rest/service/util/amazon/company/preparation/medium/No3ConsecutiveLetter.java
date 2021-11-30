package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

public class No3ConsecutiveLetter {
    public int maxLenSubStr(String s) {
        if (s.length() < 3) return s.length();
        int temp = 2;
        int ans = 2;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1) || s.charAt(i) != s.charAt(i - 2)) {
                temp++;
                sb.append(s.charAt(i));
            } else {
                ans = Math.max(ans, temp);
                temp = 2;
            }
        }
        System.out.println(sb.toString());
        return Math.max(ans, sb.length());
    }

    public static void main(String[] args) {
        No3ConsecutiveLetter no3ConsecutiveLetter = new No3ConsecutiveLetter();
        int res = no3ConsecutiveLetter.maxLenSubStr("eedaaad");
        System.out.println(res);
    }
}
