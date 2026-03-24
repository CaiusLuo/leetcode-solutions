package BinaryTree;

/**
 * @author Caius
 * @description Lc235 二叉搜索树的最近公共祖先
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * @since Created in 2026-03-24
 */
public class Lc235 {
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
        if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        return root;
    }
    public static void main(String[] args) {
        // 构建二叉搜索树
        // 节点定义
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4, node3, node5);
        TreeNode node2 = new TreeNode(2, node0, node4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8, node7, node9);
        TreeNode root = new TreeNode(6, node2, node8);

        // 测试用例
        System.out.println("=== Test Case 1 ===");
        System.out.println("LCA(2,8): " + lowestCommonAncestor(root, node2, node8).val); // 预期 6

        System.out.println("=== Test Case 2 ===");
        System.out.println("LCA(2,4): " + lowestCommonAncestor(root, node2, node4).val); // 预期 2

        System.out.println("=== Test Case 3 ===");
        System.out.println("LCA(3,5): " + lowestCommonAncestor(root, node3, node5).val); // 预期 4

        System.out.println("=== Test Case 4 ===");
        System.out.println("LCA(0,5): " + lowestCommonAncestor(root, node0, node5).val); // 预期 2

        System.out.println("=== Test Case 5 ===");
        System.out.println("LCA(7,9): " + lowestCommonAncestor(root, node7, node9).val); // 预期 8

        System.out.println("=== Test Case 6 ===");
        System.out.println("LCA(6,8): " + lowestCommonAncestor(root, root, node8).val); // 预期 6 (p是祖先)

        System.out.println("=== Test Case 7 ===");
        System.out.println("LCA(2,2): " + lowestCommonAncestor(root, node2, node2).val); // 预期 2 (p==q)

        // 额外测试：一个节点不在树中（但题目保证节点存在），这里只是为了完整性
        System.out.println("=== Test Case 8 ===");
        TreeNode notInTree = new TreeNode(100);
        System.out.println("LCA(6,100) (node 100 not in tree): " + lowestCommonAncestor(root, root, notInTree).val); // 预期 6 (因为100>所有节点，递归到右子树直到null返回null? 实际会返回根，因为p.val>root.val, q.val>root.val，一直递归到右子树，最终找到p或q? 但q不在树中，算法会返回null? 但题目保证p和q都在树中，所以不关心)

        // 空树测试
        System.out.println("=== Test Case 9 ===");
        System.out.println("LCA(null, null, null): " + lowestCommonAncestor(null, null, null)); // 预期 null
    }
}
