package com.tool.algo.astar;

/**
 * 坐标
 *
 * @author: zhangyu
 */
public class Coord {
    /**
     * x的坐标
     */
    public int x;
    /**
     * y的坐标
     */
    public int y;

    /**
     * 坐标初始化
     *
     * @param x x坐标
     * @param y y坐标
     */
    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Coord) {
            Coord c = (Coord) obj;
            return x == c.x && y == c.y;
        }
        return false;
    }
}
