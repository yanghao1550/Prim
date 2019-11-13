package com.nino.graph;

import java.util.Vector;

/**
 * @Author Nino 2019/11/11
 */
public class DenseWeightedGraph<Weight extends Number & Comparable<Weight>> implements IWeightedGraph<Weight> {
    // 顶点数
    private int V;
    // 边数
    private int E;
    // 是否是有向图
    private boolean directed;
    // 图的具体数据
    private Edge<Weight>[][] g;

    public DenseWeightedGraph(int V, boolean directed) {
        this.V = V;
        this.directed = directed;
        E = 0;
        g = new Edge[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                g[i][j] = null;
            }
        }
    }

    public DenseWeightedGraph() {
        this(5, false);
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
        g[edge.V()][edge.W()] = new Edge<>(edge);
        if (!directed && edge.V() != edge.W()) {
            g[edge.W()][edge.V()] = new Edge<>(edge.W(), edge.V(), edge.getWeight());
        }
        E++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        return g[v][w] != null;
    }

    @Override
    public void show() {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (g[i][j] != null) {
                    System.out.print(g[i][j].getWeight() + "\t");
                } else {
                    System.out.print("null\t");
                }
            }
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        Vector<Edge<Weight>> adjV = new Vector<>(V);
        for (int i = 0; i < V; i++) {
            if (hasEdge(v, i)) {
                adjV.add(g[v][i]);
            }
        }
        return adjV;
    }
}
