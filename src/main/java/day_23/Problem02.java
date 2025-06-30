package day_23;

import day_09.ListNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/8
 * @description 旋转链表
 **/
public class Problem02 {

    @Test
    public void test() {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = null;

        rotateRight(node, 2);

    }

    public ListNode rotateRight(ListNode head, int k) {

        // 找到待旋转节点
        if (head == null || head.next == null) {
            return head;
        }

        int len = 1;

        ListNode pre = head, p = head;

        // 计算链表长度
        while (p.next != null) {
            p = p.next;
            len++;
        }

        int add = len - k % len;

        if (add == len) {
            return head;
        }

        // 形成闭环
        p.next = head;

        while (add-- > 0) {
            p = p.next;
        }

        pre = p.next;
        p.next = null;

        return pre;
    }


}
