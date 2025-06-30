package day_164;

import day_09.ListNode;

/**
 * @author 王文涛
 * @date 2025/6/28
 * @description
 **/
public class Problem02 {

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        return slow;
    }

}
