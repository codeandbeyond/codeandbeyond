package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.Arrays;

public class MaxAreaPieceOfCake {
    public static void main(String[] args) {
        MaxAreaPieceOfCake maxAreaPieceOfCake = new MaxAreaPieceOfCake();
        int h = 5;
        int w = 4;
        int[] horizontalCuts = {1, 2, 4};
        int[] verticalCuts = {1, 3};

        System.out.println(maxAreaPieceOfCake.maxArea(h, w, horizontalCuts, verticalCuts));
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int maxH = 0;
        int maxV = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for (int i = 0; i < horizontalCuts.length; i++) {
            maxH = Math.max(maxH, i == 0 ? horizontalCuts[i] : horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        maxH = Math.max(maxH, h - horizontalCuts[horizontalCuts.length - 1]);
        for (int j = 0; j < verticalCuts.length; j++) {
            maxV = Math.max(maxV, j == 0 ? verticalCuts[j] : verticalCuts[j] - verticalCuts[j - 1]);
        }
        maxV = Math.max(maxV, w - verticalCuts[verticalCuts.length - 1]);

        return maxH * maxV;
    }
}
