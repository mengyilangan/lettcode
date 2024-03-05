package com.lettcode.jqn.algorthim.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private int size;
    private Vertex[] vertexes;
    //邻接表
    private LinkedList<Integer>[] adj;

    //初始化邻接表
    public Graph(int size) {
        this.size = size;
        vertexes = new Vertex[size];
        adj = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            vertexes[i] = new Vertex(i);
            adj[i] = new LinkedList<>();
        }
    }

    public void link(int num1, int num2) {
        adj[num1].add(num2);
        adj[num2].add(num1);
    }


    public String dfs() {
        StringBuilder builder = new StringBuilder();
        boolean[] visit = new boolean[size];
        Stack<Integer> stack = new Stack<>();

        int first = vertexes[0].data;
        builder.append(first).append(',');
        stack.add(first);
        visit[first] = true;
        while (!stack.isEmpty()) {
            int v = stack.pop();
            for (int a : adj[v]) {
                if (visit[a]) {
                    continue;
                } else {
                    stack.push(v);
                    stack.push(a);
                    visit[a] = true;
                    builder.append(a).append(',');
                    break;
                }
            }
        }
        return builder.toString();
    }

    //广度优先遍历
    public String bfs() {
        StringBuilder builder = new StringBuilder();
        boolean[] visit = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();
        int first = vertexes[0].data;
        builder.append(first).append(',');
        queue.add(first);
        visit[first] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int a : adj[v]) {
                if (visit[a]) {
                    continue;
                }
                visit[a] = true;
                builder.append(a).append(',');
                queue.add(a);
            }
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.link(0, 1);
        graph.link(0, 2);
        graph.link(0, 3);
        graph.link(1, 3);
        graph.link(1, 4);
        graph.link(3, 4);
        graph.link(3, 5);
        graph.link(4, 5);

        System.out.println("广度优先遍历：" + graph.bfs());
        System.out.println("深度优先遍历：" + graph.dfs());
    }

}
