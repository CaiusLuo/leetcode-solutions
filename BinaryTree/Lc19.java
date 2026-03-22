package BinaryTree;

/**
 * @author Caius
 * @description LC 19 删除链表倒数第 N 个节点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * @since Created in 2026-03-22
 */
public class Lc19 {

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

    public static ListNode removeNthFromEnd(ListNode head, int n){
        if(head == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        while(n > 0) {
            fast = fast.next;
            n--;
        }

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
//        head = [1,2,3,4,5], n = 2 构建链表
//        1=> 2=> 3=> 5 删除 4
        ListNode pre = new ListNode(5);
        ListNode cur = new ListNode(4, pre);
        pre = new ListNode(3, cur);
        cur = new ListNode(2, pre);
        pre = new ListNode(1, cur);
        ListNode node = removeNthFromEnd(pre, 2);
        helpPrint(node);
    }

    private static void helpPrint(ListNode node) {
        while(node.next != null) {
            System.out.print(node.val + "=> ");
            node = node.next;
        }
        System.out.println(node.val);
    }
}
