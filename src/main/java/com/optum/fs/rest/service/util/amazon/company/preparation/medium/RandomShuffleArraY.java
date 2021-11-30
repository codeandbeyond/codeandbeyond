package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.Arrays;
import java.util.Random;

public class RandomShuffleArraY {
    int[] array ;
    int[] original;
    Random random = new Random();
    public RandomShuffleArraY(int[] nums){
        array  = nums;
        original = nums.clone();
    }
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i=0;i<array.length;i++){
            swapAt(i,randRange(i,array.length));
        }
        return array;
    }
    private void swapAt(int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private int randRange(int min,int max){
        return (random.nextInt(max - min))+min;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        RandomShuffleArraY randomShuffleArraY = new RandomShuffleArraY(nums);
        randomShuffleArraY.printArray(randomShuffleArraY.shuffle());
        randomShuffleArraY.printArray(randomShuffleArraY.shuffle());
        randomShuffleArraY.printArray(randomShuffleArraY.shuffle());
        randomShuffleArraY.printArray(randomShuffleArraY.reset());
        randomShuffleArraY.printArray(randomShuffleArraY.shuffle());
        randomShuffleArraY.printArray(randomShuffleArraY.shuffle());
    }

    private void printArray(int[] nums){
        for(int num:nums){
            System.out.print( num );
        }
        System.out.println();
    }
}
