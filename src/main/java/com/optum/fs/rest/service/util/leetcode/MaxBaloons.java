package com.optum.fs.rest.service.util.leetcode;

public class MaxBaloons {
    public static void main(String[] args) {
        MaxBaloons maxBaloons = new MaxBaloons();
        String text = "leetcode";
        maxBaloons.maxNumberOfBalloons(text);
    }

    public int maxNumberOfBalloons(String text) {
        int[] charCount = new int[26];
        int maxBaloons = 0;
        for (int i = 0; i < text.length(); i++) {
            charCount[text.charAt(i) - 'a']++;
        }
        maxBaloons = charCount[1];
        maxBaloons = Math.min(charCount[0], maxBaloons);
        maxBaloons = Math.min(charCount[11] / 2, maxBaloons);
        maxBaloons = Math.min(charCount[14] / 2, maxBaloons);
        maxBaloons = Math.min(charCount[13], maxBaloons);

        return maxBaloons;

    }
}
