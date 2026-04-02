package BinaryTree;

/**
 * @author Caius
 * @description Lc108 有序数组转换二叉搜索树
 *
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
 *
 * @since Created in 2026-04-02
 */
public class Lc108 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static int[] nums = {-10,-3,0,5,9};
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBST(int[] nums, int left, int rigth) {
        if(left > rigth) return null;
        int mid = left + (rigth - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, rigth);

        return root;
    }

    public static void printTreeStructure(TreeNode root) {
        printTreeHelper(root, 0, "根节点: ");
    }

    private static void printTreeHelper(TreeNode node, int level, String prefix) {
        if(node == null) {
            System.out.println(prefix + "null");
            return;
        }

        // 添加缩进
        StringBuilder indent = new StringBuilder();
        for(int i = 0; i < level; i++) {
            indent.append("    ");
        }

        System.out.println(indent.toString() + prefix + node.val);

        if(node.left != null || node.right != null) {
            printTreeHelper(node.left, level + 1, "左子节点: ");
            printTreeHelper(node.right, level + 1, "右子节点: ");
        }
    }
    public static void main(String[] args) {
        TreeNode treeNode = sortedArrayToBST(nums);
        printTreeStructure(treeNode);
    }
}
