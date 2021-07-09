package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

public class No3ConsecutiveLetterMinMoves {
    private int minMoves(String s){
        int res = 0;
        for(int i=0;i<s.length();){
            int right = i+1;
            while (right<s.length() && s.charAt(i) == s.charAt(right)) right++;

            res+=(right-i)/3;
            i = right;
        }
        return res;
    }

    public static void main(String[] args) {
        No3ConsecutiveLetterMinMoves no3ConsecutiveLetter = new No3ConsecutiveLetterMinMoves();
        int res = no3ConsecutiveLetter.minMoves("eedaaad");
        System.out.println(res);
    }
}
