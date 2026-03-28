package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Caius
 * @description Lc133 克隆图
 *
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 *
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 *
 * 测试用例格式：
 *
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 *
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 *
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 *
 * @since Created in 2026/3/28
 */
public class Lc133 {

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static Node cloneGraph(Node node){
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private static Node dfs(Node node, Map<Node, Node> map){
        if(node == null) return node;
        if(map.containsKey(node)) return map.get(node);

        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node, clone);
        for(Node n: node.neighbors){
            clone.neighbors.add(dfs(n, map));
        }
        return clone;
    }
    public static void main(String[] args) {
        // Create nodes
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // Build connections according to adjList = [[2,4],[1,3],[2,4],[1,3]]
        // Node 1 neighbors: [2,4]
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        // Node 2 neighbors: [1,3]
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        // Node 3 neighbors: [2,4]
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        // Node 4 neighbors: [1,3]
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Clone the graph starting from node1
        Node clonedGraph = cloneGraph(node1);

        // Verify the clone
        System.out.println("Original graph (node1):");
        printGraph(node1, new HashMap<>());

        System.out.println("\nCloned graph (node1):");
        printGraph(clonedGraph, new HashMap<>());

        // Verify that the clone is a deep copy (different objects but same structure)
        System.out.println("\nVerification:");
        System.out.println("Original node1 != Cloned node1: " + (node1 != clonedGraph));
        System.out.println("Original node2 != Cloned node2: " +
                (node1.neighbors.get(0) != clonedGraph.neighbors.get(0)));
    }

    // Helper method to print the graph structure
    private static void printGraph(Node node, Map<Node, Boolean> visited) {
        if (node == null || visited.containsKey(node)) return;

        visited.put(node, true);
        System.out.print("Node " + node.val + " neighbors: [");
        for (int i = 0; i < node.neighbors.size(); i++) {
            System.out.print(node.neighbors.get(i).val);
            if (i < node.neighbors.size() - 1) System.out.print(", ");
        }
        System.out.println("]");

        for (Node neighbor : node.neighbors) {
            printGraph(neighbor, visited);
        }
    }
}
