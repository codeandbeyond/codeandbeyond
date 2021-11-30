package com.optum.fs.rest.service.util.leetcode;

public class BackSpaceCompare {
    public static void main(String[] args) {
        String T = "ac#b";
        String S = "abb#";
        System.out.println(backSpaceCompare(S, T));
    }

    private static boolean backSpaceCompare(String s, String t) {
        int sPointer = s.length() - 1;
        int tPointer = t.length() - 1;

        int sSkips = 0;
        int tSkips = 0;

        while (sPointer >= 0 || tPointer >= 0) {

            while (sPointer >= 0) {
                if (s.charAt(sPointer) == '#') {
                    sSkips += 1;
                    sPointer -= 1;
                } else if (sSkips > 0) {
                    sPointer -= 1;
                    sSkips -= 1;
                } else {
                    break;
                }
            }
            while (tPointer >= 0) {
                if (t.charAt(tPointer) == '#') {
                    tSkips += 1;
                    tPointer -= 1;
                } else if (tSkips > 0) {
                    tPointer -= 1;
                    tSkips -= 1;
                } else {
                    break;
                }
            }
            if (sPointer >= 0 && tPointer >= 0 && s.charAt(sPointer) != t.charAt(tPointer)) {
                return false;
            }
            if ((sPointer >= 0) != (tPointer >= 0)) {
                return false;
            }
            sPointer -= 1;
            tPointer -= 1;
        }
        return true;

    }
}
