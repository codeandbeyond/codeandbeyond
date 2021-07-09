package com.optum.fs.rest.service.util.leetcode;

import java.util.Arrays;
import java.util.List;

public class PalindromPairs {
    public static void main(String[] args) {
        PalindromPairs pairs = new PalindromPairs();
        List<String> list = Arrays.asList("geekf", "geeks", "or",
                "keeg", "abc", "bc");
        System.out.println(pairs.find(list));
    }

    private boolean find(List<String> list) {
        for(int i=0;i<list.size()-1;i++){
            for(int j=i+1;j<list.size();j++){
                String checkPalin = ""+list.get(i)+list.get(j);
                if(isPalindrome(checkPalin)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isPalindrome(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
