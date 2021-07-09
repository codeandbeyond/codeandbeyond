package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

public class MoveZeros {
    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        moveZeros.moveZeroes(new int[]{0,1,0,3,12});
    }
    public void moveZeroes(int[] nums) {
        int i=0;int j=nums.length-1;
        while(i<j){
            while(nums[j]==0 && j>=0){
                j--;
            }
            while(nums[i]!=0 && i< j){
                i++;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
