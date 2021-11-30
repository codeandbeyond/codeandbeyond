package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import java.util.ArrayList;
import java.util.List;

public class PrintCombinationWithN {
    public static void main(String[] args) {
        int d = 4;
        int n = 3;
        List<Integer> resultList = new ArrayList<>();
        PrintCombinationWithN printCombinationWithN = new PrintCombinationWithN();
        printCombinationWithN.printCombination(d, n, resultList, (n - d) + 1, n + d);
    }

    private void printCombination(int d, int n, List<Integer> resultList, int leftBoundary, int rightBoundary) {
        if (d < leftBoundary || d > rightBoundary)
            return;
        resultList.add(d);

        if (resultList.size() == n) {
            System.out.print(resultList);
            resultList.remove(resultList.size() - 1);
            return;
        }


        printCombination(d - 1, n, resultList, leftBoundary, rightBoundary);
        printCombination(d + 1, n, resultList, leftBoundary, rightBoundary);
        resultList.remove(resultList.size() - 1);
    }
}
