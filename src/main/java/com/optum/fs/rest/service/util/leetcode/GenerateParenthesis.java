package com.optum.fs.rest.service.util.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        int n = 3;
       List<String> result = generateParenthesis.generateParenthesis(n);
       for(String string:result){
           System.out.println(string);
       }
    }

    public List<String> generateParenthesis(int n) {

        List<String> output = new ArrayList<>();
        backTrack(output, "", 0, 0, n);
        return output;

    }

    private void backTrack(List<String> output, String currentString, int open, int close, int max) {
        if (currentString.length() == 2 * max) {
            output.add(currentString);
            return;
        }

        if (open < max) backTrack(output, currentString + "(", open + 1, close, max);
        if (close < open) backTrack(output, currentString + ")", open, close + 1, max);
    }

}

