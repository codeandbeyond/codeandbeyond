package home.practice.company.problems.preparation;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ashok on 31-05-2020.
 */
public class LengthNRCS {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println("The input string is " + str);
        int len = longestUniqueSubsttr(str);
        System.out.println("The length of "
                + "the longest non repeating character is " + len);
    }

    private static int longestUniqueSubsttr(String str) {
        int left = 0;
        int right = 0;
        int max = 0;

        Set<Character> unique = new HashSet<>();
        while (right < str.length()) {
            if (!unique.contains(str.charAt(right))) {
                unique.add(str.charAt(right));
                right++;
                max = Math.max(max, unique.size());
            } else {
                unique.remove(str.charAt(left));
                left++;
            }
        }
        return max;
    }
}
