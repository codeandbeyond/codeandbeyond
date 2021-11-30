package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import java.util.ArrayList;
import java.util.List;

public class GeneratingGrayCodes {
    public static void main(String[] args) {
        generateGrayCodes(3);
        grayCode(3);
    }
    public static void generateGrayCodes(int n){
        // base case
        if (n <= 0)
            return;

        // 'arr' will store all generated codes
        ArrayList<String> arr = new ArrayList<String> ();

        // start with one-bit pattern
        arr.add("0");
        arr.add("1");

        // Every iteration of this loop generates 2*i codes from previously
        // generated i codes.
        int i, j;
        for (i = 2; i < 2*n; i = 2*i)
        {
            // Enter the prviously generated codes again in arr[] in reverse
            // order. Nor arr[] has double number of codes.
            for (j = i-1 ; j >= 0 ; j--)
                arr.add(arr.get(j));

            // append 0 to the first half
            for (j = 0 ; j < i ; j++)
                arr.set(j, "0" + arr.get(j));

            // append 1 to the second half
            for (j = i ; j < 2*i ; j++)
                arr.set(j, "1" + arr.get(j));
        }

        // print contents of arr[]
        for (i = 0 ; i < arr.size() ; i++ )
            System.out.println(arr.get(i));
    }
    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);                                //n=0 {0}
        if(n == 0) return list;
        int increase = 1;
        for(int i = 0;i<n;i++){                     //              n=2
            int len = list.size();                  //              len = 2
            for(int j = len-1;j>=0;j--){            //              {0,1,3,2}
                list.add(list.get(j)+increase);     //n=1 {0,1}
            }
            increase *= 2;
        }
        for(Integer num:list){
            System.out.println(num);
        }
        return list;
    }
}
