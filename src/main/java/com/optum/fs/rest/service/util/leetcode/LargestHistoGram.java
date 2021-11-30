package com.optum.fs.rest.service.util.leetcode;

import java.util.Stack;

/**
 * Created by Ashok on 31-05-2020.
 */
public class LargestHistoGram {
    public static void main(String[] args) {
        int hist[] = {6, 2, 5, 4, 5, 1, 6 };
        int maxArea = largestArea(hist);
        System.out.println("Largest HistoGram Area is "+maxArea);
    }

    public static int largestArea(int[] hist) {
        int area = 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < hist.length) {
            if (stack.isEmpty() || hist[i] >= hist[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    area = hist[top] * i;
                } else {
                    area = hist[top] * (i - stack.peek() - 1);
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                area = hist[top] * i;
            } else {
                area = hist[top] * (i - stack.peek() - 1);
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
