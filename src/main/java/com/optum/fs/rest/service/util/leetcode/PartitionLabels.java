package com.optum.fs.rest.service.util.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        String S = "ababcbacadefegdehijhklij";
        partitionLabels.partitionLabels(S);

    }

    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        List<Integer> outPut = new ArrayList<>();
        int[] charCount = new int[26];

        for (int i = 0; i < S.length(); i++) {
            charCount[S.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, charCount[S.charAt(i) - 'a']);
            if (i == end) {
                outPut.add(end - start + 1);
                start = end + 1;
            }
        }
        return outPut;

    }
}
