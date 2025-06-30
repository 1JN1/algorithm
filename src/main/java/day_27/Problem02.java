package day_27;

import day_09.ListNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/13
 * @description 删除排序链表中的重复元素II
 **/
public class Problem02 {

    @Test
    public void test() {

        int[] nums = {1, 1, 1, 1, 1};
        ListNode head = ListNode.createList(nums);
        ListNode.printList(head);

        head = deleteDuplicates(head);

        ListNode.printList(head);

    }

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode pre = dummy, cur = dummy.next, p = cur.next;

        while (p != null) {

            while (p != null && p.val == cur.val) {
                p = p.next;
            }

            // 存在重复元素
            if (cur.next != p) {
                pre.next = p;
            } else {
                pre = cur;
            }

            cur = p;
            if (cur != null) {
                p = cur.next;
            }

        }

        return dummy.next;
    }

}
