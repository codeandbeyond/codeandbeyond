package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

public class IsPower {
    public static void main(String[] args) {
        System.out.println(isPopwer(48));
    }
    public static boolean isPopwer(int n){
        if(n==1) return true;
        for(int i=2;i<=Math.sqrt(n);i++){
            double val = Math.log(n)/Math.log(i);
            if((val-(int)val)<0.0000001) return true;
        }
        return false;
    }
}
