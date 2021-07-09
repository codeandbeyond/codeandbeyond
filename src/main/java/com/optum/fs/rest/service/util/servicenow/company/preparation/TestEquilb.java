package com.optum.fs.rest.service.util.servicenow.company.preparation;

import java.util.ArrayList;
import java.util.List;

public class TestEquilb {
    public static void main(String[] args){
        TestEquilb test = new TestEquilb();
        List<Integer> results = test.equilibriumPoints(new int[]{0,-3,5,-4,-2,3,1,0});
        for(int num:results){
            System.out.print(num+" ");
        }

    }
    public  List<Integer> equilibriumPoints(int[] arr){
        List<Integer> results = new ArrayList();
        if(arr == null || arr.length == 0){
            return results;
        }
        int sum  =0;
        for(int num:arr){
            sum+=num;
        }

        int leftSum  = 0;
        for(int i=0;i<arr.length;i++){

            if((sum-leftSum-arr[i]) == leftSum){
                results.add(i);
            }
            leftSum +=arr[i];
        }

        return results;
    }
}
