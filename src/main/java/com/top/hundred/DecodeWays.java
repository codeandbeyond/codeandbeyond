package com.top.hundred;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    Map<Integer, Integer> memo = new HashMap<>();

    public int decodeWays(String num) {
        return recurse(num, 0);
    }

    private int recurse(String num, int index) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        if (num.length() == index) {
            return 1;
        }
        if (num.charAt(0) == '0') {
            return 0;
        }
        if (num.length() - 1 == index) {
            return 1;
        }

        int ans = recurse(num, index + 1);
        if (Integer.parseInt(num.substring(index, index + 2)) <= 26) {
            ans += recurse(num, index + 2);
        }

        memo.put(index, ans);
        return ans;
    }

    public static void main(String[] args) {
        String num = "0";
        DecodeWays decodeWays = new DecodeWays();
        int res = decodeWays.decodeWays(num);
        System.out.println(res);
    }
}
