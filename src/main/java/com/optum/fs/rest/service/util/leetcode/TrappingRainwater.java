package com.optum.fs.rest.service.util.leetcode;

public class TrappingRainwater {
    public static void main(String[] args) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainwater tappingRainWater = new TrappingRainwater();
        System.out.println(tappingRainWater.findTrappedRainwater(arr));
    }

    private int findTrappedRainwater(int[] arr) {
        int water = 0;
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
           if(arr[i]>max){
               max = arr[i];
               maxIndex = i;
           }
        }
        int leftMax = arr[0];
        for (int i = 1; i < maxIndex; i++) {
            if (arr[i] > leftMax) {
                leftMax = arr[i];
            } else {
                water += leftMax - arr[i];
            }
        }
        int rightMax = arr[arr.length - 1];
        for (int i = arr.length - 2; i > maxIndex; i--) {
            if (arr[i] > rightMax) {
                rightMax = arr[i];
            } else {
                water += rightMax - arr[i];
            }
        }
        return water;
    }
}
