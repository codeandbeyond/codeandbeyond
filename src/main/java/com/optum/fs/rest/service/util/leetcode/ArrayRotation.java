package com.optum.fs.rest.service.util.leetcode;

public class ArrayRotation {
    public static void main(String[] args) {
        ArrayRotation arrayRotation = new ArrayRotation();
        int[] numns = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        arrayRotation.rotate(numns, k);

        for (Integer num : numns) {
            System.out.print(num + " ");
        }
    }

    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
