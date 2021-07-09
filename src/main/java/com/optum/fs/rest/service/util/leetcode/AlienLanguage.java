package com.optum.fs.rest.service.util.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class AlienLanguage {

    class Graph {
        LinkedList<Integer>[] adj;
        private int V;
        private boolean[] marked;
        private Stack<Integer> reversePost;

        public Graph(int V) {
            this.V = V;
            adj = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList();
            }
        }

        public void addEdge(int from, int to) {
            adj[from].add(to);
        }

        public void topological() {
            marked = new boolean[V];
            reversePost = new Stack<>();
            Arrays.fill(marked, false);
            for (int i = 0; i < V; i++) {
                if (!marked[i]) {
                    topologicalUtil(i);
                }
            }
        }

        private void topologicalUtil(int v) {
            marked[v] = true;
            for (int w : this.adj[v]) {
                if (!marked[w]) {
                    topologicalUtil(w);
                }
            }
            reversePost.push(v);
        }

        public void printTopologicalOrder() {
           while(!reversePost.isEmpty()){
               System.out.print((char)('a'+reversePost.pop())+" -> ");
           }
        }
    }

    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        AlienLanguage alienLanguage = new AlienLanguage();
        alienLanguage.printOrder(words, 4);
    }

    private void printOrder(String[] words, int alphabetSize) {
        Graph graph = new Graph(alphabetSize);
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLength = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j) - 'a');
                    break;
                }

            }
        }
        graph.topological();
        graph.printTopologicalOrder();
    }
}
