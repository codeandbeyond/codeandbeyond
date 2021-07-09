package com.optum.fs.rest.service.util.problems;

import java.util.ArrayList;
import java.util.List;

public class Permutaion {
    public static void main(String[] args) {
        String s = "ASH";
        permutation("", s);
        permute(s);
        int[] nums = {1,2,3};
        permutationBackTrack(nums);
    }

    public static void permute(String input) {
        int inputLength = input.length();
        boolean[] used = new boolean[inputLength];
        StringBuffer outputString = new StringBuffer();
        char[] in = input.toCharArray();

        doPermute(in, outputString, used, inputLength, 0);

    }

    static void doPermute(char[] in, StringBuffer outputString, boolean[] used,
                          int inputlength, int level) {
        if (level == inputlength) {
            System.out.println(outputString.toString());
            return;
        }

        for (int i = 0; i < inputlength; ++i) {

            if (used[i])
                continue;

            outputString.append(in[i]);
            used[i] = true;
            doPermute(in, outputString, used, inputlength, level + 1);
            used[i] = false;
            outputString.deleteCharAt(outputString.length() - 1);
        }
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }

    private static void permutationBackTrack(int[] nums) {
        List<List> solutions = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backTrackHelper(nums, solutions, tempList);
        for(List solution:solutions){
            System.out.println(solution);
        }
    }

    private static void backTrackHelper(int[] nums, List<List> solution, List<Integer> tempList) {
        if (tempList.size() == nums.length) {
            solution.add(new ArrayList(tempList));

        } else {
            for (int i = 0; i < nums.length; i++) {
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backTrackHelper(nums, solution, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
