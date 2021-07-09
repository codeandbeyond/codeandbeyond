package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

public class NegativeNumbersSortedMatrix {
    public static void main(String[] args) {
        NegativeNumbersSortedMatrix negativeNumbersSortedMatrix = new NegativeNumbersSortedMatrix();
        int[][] nums = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        negativeNumbersSortedMatrix.countNegatives(nums);
    }
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length, r = m - 1, c = 0, cnt = 0;
        while (r >= 0 && c < n) {
            if (grid[r][c] < 0) {
                --r;
                cnt += n - c; // there are n - c negative numbers in current row.
            }else {
                ++c;
            }
        }
        return cnt;
    }
}
