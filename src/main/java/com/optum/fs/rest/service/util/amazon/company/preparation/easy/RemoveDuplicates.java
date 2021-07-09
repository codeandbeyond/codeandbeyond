package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

import java.util.Stack;

public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        removeDuplicates.removeDuplicates("abbaca");
        removeDuplicates.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack();
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            if(stack.isEmpty() || stack.peek()!=ch){
                stack.push(ch);
            }else {
                while (!stack.isEmpty() && ch == stack.peek()) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    public int removeDuplicates(int[] nums) {
        int left = 0;
        for(int right = 1;right< nums.length;right++){
            if(nums[left]!=nums[right]){
                left++;
                nums[left] = nums[right];
            }
        }

        return left+1;
    }
}
