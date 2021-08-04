package com.tool.function.treetool;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试二叉树操作的方法
 *
 * @author: zhangyu
 */
public class TreeTestDemo {
    /**
     * 构造的二叉树：
     * <p>
     * 先序遍历：DLR
     * 1 2 4 8 9 5 3 6 7
     * 中序遍历：LDR
     * 8 4 2 9 5 1 6 3 7
     * 后序遍历：LRD
     * 8 9 4 5 2 6 7 3 1
     * 深度优先遍历
     * 1 2 4 8 9 5 3 6 7
     * 广度优先遍历
     * 1 2 3 4 5 6 7 8 9
     */
    @Test
    public void traverseFunTestDemo() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = TreeTool.constructTree(arr);
        TreeTool.show(root);

        List<Integer> list1 = new ArrayList<>();
        TreeTool.preOrderTraverse(root, list1);
        System.out.println("前序遍历：" + list1);// DLR

        List<Integer> list2 = new ArrayList<>();
        TreeTool.inOrderTraverse(root, list2);
        System.out.println("中序遍历：" + list2);//LDR

        List<Integer> list3 = new ArrayList<>();
        TreeTool.postOrderTraverse(root, list3);
        System.out.println("后序遍历：" + list3);//LRD

        List<Integer> list4 = TreeTool.depthOrderTraversal(root);//深度遍历
        System.out.println("深度遍历: " + list4);
        List<Integer> list5 = TreeTool.levelOrderTraversal(root);//广度遍历
        System.out.println("广度遍历: " + list5);
    }
}
