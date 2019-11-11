package com.nino.graph;

/**
 * 有权图的接口
 *
 * @Author Nino 2019/11/11
 */
public interface IWeightedGraph<Weight extends Comparable<Weight>> {
    // 获取顶点数
    int V();
    // 获取边数
    int E();
    // 增加边
    void addEdge(Edge<Weight> edge);
    // 是否存在v和w的边
    boolean hasEdge(int v, int w);
    // 输出图的数据
    void show();
    // 返回顶点v的边的迭代器
    Iterable<Edge<Weight>> adj(int v);
}
