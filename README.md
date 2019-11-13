# 数据结构之图的学习

学习搭建一个有权图，并实现最小生成树算法(Prim)

---
## 基础文件

其中包含了如何搭建有权图的代码以及图的测试用例

[testG1](./testG1.txt) 图的测试用例

[Edge](./src/com/nino/graph/Edge.java) 边的类

[IWeightedGraph](./src/com/nino/graph/IWeightedGraph.java) 有权图的接口

[DenseWeightedGraph](./src/com/nino/graph/DenseWeightedGraph.java) 有权稠密图

[SparseWeightedGraph](./src/com/nino/graph/SparseWeightedGraph.java) 有权稀疏图

[Main](./src/com/nino/graph/Main.java) 测试用的主文件

---

## LazyPrim算法

### 基础概念

切分(Cut):把图中的节点分为两部分，成为一个切分 

横切边： 一个边的两个端点分别属于切分Cut的不同两边 ，称该边为横切边(Crossing Edge)

切分定理： 给定任意切分，横切边中权值最小的边一定属于最小生成树 

### LazyPrim

1、标记被访问过的节点和未被访问过的节点

2、从任意一点开始访问遍历，寻找与该点相邻的边中权值最小的边，将该边加入最小生成树的容器中，同时将该边另一端的点标记访问并进行2步骤遍历

3、直至最小生成树中边数达到要求，停止2步骤

[MinHeap](./src/com/nino/graph/MinHeap.java) 最小堆 权值最小边辅助算法

[LazyPrimMST](./src/com/nino/graph/LazyPrimMST.java) LazyPrim算法主文件