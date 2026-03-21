package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Caius
 * @description Lc 199 二叉树的右视图
 *
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * @since Created in 2026-03-21
 */
public class Lc199 {
    public static class TreeNode{
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

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private static void dfs(TreeNode node, int cur, List<Integer> ans) {
        if(node == null) return;
        if(ans.size() == cur) ans.add(node.val);

        dfs(node.right, cur + 1, ans);
        dfs(node.left, cur + 1, ans);
    }
    public static void main(String[] args) {
        // 测试用例 1: 标准树
    //      1
    //    /   \
    //   2     3
    //    \     \
    //     5     4
    // 预期输出: [1, 3, 4]
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2, null, new TreeNode(5));
    root1.right = new TreeNode(3, null, new TreeNode(4));

    System.out.println("Test Case 1: " + rightSideView(root1));

    // 测试用例 2: 左侧更深的树 (验证深度逻辑)
    //      1
    //    /   \
    //   2     3
    //  /
    // 4
    // 预期输出: [1, 3, 4]
    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2, new TreeNode(4), null);
    root2.right = new TreeNode(3);

    System.out.println("Test Case 2: " + rightSideView(root2));

    // 测试用例 3: 空树
    // 预期输出: []
    System.out.println("Test Case 3: " + rightSideView(null));
    }
}
