package com.optum.fs.rest.service.util.microsft.comany.preparation;

public class MedianOfTwooSortedArrays {
    public static void main(String[] args) {
        int[] x = {1, 3};
        int[] y = {2};

        MedianOfTwooSortedArrays mm = new MedianOfTwooSortedArrays();
        System.out.println(mm.findMedianSortedArrays(x, y));
    }

    private double findMedianSortedArrays(int[] arr1, int[] arr2) {
        double result = 0.0;
        if (arr2.length < arr1.length) {
            return findMedianSortedArrays(arr2, arr1);
        }
        int x = arr1.length;
        int y = arr2.length;

        int lo = 0;
        int hi = x;
        while (lo <= hi) {
            int partitionX = lo + (hi - lo) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : arr1[partitionX - 1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : arr1[partitionX];

            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : arr2[partitionY - 1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : arr2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    result = (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                    break;
                } else {
                    result = (double) (Math.max(maxLeftX, maxLeftY));
                    break;
                }
            } else if (maxLeftX > minRightY) {
                hi = partitionX - 1;
            } else {
                lo = partitionX + 1;
            }
        }
        return result;

    }
}
