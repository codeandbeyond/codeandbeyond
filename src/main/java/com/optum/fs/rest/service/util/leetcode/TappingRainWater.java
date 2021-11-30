package com.optum.fs.rest.service.util.leetcode;

public class TappingRainWater {

    public static void main(String[] args) {
        int arr[] = new int[]{4,2,0,3,2,5};
        System.out.println("Maximum water that can be accumulated is " + maxArea(arr));

    }

    public static int maxArea(int[] height) {
        int aPointer = 0;
        int bPointer = height.length - 1;
        int maxArea = 0;

        while (aPointer < bPointer) {
            if (height[aPointer] < height[bPointer]) {
                maxArea = Math.max(maxArea, height[aPointer] * (bPointer - aPointer));
                aPointer += 1;
            } else {
                maxArea = Math.max(maxArea, height[bPointer] * (bPointer - aPointer));
                bPointer -= 1;
            }
        }
        return maxArea;
    }


}
