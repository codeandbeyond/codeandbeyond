package com.optum.fs.rest.service.util.problems;

import java.util.Arrays;

public class SuffixArray {
    private final String[] suffixes;
    private final int N;

    public SuffixArray(String s) {
        this.N = s.length();
        suffixes = new String[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = s.substring(i, N);
        }
        Arrays.sort(suffixes);
    }

    public int length() {
        return N;
    }

    public int index(int i) {
        return N - suffixes[i].length();
    }

    public String select(int i) {
        return suffixes[i];
    }

    public int lcp(int i) {
        return lcpStr(suffixes[i], suffixes[i + 1]);
    }

    private int lcpStr(String s, String t) {
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return i;
            }
        }
        return n;
    }

    public int rank(String key) {  // binary search
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(suffixes[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }
}
