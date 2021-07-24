package home.practice.company.problems.preparation;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ashok on 31-05-2020.
 */
public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int arr[] = {1, 9, 3, 10, 4, 20, 2};
        int n = arr.length;
        System.out.println("Length of the Longest consecutive subsequence is " +
                findLongestConseqSubseq(arr, n));
    }

    private static int findLongestConseqSubseq(int[] arr, int n) {
        Set<Integer> countSet = new HashSet<>();
        int longest = 0;
        for (int i : arr) {
            countSet.add(i);
        }
        for (Integer num : countSet) {
            if (!countSet.contains(num - 1)) {
                int count = 1;
                int current = num;
                while (countSet.contains(current + 1)) {
                    count++;
                    current++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}
