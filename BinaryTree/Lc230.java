package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Caius
 * @description Lc 230 二叉搜索数的第 k 小元素
 *
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（k 从 1 开始计数）。
 *
 * @since Created in 2026-03-24
 */
public class Lc230 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

   public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list.get(k - 1);
    }

    private static void dfs(TreeNode node, List<Integer> list) {
        if(node == null) return;
        dfs(node.left, list);
        if(node == null) return;
        list.add(node.val);
        dfs(node.right, list);
    }
    public static void main(String[] args) {
        // 测试用例1: [3,1,4,null,2], k=1 -> 预期输出 1
        TreeNode root1 = new TreeNode(3,
                new TreeNode(1, null, new TreeNode(2)),
                new TreeNode(4));
        System.out.println("测试1, k=1: " + kthSmallest(root1, 1)); // 预期 1

        // 测试用例2: [5,3,6,2,4,null,null,1], k=3 -> 预期输出 3
        TreeNode root2 = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2, new TreeNode(1), null),
                        new TreeNode(4)),
                new TreeNode(6));
        System.out.println("测试2, k=3: " + kthSmallest(root2, 3)); // 预期 3

        // 测试用例3: 单节点 [1], k=1 -> 预期输出 1
        TreeNode root3 = new TreeNode(1);
        System.out.println("测试3, k=1: " + kthSmallest(root3, 1)); // 预期 1

        // 测试用例4: 两个节点 [2,1], k=2 -> 预期输出 2
        TreeNode root4 = new TreeNode(2, new TreeNode(1), null);
        System.out.println("测试4, k=2: " + kthSmallest(root4, 2)); // 预期 2
    }
}
