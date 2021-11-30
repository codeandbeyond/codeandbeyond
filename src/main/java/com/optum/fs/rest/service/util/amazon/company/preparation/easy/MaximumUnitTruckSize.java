package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

import java.util.Arrays;

public class MaximumUnitTruckSize {
    public static void main(String[] args) {
        int[][] boxTypes = new int[][]{{1,3},{2,2},{3,1}};
        int truckSize = 4;
        MaximumUnitTruckSize maximumUnitTruckSize =new MaximumUnitTruckSize();
        System.out.println(maximumUnitTruckSize.maximumUnits(boxTypes,truckSize));
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int result = 0;
        Arrays.sort(boxTypes,(a,b)->(b[1]-a[1]));
        for(int[] boxType:boxTypes){
            if(boxType[0] > truckSize){
                result+=truckSize*boxType[1];
            }else {
                result += boxType[0] * boxType[1];
                truckSize -= boxType[0];
            }
        }
        return result;

    }
}
