package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.Arrays;

public class ReductionOfPiles {
    public static void main(String[] args) {
       int[] piles = {1,1,2,3,4,4,5,6,6,8};
       ReductionOfPiles reductionOfPiles = new ReductionOfPiles();
       reductionOfPiles.minSteps(piles);
    }
    public int minSteps(int[] piles){
        Arrays.sort(piles);
        int distinctNum = 0;
        int result = 0;
        for(int i=1;i<piles.length;i++){
            if(piles[i]!=piles[i-1]){
                distinctNum++;
            }
            result+=distinctNum;
        }
        System.out.println("Result "+result);
        return result;
    }
}
