package day_10;

import day_09.ListNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/9/15
 * @description 合并两个有序链表
 **/
public class Problem01 {

    @Test
    public void test() {

        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(1);
        list1.next = new ListNode(2);
        list2.next = new ListNode(3);
        list1.next.next = new ListNode(4);
        list2.next.next = new ListNode(4);

        list1.next.next.next = null;
        list2.next.next.next = null;

        ListNode head = mergeTwoLists(list1, list2);


    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {


        ListNode head = new ListNode(0, null);
        ListNode r = head;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                r.next = list1;
                r = list1;
                list1 = list1.next;
            } else {
                r.next = list2;
                r = list2;
                list2 = list2.next;
            }
        }


        // 链表一还有剩余元素
        if (list1 != null) {
            r.next = list1;
        }

        // 链表二还有剩余元素
        if (list2 != null) {
            r.next = list2;
        }

        return head.next;
    }

}
