package com.optum.fs.rest.service.util.problems.graphs.undirected;

import java.io.IOException;

public class DegreeOfSeparation {

    // this class cannot be instantiated
    private DegreeOfSeparation() {
    }

    /**
     * Reads in a social network from a file, and then repeatedly reads in
     * individuals from standard input and prints out their degrees of
     * separation.
     * Takes three command-line arguments: the name of a file,
     * a delimiter, and the name of the distinguished individual.
     * Each line in the file contains the name of a vertex, followed by a
     * list of the names of the vertices adjacent to that vertex,
     * separated by the delimiter.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) throws IOException {
        String filename  = "routes.txt";
        String delimiter = " ";
        String source="JFK";


        // StdOut.println("Source: " + source);

        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph G = sg.graph();
        if (!sg.contains(source)) {
            System.out.println(source + " not in database.");
            return;
        }

        int s = sg.indexOf(source);
        BreadthFirstSearch bfs = new BreadthFirstSearch(G, s);


        String sink = "LAS";
        if (sg.contains(sink)) {
            int t = sg.indexOf(sink);
            if (bfs.hasPathTo(t)) {
                for (int v : bfs.pathTo(t)) {
                    System.out.println("   " + sg.nameOf(v));
                }
            } else {
                System.out.println("Not connected");
            }
        } else {
            System.out.println("   Not in database.");
        }

    }
}
