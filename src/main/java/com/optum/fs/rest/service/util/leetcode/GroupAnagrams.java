package com.optum.fs.rest.service.util.leetcode;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] arr = {"code","doce","ecod","framer","farmer"};
        System.out.println(groupAnagrams.groupAnagrams(arr));

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        Map<String, LinkedList<String>> store = new HashMap<>();
        for (String str : strs) {
            char[] ca = new char[26];
            for (int i = 0; i < str.length(); i++) {
                ca[str.charAt(i) - 'a']++;
            }
            String keyStr = String.valueOf(ca);
            if (!store.containsKey(keyStr)) {
                store.put(keyStr, new LinkedList<>());
            }
                store.get(keyStr).add(str);
        }
        return new ArrayList<>(store.values());
    }
}

