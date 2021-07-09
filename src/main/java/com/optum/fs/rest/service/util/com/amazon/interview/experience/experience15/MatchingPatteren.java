package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import java.util.HashMap;
import java.util.Map;

public class MatchingPatteren {
    public static void main(String[] args) {

        String[] dict = { "abb", "abc", "xyz", "xyy" };
        String pattern = "foo";

        findMatchedWords(dict, pattern);
    }

    private static void findMatchedWords(String[] dict, String pattern) {

        String hash = encode(pattern);
        for(String word : dict){
            if(hash.equals(encode(word))){
                System.out.print(word+" ");
            }
        }
    }
    private static String encode(String pat){
        String result = "";
        int i=0;
        Map<Character, Integer> hash = new HashMap<Character, Integer>();
        for(int j=0; j< pat.length();j++){
            if(!hash.containsKey(pat.charAt(j))){
                hash.put(pat.charAt(i),i++);
            }
            result=result+hash.get(pat.charAt(j));
        }
        return result;
    }
}
