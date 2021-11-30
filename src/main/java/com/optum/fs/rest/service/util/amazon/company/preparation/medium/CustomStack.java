package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.Stack;

public class CustomStack {
    int n;
    int[] inc;
    Stack<Integer> stack;
    public CustomStack(int maxSize) {
        n = maxSize;
        inc = new int[n];
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.size() < n)
            stack.push(x);
    }

    public int pop() {
        int i = stack.size() - 1;
        if (i < 0)
            return -1;
        if (i > 0)
            inc[i - 1] += inc[i];
        int res = stack.pop() + inc[i];
        inc[i] = 0;
        return res;
    }

    public void increment(int k, int val) {
        int i = Math.min(k, stack.size()) - 1;
        if (i >= 0)
            inc[i] += val;
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(10);
        stack.push(4);
        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(1);
        stack.push(9);
        System.out.println(stack.pop());
        stack.increment(2,20);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

    }
}
