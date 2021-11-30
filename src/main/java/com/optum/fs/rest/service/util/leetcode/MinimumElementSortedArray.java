package com.optum.fs.rest.service.util.leetcode;

public class MinimumElementSortedArray {;
    public static void main(String[] args) {
        MinimumElementSortedArray minimumElementSortedArray= new MinimumElementSortedArray();
        int[] nums = new int[]{2,1};
        minimumElementSortedArray.findMin(nums);
    }
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(mid>0 && nums[mid]<nums[mid-1]){
                return nums[mid];
            }else if(nums[mid] >= nums[left] && nums[mid] > nums[right]){
                left= mid+1;
            }else{
                right = mid -1;
            }
        }
        return nums[left];

    }
}
