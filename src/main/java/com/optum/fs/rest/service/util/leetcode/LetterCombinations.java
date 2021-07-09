package com.optum.fs.rest.service.util.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {
    public static void main(String[] args) {
        letterCombinations("234");
    }

    public static List<String> letterCombinations(String digits) {
            List<String> results = new LinkedList<>();

            if (digits.length() == 0) return results;
            String[] charMap = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            results.add("");
        for (int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));//23-->2-->"abc",3--"def"
            while (((LinkedList<String>) results).peek().length() == i) {
                String permutation = ((LinkedList<String>) results).remove();

                for (char c : charMap[index].toCharArray()) {
                    results.add(permutation + c);
                }
            }
        }
        return results;

    }
}
