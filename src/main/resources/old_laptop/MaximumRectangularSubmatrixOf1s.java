package home.practice.company.problems.preparation;

/**
 * Created by Ashok on 01-06-2020.
 */
public class MaximumRectangularSubmatrixOf1s {
    public static void main(String[] args) {
        int R = 4;
        int C = 4;

        int A[][] = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
        };
        System.out.print("Area of maximum rectangle is " + maxRectangle(R, C, A));
    }

    private static int maxRectangle(int r, int c, int[][] a) {

        int area;
        int maxArea = Integer.MIN_VALUE;
        int[] temp = new int[c];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (a[i][j] == 0) {
                    temp[j] = 0;
                } else {
                    temp[j] += a[i][j];
                }

            }
            area = LargestHistoGram.largestArea(temp);
            if (area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }
}
