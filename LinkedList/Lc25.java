package LinkedList;

import java.util.List;

/**
 * @author Caius
 * @description Lc25 K个一组翻转链表
 * @since Created in 2026-03-29
 */
public class Lc25 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val){this.val = val;}
        ListNode(int val , ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reversKGroup(ListNode head, int k) {
        if(head == null) return head;
        ListNode ptr = head;
        int n = 0;
        while(ptr != null) {
            ptr = ptr.next;
            n++;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        while(n >= k) {
            ListNode pre = p0;
            ListNode groupHead = p0.next;
            ListNode cur = p0.next;

            for (int i = 0; i < k; i++) {
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            p0.next = pre;
            groupHead.next = cur;
            p0 = groupHead;
            n -= k;
        }

        return dummy.next;
    }

    private static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) System.out.print(" -> ");
            cur = cur.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode head = new ListNode(1, n2);

        System.out.print("原链表: ");
        printList(head);

        ListNode result = reversKGroup(head, 2);

        System.out.print("翻转后: ");
        printList(result);
    }
}
