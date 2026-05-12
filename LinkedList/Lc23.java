package LinkedList;

import java.util.PriorityQueue;

/**
 * @author Caius
 * @description Lc 23 合并 K 个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * @since Created in 2026-04-05
 */
public class Lc23 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 使用优先队列（最小堆）合并K个升序链表。
     * 时间复杂度：O(N log K)，其中N为所有节点总数，K为链表数量。
     * 空间复杂度：O(K)，用于存储优先队列中的K个节点。
     * @param lists 链表数组
     * @return 合并后的升序链表
     */
    public static ListNode mergeKLists1(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        for(ListNode node: lists) if(node != null) pq.offer(node);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            if(node.next != null) pq.offer(node.next);
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 使用分治法递归地将K个升序链表合并为一个升序链表。
     * 时间复杂度：O(N log K)，其中N为所有节点总数，K为链表数量。
     * 空间复杂度：O(log K)，主要为递归栈空间。
     * @param lists 链表数组
     * @return 合并后的升序链表
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    /**
     * 二分操作函数
     * @param listNodes
     * @param left
     * @param right
     * @return
     */
    private static ListNode mergeKLists(ListNode[] listNodes, int left, int right) {
        if(left == right) return listNodes[left];
        if(left > right) return null;
        int mid = left + (right - left) / 2;
        ListNode leftNode = mergeKLists(listNodes, left, mid - 1);
        ListNode rightNode = mergeKLists(listNodes, mid + 1, right);
        return margeTwoListNode(leftNode, rightNode);
    }

    /**
     * 合并 双链
     * @param left 左链开头
     * @param right 右链开头
     * @return
     */
    private static ListNode margeTwoListNode(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(left != null && right != null) {
            if(left.val > right.val) {
                cur.next = right;
                right = right.next;
            } else {
                cur.next = left;
                left = left.next;
            }
            cur = cur.next;
        }
        cur.next = (left == null) ? right : left;
        return dummy.next;
    }
    public static void main(String[] args) {
        // 创建测试数据：[[1,4,5], [1,3,4], [2,6]]

        // 链表1: 1 -> 4 -> 5
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));

        // 链表2: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        // 链表3: 2 -> 6
        ListNode list3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = {list1, list2, list3};

        // 合并
        ListNode result = mergeKLists1(lists);

        // 打印结果
        System.out.print("合并结果: ");
        printList(result);
    }
    private static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) {
                System.out.print(" -> ");
            }
            cur = cur.next;
        }
        System.out.println();
    }
}
