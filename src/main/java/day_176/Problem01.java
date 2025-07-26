package day_176;

import day_09.ListNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/26 9:51
 */
public class Problem01 {

    @Test
    public void test() {

        ListNode head = ListNode.createList(
                new int[]{1, 0, 1}
        );

        System.out.println(getDecimalValue(head));

    }

    public int getDecimalValue(ListNode head) {

        // 求出链表长度
        int len = 0;
        ListNode p = head;

        while (p != null) {
            len++;
            p = p.next;
        }

        p = head;

        int num = 0;

        while (p != null) {
            num += (int) (p.val * Math.pow(2, len - 1));
            len--;
            p = p.next;
        }

        return num;
    }

}
