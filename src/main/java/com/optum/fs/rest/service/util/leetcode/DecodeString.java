package com.optum.fs.rest.service.util.leetcode;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
    String str = "2[abc]3[cd]ef";
    DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString(str));
    }
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack();
        Stack<String> resultStack = new Stack();
        String res = "";

        int index = 0;

        while(index < s.length()){


            if(Character.isDigit( s.charAt(index))){
                int count = 0;
                while (Character.isDigit(s.charAt(index))){
                    count = 10 * count + s.charAt(index)-'0';
                    index++;
                }
                countStack.push(count);
            }else if (s.charAt(index) == '[') {
                resultStack.push(res);
                res = "";
                index+=1;
            }else if(s.charAt(index) == ']'){
                StringBuilder sb = new StringBuilder(resultStack.pop());
                int count = countStack.pop();

                for(int i=0;i<count;i++){
                    sb.append(res);
                }
                res = sb.toString();
                index+=1;
            }else{
                res+=s.charAt(index);
                index+=1;
            }

        }
        return res;

    }
}
