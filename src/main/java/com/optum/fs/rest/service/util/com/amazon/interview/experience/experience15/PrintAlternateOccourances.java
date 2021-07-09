package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class PrintAlternateOccourances {
    public static void main(String[] args) {
        String str1 = "Geeks for geeks";
        String str2 = "It is a long day Dear";
        printStringAlternate(str1);
        printStringAlternate(str2);
    }

    private static void printStringAlternate(String str) {
        int countOcc[] = new int[256];

        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            countOcc[temp]++;

            if (countOcc[temp] % 2 != 0) {
                System.out.print(str.charAt(i));
            }
        }
        System.out.println("");
    }
}
