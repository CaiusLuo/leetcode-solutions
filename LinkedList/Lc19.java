package LinkedList;

/**
 * @author Caius
 * @description Lc19 删除链表的倒数第 N 个结点
 * @since Created in 2026/3/20
 */
public class Lc19 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n){
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

    public static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Lc19 solution = new Lc19();

        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        System.out.print("原数组:");
        printList(head);

        System.out.println("================");
        ListNode result = solution.removeNthFromEnd(head, 2);
        System.out.print("后数组:");
        printList(result);

    }
}
