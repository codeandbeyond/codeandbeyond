package home.practice.company.problems.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashok on 05-06-2020.
 */
class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Nqueens {
    static int board[][] = {{0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}};
    static int N = 4;
    static List<Pair> pairs = new ArrayList<>();

    public static void main(String[] args) {


        if (!isQueenPlaced(0)) {
            System.out.printf("Solution does not exist \n");

        }
        for (Pair pair : pairs) {
            board[pair.row][pair.col] = 1;
        }
        printSolution(board);
    }

    private static void printSolution(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static boolean isQueenPlaced(int col) {
        if (col >= N) {
            return true;
        }
        int row = 0;
        while (row < board.length) {
            Pair pair = new Pair(row, col);
            pairs.add(pair);
            if (isSafe(row, col) && isQueenPlaced(col + 1)) {
                return true;
            }
            pairs.remove(pair);
            row++;
        }
        return false;
    }

    private static boolean isSafe(int row, int col) {
        for (int i = 0; i < pairs.size() - 1; i++) {
            Pair pair = pairs.get(i);
            int r = pair.row;
            int c = pair.col;
            if (r == row) {
                return false;
            }
            if (Math.abs(row - r) == Math.abs(col - c)) {
                return false;
            }
        }
        return true;
    }
}
