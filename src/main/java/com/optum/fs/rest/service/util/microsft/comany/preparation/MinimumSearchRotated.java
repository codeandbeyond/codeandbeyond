package com.optum.fs.rest.service.util.microsft.comany.preparation;

public class MinimumSearchRotated {
    public int findMin(int[] nums) {
        int lo = 0;
        int high = nums.length-1;
        while(lo<=high){
            int mid = lo+(high-lo)/2;
            if(mid > 0 && nums[mid-1] > nums[mid]){
                return mid;
            }else if(nums[mid] >= nums[lo] && nums[mid] > nums[high]){
                lo = mid+1;
            }else{
                high = mid-1;
            }
        }
        return nums[lo];
    }
}
