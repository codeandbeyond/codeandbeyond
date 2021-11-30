package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

public class SingleUnique {
    public int singleNonDuplicate(int[] nums) {
        if(nums == null || nums.length==0) return -1;

        int low = 0;
        int high = nums.length-1;
        while(low<high){
            int mid = low+(high-low)/2;
            if(mid%2==1){
                mid--;
            }
            if(nums[mid]==nums[mid+1]){
                low = mid+2;
            }else{
                high = mid;
            }
        }
        return nums[low];
    }
}
