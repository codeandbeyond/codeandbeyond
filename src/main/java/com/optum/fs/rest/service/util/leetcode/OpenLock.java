package com.optum.fs.rest.service.util.leetcode;

import java.util.*;

public class OpenLock {
    public static void main(String[] args) {
        String[] deadEnds = new String[]{"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";

        OpenLock openLock= new OpenLock();
        openLock.openLock(deadEnds,target);
    }

    public int openLock(String[] deadends, String target) {
        Set<String> deadend = new HashSet<>(Arrays.asList(deadends));

        Set<String> visited = new HashSet<>();

        visited.add("0000");

        Queue<String> lockPositions = new LinkedList<>();
        lockPositions.offer("0000");
        int level = 0;

        while (!lockPositions.isEmpty()) {

            int size = lockPositions.size();
            while (size > 0) {

                String currentLockPosition = lockPositions.poll();

                if (deadend.contains(currentLockPosition)) {
                    size--;
                    continue;

                }

                if (currentLockPosition.equals(target)) {
                    return level;

                }


                StringBuilder sb = new StringBuilder(currentLockPosition);


                for (int i = 0; i < 4; i++) {
                    char currentPosition = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (currentPosition == '9' ? 0 : currentPosition - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (currentPosition == '0' ? 9 : currentPosition - '0' - 1) + sb.substring(i + 1);
                    if (!visited.contains(s1) && !deadend.contains(s1)) {
                        lockPositions.add(s1);
                        visited.add(s1);
                    }
                    if (!visited.contains(s2) && !deadend.contains(s2)) {
                        lockPositions.add(s2);
                        visited.add(s2);
                    }
                }

                size--;
            }
            level++;

        }


        return -1;
    }
}
