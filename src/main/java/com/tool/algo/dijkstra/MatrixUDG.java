package com.tool.algo.dijkstra;

/**
 * Dijkstra算法获取最短路径(邻接矩阵)
 *
 * @author: zhangyu
 */

import java.io.IOException;
import java.util.Scanner;

public class MatrixUDG {

    private int mEdgNum;        // 边的数量
    private char[] mVexs;       // 顶点集合
    private int[][] mMatrix;    // 邻接矩阵
    private static final int INF = Integer.MAX_VALUE;   // 最大值

    /**
     * 创建图(自己输入数据)
     */
    public MatrixUDG() {
        System.out.printf("input vertex number: ");
        int vlen = readInt();
        System.out.printf("input edge number: ");
        int elen = readInt();
        if (vlen < 1 || elen < 1 || (elen > (vlen * (vlen - 1)))) {
            System.out.printf("input error: invalid parameters!\n");
            return;
        }

        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            System.out.printf("vertex(%d): ", i);
            mVexs[i] = readChar();
        }

        // 1. 初始化"边"的权值
        mEdgNum = elen;
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                if (i == j)
                    mMatrix[i][j] = 0;
                else
                    mMatrix[i][j] = INF;
            }
        }
        // 2. 初始化"边"的权值: 根据用户的输入进行初始化
        for (int i = 0; i < elen; i++) {
            System.out.printf("edge(%d):", i);
            char c1 = readChar();       // 读取"起始顶点"
            char c2 = readChar();       // 读取"结束顶点"
            int weight = readInt();     // 读取"权值"

            int p1 = getPosition(c1);
            int p2 = getPosition(c2);
            if (p1 == -1 || p2 == -1) {
                System.out.printf("input error: invalid edge!\n");
                return;
            }

            mMatrix[p1][p2] = weight;
            mMatrix[p2][p1] = weight;
        }
    }


    /**
     * 创建图(用已提供的矩阵)
     *
     * @param vexs   顶点数组
     * @param matrix 矩阵(数据)
     */
    public MatrixUDG(char[] vexs, int[][] matrix) {

        int vlen = vexs.length;

        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++)
            mVexs[i] = vexs[i];

        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++)
            for (int j = 0; j < vlen; j++)
                mMatrix[i][j] = matrix[i][j];

        mEdgNum = 0;
        for (int i = 0; i < vlen; i++)
            for (int j = i + 1; j < vlen; j++)
                if (mMatrix[i][j] != INF)
                    mEdgNum++;
    }


    /**
     * 返回ch位置
     *
     * @param ch 字符
     * @return ch位置
     */
    private int getPosition(char ch) {
        for (int i = 0; i < mVexs.length; i++)
            if (mVexs[i] == ch)
                return i;
        return -1;
    }

    /**
     * 读取一个输入字符
     *
     * @return 字符
     */
    private char readChar() {
        char ch = '0';
        do {
            try {
                ch = (char) System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')));
        return ch;
    }

    /**
     * 读取一个输入字符
     *
     * @return 数字
     */
    private int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * 返回顶点v的第一个邻接顶点的索引，失败则返回-1
     */
    private int firstVertex(int v) {
        if (v < 0 || v > (mVexs.length - 1))
            return -1;
        for (int i = 0; i < mVexs.length; i++)
            if (mMatrix[v][i] != 0 && mMatrix[v][i] != INF)
                return i;
        return -1;
    }

    /**
     * 返回顶点v相对于w的下一个邻接顶点的索引，失败则返回-1
     */
    private int nextVertex(int v, int w) {
        if (v < 0 || v > (mVexs.length - 1) || w < 0 || w > (mVexs.length - 1))
            return -1;
        for (int i = w + 1; i < mVexs.length; i++)
            if (mMatrix[v][i] != 0 && mMatrix[v][i] != INF)
                return i;
        return -1;
    }

    /**
     * 深度优先搜索遍历图的递归实现
     */
    private void DFS(int i, boolean[] visited) {

        visited[i] = true;
        System.out.printf("%c ", mVexs[i]);
        for (int w = firstVertex(i); w >= 0; w = nextVertex(i, w)) {
            if (!visited[w])
                DFS(w, visited);
        }
    }

    /*
     * 深度优先搜索遍历图
     */
    public void DFS() {
        boolean[] visited = new boolean[mVexs.length];      
        for (int i = 0; i < mVexs.length; i++) {
            visited[i] = false;
        }
        System.out.printf("DFS: ");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i])
                DFS(i, visited);
        }
        System.out.printf("\n");
    }

    /**
     * 广度优先搜索（类似于树的层次遍历）
     */
    public void BFS() {
        int head = 0;
        int rear = 0;
        int[] queue = new int[mVexs.length];            
        boolean[] visited = new boolean[mVexs.length];  

        for (int i = 0; i < mVexs.length; i++)
            visited[i] = false;

        System.out.printf("BFS: ");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.printf("%c ", mVexs[i]);
                queue[rear++] = i;  
            }

            while (head != rear) {
                int j = queue[head++];  
                for (int k = firstVertex(j); k >= 0; k = nextVertex(j, k)) { 
                    if (!visited[k]) {
                        visited[k] = true;
                        System.out.printf("%c ", mVexs[k]);
                        queue[rear++] = k;
                    }
                }
            }
        }
        System.out.printf("\n");
    }

    /**
     * 打印矩阵队列图
     */
    public void print() {
        System.out.printf("Martix Graph:\n");
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++)
                System.out.printf("%10d ", mMatrix[i][j]);
            System.out.printf("\n");
        }
    }


    /**
     * prim最小生成树
     *
     * @param start 从图中的第start个元素开始，生成最小树
     */
    public void prim(int start) {
        int num = mVexs.length;         
        int index = 0;                    
        char[] prims = new char[num];  
        int[] weights = new int[num];   

        prims[index++] = mVexs[start];

        for (int i = 0; i < num; i++)
            weights[i] = mMatrix[start][i];
        weights[start] = 0;

        for (int i = 0; i < num; i++) {
            if (start == i)
                continue;

            int j = 0;
            int k = 0;
            int min = INF;
            while (j < num) {
                if (weights[j] != 0 && weights[j] < min) {
                    min = weights[j];
                    k = j;
                }
                j++;
            }

            prims[index++] = mVexs[k];
            weights[k] = 0;
            for (j = 0; j < num; j++) {
                if (weights[j] != 0 && mMatrix[k][j] < weights[j])
                    weights[j] = mMatrix[k][j];
            }
        }

        int sum = 0;
        for (int i = 1; i < index; i++) {
            int min = INF;
            int n = getPosition(prims[i]);
            for (int j = 0; j < i; j++) {
                int m = getPosition(prims[j]);
                if (mMatrix[m][n] < min)
                    min = mMatrix[m][n];
            }
            sum += min;
        }
        // 打印最小生成树
        System.out.printf("PRIM(%c)=%d: ", mVexs[start], sum);
        for (int i = 0; i < index; i++)
            System.out.printf("%c ", prims[i]);
        System.out.printf("\n");
    }

    /**
     * 克鲁斯卡尔（Kruskal)最小生成树
     */
    public void kruskal() {
        int index = 0;                      
        int[] vends = new int[mEdgNum];     
        EData[] rets = new EData[mEdgNum];  
        EData[] edges;                      
        edges = getEdges();
        sortEdges(edges, mEdgNum);
        for (int i = 0; i < mEdgNum; i++) {
            int p1 = getPosition(edges[i].start);      
            int p2 = getPosition(edges[i].end);        

            int m = getEnd(vends, p1);                 
            int n = getEnd(vends, p2);                 
            if (m != n) {
                vends[m] = n;                      
                rets[index++] = edges[i];           
            }
        }
        int length = 0;
        for (int i = 0; i < index; i++)
            length += rets[i].weight;
        System.out.printf("Kruskal=%d: ", length);
        for (int i = 0; i < index; i++)
            System.out.printf("(%c,%c) ", rets[i].start, rets[i].end);
        System.out.printf("\n");
    }

    /**
     * 获取图中的边
     */
    private EData[] getEdges() {
        int index = 0;
        EData[] edges;
        edges = new EData[mEdgNum];
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = i + 1; j < mVexs.length; j++) {
                if (mMatrix[i][j] != INF) {
                    edges[index++] = new EData(mVexs[i], mVexs[j], mMatrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 对边按照权值大小进行排序(由小到大)
     */
    private void sortEdges(EData[] edges, int elen) {

        for (int i = 0; i < elen; i++) {
            for (int j = i + 1; j < elen; j++) {

                if (edges[i].weight > edges[j].weight) {
                    // 交换"边i"和"边j"
                    EData tmp = edges[i];
                    edges[i] = edges[j];
                    edges[j] = tmp;
                }
            }
        }
    }

    /**
     * 获取i的终点
     */
    private int getEnd(int[] vends, int i) {
        while (vends[i] != 0)
            i = vends[i];
        return i;
    }

    /**
     * Dijkstra最短路径。
     * 即，统计图中"顶点vs"到其它各个顶点的最短路径。
     *
     * @param vs 起始顶点(start vertex)。即计算"顶点vs"到其它顶点的最短路径
     * @param prev 前驱顶点数组。即，prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点
     * @param dist 长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度
     */
    public void dijkstra(int vs, int[] prev, int[] dist) {
        boolean[] flag = new boolean[mVexs.length];
        for (int i = 0; i < mVexs.length; i++) {
            flag[i] = false;          // 顶点i的最短路径还没获取到。
            prev[i] = 0;              // 顶点i的前驱顶点为0。
            dist[i] = mMatrix[vs][i];  // 顶点i的最短路径为"顶点vs"到"顶点i"的权。
        }
        flag[vs] = true;
        dist[vs] = 0;
        int k = 0;
        for (int i = 1; i < mVexs.length; i++) {
            int min = INF;
            for (int j = 0; j < mVexs.length; j++) {
                if (flag[j] == false && dist[j] < min) {
                    min = dist[j];
                    k = j;
                }
            }
            flag[k] = true;

            for (int j = 0; j < mVexs.length; j++) {
                int tmp = (mMatrix[k][j] == INF ? INF : (min + mMatrix[k][j]));
                if (flag[j] == false && (tmp < dist[j])) {
                    dist[j] = tmp;
                    prev[j] = k;
                }
            }
        }
        System.out.printf("dijkstra(%c): \n", mVexs[vs]);
        for (int i = 0; i < mVexs.length; i++)
            System.out.printf("  shortest(%c, %c)=%d\n", mVexs[vs], mVexs[i], dist[i]);
    }

    /**
     * 边的结构体
     */
    private static class EData {
        char start; 
        char end;   
        int weight; 

        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    ;


    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}};
        MatrixUDG pG;
        pG = new MatrixUDG(vexs, matrix);

        int[] prev = new int[pG.mVexs.length];
        int[] dist = new int[pG.mVexs.length];
        pG.dijkstra(3, prev, dist);
    }
}
