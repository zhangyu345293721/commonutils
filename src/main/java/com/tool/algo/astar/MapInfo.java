package com.tool.algo.astar;

/**
 * 包含地图所需的所有输入数据
 *
 * @author: zhangyu
 */
public class MapInfo {
    /**
     * 二维数组的地图
     */
    public int[][] maps;
    /**
     * 地图的宽
     */
    public int width;
    /**
     * 地图的高
     */
    public int hight;
    /**
     * 起始结点
     */
    public Node start;
    /**
     * 最终结点
     */
    public Node end;

    /**
     * 地图信息进行初始化
     *
     * @param maps  地图信息
     * @param width 宽
     * @param hight 高
     * @param start 开始位置
     * @param end   结束位置
     */
    public MapInfo(int[][] maps, int width, int hight, Node start, Node end) {
        this.maps = maps;
        this.width = width;
        this.hight = hight;
        this.start = start;
        this.end = end;
    }
}
