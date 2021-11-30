package com.optum.fs.rest.service.util.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PrintPalindromePartiton {
    public static void main(String[] args) {
        PrintPalindromePartiton printPalindromePartiton = new PrintPalindromePartiton();
        String s = "geek";
        printPalindromePartiton.print(s);
    }

    private void print(String s) {
        List<List> solutions = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        backTrackHelper(s, solutions, tempList, 0);
        for(List solution:solutions){
            System.out.println(solution);
        }
    }

    private void backTrackHelper(String s, List<List> solutions, List<String> tempList, int start) {
        if (start == s.length()) {
            solutions.add(new ArrayList(tempList));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tempList.add(s.substring(start,i+1));
                    backTrackHelper(s,solutions,tempList,i+1 );
                    tempList.remove(tempList.size()-1);
                }
            }
        }

    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;

        }
        return true;
    }
}
