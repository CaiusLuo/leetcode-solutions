package BinaryTree;

/**
 * @author Caius
 * @description Lc 124 二叉树中的最大路径和
 *
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * @since Created in 2026/4/7
 */
public class Lc124 {
    static class  TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static int globalMax;
    public static int maxPathSum(TreeNode root){
        globalMax = Integer.MIN_VALUE;
        dfs(root);
        return globalMax == Integer.MIN_VALUE ? -1 : globalMax;
    }
    private static int dfs(TreeNode node) {
        if(node == null) return 0;
        int leftMax = Math.max(0, dfs(node.left));
        int rightMax = Math.max(0, dfs(node.right));
        globalMax = Math.max(globalMax, node.val + rightMax + leftMax);
        return node.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();
        int ans = maxPathSum(root);
        System.out.println("ans = " + ans);
    }

    public static TreeNode buildTree() {
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode root = new TreeNode(-10, node9, node20);
        return root;
    }
}
