package com.optum.fs.rest.service.util.leetcode;

public class PrintBalancedParenthesisForN {
    public static void main(String[] args) {
        PrintBalancedParenthesisForN printBalancedParenthesisForN = new PrintBalancedParenthesisForN();
        printBalancedParenthesisForN.print(4);
    }

    private void print(int n) {
        char[] str = new char[2 * n];
        printBalancedUtil(str, 0, 0, 0, n);
    }

    private void printBalancedUtil(char[] str, int open, int close, int pos, int n) {
        if (close == n) {
            for (char c : str) {
                System.out.print(c);
            }
            System.out.println();
            return;
        }
        if (open > close) {
            str[pos] = '}';
            printBalancedUtil(str, open, close + 1, pos + 1, n);
        }
        if (open < n) {
            str[pos] = '{';
            printBalancedUtil(str, open + 1, close, pos + 1, n);
        }
    }
}
