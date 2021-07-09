    package com.optum.fs.rest.service.util.design;


    import java.util.LinkedList;
    import java.util.Objects;

    public class SnakeGame {
        class Point {
            int x;

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Point point = (Point) o;
                return x == point.x &&
                        y == point.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }

            int y;

            Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        int len;
        int rows;
        int cols;
        int[][] food;
        LinkedList<Point> snake;

        public SnakeGame(int width, int height, int[][] food) {
            this.rows = height;
            this.cols = width;
            this.food = food;
            len = 0;
            snake = new LinkedList<Point>();
            snake.add(new Point(0, 0));
        }

        /**
         * Moves the snake.
         *
         * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         * @return The game's score after the move. Return -1 if game over.
         * Game over when snake crosses the screen boundary or bites its body.
         */
        public int move(String direction) {
            Point snakeCurrent = new Point(snake.get(0).x, snake.get(0).y);
            if (direction.equals("U")) {
                snakeCurrent.x--;
            } else if (direction.equals("D")) {
                snakeCurrent.x++;
            } else if (direction.equals("L")) {
                snakeCurrent.y--;
            } else if (direction.equals("R")) {
                snakeCurrent.y++;
            }

            if (snakeCurrent.x < 0 || snakeCurrent.x >= rows || snakeCurrent.y < 0 || snakeCurrent.y >= cols) return -1;
            for (int i = 1; i < snake.size() - 1; i++) {
                Point next = new Point(snake.get(i).x, snake.get(i).y);
                if (snakeCurrent.equals(next)) return -1;
            }
            snake.addFirst(snakeCurrent);
            if (len < food.length) {
                Point foodPoint = new Point(food[len][0], food[len][1]);
                if (snakeCurrent.equals(foodPoint)) {
                    len++;
                }
            }

            if (snake.size() > len + 1) snake.removeLast();
            return len;

        }
    }
