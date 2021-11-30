package com.optum.fs.rest.service.util.leetcode;

public class IsSubSequence {
    public static void main(String[] args) {
        IsSubSequence isSubSequence = new IsSubSequence();
        String s = "aec";
        String t = "abcde";
        isSubSequence.isSubsequence(s, t);
    }

    public boolean isSubsequence(String s, String t) {

        if (t.length() < s.length()) return false;
        if (t.equals(s)) return true;
        if ((s.length() == 0) && t.length() == 0) return true;

        int sPointer = 0;
        int tPointer = 0;
        while (sPointer < s.length() && tPointer < t.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
                tPointer++;
            } else {
                tPointer++;
            }
        }
        if (sPointer != s.length())
            return false;
        return true;

    }
}
