package com.optum.fs.rest.service.util.leetcode;

public class DistributeCandies {
    public static void main(String[] args) {
        DistributeCandies distributeCandies = new DistributeCandies();
        int candies = 15;
        int num_people = 4;
        distributeCandies.distributeCandies(candies, num_people);

    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] output = new int[num_people];
        int i = 0;
        int loops = 0;
        while (candies > 0) {
            if (i == num_people) {
                i = 0;
                loops++;
            }

            int currentCandy = (loops * num_people) + (i + 1);
            if (candies - currentCandy < 0) {
                output[i] += candies;
            } else {
                output[i] += currentCandy;
            }
            i++;
            candies -= currentCandy;
        }

        return output;
    }
}
