package com.optum.fs.rest.service.util.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuddyStrings {

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;

        if (A.equals(B)) {
            Set<Character> uniqueChars = new HashSet<>();
            int index = 0;
            while (index < A.length()) {
                uniqueChars.add(A.charAt(index));
                index++;
            }
            if (uniqueChars.size() < A.length()) {
                return true;
            } else {
                return false;
            }
        }
        List<Integer> diffIndex = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                diffIndex.add(i);
            }
        }
        if (diffIndex.size() == 2 && (A.charAt(diffIndex.get(0)) == B.charAt(diffIndex.get(1))) && A.charAt(diffIndex.get(1)) == B.charAt(diffIndex.get(0))) {
            return true;
        } else
            return false;

    }

    public static void main(String[] args) {
        BuddyStrings buddyStrings = new BuddyStrings();
        System.out.println(buddyStrings.buddyStrings("ab","ba"));
        System.out.println(buddyStrings.buddyStrings("aaaaaaaaaab","aaaaaaaaaba"));
    }
}
