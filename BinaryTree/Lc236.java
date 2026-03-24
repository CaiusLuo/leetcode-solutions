package BinaryTree;

/**
 * @author Caius
 * @description Lc 236 二叉树最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * @since Created in 2026-03-24
 */
public class Lc236 {
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

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root) return root;

        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) {
            return root;
        } else if(left != null) {
            return left;
        } else {
            return right;
        }
    }
    public static void main(String[] args) {
        // 构建树: [3,5,1,6,2,0,8,null,null,7,4]
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2, node7, node4);
        TreeNode node5 = new TreeNode(5, node6, node2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node1 = new TreeNode(1, node0, node8);
        TreeNode root = new TreeNode(3, node5, node1);

        System.out.println("=== Test Case 1 ===");
        System.out.println("LCA(5,1): " + lowestCommonAncestor(root, node5, node1).val); // 预期 3
        System.out.println("LCA(5,4): " + lowestCommonAncestor(root, node5, node4).val); // 预期 5
        System.out.println("LCA(6,4): " + lowestCommonAncestor(root, node6, node4).val); // 预期 5
        System.out.println("LCA(2,8): " + lowestCommonAncestor(root, node2, node8).val); // 预期 3
        System.out.println("LCA(7,4): " + lowestCommonAncestor(root, node7, node4).val); // 预期 2
    }
}
