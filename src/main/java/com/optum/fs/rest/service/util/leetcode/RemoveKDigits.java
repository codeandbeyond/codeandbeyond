package com.optum.fs.rest.service.util.leetcode;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        String s = "1432219";
        System.out.println(" "+removeKdigits(s,3));
        String s1 = "54321";
        System.out.println(" "+removeKdigits(s1,2));
        String s2 = "111111";
        System.out.println(" "+removeKdigits(s2,3));
        String s3 = "1111";
        System.out.println(" "+removeKdigits(s3,5));
        String s4 = "10";
        System.out.println(" "+removeKdigits(s4,2));
    }
    public  static String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int size = num.length();
        int counter = 0;
        while(counter < size){
            while(k>0 && !stack.isEmpty() && stack.peek() > num.charAt(counter)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(counter));
            counter++;
        }
        while( k >0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        while(sb.length() > 1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }

        return sb.toString();

    }
}
