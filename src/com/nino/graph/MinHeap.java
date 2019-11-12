package com.nino.graph;

import java.util.Arrays;
import java.util.Random;

/**
 * 最小堆的算法
 * 辅助寻找最短的路径
 *
 * @Author Nino 2019/11/12
 */
public class MinHeap<E extends Comparable> {
    // 堆的具体数据
    private E[] data;
    // 堆中的元素个数
    private int count;
    // 堆的容量
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Comparable[capacity];
        count = 0;
    }

    public int Size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(E e) {
        data[count++] = e;
        siftUp(count - 1);
    }

    public E extractMin() {
        if (isEmpty()) {
            throw new IllegalArgumentException("heap is empty");
        }
        E res = peekMin();
        swap(0, count - 1);
        count--;
        siftDown(0, count - 1);
        return res;
    }

    public E peekMin() {
        return data[0];
    }

    private void swap(int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private int getLeft(int index) {
        return index * 2 + 1;
    }

    private int getRight(int index) {
        return index * 2 + 2;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    /**
     * 对index位置的元素做上浮操作
     *
     * @param index
     */
    private void siftUp(int index) {
        int parentNo;
        while ((parentNo = getParent(index)) >= 0 && data[parentNo].compareTo(data[index]) > 0) {
            swap(parentNo, index);
            index = parentNo;
        }
    }

    /**
     * 对data[]的index位置做下沉操作
     *
     * @param index 下沉位置
     * @param N     下沉终点
     */
    private void siftDown(int index, int N) {
        while (getLeft(index) <= N) {
            int destNo = getLeft(index);
            int rightNo = getRight(index);
            if (rightNo <= N && data[rightNo].compareTo(data[destNo]) < 0) {
                destNo = rightNo;
            }
            if (data[index].compareTo(data[destNo]) <= 0) {
                break;
            }
            swap(index, destNo);
            index = destNo;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    /**
     * 测试最小堆HEAP
     * @param args
     */
    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeap<>(10);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            heap.insert(random.nextInt(50));
        }
        System.out.println(heap);
        System.out.println(heap.extractMin());
        System.out.println(heap.extractMin());
        System.out.println(heap.extractMin());
        System.out.println(heap.extractMin());
    }
}
