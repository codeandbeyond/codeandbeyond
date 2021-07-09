package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class AddingBinaryStrings {
    public static void main(String[] args) {
        String a = "11";
        String b = "11";
        String result = addBinaryStrings(a, b);
        System.out.print(" Result "+result);
    }

    private static String addBinaryStrings(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        String result = "";
        int s = 0;

        while (i >= 0 || j >= 0 || s == 1) {

            s = s + (i >= 0 ? a.charAt(i) - '0' : 0);
            s = s + (j >= 0 ? b.charAt(j) - '0' : 0);

            result = (char) (s % 2 + '0') + result;
            s = s / 2;

            i--;j--;
        }
        return result;
    }
}
