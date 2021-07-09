package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import java.util.Stack;

public class  NearestSmallestLeftSide {
    private static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args) {
        Integer arr[] = {1, 6, 4, 10, 2, 5};
        int n = arr.length;
       nearestSmallest(arr, n);

    }

    private static void nearestSmallest(Integer[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                System.out.print("_");
            } else {
                System.out.print(stack.peek());
            }
            stack.push(arr[i]);
        }
    }


}
