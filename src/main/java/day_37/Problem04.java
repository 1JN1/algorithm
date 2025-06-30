package day_37;

import day_09.ListNode;
import org.junit.Test;


/**
 * @author 王文涛
 * @date 2024/10/31
 * @description
 **/
public class Problem04 {

    @Test
    public void test() {

        ListNode node = ListNode.createList(new int[]{4, 5, 2, 1, 3});
        node = insertionSortList(node);

        ListNode.printList(node);

    }

    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode p = dummy.next.next, q = dummy, after = p.next;
        dummy.next.next = null;

        while (p != null) {

            // 找到待插入位置
            while (q.next != null && q.next.val <= p.val) {
                q = q.next;
            }

            p.next = q.next;
            q.next = p;
            q = dummy;
            p = after;
            if (p != null) {
                after = p.next;
            }

        }

        return dummy.next;
    }

}
