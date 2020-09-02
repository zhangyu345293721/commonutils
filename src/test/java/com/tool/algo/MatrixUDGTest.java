package com.tool.algo;

import com.tool.algo.dijkstra.MatrixUDG;

import static com.tool.algo.dijkstra.MatrixUDG.INF;

/**
 * @author: zhangyu
 */
public class MatrixUDGTest {

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
