package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AvoidFloodFill {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> full = new HashMap<>();  // last days that is full
        TreeSet<Integer> drain = new TreeSet<>();  // storage days to be used for drain
        int n = rains.length, res[] = new int[n];
        Arrays.fill(res, 1);  // in case extra draining days not used;
        for (int i = 0; i < rains.length; i++) {
            int lake = rains[i];
            if (full.containsKey(lake)){
                Integer key = drain.ceiling(full.get(lake));  // find if there is a day could be drain after last full
                if (key == null) return new int[]{};  // did not find, flooded
                res[key] = lake;    // set the day to be drained with lake
                drain.remove(key);  // the darining day has already been used;
            }
            if (lake == 0) drain.add(i);  // we got new days
            else {
                full.put(lake, i);
                res[i] = -1;  // lake is 0, or could be dry
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] rains = new int[]{1,2,0,0,2,1};
        AvoidFloodFill avoidFloodFill = new AvoidFloodFill();
        avoidFloodFill.avoidFlood(rains);
    }
}
