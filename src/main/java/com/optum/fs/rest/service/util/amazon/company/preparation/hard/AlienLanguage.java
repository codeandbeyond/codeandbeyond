package com.optum.fs.rest.service.util.amazon.company.preparation.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlienLanguage {
    Map<Character, List<Character>> graph = new HashMap<>();
    Map<Character, Boolean> seen = new HashMap<>();

    public String alienOrder(String[] words) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.put(c, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word1.length() > word2.length()) {
                if (word1.startsWith(word2)) return "";
            }

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.get(word2.charAt(j)).add(word1.charAt(j));

                    break;
                }
            }
        }

        StringBuilder output = new StringBuilder();
        boolean cycle = false;

        for (char ch : graph.keySet()) {
            cycle = dfs(graph, ch, output);
            if (cycle) return "";
        }

        if (output.length() < graph.size()) return "";

        return output.toString();
    }

    private boolean dfs(Map<Character, List<Character>> graph, char ch, StringBuilder output) {
        if (seen.containsKey(ch)) {
            return seen.get(ch);
        }
        seen.put(ch, true);
        for (char c : graph.get(ch)) {
            boolean cycle = dfs(graph, c, output);
            if (cycle) return true;
        }
        output.append(ch);
        seen.put(ch, false);
        return false;
    }

    public static void main(String[] args) {
        AlienLanguage alienLanguage = new AlienLanguage();
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        String word = alienLanguage.alienOrder(words);
        System.out.println(word);
    }
}
