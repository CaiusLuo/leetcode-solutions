package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Caius
 * @description Lc 106 中序遍历和后序遍历返回二叉树
 *
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *
 * @since Created in 2026-03-21
 */
public class Lc106 {

    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }

    private static int[] inorder = {9,3,15,20,7};
    private static int[] postorder = {9,15,7,20,3};
    public TreeNode buildTree(int[] inorder, int[] postorder){
        return helper(inorder, 0, inorder.length - 1 , postorder, 0, postorder.length  -1);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if(inStart > inEnd || postEnd < postStart) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = inEnd;
        while(inIndex > inStart && inorder[inIndex] != postorder[postEnd]) inIndex-- ;

        int leftLen = inIndex - inStart;

        root.left = helper(inorder, inStart, inIndex - 1, postorder, postStart, postStart + leftLen - 1);
        root.right = helper(inorder, inIndex + 1, inEnd, postorder, postStart + leftLen, postEnd - 1);

        return root;
    }

    private static void helpPrint(TreeNode root) {
        if (root == null) {
        System.out.println("[]");
        return;
    }

    List<String> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        TreeNode cur = queue.poll();

        if (cur == null) {
            res.add("null");
        } else {
            res.add(String.valueOf(cur.val));
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
    }

    // 去掉末尾无意义的 null
    int last = res.size() - 1;
    while (last >= 0 && "null".equals(res.get(last))) {
        last--;
    }

    System.out.println(res.subList(0, last + 1));
    }
    public static void main(String[] args) {
        Lc106 solution = new Lc106();
        TreeNode node = solution.buildTree(inorder, postorder);
        helpPrint(node);
    }
}
