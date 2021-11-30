package com.optum.fs.rest.service.util.leetcode;

public class LargestChunkedPalindrome {
    public static void main(String[] args) {
        LargestChunkedPalindrome largestChunkedPalindrome = new LargestChunkedPalindrome();
        String currentStr = "ghiabcdefhelloadamhelloabcdefghi";
        String str = "ghiabcdefhelloadamhelloabcdefghi";
        System.out.println(largestChunkedPalindrome.lcp(currentStr, 0, 0, str));
    }

    private int lcp(String currentStr, int length, int count, String str) {
        if (currentStr == null || currentStr.isEmpty()) return 0;
        if (currentStr.length() <= 1) {
            if (count != 0 && str.length() - length <= 1) {
                return count + 1;
            } else {
                return 1;
            }
        }
        int n = currentStr.length();
        for (int i = 0; i < n / 2; i++) {
            if (currentStr.substring(0, i + 1).equals(currentStr.substring(n - i - 1, n))) {
                return lcp(currentStr.substring(i + 1, n - i - 1), (i + 1) * 2,count + 2, str);
            }
        }
        return count + 1;
    }
}
