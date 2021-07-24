package com.top.hundred;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        boolean isOneFound = false;

        for (int num : nums) {
            if (num == 1) {
                isOneFound = true;
            }
        }

        if (!isOneFound) return 1;
        if (n == 1) return 2;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }


        for (int i = 0; i < nums.length; i++) {

            int a = Math.abs(nums[i]);
            if (a == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[a] = -Math.abs(nums[a]);
            }
        }


        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }


        if (nums[0] > 0) {
            return n;
        }

        return n + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,0};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        firstMissingPositive.firstMissingPositive(arr);
    }
}
