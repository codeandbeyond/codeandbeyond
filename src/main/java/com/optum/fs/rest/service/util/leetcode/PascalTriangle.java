package com.optum.fs.rest.service.util.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashok on 06-06-2020.
 */
public class PascalTriangle {
    public static void main(String[] args) {
        getRow(3);
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        if(rowIndex<0){
            return row;
        }
        int[] arr = new int[rowIndex+1];
        // row.add(1);
        arr[0]=1;
        for(int i=1;i<=rowIndex;i++){
            for(int j=i-1;j>0;j--){
                //row.add(row.get(j-1)+row.get(j));
                arr[j] = arr[j-1]+arr[j];
            }
            arr[i] =1;
        }
        for(int i=0;i<arr.length;i++){
            row.add(arr[i]);
        }
        return row;
    }
}
