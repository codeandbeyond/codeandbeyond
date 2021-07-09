package com.optum.fs.rest.service.util.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] str = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(str));
        isValid("()");
    }


    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (start < strs[0].length()) {
            char startChar = strs[0].charAt(start);
            for (int i = 1; i < strs.length; i++) {
                String str = strs[i];
                if (start >= str.length() || str.charAt(start) != startChar) return sb.toString();
            }
            sb.append(startChar);
            start++;
        }
        return sb.toString();

    }
    public static boolean isValid(String s) {
        if(s.length()==0 || s.length()==1){
            return false;
        }
        Map<Character,Character> symbolMap = new HashMap<>();
        symbolMap.put('{','}');
        symbolMap.put('[',']');
        symbolMap.put('(',')');
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='{' || ch == '[' || ch=='('){
                stack.push(ch);
            }else if(ch == '}' || ch == ']' || ch==')'){
                if(stack.isEmpty()){
                    return false;
                }
                char popped = symbolMap.get(stack.pop());
                if(popped!=ch){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}

