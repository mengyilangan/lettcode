package com.lettcode.jqn.algorthim.graph;

import java.util.*;

public class DijkstraWeightGraph {
    private int size;
    private Vertex[] vertexes;

    //路径和权重值
    private LinkedHashMap<Integer, Integer>[] adj;

    public DijkstraWeightGraph(int size) {
        this.size = size;
        vertexes = new Vertex[size];
        adj = new LinkedHashMap[size];
        for (int i = 0; i < size; i++) {
            vertexes[i] = new Vertex(i);
            adj[i] = new LinkedHashMap<>();
        }
    }

    public void link(int num1, int num2, int weight) {
        adj[num1].put(num2, weight);
        adj[num2].put(num1, weight);
    }

    //从起点到其他位置的距离表【其实不管三七二十一，把所有距离都计算了一遍】
    public int[] dijkstraDistances(int startIndex) {
        int[] distances = new int[size];
        Arrays.fill(distances, Integer.MAX_VALUE);
        boolean[] visited = new boolean[size];
        distances[startIndex] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startIndex);
        while (!queue.isEmpty()) {
            startIndex = queue.poll();
            if (visited[startIndex]) {
                continue;
            }
            visited[startIndex] = true;

            for (Map.Entry<Integer, Integer> entry : adj[startIndex].entrySet()) {
                int to = entry.getKey();
                int distance = entry.getValue();
                int finalDistance = distances[startIndex] + distance;
                if (finalDistance < distances[to]) {
                    distances[to] = finalDistance;
                }
                queue.add(to);
            }

        }
        return distances;
    }


    //不管三七二十一都记录了一遍,
    public int[] dijkstraDistancesWithPath(int initStartIndex) {
        int[] frontStart = new int[size];
        int[] distances = new int[size];
        Arrays.fill(distances, Integer.MAX_VALUE);
        boolean[] visited = new boolean[size];
        distances[initStartIndex] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(initStartIndex);
        while (!queue.isEmpty()) {
            int startIndex = queue.poll();
            if (visited[startIndex]) {
                continue;
            }
            visited[startIndex] = true;

            for (Map.Entry<Integer, Integer> entry : adj[startIndex].entrySet()) {
                int to = entry.getKey();
                int distance = entry.getValue();
                int finalDistance = distances[startIndex] + distance;
                if (finalDistance < distances[to]) {
                    distances[to] = finalDistance;
                    frontStart[to] = startIndex;
                }
                queue.add(to);
            }
        }
        System.out.println("路径为:");

        return frontStart;
    }

    //从初始位置到其他地方
    public void recordDistance(int startIndex, int[] distances) {
        for (Map.Entry<Integer, Integer> entry : adj[startIndex].entrySet()) {
            int to = entry.getKey();
            int distance = entry.getValue();
            int finalDistance = distances[startIndex] + distance;
            distances[to] = Math.min(finalDistance, distances[to]);
        }
    }


    //永远取最小的数向前试探
    public int[] dijkstraDistancesV2(int start) {
        int[] distances = new int[size + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        boolean[] visited = new boolean[size];
        visited[start] = true;
        distances[start] = 0;
        recordDistance(start, distances);
        while (true) {
            int minIndex = size;
            for (int j = 0; j < size; j++) {
                if (distances[j] < distances[minIndex] && !visited[j]) {
                    minIndex = j;
                }
            }

            if (minIndex == size) {
                break;
            }
            visited[minIndex] = true;
            recordDistance(minIndex, distances);
        }
        return distances;
    }

    private static DijkstraWeightGraph initGraph(int size) {
        DijkstraWeightGraph graph = new DijkstraWeightGraph(size);
        graph.link(0, 1, 5);
        graph.link(0, 2, 2);
        graph.link(1, 3, 1);
        graph.link(1, 4, 6);
        graph.link(2, 3, 6);
        graph.link(2, 5, 8);
        graph.link(3, 4, 1);
        graph.link(3, 5, 2);
        graph.link(4, 6, 7);
        graph.link(5, 6, 3);
        return graph;
    }

    public static void main(String[] args) {
        DijkstraWeightGraph graph = initGraph(7);
        int start = 0;
        int end = 6;
        int[] distances = graph.dijkstraDistances(start);
        System.out.println(distances[end]);
        int[] distancesV2 = graph.dijkstraDistancesV2(start);
        System.out.println(Arrays.toString(distancesV2));
        int[] paths = graph.dijkstraDistancesWithPath(start);
        StringBuilder builder = new StringBuilder();
        builder.append(end);
        while (end != start) {
            end = paths[end];
            builder.insert(0, end + ",");
        }
        System.out.println(builder.toString());
    }
}
