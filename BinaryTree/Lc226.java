package BinaryTree;

/**
 * @author Caius
 * @description LC 226 翻转二叉树
 *
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * @since Created in 2026-03-22
 */
public class Lc226 {

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

    public static TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private static void dfs(TreeNode node) {
        if(node == null) return;
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        dfs(node.left);
        dfs(node.right);
    }

    public static void main(String[] args) {
//        题目太简单不写案例了
    }
}
