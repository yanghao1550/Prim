package com.nino.graph;

import java.util.Vector;

/**
 * 最小生成树
 * LazyPrim算法
 *
 * @Author Nino 2019/11/13
 */
public class LazyPrimMST<Weight extends Number & Comparable<Weight>> {
    // 图的引用
    private IWeightedGraph<Weight> graph;
    // 最小堆 辅助算法
    private MinHeap<Edge<Weight>> heap;
    // 用于标记图中节点是否被访问
    private boolean[] visited;
    // 存放最小生成树的边
    private Vector<Edge<Weight>> mst;
    // 最小生成树的权重
    private Number mstWeight;

    public LazyPrimMST(IWeightedGraph<Weight> graph) {
        this.graph = graph;
        int N = graph.V();
        heap = new MinHeap<>(graph.E());
        visited = new boolean[N];
        mst = new Vector<>(N);

        // LazyPrim
        visit(0);
        while (mst.size() != N - 1) {
            Edge<Weight> e = heap.extractMin();
            // 如果这条边两个端点都被访问过 则抛弃
            if (visited[e.V()] && visited[e.W()]) {
                continue;
            }
            mst.add(e);
            if (!visited[e.V()]) {
                visit(e.V());
            } else {
                visit(e.W());
            }
        }
        mstWeight = mst.elementAt(0).getWeight();
        for (int i = 1; i < mst.size(); i++) {
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).getWeight().doubleValue();
        }
    }

    private void visit(int v) {
        visited[v] = true;
        for (Edge<Weight> edge : graph.adj(v)) {
            if (!visited[edge.other(v)]) {
                heap.insert(edge);
            }
        }
    }

    public Iterable<Edge<Weight>> getMst() {
        return mst;
    }

    public void showMst() {
        System.out.println("Test LazyPrim MST: ");
        for (Edge<Weight> e : mst) {
            System.out.println(e.V() + " to " + e.W() + ": " + e.getWeight());
        }
    }

    public Number getMstWeight() {
        return mstWeight;
    }
}
