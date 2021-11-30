package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class MatrixChainMultiplication {
    private static char name='A';
    public static void main(String[] args) {
        int p[] = {40, 20, 30, 10, 30};
        printBrackets(p);
    }

    private static void printBrackets(int[] p) {
        int n = p.length;
        int m[][] = new int[n][n];
        int bracket[][] = new int[n][n];
        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k+1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        bracket[i][j] = k;
                    }
                }
            }
        }
        System.out.println("Optimal Prenthesization is ");
        printBracketsOptimally(1, n - 1, n, bracket);
        System.out.println("\n Optimal Cost is "+m[1][n-1]);

    }

    private static void printBracketsOptimally(int i, int j, int n, int[][] bracket) {
        if (i == j) {
            System.out.print(name);
            name++;
            return;
        }
        System.out.print("( ");
        printBracketsOptimally(i, bracket[i][j], n, bracket);
        printBracketsOptimally(bracket[i][j] + 1, j, n, bracket);
        System.out.print(" )");
    }
}
