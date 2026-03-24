package BinaryTree;

/**
 * @author Caius
 * @description Lc 144 二叉树转换为链表
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * @since Created in 2026/3/24
 */
public class Lc114 {

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

    /**
     * 展开逻辑 先序遍历 --- 左边切换到右边 --- 右边节点接到左边末尾
     *
     * @param root
     */
    public static void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while(p.right != null) {
            p = p.right;
        }

        p.right = right;
    }

    public static void main(String[] args) {
        //root = [1,2,5,3,4,null,6]
        //ans = [1,null,2,null,3,null,4,null,5,null,6]
        TreeNode cur = new TreeNode(1);
        cur.left = new TreeNode(2);
        cur.right = new TreeNode(5);
        cur.left.left = new TreeNode(3);
        cur.left.right = new TreeNode(4);
        cur.right.right = new TreeNode(6);

        flatten(cur);
        helpPrint(cur);
    }

    private static void helpPrint(TreeNode node){
        TreeNode p = node;
        System.out.print(node.val + "=> ");
        while(p.right != null) {
            System.out.print(p.right.val + "=> ");
            p = p.right;
        }
    }
}
