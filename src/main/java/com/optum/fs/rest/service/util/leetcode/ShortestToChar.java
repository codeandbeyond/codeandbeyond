package com.optum.fs.rest.service.util.leetcode;

public class ShortestToChar {
    public static void main(String[] args) {
        ShortestToChar shortestToChar = new ShortestToChar();
        String S = "loveleetcode";
        char c = 'e';
        shortestToChar.shortestToChar(S, c);
    }

    public int[] shortestToChar(String S, char c) {

        int[] outPutArr = new int[S.length()];

        int cPosition = -S.length();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == c) {
                cPosition = i;
            }
            outPutArr[i] = i - cPosition;
        }

        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == c) {
                cPosition = i;
            }
            outPutArr[i] = Math.min(Math.abs(outPutArr[i]), Math.abs(i - cPosition));
        }
        return outPutArr;

    }
}
