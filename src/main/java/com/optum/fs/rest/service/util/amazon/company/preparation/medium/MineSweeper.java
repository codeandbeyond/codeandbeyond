package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

public class MineSweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board.length == 0 || board[0].length == 0 || click.length != 2) return board;
        int x = click[0], y = click[1], m = board.length, n = board[0].length;
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
            dfs(board, x, y, m, n, dirs);
        }
        return board;
    }

    private void dfs(char[][] board, int x, int y, int m, int n, int[][] dirs) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'E') return;
        int mine = adjMine(board, x, y, m, n);
        if (mine > 0) {
            board[x][y] = (char) (mine + '0');
        } else {
            board[x][y] = 'B';
            for (int[] dir : dirs) {
                dfs(board, x + dir[0], y + dir[1], m, n, dirs);
            }
        }
    }

    private int adjMine(char[][] board, int x, int y, int m, int n) {
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < m && j >= 0 && j < n && board[i][j] == 'M') {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] board = {{'B', '1', 'E', '1', 'B'}, {'B', '1', 'M', '1', 'B'}, {'B', '1', '1', '1', 'B'}, {'B', 'B', 'B', 'B', 'B'}};
        int[] click = {1, 2};
        MineSweeper mineSweeper = new MineSweeper();
        mineSweeper.updateBoard(board,click);
    for(int i=0;i<board.length;i++){
        for(int j=0;j<board[i].length;j++){
            System.out.print(board[i][j]+"\t");
        }
        System.out.println("");
    }
    }
}
