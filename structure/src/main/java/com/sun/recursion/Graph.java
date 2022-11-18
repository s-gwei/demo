package com.sun.recursion;

/**
 * author sungw
 *
 * @description BFSDFS实现
 * @date 2021/6/25
 */
public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];// 顶点数组
    private int adjMat[][];// 邻接矩阵
    private int nVerts;// 当前顶点总数

    //自定义栈
    private StackX theStack;

    //自定义队列
    private Queue theQueue;

    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');

        theGraph.addEdge(0, 1);
        theGraph.addEdge(1, 2);
        theGraph.addEdge(0, 3);
        theGraph.addEdge(3, 4);

        System.out.print("visits:");
         theGraph.dfs();
//        theGraph.bfs();
        System.out.println();
    }

    public Graph() {// 构造图
        vertexList = new Vertex[MAX_VERTS];

        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
        theStack = new StackX();
        theQueue = new Queue();
    }

    public void addVertex(char lab) {// 添加顶点
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {// 添加边
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {// 打印数组中v位置下的顶点名
        System.out.print(vertexList[v].lable);
    }

    public int getAdjUnvisitedVertex(int v) {// 获取和v邻接的未访问的顶点
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }

    public void dfs() {// 深度优先搜索
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;// 重置，防止后边再次使用dfs
        }
    }

    public void bfs() {// 广度优先搜索
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.insert(0);
        int v2;

        while (!theQueue.isEmpty()) {
            int v1 = theQueue.remove();

            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }

        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited = false;
        }
    }
}

class StackX {// 自定义栈
    private final int SIZE = 20;
    private int[] st;
    private int top;

    public StackX() {
        st = new int[SIZE];
        top = -1;
    }

    public void push(int j) {
        st[++top] = j;
    }

    public int pop() {
        if (top == 0) {
            return -1;
        }
        return st[--top];
    }

    public int peek() {
        return st[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}

class Queue {
    private final int SIZE = 20;
    private int[] queArray;
    private int front;
    private int rear;

    public Queue() {
        queArray = new int[SIZE];
        front = 0;
        rear = -1;
    }

    public void insert(int j) {// 入队
        if (rear == SIZE - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
    }

    public int remove() {// 出队
        if (!isEmpty()) {
            return queArray[front++];
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return (rear + 1 == front);
    }
}

class Vertex {
    public char lable;// 名字
    public boolean wasVisited;

    public Vertex(char lab) {
        lable = lab;
        wasVisited = false;
    }
}
