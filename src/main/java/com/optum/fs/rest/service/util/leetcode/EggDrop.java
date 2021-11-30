package com.optum.fs.rest.service.util.leetcode;

import java.util.Arrays;

public class EggDrop {
    public static void main(String[] args) {
        EggDrop eggDrop = new EggDrop();
        int n = 2, k = 10;
        int[][] eggDropSolution = new int[n+1][k+1];
       for(int i=0;i<eggDropSolution.length;i++){
           for(int j=0;j<eggDropSolution[i].length;j++){
               eggDropSolution[i][j] = Integer.MAX_VALUE;
           }
       }
        System.out.print("Minimum number of "
                + "trials in worst case with "
                + n + " eggs and " + k
                + " floors is " + eggDrop.eggDropRecursive(n, k));
        System.out.print("\nMinimum number of "
                + "trials in worst case with "
                + n + " eggs and " + k
                + " floors is " + eggDrop.eggDrop(n, k,eggDropSolution));
    }

    private int eggDropRecursive(int eggs, int floors) {

        if(floors==0 || floors==1){
            return floors;
        }
        if(eggs==1){
            return floors;
        }

        int res = Integer.MAX_VALUE;

        for(int x=2;x<floors;x++){
            int currentResult = Math.max(eggDropRecursive(eggs-1,x-1),eggDropRecursive(eggs,floors-x));
            res = Math.min(currentResult,res);
        }
        return res+1;
    }
    private int eggDrop(int eggs, int floors, int[][] eggDropSolution) {
        if(eggDropSolution[eggs][floors]!=Integer.MAX_VALUE){
            return eggDropSolution[eggs][floors];
        }

        if(floors==0 || floors==1){
            eggDropSolution[eggs][floors] = floors;
            return eggDropSolution[eggs][floors];
        }
        if(eggs==1){
            eggDropSolution[eggs][floors] = floors;
            return  eggDropSolution[eggs][floors];
        }

        int res = Integer.MAX_VALUE;

        for(int x=2;x<=floors;x++){
            int currentResult = Math.max(eggDrop(eggs-1,x-1, eggDropSolution),eggDrop(eggs,floors-x, eggDropSolution));
            res = Math.min(currentResult,res);
        }
        eggDropSolution[eggs][floors] = res+1;
        return eggDropSolution[eggs][floors];
    }
}
