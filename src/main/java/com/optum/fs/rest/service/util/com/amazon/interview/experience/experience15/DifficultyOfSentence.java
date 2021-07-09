package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class DifficultyOfSentence {
    public static void main(String[] args) {
        String str = "We are geeks";
        System.out.println(calculateDifficulty(str));
    }

    private static int calculateDifficulty(String str) {
        int count_vowels = 0;
        int count_consonant = 0;
        int hard_words = 0;
        int easy_words = 0;
        int count_consec_consonant = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));

            if (!Character.isWhitespace(ch)  && isVowel(Character.toLowerCase(ch))) {
                count_vowels++;
            } else if (!Character.isWhitespace(ch)) {
                count_consonant++;
                count_consec_consonant++;

            }
            if (count_consec_consonant == 4) {
                hard_words++;
                while (i < str.length() - 1 && Character.toLowerCase(str.charAt(i)) != ' ') {
                    i++;
                }
                count_consonant = 0;
                count_vowels = 0;
                count_consec_consonant = 0;
            } else if (i < str.length() && (Character.toLowerCase(str.charAt(i)) == ' ' || i == str.length() - 1)) {
                if (count_consonant > count_vowels) {
                    hard_words++;
                } else {
                    easy_words++;
                }
                count_consonant = 0;
                count_vowels = 0;
                count_consec_consonant = 0;
            }
        }
        return 5*hard_words+3*easy_words;
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
