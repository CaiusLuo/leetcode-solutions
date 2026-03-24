package BinaryTree;

/**
 * @author Caius
 * @description LC 98 验证二叉搜索树
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 严格小于 当前节点的数。
 * 节点的右子树只包含 严格大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @since Created in 2026-03-24
 */
public class Lc98 {
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

    public static boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean dfs(TreeNode node, long min, long max) {
         if(node == null) return true;

         if(node.val >= max || node.val <= min) return false;

         return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
    }

    public static void main(String[] args) {
         // 测试用例1：有效 BST [2,1,3]
        TreeNode root1 = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3));
        System.out.println("测试1 [2,1,3] → " + isValidBST(root1)); // 预期 true

        // 测试用例2：无效 BST [5,1,4,null,null,3,6]
        TreeNode root2 = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println("测试2 [5,1,4,null,null,3,6] → " + isValidBST(root2)); // 预期 false

        // 测试用例3：单节点 [1]
        TreeNode root3 = new TreeNode(1);
        System.out.println("测试3 [1] → " + isValidBST(root3)); // 预期 true

        // 测试用例4：边界值 [Integer.MIN_VALUE, null, Integer.MAX_VALUE]
        TreeNode root4 = new TreeNode(Integer.MIN_VALUE,
                null,
                new TreeNode(Integer.MAX_VALUE));
        System.out.println("测试4 [MIN, null, MAX] → " + isValidBST(root4)); // 预期 true

        // 测试用例5：复杂无效 [10,5,15,null,null,6,20]
        // 6 位于右子树中，但小于根节点 10，因此无效
        TreeNode root5 = new TreeNode(10,
                new TreeNode(5),
                new TreeNode(15, new TreeNode(6), new TreeNode(20)));
        System.out.println("测试5 [10,5,15,null,null,6,20] → " + isValidBST(root5)); // 预期 false
    }
}
