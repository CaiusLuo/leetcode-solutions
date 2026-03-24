package BinaryTree;

/**
 * @author Caius
 * @description Lc 530 二叉搜索树中的最小绝对值
 *
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 * @since Created in 2026-03-24
 */
public class Lc530 {

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

    private static int minDiff = Integer.MAX_VALUE;
    private static Integer prev = null;
    public static int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;
        inorder(root);
        return  minDiff;
    }

    private static void inorder(TreeNode node) {
        if(node.left != null) inorder(node.left);

        if(prev != null) minDiff = Math.min(minDiff, node.val - prev);

        prev = node.val;

        if(node.right != null) inorder(node.right);
    }

    public static void main(String[] args) {
        // 示例1: 构造树 [4,2,6,1,3]
        TreeNode root1 = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(6));
        // 重置静态变量
        minDiff = Integer.MAX_VALUE;
        prev = null;
        System.out.println("示例1 最小差值: " + getMinimumDifference(root1)); // 预期 1

        // 示例2: 构造树 [1,0,48,null,null,12,49]
        TreeNode root2 = new TreeNode(1,
                new TreeNode(0),
                new TreeNode(48, new TreeNode(12), new TreeNode(49)));
        minDiff = Integer.MAX_VALUE;
        prev = null;
        System.out.println("示例2 最小差值: " + getMinimumDifference(root2)); // 预期 1
    }
}
