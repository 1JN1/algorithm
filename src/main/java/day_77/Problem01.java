package day_77;

import day_09.ListNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/1/24
 * @description 两数相加 II
 **/
public class Problem01 {

    @Test
    public void test() {

        ListNode node1 = ListNode.createList(new int[]{7, 2, 4, 3});
        ListNode node2 = ListNode.createList(new int[]{5, 6, 4});

        ListNode.printList(addTwoNumbers(node1, node2));


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l1.val == 0) {
            return l2;
        }

        if (l2 == null || l2.val == 0) {
            return l1;
        }

        ListNode ans = new ListNode(0);

        // 链表逆置
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode p = l1, q = l2;

        int carry = 0;

        while (p != null || q != null) {

            int num1 = p == null ? 0 : p.val;
            int num2 = q == null ? 0 : q.val;
            int sum = num1 + num2 + carry;

            ListNode node = new ListNode(sum % 10);
            node.next = ans.next;
            ans.next = node;

            carry = sum / 10;

            if (p != null) {
                p = p.next;
            }

            if (q != null) {
                q = q.next;
            }

        }

        if (carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = ans.next;
            ans.next = node;
        }

        return ans.next;
    }


    public ListNode reverseList(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode p = cur.next;

        while (cur != null) {

            cur.next = dummy.next;
            dummy.next = cur;
            cur = p;
            if (cur != null) {
                p = cur.next;
            }

        }

        return dummy.next;
    }

}
