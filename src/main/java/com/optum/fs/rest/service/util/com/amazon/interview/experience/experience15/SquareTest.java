package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class SquareTest {
    public static void main(String[] args) {
        Point point1 = new Point(10, 10);
        Point point2 = new Point(20, 10);
        Point point3 = new Point(20, 20);
        Point point4 = new Point(10, 20);
        if (isSquare(point1, point2, point3, point4)) {
            System.out.println(" it Forms a Square");
        } else {
            System.out.println(" It does not forms a Square");
        }


    }

    private static boolean isSquare(Point p1, Point p2, Point p3, Point p4) {
        int dist2 = squareDistance(p1, p2);
        int dist3 = squareDistance(p1, p3);
        int dist4 = squareDistance(p1, p4);
        if (dist2 == dist3 && 2 * dist3 == dist4 && 2 * squareDistance(p2, p4) == squareDistance(p2, p3)) {
            return true;
        }
        if (dist3 == dist4 && 2 * dist4 == dist2 && 2 * squareDistance(p2, p3) == squareDistance(p4, p3)) {
            return true;
        }
        if (dist2 == dist4 && 2 * dist4 == dist3 && 2 * squareDistance(p2, p3) == squareDistance(p4, p2)) {
            return true;
        }
        return false;

    }

    private static int squareDistance(Point p, Point q) {
        return (p.getX() - q.getX()) * (p.getX() - q.getX()) + (p.getY() - q.getY()) * (p.getY() - q.getY());
    }

}
