package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

public class SignOfProductArray {
    int sum = 1;

    public int arraySign(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) return 0;
            nums[i] = nums[i] > 0 ? 1 : -1;
            sum = sum * nums[i];
        }
        return sum < 0 ? -1 : 1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,1,-1,1,-1};
        SignOfProductArray signOfProductArray = new SignOfProductArray();
        System.out.println(signOfProductArray.arraySign(nums));
    }
}
