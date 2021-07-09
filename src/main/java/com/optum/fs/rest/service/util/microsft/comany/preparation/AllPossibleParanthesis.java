package com.optum.fs.rest.service.util.microsft.comany.preparation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleParanthesis {
    Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (map.containsKey(expression)) return map.get(expression);
        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '*' || expression.charAt(i) == '-') {
                String part1 = expression.substring(0, i);
                String part2 = expression.substring(i + 1);

                List<Integer> retPart1 = diffWaysToCompute(part1);
                List<Integer> retPart2 = diffWaysToCompute(part2);

                for (Integer p : retPart1) {

                    for (Integer q : retPart2) {
                        int c = 0;

                        if (expression.charAt(i) == '+') {
                            c = p + q;
                        } else if (expression.charAt(i) == '-') {
                            c = p - q;

                        } else if (expression.charAt(i) == '*') {
                            c = p * q;

                        }
                        ret.add(c);
                    }

                }
            }
        }
        if(ret.size() == 0){
            ret.add(Integer.valueOf(expression));
        }
        map.put(expression, ret);
        return ret;
    }

    public static void main(String[] args) {
        AllPossibleParanthesis allPossibleParanthesis = new AllPossibleParanthesis();
        List<Integer> list = allPossibleParanthesis.diffWaysToCompute("2*3-4*5");
        for (Integer val : list) {
            System.out.println(val);
        }

    }
}
