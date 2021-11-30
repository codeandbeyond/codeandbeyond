package com.optum.fs.rest.service.util.design;

import javax.validation.constraints.Max;
import java.util.*;

public class MaxFreqStack {
    List<Stack<Integer>> bucket;
    Map<Integer, Integer> map;

    public MaxFreqStack() {
        this.bucket = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        int freq = map.get(val);
        if (freq - 1 >= bucket.size()) {
            bucket.add(new Stack<>());
        }
        bucket.get(freq - 1).add(val);
    }

    public int pop() {
        int freq = bucket.size();
        int x = bucket.get(freq - 1).pop();
        if (bucket.get(freq - 1).isEmpty()) {
            bucket.remove(freq - 1);
        }
        map.put(x, map.get(x) - 1);
        return x;
    }

    public static void main(String[] args) {
        MaxFreqStack maxFreqStack = new MaxFreqStack();
        maxFreqStack.push(5);
        maxFreqStack.push(5);
        maxFreqStack.push(3);
        maxFreqStack.push(2);
        maxFreqStack.push(0);
        maxFreqStack.push(1);
        maxFreqStack.push(2);
        System.out.println(maxFreqStack.pop());
        System.out.println(maxFreqStack.pop());
        System.out.println(maxFreqStack.pop());




    }
}
