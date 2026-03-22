package BinaryTree;

import java.util.List;

/**
 * @author Caius
 * @description LC 61 旋转链表
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * @since Created in 2026-03-22
 */
public class Lc61 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;

        ListNode tail = head;
        int size = 1;
        while(tail.next != null) {
            tail = tail.next;
            size++;
        }

        int step = size - k % size;
        tail.next = head;
        while(step > 0) {
            head = head.next;
            tail = tail.next;
            step--;
        }
        tail.next = null;
        return head;
    }

    public static void main(String[] args) {
        // Case 1: 标准示例
    // 输入: 1 -> 2 -> 3 -> 4 -> 5, k = 2
    // 输出: 4 -> 5 -> 1 -> 2 -> 3
    test(new int[]{1, 2, 3, 4, 5}, 2, "Case 1");

    // Case 2: k 大于链表长度 (k % length)
    // 输入: 0 -> 1 -> 2, k = 4 (相当于旋转 4%3 = 1 次)
    // 输出: 2 -> 0 -> 1
    test(new int[]{0, 1, 2}, 4, "Case 2");

    // Case 3: 边界情况 (空链表或 k=0)
    // 输入: [], k = 0
    // 输出: []
    test(new int[]{}, 0, "Case 3");
    }

    /**
     * 测试辅助方法
     */
    private static void test(int[] nums, int k, String caseName) {
        ListNode head = buildList(nums);
        System.out.print(caseName + " 前: ");
        printList(head);

        ListNode result = rotateRight(head, k);

        System.out.print(caseName + " 后: ");
        printList(result);
        System.out.println("---");
    }

    private static ListNode buildList(int[] nums) {
        if (nums.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int x : nums) {
            curr.next = new ListNode(x);
            curr = curr.next;
        }
        return dummy.next;
    }

    private static void printList(ListNode head) {
        if (head == null) {
            System.out.println("NULL");
            return;
        }
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }
}
