package com.zeta;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
    public static void main(String[] args) {
        Isomorphic isomorphic = new Isomorphic();
        System.out.println(isomorphic.isoMorphic("eggp", "addt"));
        System.out.println("---------------------");
        System.out.println(isomorphic.isoMorphic("paper", "title"));
        System.out.println("---------------------");
        System.out.println(isomorphic.isoMorphic("foo", "bar"));
        System.out.println("---------------------");
        System.out.println(isomorphic.isoMorphic("bcda", "baba"));
    }

    public boolean isoMorphic(String s, String t) {

        String patt = getCode(s);
        String tCode = getCode(t);

        System.out.println("s code " + patt + "  tCode" + tCode);
        return patt.equals(tCode);
    }

    private String getCode(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, count);
                count++;
            }

            sb.append(map.get(c));
        }
        return sb.toString();
    }
}
