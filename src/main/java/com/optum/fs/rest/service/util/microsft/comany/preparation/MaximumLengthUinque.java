package com.optum.fs.rest.service.util.microsft.comany.preparation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLengthUinque {
    private int result = 0;

    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }

        dfs(arr, "", 0);

        return result;
    }

    private void dfs(List<String> arr, String path, int idx) {
        boolean isUniqueChar = isUniqueChars(path);

        if (isUniqueChar) {
            result = Math.max(path.length(), result);
        }

        if (idx == arr.size() || !isUniqueChar) {
            return;
        }

        for (int i = idx; i < arr.size(); i++) {
            dfs(arr, path + arr.get(i), i + 1);
        }
    }

    private boolean isUniqueChars(String s) {
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        MaximumLengthUinque maximumLengthUinque = new MaximumLengthUinque();
        String[] arr = {"un","iq","ue"};
        List<String> list = Arrays.asList(arr);
        maximumLengthUinque.maxLength(list);
    }
}
