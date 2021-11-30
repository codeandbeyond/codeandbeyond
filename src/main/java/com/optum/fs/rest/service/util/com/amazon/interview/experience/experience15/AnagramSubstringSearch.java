package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class AnagramSubstringSearch {
    public static void main(String[] args) {
        String txt = "BACDGABCDA";
        String pat = "ABCD";
        search(pat, txt);
    }

    private static void search(String pat, String text) {
        int M = pat.length();
        int n = text.length();

        int[] countFreqPat = new int[256];
        int[] countFreqTxt = new int[256];

        for (int i = 0; i < M; i++) {
            countFreqPat[pat.charAt(i)]++;
            countFreqTxt[text.charAt(i)]++;
        }
        for (int i = M; i < n; i++) {
            if (compare(countFreqPat, countFreqTxt)) {
                System.out.println("Match found at " + (i - M));
            }
            countFreqTxt[text.charAt(i)]++;
            countFreqTxt[text.charAt(i-M)]--;

        }
        if(compare(countFreqPat,countFreqTxt)){
            System.out.println(" Match found at "+(n-M));
        }

    }

    private static boolean compare(int[] countFreqPat, int[] countFreqTxt) {
        for (int i = 0; i < 256; i++) {
            if (countFreqPat[i] != countFreqTxt[i])
                return false;

        }
        return true;
    }

}
