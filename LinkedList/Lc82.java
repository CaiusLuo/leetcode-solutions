package LinkedList;

/**
 * @author Caius
 * @description LC 82 删除排序链表中间的重复元素
 *
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 *
 * @since Created in 2026-03-21
 */
public class Lc82 {

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

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;

        while(cur.next != null && cur.next.next != null) {
            int val = cur.next.val;
            if(cur.next.next.val == val) {
                while(cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    // --- 辅助工具函数 ---

    /**
     * 打印链表结构
     */
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? " -> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 快速通过数组构造链表
     */
    public static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // 测试用例 1: [1,2,3,3,4,4,5] -> 预期输出: [1,2,5]
        int[] input1 = {1, 2, 3, 3, 4, 4, 5};
        ListNode head1 = createLinkedList(input1);
        System.out.print("Case 1 Input:  ");
        printList(head1);
        ListNode result1 = deleteDuplicates(head1);
        System.out.print("Case 1 Output: ");
        printList(result1);

        System.out.println("---");

        // 测试用例 2: [1,1,1,2,3] -> 预期输出: [2,3]
        int[] input2 = {1, 1, 1, 2, 3};
        ListNode head2 = createLinkedList(input2);
        System.out.print("Case 2 Input:  ");
        printList(head2);
        ListNode result2 = deleteDuplicates(head2);
        System.out.print("Case 2 Output: ");
        printList(result2);
    }
}
