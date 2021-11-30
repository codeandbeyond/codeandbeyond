package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

public class Ratings {
    public int numTeams(int[] rating) {
        int count = 0;
        int len = rating.length;
        for(int i=0;i<len;i++){
            int leftSmaller = 0;int rightLarger = 0;
            int leftLarger = 0;int rightSmaller = 0;
            for(int j = 0;j<i;j++){
                if(rating[j] < rating[i]){
                    leftSmaller++;
                }else if(rating[j] >rating[i]){
                    leftLarger++;
                }
            }
            for(int k = i+1;k<len;k++){
                if(rating[k]>rating[i]){
                    rightLarger++;
                }else if(rating[k]<rating[i]){
                    rightSmaller++;
                }
            }
            count+=leftSmaller*rightLarger+rightSmaller*leftLarger;
        }
        return count;

    }
}
