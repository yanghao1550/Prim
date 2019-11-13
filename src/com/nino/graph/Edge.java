package com.nino.graph;

/**
 * @Author Nino 2019/11/11
 */
public class Edge<Weight extends Number & Comparable<Weight>> implements Comparable<Edge<Weight>> {
    // 顶点v和顶点w
    private int v, w;
    // 权重
    private Weight weight;

    public Edge() {
    }

    public Edge(int v, int w, Weight weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public Edge(Edge<Weight> edge) {
        this.v = edge.v;
        this.w = edge.w;
        this.weight = edge.weight;
    }

    public int V() {
        return v;
    }

    public int W() {
        return w;
    }

    public Weight getWeight() {
        return weight;
    }

    public int other(int x) {
        return v == x ? w : v;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Edge<Weight> o) {
        if (weight.compareTo(o.weight) > 0) {
            return 1;
        } else if (weight.compareTo(o.weight) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
