package com.optum.fs.rest.service.util.leetcode;

public class FloodFill {
    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        floodFill.floodFill(image, sr, sc, 1, newColor);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public void floodFill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) {
            return;
        }

        image[sr][sc] = newColor;
        floodFill(image, sr - 1, sc, color, newColor);
        floodFill(image, sr + 1, sc, color, newColor);
        floodFill(image, sr, sc - 1, color, newColor);
        floodFill(image, sr, sc + 1, color, newColor);

    }
}
