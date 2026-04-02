package DivideConquer;

/**
 * @author Caius
 * @description Lc427 建立四叉树
 *
 * 给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。
 *
 * 你需要返回能表示矩阵 grid 的 四叉树 的根结点。
 *
 * 四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：
 *
 * val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False。注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。
 * isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
 * class Node {
 *     public boolean val;
 *     public boolean isLeaf;
 *     public Node topLeft;
 *     public Node topRight;
 *     public Node bottomLeft;
 *     public Node bottomRight;
 * }
 * 我们可以按以下步骤为二维区域构建四叉树：
 *
 * 如果当前网格的值相同（即，全为 0 或者全为 1），将 isLeaf 设为 True ，将 val 设为网格相应的值，并将四个子节点都设为 Null 然后停止。
 * 如果当前网格的值不同，将 isLeaf 设为 False， 将 val 设为任意值，然后如下图所示，将当前网格划分为四个子网格。
 * 使用适当的子网格递归每个子节点。
 *
 * @since Created in 2026-04-02
 */
public class Lc427 {
    static class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

    public static Node construct(int[][] grid) {
        return buildGraph(grid, 0, 0, grid.length);
    }

    private static Node buildGraph(int[][] grid, int row, int col, int len) {
        if(isSame(grid, row, col, len)){
            return new Node(grid[row][col] == 1, true);
        }
        int half = len / 2;
        Node node = new Node(true, false);
        node.topLeft = buildGraph(grid, row, col, half);
        node.topRight = buildGraph(grid, row, col + half, half);
        node.bottomLeft = buildGraph(grid, row + half, col, half);
        node.bottomRight = buildGraph(grid, row + half, col + half, half);
        return node;
    }

    private static boolean isSame(int[][] grid, int row, int col, int len) {
        int val = grid[row][col];
        for(int i = row; i < row + len; ++i) {
            for(int j = col; j < col + len; ++j) {
                if(grid[i][j] != val) return false;
            }
        }
        return true;
    }
    // 方法1：前序遍历输出四叉树结构
    public static void printQuadTree(Node node) {
        printQuadTreeHelper(node, 0);
    }

    private static void printQuadTreeHelper(Node node, int depth) {
        if (node == null) return;

        // 添加缩进
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append("    ");
        }

        // 输出当前节点信息
        System.out.println(indent.toString() + "Node [isLeaf=" + node.isLeaf +
                           ", val=" + node.val + "]");

        // 如果不是叶子节点，递归输出四个子节点
        if (!node.isLeaf) {
            System.out.println(indent.toString() + "  topLeft:");
            printQuadTreeHelper(node.topLeft, depth + 2);
            System.out.println(indent.toString() + "  topRight:");
            printQuadTreeHelper(node.topRight, depth + 2);
            System.out.println(indent.toString() + "  bottomLeft:");
            printQuadTreeHelper(node.bottomLeft, depth + 2);
            System.out.println(indent.toString() + "  bottomRight:");
            printQuadTreeHelper(node.bottomRight, depth + 2);
        }
    }
    public static void main(String[] args) {
        int[][] grid = {{0,1},{1,0}};
        Node construct = construct(grid);
        printQuadTree(construct);
    }
}
