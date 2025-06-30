package day_47;

import day_09.ListNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/12
 * @description 回文链表
 **/
public class Problem01 {

    @Test
    public void test() {

    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode slow = head, fast = head, pre = dummy;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;
        if (fast != null) {
            slow = slow.next;
        }

        slow = reverseList(slow);
        fast = head;

        while (fast != null && slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }


        return (fast == null && slow == null);
    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        dummy.next = null;

        ListNode p = head, q = p.next;

        while (p != null) {

            p.next = dummy.next;
            dummy.next = p;

            p = q;
            if (p != null) {
                q = p.next;
            }

        }


        return dummy.next;
    }

}
