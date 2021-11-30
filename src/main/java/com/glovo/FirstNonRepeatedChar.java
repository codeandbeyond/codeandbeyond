package com.glovo;

import java.util.Arrays;

public class FirstNonRepeatedChar {

    public void firStNonRepated(String word) {
        if (word == null || word.length() == 0) return;

        int[] count = new int[256];
        Arrays.fill(count, -1);

        for (int i = 0; i < word.length(); i++) {
            if (count[word.charAt(i)] == -1) {
                count[word.charAt(i)] = i;
            } else {
                count[word.charAt(i)] = -2;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++) {
            if (count[i] >= 0) {
                if (count[i] < min) {
                    min = count[i];
                }
            }
        }
        if (min != Integer.MAX_VALUE) {
            System.out.println(word.charAt(min));
        } else {
            System.out.println(" no char present");
        }
    }

    public static void main(String[] args) {
        FirstNonRepeatedChar firstNonRepeatedChar = new FirstNonRepeatedChar();
     firstNonRepeatedChar.firStNonRepated("ABCA");
      firstNonRepeatedChar.firStNonRepated("BCABAC");
        firstNonRepeatedChar.firStNonRepated("BAC");
        firstNonRepeatedChar.firStNonRepated("GlovoOnGlovo");
        firstNonRepeatedChar.firStNonRepated("What is the first non-repeated character?");
    }
}

//    Write an algorithm that returns the first non-repeated character in a string. For example:
//
//        1. firstNonRepeatedCharacter("ABCA") returns B
//        2. firstNonRepeatedCharacter("BCABAC") returns null
//        3. firstNonRepeatedCharacter("BAC") returns B
//        4. firstNonRepeatedCharacter("GlovoOnGlovo") returns O
//        5. firstNonRepeatedCharacter("What is the first non-repeated character?") returns W
