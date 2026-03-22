package BinaryTree;

/**
 * @author Caius
 * @description LC 100 相同的树
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * @since Created in 2026-03-22
 */
public class Lc100 {
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

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(q == null || p == null) return p == q;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public static void main(String[] args) {
//        p = [1,2,3], q = [1,2,2]
//        ans = false;
        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.left = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(2);

        boolean sameTree = isSameTree(q, p);
        System.out.println(sameTree);
    }
}
