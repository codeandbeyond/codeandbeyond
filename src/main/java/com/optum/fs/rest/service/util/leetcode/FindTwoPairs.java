package com.optum.fs.rest.service.util.leetcode;

import java.util.*;

public class FindTwoPairs {
    class Pair {
        int i;
        int j;
        int sum;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 1, 2, 9, 8};
        FindTwoPairs findTwoPairs = new FindTwoPairs();
        findTwoPairs.find(arr);
    }

    private void find(int[] arr) {
        Map<Integer, Pair> sumPair = new HashMap<>();
        Set<String> resultSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (!sumPair.containsKey(sum)) {
                    sumPair.put(sum, new Pair(i, j));
                } else {
                    Pair p = sumPair.get(sum);
                    if (arr[i] != arr[p.i] && arr[i] != arr[p.j] && arr[j] != arr[p.i] && arr[j] != arr[p.j])
                        resultSet.add(arr[i] + "+" + arr[j] + " = " + arr[p.i] + "+" + arr[p.j]);
                }
            }
        }
        System.out.println();
    }

    private void findWithDuplicates(int[] arr) {
        int n = arr.length * (arr.length - 1) / 2;
        int k = 0;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length; j++) {
                pairs[k].i = i;
                pairs[k].j = j;
                pairs[k].sum = arr[i] + arr[j];
            }
        }
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.sum - o2.sum;
            }
        });
        int i = 0;
        int j = n - 1;
        while (i <= n - 1 && j >= 0) {
            if (pairs[i].sum + pairs[j].sum == 11 && noCommonPairs(pairs[i], pairs[j])) {
                System.out.println(arr[pairs[i].i] + " " + arr[pairs[i].j] + " " + arr[pairs[j].i] + " " + arr[pairs[j].j]);
            }
        }
        System.out.println();
    }

    private boolean noCommonPairs(Pair pair, Pair pair1) {
        return (pair.i == pair1.i || pair.i == pair1.j || pair.j == pair1.i || pair.j == pair1.j);
    }
}
