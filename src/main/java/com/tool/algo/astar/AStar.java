package com.tool.algo.astar;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A星算法
 * https://www.gamedev.net/articles/programming/artificial-intelligence/a-pathfinding-for-beginners-r2003/
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class AStar {

    /**
     * 障碍值
     */
    public final static int BAR = 1;
    /**
     * 路径
     */
    public final static int PATH = 2;
    /**
     * 横竖移动代价
     */
    public final static int DIRECT_VALUE = 10;
    /**
     * 斜移动代价
     */
    public final static int OBLIQUE_VALUE = 14;

    /**
     * 优先队列(升序)
     */
    Queue<Node> openList = new PriorityQueue<>();
    List<Node> closeList = new ArrayList<>();

    /**
     * 开始算法
     *
     * @param mapInfo 地图信息
     */
    public void start(MapInfo mapInfo) {
        if (mapInfo == null) {
            return;
        }
        openList.clear();
        closeList.clear();
        // 开始搜索
        openList.add(mapInfo.start);
        moveNodes(mapInfo);
    }

    /**
     * 移动当前节点
     *
     * @param mapInfo 地图信息
     */
    private void moveNodes(MapInfo mapInfo) {
        while (!openList.isEmpty()) {
            if (isCoordInClose(mapInfo.end.coord)) {
                drawPath(mapInfo.maps, mapInfo.end);
                break;
            }
            Node current = openList.poll();
            closeList.add(current);
            addNeighborNodeInOpen(mapInfo, current);
        }
    }

    /**
     * 在二维中绘制路径
     *
     * @param maps map数组
     * @param end  结束节点
     */
    private void drawPath(int[][] maps, Node end) {
        if (end == null || maps == null) {
            return;
        }
        System.out.println("总代价：" + end.G);
        while (end != null) {
            Coord c = end.coord;
            maps[c.y][c.x] = PATH;
            end = end.parent;
        }
    }

    /**
     * 添加所有邻结点到open表
     *
     * @param mapInfo 地图信息
     * @param current 当前节点
     */
    private void addNeighborNodeInOpen(MapInfo mapInfo, Node current) {
        int x = current.coord.x;
        int y = current.coord.y;
        // 左
        addNeighborNodeInOpen(mapInfo, current, x - 1, y, DIRECT_VALUE);
        // 上
        addNeighborNodeInOpen(mapInfo, current, x, y - 1, DIRECT_VALUE);
        // 右
        addNeighborNodeInOpen(mapInfo, current, x + 1, y, DIRECT_VALUE);
        // 下
        addNeighborNodeInOpen(mapInfo, current, x, y + 1, DIRECT_VALUE);
        // 左上
        addNeighborNodeInOpen(mapInfo, current, x - 1, y - 1, OBLIQUE_VALUE);
        // 右上
        addNeighborNodeInOpen(mapInfo, current, x + 1, y - 1, OBLIQUE_VALUE);
        // 右下
        addNeighborNodeInOpen(mapInfo, current, x + 1, y + 1, OBLIQUE_VALUE);
        // 左下
        addNeighborNodeInOpen(mapInfo, current, x - 1, y + 1, OBLIQUE_VALUE);
    }

    /**
     * 添加一个邻结点到open表
     *
     * @param mapInfo 地图信息
     * @param current 当前节点
     * @param x       x坐标
     * @param y       y坐标
     * @param value   值
     */
    private void addNeighborNodeInOpen(MapInfo mapInfo, Node current, int x, int y, int value) {
        if (canAddNodeToOpen(mapInfo, x, y)) {
            Node end = mapInfo.end;
            Coord coord = new Coord(x, y);
            int G = current.G + value; // 计算邻结点的G值
            Node child = findNodeInOpen(coord);
            if (child == null) {
                int H = calcH(end.coord, coord); // 计算H值
                if (isEndNode(end.coord, coord)) {
                    child = end;
                    child.parent = current;
                    child.G = G;
                    child.H = H;
                } else {
                    child = new Node(coord, current, G, H);
                }
                openList.add(child);
            } else if (child.G > G) {
                child.G = G;
                child.parent = current;
                openList.add(child);
            }
        }
    }

    /**
     * 从Open列表中查找结点
     *
     * @param coord 位置坐标
     * @return 节点
     */
    private Node findNodeInOpen(Coord coord) {
        if (coord == null || openList.isEmpty()) {
            return null;
        }
        for (Node node : openList) {
            if (node.coord.equals(coord)) {
                return node;
            }
        }
        return null;
    }


    /**
     * 计算H的估值：“曼哈顿”法，坐标分别取差值相加
     *
     * @param end   结束坐标
     * @param coord 坐标
     * @return
     */
    private int calcH(Coord end, Coord coord) {
        return Math.abs(end.x - coord.x)
                + Math.abs(end.y - coord.y);
    }

    /**
     * 判断结点是否是最终结点
     *
     * @param end   结束位置
     * @param coord 位置
     * @return 布尔值
     */
    private boolean isEndNode(Coord end, Coord coord) {
        return coord != null && end.equals(coord);
    }


    /**
     * 判断结点能否放入Open列表
     *
     * @param mapInfo map地图
     * @param x       x坐标
     * @param y       y坐标
     * @return 布尔值
     */
    private boolean canAddNodeToOpen(MapInfo mapInfo, int x, int y) {
        // 是否在地图中
        if (x < 0 || x >= mapInfo.width || y < 0 || y >= mapInfo.hight) {
            return false;
        }
        // 判断是否是不可通过的结点
        if (mapInfo.maps[y][x] == BAR) {
            return false;
        }
        // 判断结点是否存在close表
        if (isCoordInClose(x, y)) {
            return false;
        }
        return true;
    }

    /**
     * 判断坐标是否在close表中
     *
     * @param coord 位置信息
     * @return 布尔值
     */
    private boolean isCoordInClose(Coord coord) {
        return coord != null && isCoordInClose(coord.x, coord.y);
    }

    /**
     * 判断坐标是否在close表中
     *
     * @param x 坐标x
     * @param y 坐标y
     * @return 布尔值
     */
    private boolean isCoordInClose(int x, int y) {
        if (closeList.isEmpty()) {
            return false;
        }
        for (Node node : closeList) {
            if (node.coord.x == x && node.coord.y == y) {
                return true;
            }
        }
        return false;
    }
}
