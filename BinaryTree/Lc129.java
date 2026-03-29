package BinaryTree;

/**
 * @author Caius
 * @description Lc129 求根节点到叶子节点的和
 *
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 *
 * @since Created in 2026-03-29
 */
public class Lc129 {

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

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode node, int cur) {
        if(node == null) return 0;
        cur = cur * 10 + node.val;
        if(node.left == null && node.right == null) return cur;
        return dfs(node.left, cur) + dfs(node.right, cur);
    }
    public static void main(String[] args) {
//        root = [4,9,0,5,1]
//        ans = 1026
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(9);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(1);
        node.right = new TreeNode(0);

        int ans = sumNumbers(node);
        System.out.println(ans);
    }
}
