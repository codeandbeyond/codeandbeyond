package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class ClosesNDivisibleM {
    public static void main(String[] args) {
        int n =-15;
        int m =6;
        System.out.println(closestDivisible(n,m));
    }

    private static int closestDivisible(int n, int m) {
        int q =n/m;
        int n1 = m*q;
        int n2 = (n*m)>0? m*(q+1):m*(q-1);
        if(Math.abs(n-n1)<Math.abs(n-n2)){
            return n1;
        }else{
            return n2;
        }
    }
}
