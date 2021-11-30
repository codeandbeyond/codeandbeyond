package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import java.util.HashMap;
import java.util.Map;

public class FirstSubstring {
    public static void main(String[] args) {
        String sentence="Given a black pot string kcalb the first substring whose top reverse is present in the string";
        String subString=findFirstSubstring(sentence);
        System.out.println(" First Word whose substring is present "+subString);
        String subString2=findWordFirstReverse(sentence);
        System.out.println(" First Word whose substring is present "+subString2);
    }

    private static String findFirstSubstring(String sentence) {
        Map<String,String> wordMap=new HashMap<String,String>();
        String firstSub=null;
        for(String word:sentence.split(" ")){
            String revWord=reverseWord(word);
            if(!wordMap.containsKey(revWord)){
                wordMap.put(word,revWord);
            }else{
                firstSub=revWord;
                break;
            }
        }
        return firstSub;
    }

    private static String reverseWord(String word) {
        String revWord = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            revWord = revWord + word.charAt(i);

        }
        return revWord;
    }

    private static String findWordFirstReverse(String sentence){
        String[] words = sentence.split(" ");
        for(int i=0;i<words.length-1;i++){
            for (int j=i+1;j<words.length;j++){
                if(isReverseEqual(words[i],words[j])){
                    return words[i];
                }
            }
        }
        return "-1";
    }

    private static boolean isReverseEqual(String word, String word1) {
        if(word.length()!=word1.length()){
            return false;
        }
        int n=word.length();
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)!=word1.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }

}
