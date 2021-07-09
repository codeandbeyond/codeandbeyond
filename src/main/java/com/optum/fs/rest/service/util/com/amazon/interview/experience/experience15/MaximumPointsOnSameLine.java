package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumPointsOnSameLine {
    static List<Point> pointList = new ArrayList<Point>();

    public static void main(String[] args) {
        int arr[][] = new int[][]{
                {-1, 1},
                {0, 0},
                {1, 1},
                {2, 2},
                {3, 3},
                {3, 4}};
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            Point p = new Point(x, y);
            pointList.add(p);

        }
        maximumPointsOnSameLine(pointList);
    }

    private static void maximumPointsOnSameLine(List<Point> pointList) {
        int overlapPoint = 0;
        int verticalPoint = 0;
        double currMax = 0;
        double maxPoint = 0;

        Map<Double, Integer> slopeMap = new HashMap<Double, Integer>();
        for (int i = 0; i < pointList.size() - 1; i++) {
            Point p1 = pointList.get(i);
            for (int j = i + 1; j < pointList.size(); j++) {
                Point p2 = pointList.get(j);
                if (p1.compareTo(p2) == 0) {

                    overlapPoint++;
                } else if (p1.getX() == p2.getX()) {
                    verticalPoint++;
                } else {
                    Double slope = calculateSlope(p1, p2);
                    if (slopeMap.containsKey(slope)) {
                        slopeMap.put(slope, slopeMap.get(slope) + 1);
                    } else {
                        slopeMap.put(slope, 1);
                    }
                    currMax = Math.max(currMax, slopeMap.get(slope));

                }
                currMax = Math.max(currMax, verticalPoint);

            }
            maxPoint = Math.max(maxPoint, currMax + overlapPoint + 1);
        }
        System.out.println("Maximum points on the lines " + maxPoint);
    }

    private static double calculateSlope(Point p1, Point p2) {
        double diffY = p2.getY()-p1.getY();
        double diffX = p2.getX()-p1.getX();
        double slope = (double) Math.round((diffY/diffX)*100)/100;
        return slope;
    }
}
