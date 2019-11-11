package com.nino.graph;

/**
 * @Author Nino 2019/11/11
 */
public class Main {
    public static void main(String[] args) {
        IWeightedGraph<Double> graph = new SparseWeightedGraph<>(8, false);
        new ReadWeightedGraph(graph, "testG1.txt");
        graph.show();
    }
}
