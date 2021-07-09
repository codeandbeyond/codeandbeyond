package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.HashMap;
import java.util.Map;

public class StrobrogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 0);
        map.put(1, 1);
        map.put(8, 8);
        map.put(6, 9);
        map.put(9, 6);
        StringBuilder sb = new StringBuilder();
        for (char c : num.toCharArray()) {
            if (map.containsKey(c - '0')) {
                sb.append(map.get(c - '0'));
            } else {
                sb.append(c - '0');
            }
        }
        return num.equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        StrobrogrammaticNumber strobrogrammaticNumber = new StrobrogrammaticNumber();
        strobrogrammaticNumber.isStrobogrammatic("692");
    }
}
