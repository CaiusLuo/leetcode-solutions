package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Caius
 * @description Lc 二叉树层平均值
 *
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 *
 * @since Created in 2026/3/22
 */
public class Lc637 {

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

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root == null) return ans;
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        while(!cur.isEmpty()) {
            List<TreeNode> nxt = new ArrayList<>();
            double sum = 0;
            for(TreeNode node: cur){
                sum += node.val;
                if(node.left != null) nxt.add(node.left);
                if(node.right != null) nxt.add(node.right);
            }
            ans.add(sum / cur.size());
            cur = nxt;
        }
        return ans;
    }

    public static void main(String[] args) {
        // 示例 1:
        //      3
        //     / \
        //    9  20
        //      /  \
        //     15   7
        // 层平均值: [3.0, 14.5, 11.0]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        System.out.println("用例 1 结果: " + averageOfLevels(root1));

        // 示例 2:
        //      3
        //     / \
        //    9  20
        //   / \
        //  15  7
        // 层平均值: [3.0, 14.5, 11.0] (结构不同但均值可能相同)
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(9, new TreeNode(15), new TreeNode(7));
        root2.right = new TreeNode(20);

        System.out.println("用例 2 结果: " + averageOfLevels(root2));
    }
}
