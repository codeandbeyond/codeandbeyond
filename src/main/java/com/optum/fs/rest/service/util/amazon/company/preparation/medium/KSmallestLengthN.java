package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.ArrayList;
import java.util.List;

public class KSmallestLengthN {
   static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        KSmallestLengthN kSmallestLengthN = new KSmallestLengthN();
        kSmallestLengthN.dfs(2,20,new StringBuilder());
        for(String s: result){
            System.out.println(s);
        }
    }
    public void dfs(int n, int k,StringBuilder sb){
       if(result.size() == k) return ;
       if(sb.length() == n){
           result.add(sb.toString());
           return;
       }

       for(int i=0;i<"abc".length();i++){
           if(sb.length() == 0 || sb.charAt(sb.length()-1) != "abc".charAt(i) ){
               sb.append("abc".charAt(i));
               dfs(n,k,sb);
               sb.deleteCharAt(sb.length()-1);
           }
       }
    }
}
