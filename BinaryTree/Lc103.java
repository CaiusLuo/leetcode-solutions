package BinaryTree;

import java.util.*;

/**
 * @author Caius
 * @description Lc 103 二叉树的锯齿形状层序遍历
 * @since Created in 2026-03-23
 */
public class Lc103 {
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

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        List<TreeNode> cur = List.of(root);
        boolean right2Left = false;

        while(!cur.isEmpty()) {
            List<TreeNode> tmp = cur;
            cur = new ArrayList<>();
            List<Integer> nums = new ArrayList<>();

            for(TreeNode node : tmp) {
                nums.add(node.val);
                if(node.left != null) cur.add(node.left);
                if(node.right != null) cur.add(node.right);
            }
            if(right2Left) {
                Collections.reverse(nums);
            }
            right2Left = !right2Left;
            ans.add(nums);
        }
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> ans = zigzagLevelOrder(root);
        for(List<Integer> nums: ans) {
            System.out.print("[");
            for(Integer num: nums) System.out.print(num + " ->");
            System.out.print("]");
        }
    }
}
