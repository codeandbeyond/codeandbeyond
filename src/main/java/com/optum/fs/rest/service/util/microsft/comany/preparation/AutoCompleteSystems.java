package com.optum.fs.rest.service.util.microsft.comany.preparation;

import java.util.*;

class AutocompleteSystem {
    TrieNode root;
    String prefix;

    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;

        TrieNode() {
            this.children = new HashMap<>();
            this.counts = new HashMap<>();
        }
    }

    class Pair {
        String s;
        Integer c;

        Pair(String word, Integer count) {
            this.s = word;
            this.c = count;
        }
    }

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        List<String> solution = new ArrayList<>();
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }
        prefix = prefix + c;
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
            TrieNode next = curr.children.get(ch);
            if (next == null) {
                return new ArrayList<>();
            }
            curr = next;
        }
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<Pair>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
        for (String key : curr.counts.keySet()) {
            priorityQueue.add(new Pair(key, curr.counts.get(key)));
        }

        for (int i = 0; i < 3 && !priorityQueue.isEmpty(); i++) {
            solution.add(priorityQueue.poll().s);
        }
        return solution;

    }

    private void add(String word, int count) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            TrieNode next = curr.children.get(c);
            if (next == null) {
                next = new TrieNode();
                curr.children.put(c, next);
            }
            curr = next;
            curr.counts.put(word, curr.counts.getOrDefault(word, 0) + count);
        }
    }

    public static void main(String[] args) {
        String[] sentences = {"i love you", "island","ironman", "i love leetcode"};
        int[] times = {5,3,2,2};
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(sentences,times);
        System.out.println(autocompleteSystem.input('i'));
    }
}
