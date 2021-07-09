package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrisonAfterNDays {
    public static void main(String[] args) {
        int[] cells = new int[]{0,1,0,1,1,0,0,1};
        int n = 7;
        PrisonAfterNDays prisonAfterNDays = new PrisonAfterNDays();
        prisonAfterNDays.prisonAfterNDays(cells, n);
        for (int i :  prisonAfterNDays.prisonAfterNDays(cells, n)) {
            System.out.print(i + " ");
        }
    }

    public int[] prisonAfterNDays(int[] cells, int n) {
        if (cells == null || cells.length == 0 || n < 0) return cells;
        boolean hasCycle = false;
        Set<String> set = new HashSet();
        int cycle = 0;


        for (int i = 0; i < n; i++) {
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            if (!set.contains(key)) {
                set.add(key);
                cycle++;
            } else {
                hasCycle = true;
                break;
            }
            cells = next;

        }
        if (hasCycle) {
            n = n % cycle;
            for (int i = 0; i < n; i++) {
                cells = nextDay(cells);
            }
        }

        return cells;
    }

    private int[] nextDay(int[] cells) {
        int[] next = new int[cells.length];
        for (int i = 1; i < cells.length-1; i++) {
            next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return next;
    }
}
