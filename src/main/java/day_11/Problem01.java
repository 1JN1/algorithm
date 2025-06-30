package day_11;

import day_09.ListNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/9/16
 * @description 两两交换链表中的节点
 **/


public class Problem01 {

    @Test
    public void test() {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = null;

        head = swapPairs(head);

    }


    public ListNode swapPairs(ListNode head) {

//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode newHead = head.next;
//
//        head.next = swapPairs(newHead.next);
//
//        newHead.next = head;
//
//        return newHead;


        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0, head);

        ListNode pre = dummy;

        while (pre.next != null && pre.next.next != null) {

            ListNode p = pre.next, q = pre.next.next;

            pre.next = q;

            p.next = q.next;

            q.next = p;

            pre = p;

        }

        return dummy.next;
    }

}
