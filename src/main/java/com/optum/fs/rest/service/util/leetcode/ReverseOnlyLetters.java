package com.optum.fs.rest.service.util.leetcode;

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        String str = "a-bC-dEf-ghIj";
        String reversed = reverseOnlyLetters(str);
        System.out.println(reversed);
        String string = "A man, a plan, a canal: Panama";
         isPalindrome(string);
    }

    private static String reverseOnlyLetters(String str) {
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (Character.isLetter(arr[left]) && Character.isLetter(arr[right])) {
                exchange(arr, left, right);
                left++;
                right--;
            }
            if (!Character.isLetter(arr[left])) {
                left++;
            }
            if (!Character.isLetter(arr[right])) {
                right--;
            }
        }
        return new String(arr);
    }

    private static void exchange(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))|| Character.isLetter(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        s = sb.toString();
        int left = 0;
        int right = s.length()-1;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
