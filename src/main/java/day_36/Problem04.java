package day_36;

import day_09.ListNode;
import org.junit.Test;

import java.util.List;

/**
 * @author 王文涛
 * @date 2024/10/26
 * @description 环形链表
 **/
public class Problem04 {

    @Test
    public void test() {

    }

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }

        }

        return false;
    }

}
