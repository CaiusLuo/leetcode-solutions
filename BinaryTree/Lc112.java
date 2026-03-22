package BinaryTree;

/**
 * @author Caius
 * @description Lc 112 路径总和
 *
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * @since Created in 2026/3/22
 */
public class Lc112 {

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

    public static boolean hashPathSum(TreeNode root, int targetSum){
        if(root == null) return false;
        if(root.left == null && root.right == null && root.val == targetSum) return true;
        return hashPathSum(root.left, targetSum - root.val) || hashPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        // 测试用例 1: 标准二叉树，存在路径
        //       5
        //      / \
        //     4   8
        //    /   / \
        //   11  13  4
        //  /  \      \
        // 7    2      1
        // 目标和: 22 (路径: 5 -> 4 -> 11 -> 2)
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.right.right.right = new TreeNode(1);

        System.out.println("测试 1 (预期 true): " + hashPathSum(root1, 22));

        // 测试用例 2: 不存在匹配路径
        // 目标和: 26
        System.out.println("测试 2 (预期 false): " + hashPathSum(root1, 26));

        // 测试用例 3: 空树
        System.out.println("测试 3 (预期 false): " + hashPathSum(null, 0));

        // 测试用例 4: 只有一个节点
        TreeNode root2 = new TreeNode(1);
        System.out.println("测试 4.1 (1=1, 预期 true): " + hashPathSum(root2, 1));
        System.out.println("测试 4.2 (1!=2, 预期 false): " + hashPathSum(root2, 2));

        // 测试用例 5: 负数节点路径
        //    -2
        //      \
        //      -3
        // 目标和: -5
        TreeNode root3 = new TreeNode(-2);
        root3.right = new TreeNode(-3);
        System.out.println("测试 5 (预期 true): " + hashPathSum(root3, -5));
    }
}
