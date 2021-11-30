package com.optum.fs.rest.service.util.leetcode;

import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        asteroidCollision.asteroidCollision(new int[]{-2, -1, 1, 2});
    }

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty() || asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while (true) {
                    int peek = stack.peek();
                    if (peek < 0) {
                        stack.push(asteroids[i]);
                        break;
                    } else if (peek == -asteroids[i]) {
                        stack.pop();
                        break;
                    } else if (peek > -asteroids[i]) {
                        break;
                    } else {
                        stack.pop();
                        if (stack.isEmpty()) {
                            stack.push(asteroids[i]);
                            break;
                        }
                    }
                }
            }
        }
        int[] output = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            output[i] = stack.get(i);
        }
        return output;
    }
}
