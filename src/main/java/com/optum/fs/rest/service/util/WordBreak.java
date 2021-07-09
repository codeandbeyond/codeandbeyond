package com.optum.fs.rest.service.util;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String dictionary[] = {"mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i", "like", "ice", "cream"};
        WordBreak wordBreak = new WordBreak();
        String string = "ilikesamsung";
        System.out.println(wordBreak.wordBreak(dictionary, string));
        Set<String> dict = new HashSet<>();
        for (String word : dictionary) {
            dict.add(word);
        }
        int n = string.length();
        wordBreakPrint(string,n,"",dict);
    }

    private static void wordBreakPrint(String string, int n, String result,Set<String> dict) {
        for(int i=1;i<=n;i++){
            String prefix = string.substring(0,i);
            if(dict.contains(prefix)){
                if(i==n){
                    result=result+prefix;
                    System.out.println(result);
                    return;
                }
                wordBreakPrint(string.substring(i,n),n-i,result+prefix+"",dict);
            }
        }
    }

    private boolean wordBreak(String[] dictionary, String s) {
        Set<String> dict = new HashSet<>();
        for (String word : dictionary) {
            dict.add(word);
        }
        boolean[] wb = new boolean[s.length()+1];
        wb[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(wb[j] && dict.contains(s.substring(j,i))){
                    wb[i] = true;
                    break;
                }
            }
        }
        return wb[s.length()];
    }

}
