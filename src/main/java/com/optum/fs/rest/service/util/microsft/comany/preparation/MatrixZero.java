package com.optum.fs.rest.service.util.microsft.comany.preparation;

public class MatrixZero {
    public void setZeroes(int[][] matrix) {
        int m  = matrix.length;;
        int n = matrix[0].length;
        boolean row = false;
        boolean col = false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&& matrix[i][j] == 0){
                    row = true;
                }
                if(j==0&& matrix[i][j] == 0){
                    col = true;
                }

                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[0][j] == 0 || matrix[i][0]==0){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j=0;j<n;j++){
            if(row){
                matrix[0][j] = 0;
            }
        }
        for(int i=0;i<m;i++){
            if(col){
                matrix[i][0] = 0;
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        MatrixZero matrixZero = new MatrixZero();
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        matrixZero.setZeroes(matrix);
    }
}
