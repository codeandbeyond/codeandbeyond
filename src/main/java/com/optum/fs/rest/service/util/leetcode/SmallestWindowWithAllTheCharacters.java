package com.optum.fs.rest.service.util.leetcode;

import java.util.Arrays;

/**
 * Created by Ashok on 04-06-2020.
 */
public class SmallestWindowWithAllTheCharacters {
    public static void main(String[] args) {
        String str = "aabcbcdbca";
        System.out.println("Smallest width all the characters " + smallestWindow(str));
    }

    private static int smallestWindow(String str) {
        int n = str.length();
        boolean[] visited = new boolean[256];
        Arrays.fill(visited, false);
        int[] currCount = new int[256];
        int start = 0;
        int startIndex = -1;
        int distinctCount = 0;
        for (int i = 0; i < n; i++) {
            if (visited[str.charAt(i)] == false) {
                visited[str.charAt(i)] = true;
                distinctCount++;
            }
        }
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        for (int j = 0; j < n; j++) {
            currCount[str.charAt(j)]++;
            if (currCount[str.charAt(j)] == 1) {
                count++;
            }
            if (count == distinctCount) {
                while (currCount[str.charAt(start)] > 1) {
                    if (currCount[str.charAt(start)] > 1) {
                        currCount[str.charAt(start)]--;
                        start++;
                    }
                }
                int length = j - start + 1;
                if (length < minLength) {
                    minLength = length;
                    startIndex = start;
                }
            }
        }
        System.out.println(" " + str.substring(startIndex, startIndex + minLength));
        return minLength;
    }
}
