package com.optum.fs.rest.service.util.leetcode;

import java.util.*;

public class TopKfrequentWordsinReviews {
    public static void main(String[] args) {
        int k = 2;
        String[] keywords = {"anacell", "cetracular", "betacellular"};
        String[] reviews = {
                "Anacell provides the best services in the city",
                "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell"
        };
        TopKfrequentWordsinReviews topKfrequentWordsinReviews = new TopKfrequentWordsinReviews();
        topKfrequentWordsinReviews.findTopKwords(k, keywords, reviews);
    }

    private void findTopKwords(int k, String[] keywords, String[] reviews) {
        Set<String> allowedwords = new HashSet<>(Arrays.asList(keywords));
        Map<String, Integer> countMap = new HashMap<>();
        for (String review : reviews) {
            String[] words = review.split("\\s");
            Set<String> added = new HashSet<>();
            for (String word : words) {
                if (allowedwords.contains(word) && !added.contains(word)) {
                    countMap.put(word, countMap.getOrDefault(word, 0) + 1);
                    added.add(word);
                }
            }
        }
        Queue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        priorityQueue.addAll(countMap.entrySet());
        while (!priorityQueue.isEmpty() && k-->0){
            System.out.println(priorityQueue.poll().getKey());
        }
    }
}
