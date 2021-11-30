package com.optum.fs.rest.service.util.leetcode;

import com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15.Point;

public class PointLiesInsideTriangle {
    public static void main(String[] args) {
        PointLiesInsideTriangle pointLiesInsideTriangle = new PointLiesInsideTriangle();
        if (pointLiesInsideTriangle.isInside(0, 0, 20, 0, 10, 30, 10, 15))
            System.out.println("Inside");
        else
            System.out.println("Not Inside");

    }

    private boolean isInside(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y) {
        Point a = new Point(x1, y1);
        Point b = new Point(x2, y2);
        Point c = new Point(x3, y3);
        Point p = new Point(x, y);

        double abc = area(a, b, c);
        double pbc = area(p, b, c);
        double pac = area(a, p, c);
        double pab = area(a, b, p);

        if (abc != (pbc + pab + pac)) {
            return false;
        }
        return true;


    }

    public double area(Point p1, Point p2, Point p3) {
        return (p1.getX() * (p2.getY() - p3.getY()) + p2.getX() * (p3.getY() - p1.getY()) + p3.getX() * (p1.getY() - p2.getY())) / 2.0;
    }
}
