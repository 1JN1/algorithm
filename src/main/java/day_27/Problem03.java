package day_27;

import day_09.ListNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/13
 * @description 删除排序链表中的重复元素
 **/
public class Problem03 {

    @Test
    public void test() {

        ListNode head = ListNode.createList(new int[]{1, 1, 2, 2, 3, 4});

        head = deleteDuplicates(head);

        ListNode.printList(head);

    }

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = head, p = head.next;

        while (p != null) {

            while (p != null && p.val == pre.val) {
                p = p.next;
            }

            pre.next = p;
            pre = p;
            if (pre != null) {
                p = pre.next;
            }

        }

        return head;
    }

}
