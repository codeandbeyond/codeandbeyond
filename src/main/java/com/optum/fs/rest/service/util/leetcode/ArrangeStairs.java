package com.optum.fs.rest.service.util.leetcode;

public class ArrangeStairs {
    public static void main(String[] args) {
        ArrangeStairs arrangeStairs = new ArrangeStairs();
        System.out.println(arrangeStairs.arrangeStairs(5));

    }

    public int arrangeStairs(int n) {
        if (n == 0) return 0;
        int stairs = 1;
        int count =0;
        while (n - stairs >= 0) {
            n = n - stairs;
            if(n!=0){
                count++;
            }

            stairs++;
        }
        return (n != 0) ? count : count+1;
    }
}
