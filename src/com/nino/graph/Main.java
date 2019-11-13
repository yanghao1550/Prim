package com.nino.graph;

/**
 * @Author Nino 2019/11/11
 */
public class Main {
    public static void main(String[] args) {
        IWeightedGraph<Double> graph = new SparseWeightedGraph<>(8, false);
        new ReadWeightedGraph(graph, "testG1.txt");
        LazyPrimMST<Double> mst = new LazyPrimMST<>(graph);
        mst.showMst();
        System.out.println(mst.getMstWeight());
    }
}
