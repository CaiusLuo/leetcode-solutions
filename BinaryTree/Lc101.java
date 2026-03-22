package BinaryTree;

/**
 * @author Caius
 * @description
 * @since Created in 2026-03-22
 */
public class Lc101 {
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

    public static boolean isSymmetric(TreeNode root) {
        return isMirros(root.right, root.left);
    }

    private  static boolean isMirros(TreeNode p, TreeNode q) {
        if(p == null || q == null) return p == q;
        return p.val == q.val && isMirros(p.left, q.right) && isMirros(p.right, q.left);
    }
    public static void main(String[] args) {
//        root = [1,2,2,3,4,4,3]
//        ans = true
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);

        boolean symmetric = isSymmetric(root);
        System.out.println(symmetric);
    }
}
