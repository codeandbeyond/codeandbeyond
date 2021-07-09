package com.optum.fs.rest.service.util.leetcode;

import java.util.Arrays;

public class ValidSquare {
    public static void main(String[] args) {
        int[] p1 = new int[]{1, 0};
        int[] p2 = new int[]{0, 1};
        int[] p3 = new int[]{-1, 0};
        int[] p4 = new int[]{0, -1};

        ValidSquare validSquare = new ValidSquare();
        validSquare.validSuqareDifferent(p1, p2, p3, p4);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int d2 = distSq(p1, p2);
        int d3 = distSq(p1, p3);
        int d4 = distSq(p1, p4);

        if (d2 == d3 && 2 * d2 == d4 && 2 * distSq(p2, p4) == distSq(p2, p3)) {
            return true;
        }
        if (d3 == d4 && 2 * d3 == d2 && 2 * distSq(p2, p3) == distSq(p3, p4)) {
            return true;
        }
        if (d2 == d4 && 2 * d4 == d3 && 2 * distSq(p2, p4) == distSq(p2, p4)) {
            return true;
        }
        return false;
    }

    public int distSq(int[] x, int[] y) {
        int a1 = x[0];
        int b1 = x[1];
        int a2 = y[0];
        int b2 = y[1];

        return ((a1 - a2) * (a1 - a2)) + ((b1 - b2) * (b1 - b2));
    }

    public boolean validSuqareDifferent(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] arr = {dis(p1, p2), dis(p1, p3), dis(p1, p4), dis(p2, p3), dis(p2, p4), dis(p3, p4)};
        Arrays.sort(arr);

        return arr[0] > 0 && arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3] && arr[4] == arr[5];
    }

    int dis(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }


}
