package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

public class ReversedStringInWords {
    public static void main(String[] args) {
        ReversedStringInWords reversedStringInWords = new ReversedStringInWords();
        System.out.println(reversedStringInWords.reverseWords("Let's take LeetCode contest"));
    }
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String result = "";

        for(String word:words){
            char[] charArray = word.toCharArray();
            int a =0;int b = charArray.length-1;
            while(a<b){
                char temp = charArray[a];
                charArray[a] = charArray[b];
                charArray[b] = temp;
                a++;
                b--;
            }
            String rteversed  = new String(charArray);
            result += rteversed+" ";
        }
        return result.trim();
    }
}
