package com.optum.fs.rest.service.util.problems.graphs.leetcode;

import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> g = buildgraph(equations, values);
        double result[] = new double[queries.size()];
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            result[i] = getPathWeight(g, start, end, visited);
        }

        return result;

    }

    private double getPathWeight(Map<String, Map<String, Double>> g, String u, String v, Set<String> visited) {
        if (!g.containsKey(u)) {
            return -1.0;
        }
        if (g.get(u).containsKey(v)) {
            return g.get(u).get(v);
        }
        visited.add(u);
        for (Map.Entry<String, Double> neighbour : g.get(u).entrySet()) {
            if (!visited.contains(neighbour.getKey())) {
                double proudctWeight = getPathWeight(g, neighbour.getKey(), v, visited);
                if (proudctWeight != -1.0) {
                    return proudctWeight * neighbour.getValue();
                }
            }
        }
        return -1.0;
    }

    private Map<String, Map<String, Double>> buildgraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int i = 0;
        for (List<String> equation : equations) {
            String u = equation.get(0);
            String v = equation.get(1);
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1 / values[i]);
            i++;
        }
        return graph;

    }

}
