package com.optum.fs.rest.service.util.leetcode;

public class PeakIndex {
    public static void main(String[] args) {
        PeakIndex peakIndex = new PeakIndex();
        peakIndex.peakIndexInMountainArray(new int[]{0,2,1,0});
    }
    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length-1;
        while(left < right){
            int midPoint = left + (right-left)/2;
            if(A[midPoint] < A[midPoint+1]){
                left = midPoint+1;
            }else{
                right = midPoint;
            }
        }
        return left;
    }
}
