package com.optum.fs.rest.service.util.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumberFormedInAnArray {
    public static void main(String[] args) {
        LargestNumberFormedInAnArray largestNumberFormedInAnArray = new LargestNumberFormedInAnArray();
        List<String> stringList = new ArrayList<>();
        stringList.add("54");
        stringList.add("546");
        stringList.add("548");
        stringList.add("60");
        largestNumberFormedInAnArray.printLargest(stringList);
    }

    private void printLargest(List<String> stringList) {
        if (stringList.isEmpty()) return;
        Collections.sort(stringList, (X, Y) -> {
            String XY = X + Y;
            String YX = Y + X;
            return XY.compareTo(YX) > 0 ? -1 : 1;
        });
        for (String str : stringList) {
            System.out.print(str);
        }
    }
}
