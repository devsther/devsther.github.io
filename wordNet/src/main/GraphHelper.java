package main;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedDFS;

import java.util.Set;
import java.util.TreeSet;

public class GraphHelper {

    public static Set<Integer> hypos(Digraph G, Set<Integer> synsetIDs) {
        DirectedDFS ddfs = new DirectedDFS(G, synsetIDs);
        TreeSet<Integer> neighbors = new TreeSet<>();
        for (int i = 0; i < G.V(); i++) {
            if (ddfs.marked(i)) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }
}
