package com.nino.graph;

import java.util.Vector;

/**
 * @Author Nino 2019/11/11
 */
public class SparseWeightedGraph<Weight extends Comparable<Weight>> implements IWeightedGraph<Weight> {
    // 顶点数
    private int V;
    // 边数
    private int E;
    // 是否有向
    private boolean directed;
    // 图的数据
    private Vector<Edge<Weight>>[] g;

    public SparseWeightedGraph(int V, boolean directed) {
        this.V = V;
        this.directed = directed;
        E = 0;
        g = new Vector[V];
        for (int i = 0; i < V; i++) {
            g[i] = new Vector<>(V);
        }
    }

    public SparseWeightedGraph() {
        this(6, false);
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addEdge(Edge<Weight> edge) {
        if (hasEdge(edge.V(), edge.W())) {
            return;
        }
        g[edge.V()].add(new Edge<>(edge));
        if (!directed && edge.V() != edge.W()) {
            g[edge.W()].add(new Edge<>(edge.W(), edge.V(), edge.getWeight()));
        }
        E++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        for (Edge<Weight> edge : g[v]) {
            if (edge.W() == w) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ":\t");
            for (Edge<Weight> edge : g[i]) {
                System.out.print("to " + edge.W() + ", Weight: " + edge.getWeight() + "||\t");
            }
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        return g[v];
    }
}
