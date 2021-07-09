package com.optum.fs.rest.service.util.microsft.comany.preparation;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "  Bob    Loves  Alice   ";
        System.out.println(reverseWords(s));
    }

    private static String reverseWords(String s) {
        if (s == null) return s;
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length();

        reverseArray(chars, left, right - 1);
        reverseWord(chars, right);
        return cleanUpspaces(chars, right);
    }

    private static String cleanUpspaces(char[] chars, int right) {
        int i = 0;
        int j = 0;
        while (j < right) {
            while (j < right && chars[j] == ' ') j++;
            while (j < right && chars[j] != ' ') chars[i++] = chars[j++];
            while (j < right && chars[j] == ' ') j++;
            if (j < right) {
                chars[i++] = ' ';
            }
        }
        return new String(chars).substring(0, i);
    }

    private static void reverseWord(char[] chars, int right) {
        int i = 0;
        int j = 0;
        while (i < right) {
            while (i < j || i < right && chars[i] == ' ') i++;
            while (j < i || j < right && chars[j] != ' ') j++;
            reverseArray(chars, i, j - 1);
        }
    }

    private static void reverseArray(char[] chars, int left, int right) {
        while (left <= right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
