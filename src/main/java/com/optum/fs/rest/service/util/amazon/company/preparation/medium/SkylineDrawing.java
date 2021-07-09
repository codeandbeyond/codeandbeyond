package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SkylineDrawing {
    static class BuildingPoint implements Comparable<BuildingPoint> {
        int x;
        boolean isStart;
        int height;

        @Override
        public int compareTo(BuildingPoint o) {
            if (this.x != o.x) {
                return this.x - o.x;
            }
            return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
        }


    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        BuildingPoint[] buildingPoints = new BuildingPoint[2 * buildings.length];
        int index = 0;
        int prevMaxHeight = 0;
        for (int[] building : buildings) {

            buildingPoints[index] = new BuildingPoint();
            buildingPoints[index].x = building[0];
            buildingPoints[index].isStart = true;
            buildingPoints[index].height = building[2];

            buildingPoints[index + 1] = new BuildingPoint();
            buildingPoints[index + 1].x = building[1];
            buildingPoints[index + 1].isStart = false;
            buildingPoints[index + 1].height = building[2];
            index += 2;
        }
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(buildingPoints);
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        queue.put(0, 1);
        for (BuildingPoint buildingPoint : buildingPoints) {
            if (buildingPoint.isStart) {
                queue.put(buildingPoint.height, queue.getOrDefault(buildingPoint.height, 0) + 1);
            } else {
                queue.put(buildingPoint.height, queue.getOrDefault(buildingPoint.height, 0) - 1);
                if (queue.get(buildingPoint.height) == 0) {
                    queue.remove(buildingPoint.height);
                }
            }
            int currentMaxHeight = queue.lastKey();
            if (currentMaxHeight != prevMaxHeight) {
                List<Integer> list = new ArrayList<>();
                list.add(buildingPoint.x);
                list.add(currentMaxHeight);
                results.add(list);
                prevMaxHeight = currentMaxHeight;
            }
        }

        return results;

    }

    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        SkylineDrawing skylineDrawing = new SkylineDrawing();
        List<List<Integer>> results = skylineDrawing.getSkyline(buildings);
        for (List<Integer> p : results) {
            System.out.println(p.get(0) + "<->" + p.get(1));
        }
    }
}
