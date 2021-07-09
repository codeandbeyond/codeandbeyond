package com.optum.fs.rest.service.util.leetcode;

public class ForcedPushDominoes {
    public static void main(String[] args) {
        ForcedPushDominoes forcedPushDominoes = new ForcedPushDominoes();
        System.out.println(forcedPushDominoes.pushDominoes(".L.R...LR..L.."));
    }

    public String pushDominoes(String string) {
        char[] dominoes = string.toCharArray();
        int N = dominoes.length;

        int[] forces = new int[N];

        int force = 0;

        for (int i = 0; i < N; i++) {
            if (dominoes[i] == 'R') {
                force = N;
            } else if (dominoes[i] == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] = forces[i] + force;
        }

        for (int i = N - 1; i >= 0; i--) {
            if (dominoes[i] == 'L') {
                force = N;
            } else if (dominoes[i] == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] = forces[i] - force;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer f : forces) {
            if (f > 0) {
                sb.append('R');
            } else if (f < 0) {
                sb.append('L');
            } else {
                sb.append('.');
            }
        }
        return sb.toString();

    }
}
