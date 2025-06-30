package day_43;

import day_09.ListNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/8
 * @description 移除链表元素
 **/
public class Problem01 {

    @Test
    public void test() {

    }

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0, head);

        ListNode p = dummy.next, pre = dummy;

        while (p != null) {

            if (p.val == val) {
                pre.next = p.next;
            } else {
                pre = p;
            }

            p = p.next;
        }

        return dummy.next;
    }

}
