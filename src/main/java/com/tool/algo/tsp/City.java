package com.tool.algo.tsp;

/**
 * @author zhangyu (zhangyuyu417@gmail.com)
 */

public class City {
    /**
     * 初始化x位置
     */
    int x;
    /**
     * 初始y位置
     */
    int y;

    public City() {
        this.x = (int) (Math.random() * 200);
        this.y = (int) (Math.random() * 200);
    }

    public City(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    /**
     * 计算到城市间的距离
     *
     * @param city 城市
     * @return 布尔值
     */
    public double distanceTo(City city) {
        int xDistance = Math.abs(getX() - city.getX());
        int yDistance = Math.abs(getY() - city.getY());
        return Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
    }

    @Override
    public String toString() {
        return getX() + ", " + getY();
    }
}
