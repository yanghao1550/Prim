package com.nino.graph;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 * 读取有权重的图
 *
 * @Author Nino 2019/11/11
 */
public class ReadWeightedGraph {
    private Scanner scanner;

    public ReadWeightedGraph(IWeightedGraph<Double> graph, String fileName) {
        readFile(fileName);
        int V = scanner.nextInt();
        int E = scanner.nextInt();

        for (int i = 0; i < E; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            Double weight = scanner.nextDouble();
            graph.addEdge(new Edge<>(v, w, weight));
        }
    }

    private void readFile(String fileName) {
        File file = new File(fileName);
        try {
            if (file.isFile()) {
                scanner = new Scanner(new BufferedInputStream(new FileInputStream(file)), "utf-8");
                scanner.useLocale(Locale.ENGLISH);
            } else {
                throw new IllegalArgumentException("file is not exist");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
