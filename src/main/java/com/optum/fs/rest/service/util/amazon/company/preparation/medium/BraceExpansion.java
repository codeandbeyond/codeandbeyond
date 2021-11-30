package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.*;

public class BraceExpansion {
    public List<String> braceExpansionII(String expression) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(expression);
        Set<String> set = new HashSet<>();

        while (!queue.isEmpty()) {
            String str = queue.poll();

            if (str.indexOf('{') == -1) {
                set.add(str);
                continue;
            }

            int i = 0, l = 0, r = 0;
            while (str.charAt(i) != '}') {
                if (str.charAt(i) == '{')
                    l = i;
                i++;
            }
            r = i;

            String before = str.substring(0, l);
            String after = str.substring(r+1);
            String[] strs = str.substring(l+1, r).split(",");

            StringBuilder sb = new StringBuilder();
            for (String ss : strs) {
                sb.setLength(0);
                queue.offer(sb.append(before).append(ss).append(after).toString());
            }
        }

        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        BraceExpansion braceExpansion = new BraceExpansion();
        String expr = "{a,b}{c,{d,e}}";
        braceExpansion.braceExpansionII(expr);
    }
}
