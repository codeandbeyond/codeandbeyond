package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class Point implements Comparable<Point> {
    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(Point that) {
        return this.getX() == that.getX() && this.getY()==that.getY() ? 0 : 1;
    }
}
