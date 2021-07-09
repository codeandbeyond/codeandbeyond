package com.optum.fs.rest.service.util.leetcode;

public class NumberOfLines {
    public static void main(String[] args) {
        int[] widths = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String s = "abcdefghijklmnopqrstuvwxyz";
        NumberOfLines numberOfLines = new NumberOfLines();
        int[] result = numberOfLines.numberOfLines(widths, s);
        for (Integer num : result) {
            System.out.print(" " + num);
        }
    }

    public int[] numberOfLines(int[] widths, String S) {
        int width = 0;
        int numOfLines = 1;
        int[] result = new int[2];
        for (int i = 0; i < S.length(); i++) {
            int charWidth = widths[S.charAt(i) - 'a'];
            if (width + charWidth > 100) {
                numOfLines++;
                width = 0;
            }
            width += charWidth;
        }
        result[0] = numOfLines;
        result[1] = width;

        return result;
    }
}
