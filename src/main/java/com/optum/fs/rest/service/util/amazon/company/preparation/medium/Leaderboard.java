package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leaderboard {
    Map<Integer, Integer> idScoreMap;


    public Leaderboard() {
        this.idScoreMap = new HashMap();

    }

    public void addScore(int playerId, int score) {
        idScoreMap.put(playerId, idScoreMap.getOrDefault(playerId, 0) + score);
    }

    public int top(int K) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> b.getValue() - a.getValue());
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : idScoreMap.entrySet()) {
            pq.add(entry);
        }
        while (K-- > 0 && !pq.isEmpty()) {
            result = result + pq.poll().getValue();
        }
        System.out.println(" Result " + result);
        return result;
    }

    public void reset(int playerId) {
        idScoreMap.remove(playerId);
    }

    public static void main(String[] args) {
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.addScore(1, 73);   // leaderboard = [[1,73]];
        leaderboard.addScore(2, 56);   // leaderboard = [[1,73],[2,56]];
        leaderboard.addScore(3, 39);   // leaderboard = [[1,73],[2,56],[3,39]];
        leaderboard.addScore(4, 51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
        leaderboard.addScore(5, 4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
        leaderboard.top(1);           // returns 73;
        leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
        leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
        leaderboard.addScore(2, 51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
        leaderboard.top(3);           // returns 141 = 51 + 51 + 39;
    }

}
