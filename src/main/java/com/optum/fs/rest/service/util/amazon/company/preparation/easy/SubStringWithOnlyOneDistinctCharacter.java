package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

public class SubStringWithOnlyOneDistinctCharacter {
    int seqChar = '-';
    int seqLength = 0;
    int result = 0;

    public int countLetters(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == seqChar) {
                seqLength++;
            } else {
                seqChar = s.charAt(i);
                seqLength = 1;
            }
            result += seqLength;
        }
        return result;
    }

    public static void main(String[] args) {
        SubStringWithOnlyOneDistinctCharacter subStringWithOnlyOneDistinctCharacter = new SubStringWithOnlyOneDistinctCharacter();
        int length = subStringWithOnlyOneDistinctCharacter.countLetters("aaaba");
        System.out.println(" Length " + length);
    }
}
