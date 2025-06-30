package day_56;

import day_09.ListNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/21
 * @description 奇偶链表
 **/
public class Problem02 {

    @Test
    public void test() {

        ListNode head = ListNode.createList(new int[]{2, 1, 3, 5, 6, 4, 7});

        head = oddEvenList(head);

        ListNode.printList(head);

    }

    public ListNode oddEvenList(ListNode head) {


        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode h1 = dummy.next, h2 = dummy.next.next, r = h2, p = r.next, q = p.next;

        int idx = 1;

        while (p != null) {

            // 索引为奇数的节点
            if (idx == 1) {

                h1.next = p;
                p.next = h2;
                h1 = p;
                // 索引为偶数的节点
            } else {

                r.next = p;
                r = p;

            }

            idx = (idx + 1) % 2;
            p = q;
            if (p != null) {
                q = p.next;
            }

        }

        r.next = null;

        return dummy.next;
    }

}
