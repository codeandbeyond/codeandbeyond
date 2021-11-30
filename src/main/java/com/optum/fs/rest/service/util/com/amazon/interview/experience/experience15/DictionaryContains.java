package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;


import java.util.*;

public class DictionaryContains {

    public static void main(String[] args) {
        Map<String, Integer> dict = new HashMap<>();
        dict.put("a", 1);
        dict.put("aa", 1);
        dict.put("aaa", 1);

        String input = "aaabaa";

        get_combinations(input, dict);

    }

    public static void get_combinations(String input, Map<String, Integer> dict) {
        List<String> retList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j <=input.length(); j++) {
                String sub = input.substring(i, j);
                if (dict.containsKey(sub)) {
                   retList.add(sub);
                }
            }
        }
        Collections.sort(retList);
        System.out.println(retList);
    }

}
