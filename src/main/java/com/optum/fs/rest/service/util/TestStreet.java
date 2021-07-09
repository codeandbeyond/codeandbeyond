package com.optum.fs.rest.service.util;

public class TestStreet {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        TestStreet testStreet = new TestStreet();
        System.out.println(testStreet.printSumDiagonal(matrix));
        String word = "Java ";
        System.out.println(testStreet.reverse(word));

    }

    public int printSumDiagonal(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return -1;
        int m = matrix.length;
        int n = matrix[0].length;
        int diagSum = 0;
        int antiDiagSum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    System.out.println("diag:"+matrix[i][j]);
                    diagSum += matrix[i][j];
                }
                if (j == (n - i - 1)) {
                    System.out.println("anti:" + matrix[i][j]);
                    antiDiagSum += matrix[i][j];

                }
            }
        }

        return diagSum+antiDiagSum;
    }

    public String reverse(String word){
        if(word.length() <=1){
            return word;
        }
        return reverse(word.substring(1))+word.substring(0,1);
    }
}
