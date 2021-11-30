package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

public class GoodSubArrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int n = nums.length;
        for (int right = 0; right < n; right++) {
            if (nums[right] % 2 != 0) {
                k--;
            }
            while (k < 0) {
                if (nums[left] % 2 != 0) {
                    k++;
                }
                left++;
            }

            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k = 2;
        GoodSubArrays goodSubArrays = new GoodSubArrays();
        int countAtmostK = goodSubArrays.numberOfSubarrays(arr, k);
        int countAtmostKMinus1 = goodSubArrays.numberOfSubarrays(arr, k - 1);
        System.out.println(" count = " + (countAtmostK - countAtmostKMinus1));
    }
}
