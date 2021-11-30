package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class NdigitNumberSum {
    public static void main(String[] args) {
        int n = 3;
        int sum = 6;
        int result = calculateSum(n, sum);
        System.out.println(result);
    }

    private static int calculateSum(int n, int sum) {
        int count =0;
        int start = (int) Math.pow(10, n - 1);
        int end = (int) Math.pow(10, n);
        int i = start;
        while (i < end) {
            int curr = 0;
            int temp = i;

            while (temp != 0) {
                curr = curr + temp % 10;
                temp = temp / 10;

            }
            if(curr == sum){
                count =count+1;
                i = i+9;
            }else{
                i++;
            }
        }
        return count;
    }
}
