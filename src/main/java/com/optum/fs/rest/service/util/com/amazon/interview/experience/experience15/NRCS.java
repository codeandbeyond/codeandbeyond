package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import java.util.HashSet;
import java.util.Set;

public class NRCS {
    static final int NO_OF_CHARS = 256;

    static int longestUniqueSubsttr(String str) {
        int n = str.length();
        int cur_len = 1; // length of current substring
        int max_len = 1; // result
        int prev_index; // previous index
        int i;
        int visited[] = new int[NO_OF_CHARS];
        for (i = 0; i < NO_OF_CHARS; i++) {
            visited[i] = -1;
        }
        visited[str.charAt(0)] = 0;

        for (i = 1; i < n; i++) {
            prev_index = visited[str.charAt(i)];

            if (prev_index == -1 || i - cur_len > prev_index)
                cur_len++;

            /* If the current character is present in currently
               considered NRCS, then update NRCS to start from
               the next character of the previous instance. */
            else {
                /* Also, when we are changing the NRCS, we
                   should also check whether length of the
                   previous NRCS was greater than max_len or
                   not.*/
                if (cur_len > max_len)
                    max_len = cur_len;

                cur_len = i - prev_index;
            }

            // update the index of current character
            visited[str.charAt(i)] = i;
        }

        if (cur_len > max_len)
            max_len = cur_len;

        return max_len;
    }

    static int longestUniqueSubsttrSet(String s) {
        int i = 0;
        int j = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                max = Math.max(max, set.size());
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }

        }
        return max;
}

    /* Driver program to test above function */
    public static void main(String[] args) {
        String str = "abccbda";
        System.out.println("The input string is " + str);
        int len = longestUniqueSubsttrSet(str);//longestUniqueSubsttr(str);
        System.out.println("The length of "
                + "the longest non repeating character is " + len);
    }
}
