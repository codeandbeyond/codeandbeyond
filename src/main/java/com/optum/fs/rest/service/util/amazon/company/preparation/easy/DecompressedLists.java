package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DecompressedLists {
    public static void main(String[] args) {
        DecompressedLists decompressedLists = new DecompressedLists();
        decompressedLists.decompressRLElist(new int[]{1,2,3,4});
    }

    public int[] decompressRLElist(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            while (freq-- > 0) {
                result.add(val);
            }
        }
        int[] results = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            results[i] = result.get(i);
        }
        return results;
    }
}
