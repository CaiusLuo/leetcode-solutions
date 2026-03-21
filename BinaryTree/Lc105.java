package BinaryTree;

/**
 * @author Caius
 * @description Lc 105 前序序列和中序序列返回二叉树
 *
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点
 *
 * @since Created in 2026-03-21
 */
public class Lc105 {
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

    private static int[] preorder = {3,9,20,15,7};
    private static int[] inorder = {9,3,15,20,7};

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private static TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = inStart;
        while(inIndex < inEnd && inorder[inIndex] != preorder[preStart]) inIndex++;

        int leftLen = inIndex - inStart;

        root.left = helper(preorder, preStart + 1, preStart + leftLen, inorder, inStart, inIndex - 1);
        root.right = helper(preorder, preStart + leftLen + 1, preEnd, inorder, inIndex + 1, inEnd);
        return root;
    }
    public static void main(String[] args) {

    }
}
