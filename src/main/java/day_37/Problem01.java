package day_37;

import day_09.ListNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/31
 * @description 重排链表
 **/
public class Problem01 {

    @Test
    public void test() {

        ListNode node = ListNode.createList(new int[]{1});

        reorderList(node);
        ListNode.printList(node);

    }

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ListNode dummy = new ListNode(0, head);

        // 找到中间节点
        ListNode p = dummy.next, q = dummy.next, r = dummy;

        while (p != null && p.next != null) {
            p = p.next.next;
            r = q;
            q = q.next;
        }

        if (p != null) {
            r = q;
            q = q.next;
        }

        r.next = null;
        // 将后半部分链表逆置
        q = reverseList(q);

        p = dummy.next;
        ListNode after = q.next;

        while (q != null) {
            q.next = p.next;
            p.next = q;
            p = q.next;
            q = after;
            if (q != null) {
                after = q.next;
            }
        }

    }

    public ListNode reverseList(ListNode head) {

        ListNode dummy = new ListNode(0, head);

        ListNode p = dummy.next, q = p.next;
        dummy.next = null;
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
