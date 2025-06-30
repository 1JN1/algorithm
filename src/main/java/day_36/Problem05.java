package day_36;

import day_09.ListNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/26
 * @description 环形链表II
 **/
public class Problem05 {

    @Test
    public void test() {

    }

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // 有环
            if (slow == fast) {

                ListNode temp = head;

                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }

                return temp;
            }

        }

        return null;

    }

}
