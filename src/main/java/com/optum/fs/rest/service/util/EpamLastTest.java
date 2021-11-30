package com.optum.fs.rest.service.util;

public class EpamLastTest {
    public boolean isPalindrome(String str){
        if(str == null || str.length() == 0) return false;
        boolean isPalindrome = palindrome(str);
        int[] count = new int[26];
        if(!isPalindrome){
           for(char c:str.toCharArray()){
               count[c-'a']++;
           }
           int oddCount = 0;
           for(int counts:count){
               if(counts%2!=0){
                   oddCount++;
               }
           }
           return oddCount<=1;
        }
        return true;
    }

    private boolean palindrome(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length-1;
        while(left < right){
            if(charArray[left]!=charArray[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        EpamLastTest test = new EpamLastTest();
        System.out.println(test.isPalindrome("aba"));
        System.out.println(test.isPalindrome("abbad"));
        System.out.println(test.isPalindrome("adbba"));
        System.out.println(test.isPalindrome("abbade"));
        String str = "((metadata.form_data.State=OR)OR(metadata.form_data.LOB=Medicare%20Advantage)AND(metadata.form_data.State=OR)OR(metadata.form_data.LOB=Medicare%20Advantage))";
        System.out.println(parse(str));
        
    }

    private static String parse(String expression) {

        expression = expression.replace(")OR(",")|(");
        expression = expression.replace(")AND(",")+(");
        expression = expression.replace("<>","!=");
        return expression;
    }
}
