package com.top.hundred;

public class DuplicateNumber {
    public int duplicateNumber(int[] nums){
        if(nums.length == 0) return -1;
        int fast = nums[nums[0]];
        int slow = nums[0];
        while (fast!=slow){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (fast!=slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        DuplicateNumber duplicateNumber = new DuplicateNumber();
        int[] arr = {1,3,4,2,2};
        duplicateNumber.duplicateNumber(arr);
    }
}
