package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

public class MonotonicIncreasingDigit {
    public int monotoneIncreasingDigits(int N) {
        String str = String.valueOf(N);
        char[] arr = str.toCharArray();
        int monoTonicEnd = arr.length-1;
        for(int i= arr.length-1;i>0;i--){
            if(arr[i-1]>arr[i]){
                monoTonicEnd = i-1;
                arr[i-1]--;
            }
        }
        for(int j=monoTonicEnd+1;j<arr.length;j++){
            arr[j]='9';
        }

        return Integer.parseInt(String.valueOf(arr));
    }

    public static void main(String[] args) {
        MonotonicIncreasingDigit monotonicIncreasingDigit = new MonotonicIncreasingDigit();
        System.out.println(monotonicIncreasingDigit.monotoneIncreasingDigits(12321));
    }
}
