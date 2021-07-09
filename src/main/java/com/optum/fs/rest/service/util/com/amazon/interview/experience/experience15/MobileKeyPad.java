package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class MobileKeyPad {
    // left, up, right, down
// move from current location
    static int row[] = {0, 0, -1, 0, 1};
    static int col[] = {0, -1, 0, 1, 0};

    // Returns count of numbers of length
// n starting from key position
// (i, j) in a numeric keyboard.
    static int getCountUtil(char keypad[][],
                            int i, int j, int n) {
        if (keypad == null || n <= 0)
            return 0;

        // From a given key, only one
        // number is possible of length 1
        if (n == 1)
            return 1;

        int k = 0, move = 0, ro = 0, co = 0, totalCount = 0;

        // move left, up, right, down
        // from current location and if
        // new location is valid, then
        // get number count of length
        // (n-1) from that new position
        // and add in count obtained so far
        for (move = 0; move < 5; move++) {
            ro = i + row[move];
            co = j + col[move];
            if (ro >= 0 && ro <= 3 && co >= 0 && co <= 2 &&
                    keypad[ro][co] != '*' && keypad[ro][co] != '#') {
                totalCount += getCountUtil(keypad, ro, co, n - 1);
            }
        }
        return totalCount;
    }

    // Return count of all possible numbers of length n
// in a given numeric keyboard
    static int getCount(char keypad[][], int n) {
        // Base cases
        if (keypad == null || n <= 0)
            return 0;
        if (n == 1)
            return 10;

        int i = 0, j = 0, totalCount = 0;
        for (i = 0; i < 4; i++) // Loop on keypad row
        {
            for (j = 0; j < 3; j++) // Loop on keypad column
            {
                // Process for 0 to 9 digits
                if (keypad[i][j] != '*' && keypad[i][j] != '#') {
                    // Get count when number is starting from key
                    // position (i, j) and add in count obtained so far
                    totalCount += getCountUtil(keypad, i, j, n);
                }
            }
        }
        return totalCount;
    }

    public static void main(String[] args) {
        char keypad[][] = {{'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'},
                {'*', '0', '#'}};
        System.out.printf("Count for numbers of" +
                " length %d: %d", 1, getCount(keypad, 1));
        System.out.printf("\nCount for numbers of" +
                "length %d: %d", 2, getCount(keypad, 2));
        System.out.printf("\nCount for numbers of" +
                "length %d: %d", 3, getCount(keypad, 3));
        System.out.printf("\nCount for numbers of" +
                "length %d: %d", 4, getCount(keypad, 4));
        System.out.printf("\nCount for numbers of" +
                "length %d: %d", 5, getCountKeyPadDp(keypad, 5));
    }

    public static int getCountKeyPadDp(char keypad[][], int n) {
        if (keypad == null || n < 0) {
            return 0;
        }
        if (n == 1) return 10;

        int count[][] = new int[10][n + 1];
        int[] dx = {0, -1, 0, 1,0};
        int[] dy = {1, 0, -1, 0,0};

        for (int i = 0; i < 10; i++) {
            count[i][1] = 1;
        }

        for (int k = 2; k <= n; k++) {

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (keypad[i][j] != '*' && keypad[i][j] != '#') {
                        int num = keypad[i][j] - '0';
                        count[num][k] = 0;

                        for (int move = 0; move < 5; move++) {
                            int ro = i + dx[move];
                            int col = j + dy[move];

                            if (ro >= 0 && ro < 4 && col >= 0 && col < 3 && keypad[ro][col] != '*' && keypad[ro][col] != '#') {
                                int nextNum = keypad[ro][col] - '0';
                                count[num][k] += count[nextNum][k - 1];
                            }
                        }
                    }
                }
            }
        }
        int totalCount = 0;
        for (int i = 0; i < 10; i++) {
            totalCount += count[i][n];
        }
        return totalCount;
    }
}

