package LinkedList;

/**
 * @author Caius
 * @description Lc142 环形链表
 *
 * @since Created in 2026/5/12
 */
public class Lc142 {
    /**
     * Floyd's cycle detection:
     * 1) Use fast/slow pointers to detect a meeting inside the cycle.
     * 2) Move one pointer to head; advance both one step each time.
     *    The meeting point is the cycle entry.
     * Time: O(n), Space: O(1).
     */
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {this.val = x; this.next = null;}
    }
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                while(head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        testHasCycle();
        testNoCycle();
        testSingleNodeCycle();
        System.out.println("All tests passed.");
    }

    private static void testHasCycle() {
        ListNode head = buildList(new int[]{3, 2, 0, -4});
        ListNode entry = head.next; // node with value 2
        tail(head).next = entry;
        ListNode detected = detectCycle(head);
        assertSame(entry, detected, "testHasCycle");
    }

    private static void testNoCycle() {
        ListNode head = buildList(new int[]{1, 2, 3});
        ListNode detected = detectCycle(head);
        assertSame(null, detected, "testNoCycle");
    }

    private static void testSingleNodeCycle() {
        ListNode head = new ListNode(1);
        head.next = head;
        ListNode detected = detectCycle(head);
        assertSame(head, detected, "testSingleNodeCycle");
    }

    private static ListNode buildList(int[] values) {
        if (values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode cur = head;
        for (int i = 1; i < values.length; i++) {
            cur.next = new ListNode(values[i]);
            cur = cur.next;
        }
        return head;
    }

    private static ListNode tail(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    private static void assertSame(ListNode expected, ListNode actual, String name) {
        if (expected != actual) {
            throw new AssertionError(name + ": expected " + nodeVal(expected) + " but got " + nodeVal(actual));
        }
    }

    private static String nodeVal(ListNode node) {
        return node == null ? "null" : String.valueOf(node.val);
    }
}
