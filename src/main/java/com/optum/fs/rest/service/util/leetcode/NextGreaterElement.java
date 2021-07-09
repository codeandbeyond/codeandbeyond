package com.optum.fs.rest.service.util.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1};
        int[] arr2 = new int[]{4, 2, 5,25};
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        nextGreaterElement.nextGreaterElement(arr2);
        //nextGreaterElements(arr);
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] outPutArr = new int[nums.length];
        Arrays.fill(outPutArr,-1);
        int n = nums.length;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {

            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                outPutArr[stack.pop()] = nums[i % n];
            }

            if (i < n) stack.push(i);
        }


        return outPutArr;
    }
    public void nextGreaterElement(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        for(int i=1;i<nums.length;i++){
            while (!stack.isEmpty() && nums[i] > stack.peek()){
                System.out.println(stack.pop()+" --> "+nums[i]);
            }
            stack.push(nums[i]);
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop()+" --> "+" -1");
        }

    }
}
