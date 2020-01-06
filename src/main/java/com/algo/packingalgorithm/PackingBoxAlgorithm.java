package com.algo.packingalgorithm;

import java.util.*;

/**
 * 装箱算法（考虑到三维）
 *
 * @author: zhangyu
 */
public class PackingBoxAlgorithm {
    // 箱子的型号,盛放空间
    private Map<Integer, Map<String, Object>> boxTypeArr;
    // 订单中的商品
    private Map<Integer, Map<String, Integer>> orderItemArr;
    // 计算结果    map 箱子型号 需要个数
    private Map<String, Integer> result = new HashMap();
    // 计算过程数据,有效的空间列表
    private List<String> inboxinfo = new ArrayList();

    /**
     * 根据箱型以及订单中的商品，返回每个箱型需要箱子多少只。如果没有任何的箱子能装下某一款超大商品的时候，抛出异常
     *
     * @param linkedHashMap
     * @param orderItemArr
     * @return 无返回值
     */
    public PackingBoxAlgorithm(Map<Integer, Map<String, Object>> linkedHashMap, Map<Integer, Map<String, Integer>> orderItemArr) {
        this.boxTypeArr = linkedHashMap;
        this.orderItemArr = orderItemArr;
        //开始执行装箱
        executePackingBox();
    }


    /**
     * boxType.get(boxkey)  value{boxcode=1, l=100, w=100, h=120}
     * boxType.get(boxkey) {boxcode=2, l=200, w=150, h=180}
     * boxType.get(boxkey) {boxcode=3, l=500, w=600, h=700}
     */
    //执行装箱
    private void executePackingBox() {
        Integer[] boxkeys = boxTypeArr.keySet().toArray(new Integer[]{});
        aBoxType:
        for (Integer boxkey : boxkeys) {
            tryInSpance(boxTypeArr.get(boxkey), orderItemArr);
        }
    }

