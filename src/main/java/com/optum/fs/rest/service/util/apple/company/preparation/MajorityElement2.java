package com.optum.fs.rest.service.util.apple.company.preparation;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList();

        int count1 = 0;
        int count2 = 0;

        Integer cand1 = null;
        Integer cand2 = null;

        for (int num : nums) {
            if (cand1 != null && cand1 == num) {
                count1++;
            } else if (cand2 != null && cand2 == num) {
                count2++;
            } else if (count1 == 0) {
                cand1 = num;
                count1++;
            } else if (count2 == 0) {
                cand2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (cand1 != null && num == cand1) count1++;
            if (cand2 != null && num == cand2) count2++;
        }
        if (count1 > nums.length / 3) result.add(cand1);
        if (count2 > nums.length / 3) result.add(cand2);
        return result;

    }
}
