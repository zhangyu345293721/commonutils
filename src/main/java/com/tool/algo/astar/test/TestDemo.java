package com.tool.algo.astar.test;

import com.tool.algo.astar.*;
import com.tool.algo.astar.MapInfo;

/**
 * 迪杰斯特拉是特殊的aStar算法
 * @author: zhangyu
 */
public class TestDemo {

    public static void main(String[] args) throws Exception {
        int[][] maps = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}
        };
        Thread.sleep(20000);
        MapInfo info = new MapInfo(maps, maps[0].length, maps.length, new Node(1, 5), new Node(10, 5));
        new AStar().start(info);
        printMap(maps);
    }

    /**
     * 打印地图
     */
    public static void printMap(int[][] maps) {
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                System.out.print(maps[i][j] + " ");
            }
            System.out.println();
        }
    }
}
