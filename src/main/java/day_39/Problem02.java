package day_39;

import day_09.ListNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/4
 * @description 相交链表
 **/
public class Problem02 {

    @Test
    public void test() {

        ListNode node = ListNode.createList(new int[]{1, 2, 3, 4, 5});

        System.out.println(getLength(node));

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // 求链表长度
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        ListNode p = headA, q = headB;

        if (lenB > lenA) {
            p = headB;
            q = headA;
        }

        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            p = p.next;
        }

        while (p != null && q != null) {
            if (p == q) {
                return p;
            }
            p = p.next;
            q = q.next;
        }

        return null;
    }

    public int getLength(ListNode head) {

        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }

        return len;
    }

}
