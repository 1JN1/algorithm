package day_01;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/9/4
 * @description 两数相加
 **/
public class Problem02 {


    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    @Test
    public void test() {


        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);


        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);


        ListNode listNode = addTwoNumbers(l1, l2);


    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 进位
        int carry = 0;

        ListNode result = new ListNode(0);

        ListNode p = l1, q = l2, r = result;

        // p, q 均非空
        while (p != null && q != null) {

            int sum = carry + p.val + q.val;

            if (sum >= 10) {
                carry = sum / 10;
                r.next = new ListNode(sum % 10);
            } else {
                carry = 0;
                r.next = new ListNode(sum);
            }

            r = r.next;
            p = p.next;
            q = q.next;
        }

        while (p != null) {

            int sum = carry + p.val;


            if (sum >= 10) {
                carry = sum / 10;
                r.next = new ListNode(sum % 10);
            } else {
                carry = 0;
                r.next = new ListNode(sum);
            }

            r = r.next;
            p = p.next;
        }

        // 处理
        while (q != null) {

            int sum = carry + q.val;


            if (sum >= 10) {
                carry = sum / 10;
                r.next = new ListNode(sum % 10);
            } else {
                carry = 0;
                r.next = new ListNode(sum);
            }

            r = r.next;
            q = q.next;

        }

        if (carry > 0) {
            r.next = new ListNode(carry);
        }

        return result.next;

    }

}
