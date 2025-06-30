package day_09;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/9/14
 * @description 删除链表倒数第N个节点
 **/
public class Problem01 {

    @Test
    public void test() {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = null;


        removeNthFromEnd(head, 1);

    }


    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 方法一、计算长度转换解决

//        // 计算链表长度
//        int len = 0;
//
//        ListNode p = head;
//
//        while (p != null) {
//            len++;
//            p = p.next;
//        }
//
//        // 删除倒数第K个相当于删除正数第K+1个
//        int k = len - n;
//
//        // 删除第一个节点
//        if (k == 0) {
//            return head.next;
//        }
//
//        // 参数错误
//        if (k < 0) {
//            return null;
//        }
//
//        p = head;
//
//        // 找到待删除节点的前一个节点
//        for (int i = 1; i < k; i++) {
//            p = p.next;
//        }
//
//        if (p.next.next == null) {
//            p.next = null;
//        } else {
//            p.next = p.next.next;
//        }
//
//
//        return head;

        // 方法二、双指针

        // 虚构一个头节点，方便操作
        ListNode dummy = new ListNode(0, head);

        ListNode first = head, second = dummy;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }
}