    /**
     * 每次测试1块空间,和全部商品,将商品一次向空间转移,放进去后产生新的3块空间,同时商品的数量再减少,直到商品全部转移;
     *
     * @param boxMap   长l宽w高h  厘米  某1个盒子或者是1个剩余空间
     * @param products 多件商品，装进去一件，删除一件，直到删没了为止
     */
    private void tryInSpance(Map<String, Object> boxMap,
                             Map<Integer, Map<String, Integer>> products) {
        if (null == boxMap || null == products) {
            return;
        }
        Iterator<Integer> gks = products.keySet().iterator();    //对存储商品的Map进行遍历
        while (gks.hasNext()) {
            Integer oid = gks.next();                      //oid就是products的Key
            Map<String, Integer> g = products.get(oid);    //g是具体的商品属性
            // 商品数量
            Integer num = g.get("n");     //获取某种商品的数量
            if (0 == num) {
                return;
            }
            // 多少件商品就循环多少次，每次处理一件；
            for (int i = num; i > 0; i--) {
                String boxcode = boxMap.get("boxcode").toString().concat(":").concat(oid.toString());   //箱的Kye:商品的Key    1:1
                Integer bl = Integer.valueOf(boxMap.get("l").toString());       //箱的长
                Integer bw = Integer.valueOf(boxMap.get("w").toString());       //箱的宽
                Integer bh = Integer.valueOf(boxMap.get("h").toString());       //箱的高
                Integer gl = g.get("l");                                        //商品的长
                Integer gw = g.get("w");                                        //商品的宽
                Integer gh = g.get("h");                                        //商品的高
                // 正面放置商品
                if ((bl - gl) >= 0 && (bw - gw) >= 0 && (bh - gh) >= 0) {
                    // 可以放入的情况下先减少商品的数量；
                    g.put("n", i - 1);
                    // 加入统计
                    inboxinfo.add(boxcode);
                    // 正放的3块剩余空间
                    Map<String, Object> leftover;
                    // 第一块空间
                    leftover = new HashMap<String, Object>();
                    leftover.put("boxcode", boxcode.concat("-1:").concat(oid.toString()));
                    leftover.put("l", gl);
                    leftover.put("w", gw);
                    leftover.put("h", bh - gh);
                    tryInSpance(leftover, products);
                    // 第二块空间
                    leftover = new HashMap();
                    leftover.put("boxcode", boxcode.concat("-2:").concat(oid.toString()));
                    leftover.put("l", gl);
                    leftover.put("w", bw - gw);
                    leftover.put("h", bh);
                    tryInSpance(leftover, products);
                    // 第三块空间
                    leftover = new HashMap();
                    leftover.put("boxcode", boxcode.concat("-3:").concat(oid.toString()));
                    leftover.put("l", bl - gl);
                    leftover.put("w", bw);
                    leftover.put("h", bh);
                    tryInSpance(leftover, products);

                    // 侧面放置商品
                } else if ((bl - gw) >= 0 && (bw - gl) >= 0 && (bh - gh) >= 0) {
                    // 可以放入的情况下先减少商品的数量；
                    g.put("n", i - 1);
                    // 加入统计
                    inboxinfo.add(boxcode);
                    // 侧放的3块剩余空间
                    Map<String, Object> leftover;
                    // 第一块空间
                    leftover = new HashMap();
                    leftover.put("boxcode", boxcode.concat("-1:").concat(oid.toString()));
                    leftover.put("l", gl);
                    leftover.put("w", gw);
                    leftover.put("h", bh - gh);
                    tryInSpance(leftover, products);
                    // 第二块空间
                    leftover = new HashMap();
                    leftover.put("boxcode", boxcode.concat("-2:").concat(oid.toString()));
                    leftover.put("l", bw - gl);
                    leftover.put("w", gw);
                    leftover.put("h", bh);
                    tryInSpance(leftover, products);

                    // 第三块空间
                    leftover = new HashMap();
                    leftover.put("boxcode", boxcode.concat("-3:").concat(oid.toString()));
                    leftover.put("l", bl - gw);
                    leftover.put("w", bw);
                    leftover.put("h", bh);
                    tryInSpance(leftover, products);

                    // 卧倒放置商品
                } else if (g.get("t") == 1 && (bl - gh) >= 0 && (bw - gw) >= 0 && (bw - gl) >= 0) {
                    // 可以放入的情况下先减少商品的数量；
                    g.put("n", i - 1);
                    // 加入统计
                    inboxinfo.add(boxcode);
                    // 侧放的3块剩余空间
                    Map<String, Object> leftover;
                    // 第一块空间
                    leftover = new HashMap<String, Object>();
                    leftover.put("boxcode", boxcode.concat("-1:").concat(oid.toString()));
                    leftover.put("l", gh);
                    leftover.put("w", gw);
                    leftover.put("h", bh - gh);
                    tryInSpance(leftover, products);

                    // 第二块空间
                    leftover = new HashMap<String, Object>();
                    leftover.put("boxcode", boxcode.concat("-2:").concat(oid.toString()));
                    leftover.put("l", bw - gw);
                    leftover.put("w", gh);
                    leftover.put("h", bh);
                    tryInSpance(leftover, products);

                    // 第三块空间
                    leftover = new HashMap<String, Object>();
                    leftover.put("boxcode", boxcode.concat("-3:").concat(oid.toString()));
                    leftover.put("l", bl - gh);
                    leftover.put("w", bw);
                    leftover.put("h", bh);
                    tryInSpance(leftover, products);

                    // 侧卧放置商品
                } else if (g.get("t") == 1 && (bl - gw) >= 0 && (bh - gl) >= 0 && (bw - gh) >= 0) {
                    // 可以放入情况下先减少商品数量；
                    g.put("n", i - 1);
                    // 加入统计
                    inboxinfo.add(boxcode);
                    // 侧放的3块剩余空间
                    Map<String, Object> leftover;
                    // 第一块空间
                    leftover = new HashMap<String, Object>();
                    leftover.put("boxcode", boxcode.concat("-1:").concat(oid.toString()));
                    leftover.put("l", gw);
                    leftover.put("w", gh);
                    leftover.put("h", bh - gl);
                    tryInSpance(leftover, products);
                    // 第二块空间
                    leftover = new HashMap<String, Object>();
                    leftover.put("boxcode", boxcode.concat("-2:").concat(oid.toString()));
                    leftover.put("l", bw - gh);
                    leftover.put("w", gw);
                    leftover.put("h", bh);
                    tryInSpance(leftover, products);
                    // 第三块空间
                    leftover = new HashMap<String, Object>();
                    leftover.put("boxcode", boxcode.concat("-3:").concat(oid.toString()));
                    leftover.put("l", bl - gw);
                    leftover.put("w", bw);
                    leftover.put("h", bh);
                    tryInSpance(leftover, products);

                }
            }
        }
    }

    /**
     * 返回计算后得到的结果
     *
     * @return 箱子的型号, 箱子数量的map
     */
    public Map<String, Integer> getResult() {
        result.clear();
        // 这里开始数数了！
        // 所有装入盒子的商品都放到列表中了，
        // length为特定长度（3）的为商品第一次装入箱子，其它过长（>3）的都是小件商品塞到之前的箱子里的。
        for (String code : inboxinfo) {
            if (code.length() == 3) {
                String boxno = String.valueOf(code.split(":")[0]);
                Integer num = result.get(boxno);
                if (null == num)
                    num = 0;
                num = num + 1;
                result.put(boxno + "", num);
            }
        }
        return this.result;
    }
}

