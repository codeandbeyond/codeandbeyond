package com.optum.fs.rest.service.util.leetcode;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        hmap.put('I', 1);
        hmap.put('V', 5);
        hmap.put('X', 10);
        hmap.put('L', 50);
        hmap.put('C', 100);
        hmap.put('D', 500);
        hmap.put('M', 1000);
        int max = 0;
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int temp = hmap.get(s.charAt(i));

            if (temp < max) {
                result -= temp;
            } else {
                max = temp;
                result += temp;
            }
        }
        return result;
    }

}
