package com.optum.fs.rest.service.util.leetcode;

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        String s = "2-5g-3-J";
        int K = 2;
        System.out.println(formatLicense(s, K));
    }

    private static String formatLicense(String S, int K) {
       S = S.replace("-","");
       S = S.toUpperCase();
       StringBuilder sb = new StringBuilder(S);
       int i = sb.length()-K;
       while (i>0){
           sb.insert(i,'-');
           i = i-K;
       }
       return sb.toString();
    }
}
