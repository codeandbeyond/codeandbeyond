package com.optum.fs.rest.service.util.microsft.comany.preparation;

public class WildCardMatching {
    public static void main(String[] args) {
        String s = "adceb";
        String p = "*a*b";
    }
    public boolean isMatch(String s, String p){
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;

        for(int i=1;i<=sLen;i++){
            dp[i][0] = false;
        }
        for(int j=1;j<=pLen;j++){
           if(p.charAt(j-1) == '*'){
               dp[0][j] = dp[0][j-1];
           }
        }

        for(int i=1;i<=sLen;i++){
            for(int j=1;j<=pLen;j++){
                if((s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') && dp[i-1][j-1]){
                    dp[i][j] = true;
                }else if((p.charAt(j-1) == '*') && (dp[i-1][j] || dp[i][j-1])){
                    dp[i][j] = true;

                }
            }
        }
        return dp[sLen][pLen];
    }
}
