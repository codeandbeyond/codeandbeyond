package com.optum.fs.rest.service.util.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class    RoomsKeys {
    public static void main(String[] args) {
         List<Integer> room1 = new ArrayList<>();
        List<Integer> room2 = new ArrayList<>();
        List<Integer> room3 = new ArrayList<>();
        List<Integer> room = new ArrayList<>();
        room1.add(1);
        room2.add(2);
        room3.add(3);
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room);
        System.out.println(canVisitAllRooms(rooms));

    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];

        Stack<Integer> keys = new Stack<>();
        visited[0] = true;
        keys.add(0);
        while (!keys.isEmpty()) {
            Integer currentKey = keys.pop();
            for (Integer newKey : rooms.get(currentKey)) {
                if (!visited[newKey]) {
                    visited[newKey] = true;
                    keys.add(newKey);
                }
            }
        }
        for (boolean visit : visited) {
            if (!visit)
                return false;
        }
        return true;

    }
}
