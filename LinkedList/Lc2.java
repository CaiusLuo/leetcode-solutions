package LinkedList;

/**
 * @author Caius
 * @description LC 2 链表之和
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @since Created in 2026-03-11
 */
public class Lc2 {

   public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    /**
     * 虚拟头结点 / 遍历状态记忆 / 获取变化值先相加后移动逻辑
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       ListNode dummy = new ListNode(0);
       ListNode curr = dummy;
       int cherry = 0;
       while (l1 != null || l2 != null || cherry != 0) {
           int x = (l1 != null) ? l1.val : 0;
           int y = (l2 != null) ? l2.val : 0;

           int sum = x + y + cherry;
           curr.next = new ListNode(sum % 10);
           curr = curr.next;

           cherry = sum / 10;
           if(l1 != null) l1 = l1.next;
           if(l2 != null) l2 = l2.next;
       }
       return dummy.next;
    }
}
