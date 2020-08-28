package com.tool.algo.astar;

/**
 * 路径结点
 *
 * @author: zhangyu
 */
public class Node implements Comparable<Node> {
    /**
     * 坐标
     */
    public Coord coord;
    /**
     * 父结点
     */
    public Node parent;
    /**
     * G：是个准确的值，是起点到当前结点的代价
     */
    public int G;
    /**
     * H：是个估值，当前结点到目的结点的估计代价
     */
    public int H;

    /**
     * 坐标位置x,坐标位置y
     *
     * @param x 位置x
     * @param y 位置y
     */
    public Node(int x, int y) {
        this.coord = new Coord(x, y);
    }

    /**
     * 节点
     *
     * @param coord  坐标位置
     * @param parent 父节点
     * @param g      估值g
     * @param h      估值h
     */
    public Node(Coord coord, Node parent, int g, int h) {
        this.coord = coord;
        this.parent = parent;
        G = g;
        H = h;
    }

    @Override
    public int compareTo(Node o) {
        if (o == null) {
            return -1;
        }
        if (G + H > o.G + o.H) {
            return 1;
        } else if (G + H < o.G + o.H) {
            return -1;
        }
        return 0;
    }
}
