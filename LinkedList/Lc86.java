package LinkedList;

import java.util.List;

/**
 * @author Caius
 * @description Lc 86 分隔链表
 *
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * @since Created in 2026/3/24
 */
public class Lc86 {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }

    public static ListNode partition(ListNode head, int x){
        if(head == null) return head;
        ListNode smlDummyNode = new ListNode(0);
        ListNode bigDummyNode = new ListNode(0);

        ListNode smlPtr = smlDummyNode;
        ListNode bigPtr = bigDummyNode;

        ListNode cur = head;
        while(cur != null) {
            if(cur.val >= x) {
                bigPtr.next = cur;
                bigPtr = bigPtr.next;
            }else {
                smlPtr.next = cur;
                smlPtr = smlPtr.next;
            }

            cur = cur.next;
        }

        smlPtr.next = bigDummyNode.next;
        bigPtr.next = null;

        return smlDummyNode.next;
    }

    // Helper method to print the list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Case 1: Example from problem
        // Input: head = [1,4,3,2,5,2], x = 3
        // Expected output: [1,2,2,4,3,5]
        ListNode head1 = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        System.out.print("Test case 1 - Input: ");
        printList(head1);
        ListNode result1 = partition(head1, 3);
        System.out.print("Output: ");
        printList(result1);
        System.out.println("Expected: 1 -> 2 -> 2 -> 4 -> 3 -> 5");
        System.out.println();

        // Test Case 2: All nodes less than x
        // Input: head = [1,2,3], x = 4
        // Expected: [1,2,3] (unchanged)
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.print("Test case 2 - Input: ");
        printList(head2);
        ListNode result2 = partition(head2, 4);
        System.out.print("Output: ");
        printList(result2);
        System.out.println("Expected: 1 -> 2 -> 3");
        System.out.println();

        // Test Case 3: All nodes greater or equal to x
        // Input: head = [4,5,6], x = 3
        // Expected: [4,5,6] (unchanged)
        ListNode head3 = new ListNode(4, new ListNode(5, new ListNode(6)));
        System.out.print("Test case 3 - Input: ");
        printList(head3);
        ListNode result3 = partition(head3, 3);
        System.out.print("Output: ");
        printList(result3);
        System.out.println("Expected: 4 -> 5 -> 6");
        System.out.println();

        // Test Case 4: Single node
        // Input: head = [1], x = 0
        // Expected: [1]
        ListNode head4 = new ListNode(1);
        System.out.print("Test case 4 - Input: ");
        printList(head4);
        ListNode result4 = partition(head4, 0);
        System.out.print("Output: ");
        printList(result4);
        System.out.println("Expected: 1");
        System.out.println();

        // Test Case 5: Empty list
        // Input: head = [], x = 5
        // Expected: []
        ListNode head5 = null;
        System.out.print("Test case 5 - Input: ");
        printList(head5);
        ListNode result5 = partition(head5, 5);
        System.out.print("Output: ");
        printList(result5);
        System.out.println("Expected: (empty)");
        System.out.println();

        // Test Case 6: Duplicate values, including x itself
        // Input: head = [3,3,3,2,2,1], x = 3
        // Expected: [2,2,1,3,3,3] (less than 3 moved to front, keep relative order)
        ListNode head6 = new ListNode(3, new ListNode(3, new ListNode(3, new ListNode(2, new ListNode(2, new ListNode(1))))));
        System.out.print("Test case 6 - Input: ");
        printList(head6);
        ListNode result6 = partition(head6, 3);
        System.out.print("Output: ");
        printList(result6);
        System.out.println("Expected: 2 -> 2 -> 1 -> 3 -> 3 -> 3");
        System.out.println();
    }
}
