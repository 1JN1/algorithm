package day_37;

import day_09.ListNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/31
 * @description 排序链表
 **/
public class Problem05 {

    @Test
    public void test() {

        ListNode left = ListNode.createList(new int[]{-1, 5});
        ListNode right = ListNode.createList(new int[]{0, 3, 4});
        ListNode node = merge(left, right);


    }

    public ListNode sortList(ListNode head) {

        // 归并排序
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {

        // 合并两个有序链表
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        ListNode dummy = new ListNode(0, left);

        ListNode p = left, q = right, pre = dummy, last = q.next;

        while (p != null && q != null) {

            while (p != null && p.val < q.val) {
                pre = p;
                p = p.next;
            }

            pre.next = q;
            pre = q;
            if (p != null) {
                q.next = p;
            }

            q = last;
            if (q != null) {
                last = q.next;
            }

        }


        return dummy.next;
    }

}
