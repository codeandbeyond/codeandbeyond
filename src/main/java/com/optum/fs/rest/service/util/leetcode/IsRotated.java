package com.optum.fs.rest.service.util.leetcode;

public class IsRotated {
    public static void main(String[] args) {
       String a = "abcde";
       String b = "abced";
        System.out.println(rotateString(a,b));

    }
    public static boolean rotateString(String A, String B) {
       return (A+A).contains(B);
    }
}
