package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Caius
 * @description LC 102 层序遍历二叉树
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * @since Created in 2026-03-21
 */
public class Lc102 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        while(!cur.isEmpty()) {
            List<TreeNode> nxt = new ArrayList<>();
            List<Integer> value = new ArrayList<>();

            for(TreeNode node: cur) {
                value.add(node.val);
                if(node.left != null) nxt.add(node.left);
                if(node.right != null) nxt.add(node.right);
            }
            cur = nxt;
            ans.add(value);
        }
        return ans;
    }

    public static void printResult(List<List<Integer>> result) {
    System.out.println("[");
    for (List<Integer> level : result) {
        System.out.println("  " + level.toString());
    }
    System.out.println("]");
}
    public static void main(String[] args) {
        // 1. 构建二叉树
    //       3
    //      / \
    //     9  20
    //       /  \
    //      15   7
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    // 2. 调用算法
    List<List<Integer>> result = levelOrder(root);

    // 3. 打印结果
    System.out.println("层序遍历结果：");
    printResult(result);
    }
}
