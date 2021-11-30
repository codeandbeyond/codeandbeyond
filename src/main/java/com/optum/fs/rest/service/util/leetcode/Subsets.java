package com.optum.fs.rest.service.util.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] arr = {1, 2, 3};
        List<List> solutions = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        subsets.printAllSubsets(arr, 0, solutions, tempList);
    }

    private void printAllSubsets(int[] arr, int start, List<List> solutions, List<Integer> tempList) {
        solutions.add(new ArrayList(tempList));
        for (int i = start; i < arr.length; i++) {
            tempList.add(arr[i]);
            printAllSubsets(arr, i + 1, solutions, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}
