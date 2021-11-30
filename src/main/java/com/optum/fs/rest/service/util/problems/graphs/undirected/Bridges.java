package com.optum.fs.rest.service.util.problems.graphs.undirected;

import java.util.*;

public class Bridges {
    private Set<Integer> articulationPoints = new HashSet<>();
    private int bridges;      // number of bridges
    private int time;          // counter
    private int[] disc;        // disc[v] = order in which dfs examines v
    private int[] low;        // low[v] = lowest preorder of any vertex connected to v

    public Bridges(Graph G) {
        List<List<Integer>> results = new ArrayList();

        low = new int[G.V()];
        disc = new int[G.V()];
        Arrays.fill(low, -1);
        Arrays.fill(disc, -1);
        for (int v = 0; v < G.V(); v++)
            if (disc[v] == -1)
                dfs(G, v, v, results);
        System.out.println(" ");
        for(Integer point:articulationPoints){
            System.out.print(point+" ");
        }
    }

    public int components() {
        return bridges + 1;
    }

    private void dfs(Graph G, int u, int v, List<List<Integer>> results) {
        low[v] =  disc[v] = time++;// first time discovered
        for (int w : G.adj(v)) {
            if (disc[w] == -1) {
                dfs(G, v, w, results);
                low[v] = Math.min(low[v], low[w]);
                if (low[w] == disc[w]) {
                    List<Integer> pair = new ArrayList<>();
                    System.out.println(v + "-" + w + " is a bridge");
                    articulationPoints.add(v);
                    articulationPoints.add(w);
                    pair.add(v);
                    pair.add(w);
                    results.add(pair);
                    bridges++;
                }
            }

            // update low number - ignore reverse of edge leading to v
            else if (w != u)
                low[v] = Math.min(low[v], disc[w]);
        }
    }

    public int getBridges() {
        return bridges;
    }

    // test client
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(0, 1);
        g.addEdge(1, 3);
//        g.addEdge(5, 4);
//        g.addEdge(5, 6);
//        g.addEdge(6, 7);
//        g.addEdge(9, 8);
//        g.addEdge(0, 1);

        Bridges bridge = new Bridges(g);
        System.out.println(" Number of Bridges are " + bridge.getBridges());
        System.out.println("Edge connected components = " + bridge.components());
        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> pair = new ArrayList<>();
        List<Integer> pair2 = new ArrayList<>();
        List<Integer> pair3 = new ArrayList<>();
        List<Integer> pair4 = new ArrayList<>();
        List<Integer> pair6 = new ArrayList<>();
        List<Integer> pair5 = new ArrayList<>();
        List<Integer> pair8 = new ArrayList<>();
        List<Integer> pair9 = new ArrayList<>();
        List<Integer> pair10 = new ArrayList<>();
        pair.add(0);
        pair.add(2);
        pair2.add(2);
        pair2.add(4);
        pair3.add(0);
        pair3.add(3);
        pair4.add(7);
        pair4.add(5);
        pair5.add(5);
        pair5.add(4);
        pair6.add(5);
        pair6.add(6);
        pair8.add(6);
        pair8.add(7);
        pair9.add(9);
        pair9.add(8);
        pair10.add(0);
        pair10.add(1);
        connections.add(pair);
        connections.add(pair2);
        connections.add(pair3);
        connections.add(pair4);
        connections.add(pair5);
        connections.add(pair6);
        connections.add(pair8);
        connections.add(pair9);
        connections.add(pair10);


        bridge.criticalConnections(10, connections);
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        // build adjacency list
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }
        for (List<Integer> l : connections) {
            adj[l.get(0)].add(l.get(1));
            adj[l.get(1)].add(l.get(0));
        }

        // store the timestamp when a node was first visited
        // initialized with -1, indicating not visited yet
        int[] timeFirstVisited = new int[n];
        Arrays.fill(timeFirstVisited, -1);

        // result: final result holding all critical connections
        List<List<Integer>> result = new ArrayList<>();

        dfs(0, -1, 0, adj, timeFirstVisited, result);
        return result;
    }

    // current: current node being visited
    // parent: previous node from which we come to current
    // timer: clock to timestamp a node when it was first visited
    // adj: adjacency list to represent the graph of all conenctions
    public void dfs(int current, int parent, int timer, List<Integer>[] adj, int[] timeFirstVisited, List<List<Integer>> result) {

        // timestamp current node being visited
        timeFirstVisited[current] = timer;

        // iterate all neighbors of current node
        for (int neighbor : adj[current]) {

            // skip parent node from which we came to current, so we avoid trivial circle such as parent -> current -> parent
            if (parent == neighbor) continue;

            // visited the neighbor that has not been visited yet
            if (timeFirstVisited[neighbor] < 0) dfs(neighbor, current, timer + 1, adj, timeFirstVisited, result);

            // check if a neighbor has a smaller timestamp, if so, use the minimun among the neighbors and backtrack it, this is where you need to understand Tarjan's algorithm. We use the smallest timestamp among the neighbors to back propogate that we have detected a circle. Any edge of a circle must not be a critical conenction, because even if we remove it, we can still reach any node from any other node.
            timeFirstVisited[current] = Math.min(timeFirstVisited[current], timeFirstVisited[neighbor]);

            // if a neighbor has bigger timestamp, it must have not been visited before current node, meaning no circle has been detected, so it's a critical connection. We add it to the final result
            if (timeFirstVisited[neighbor] > timer) result.add(Arrays.asList(current, neighbor));
        }
    }


}

