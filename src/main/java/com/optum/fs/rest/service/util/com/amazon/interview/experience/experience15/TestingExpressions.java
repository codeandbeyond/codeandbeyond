package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import java.util.Arrays;

public class TestingExpressions {
    public static void main(String[] args) {
//        System.out.println(" mystery(2,25) :  "+mystery(2,25));
//        System.out.println(" mystery(3,11) :  "+mystery(3,11));
//        System.out.println(" mystery(3,25) :  "+mysteryDifferent(3,25));
//        System.out.println(" mystery(4,11) :  "+mysteryDifferent(4,11));
        int[] arr={23,45,65,87,5,6,90,25,46,21,32,76,9,50};
        Arrays.sort(arr);
        System.out.println(" Rank of 65 is "+rank(0,arr.length-1,0,arr,65));

    }
    public static int mystery(int a, int b)
    {
        if (b == 0)     return 0;
        if (b % 2 == 0) return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }
    public static int mysteryDifferent(int a, int b)
    {
        if (b == 0)     return 1;
        if (b % 2 == 0) return mystery(a*a, b/2);
        return mystery(a*a, b/2) + a;
    }
    public static int rank(int low,int high,int level,int[] arr,int key){
        if(high>=low){
           int mid=low+(high-low)/2;
           if(arr[mid]==key){
               System.out.println(" Found the key in the current level "+level);
               return mid;
           }
           else if(key<arr[mid]){
               System.out.println(" Currently in "+level+" level "+" less than mid");
               return rank(low,mid-1,level+1,arr,key);
           }else{
               System.out.println(" Currently in "+level+" level "+" greater than mid");
               return rank(mid+1,high,level+1,arr,key);
           }
        }
        return -1;
    }
}
