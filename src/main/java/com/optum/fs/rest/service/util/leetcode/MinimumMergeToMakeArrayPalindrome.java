package com.optum.fs.rest.service.util.leetcode;

public class MinimumMergeToMakeArrayPalindrome {
    public static void main(String[] args) {
        MinimumMergeToMakeArrayPalindrome minimumMergeToMakeArrayPalindrome = new MinimumMergeToMakeArrayPalindrome();
        int arr[] = {11, 14, 15, 99};
        int count = minimumMergeToMakeArrayPalindrome.findMerge(arr);
        System.out.println(count);
    }

    private int findMerge(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        int ans = 0;
        while (i < j) {
            if (arr[i] == arr[j]) {
                i++;
                j--;
            } else if (arr[i] > arr[j]) {
                j--;
                arr[j] += arr[j + 1];
                ans++;
            } else {
                i++;
                arr[i] += arr[i - 1];
                ans++;
            }
        }
        return ans;
    }
}
