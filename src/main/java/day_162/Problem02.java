package day_162;

import day_09.ListNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/6/23
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        int[] nums = {4, 5, 1, 2, 3};
        ListNode head = ListNode.createList(nums);
        ListNode.printList(head);
        ListNode newHead = sortList(head);
        ListNode.printList(newHead);
    }

    public ListNode sortList(ListNode head) {


        // 归并排序
        if (head == null || head.next == null) {
            return head;
        }

        // 找出中间节点
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
        ListNode pre = new ListNode();
        ListNode node = pre;
        while (left != null && right != null) {
            if (left.val < right.val) {
                node.next = left;
                left = left.next;
            } else {
                node.next = right;
                right = right.next;
            }
            node = node.next;
        }

        node.next = left == null ? right : left;
        return pre.next;
    }

}
