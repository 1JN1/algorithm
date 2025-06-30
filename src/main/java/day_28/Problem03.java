package day_28;

import day_09.ListNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/14
 * @description 反转链表II
 **/
public class Problem03 {


    @Test
    public void test() {

        ListNode head = ListNode.createList(new int[]{1, 2, 3, 4, 5});

        head = reverseBetween(head, 2, 4);

        ListNode.printList(head);

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right) {
            return head;
        }

        // 头节点
        ListNode dummy = new ListNode(0, head);

        // pre是第一个翻转节点的前一个节点，p是指向当前要翻转的节点，h指向已经翻转部分的第一个节点，t指向已经翻转部分的最后一个节点
        ListNode pre = dummy, p = head, h = head, t = head;

        for (int i = 0; i < left - 1; i++) {
            pre = p;
            if (p != null) {
                p = p.next;
            }
        }

        h = p;
        t = p;
        if (p != null) {
            p = p.next;
        }


        for (int i = 0; i < right - left; i++) {

            if (p != null) {

                pre.next = p;
                // 保证已翻转部分和其他剩余部分不断链
                t.next = p.next;
                p.next = h;
                h = p;

                p = t.next;
            }

        }

        return dummy.next;
    }

}
