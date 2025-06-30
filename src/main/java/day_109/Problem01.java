package day_109;

import day_09.ListNode;

/**
 * @author 王文涛
 * @date 2025/3/17
 * @description
 **/
public class Problem01 {

    public void deleteNode(ListNode node) {

        ListNode next = node.next;
        int temp = next.val;
        next.val = node.val;
        node.val = temp;

        node.next = next.next;

    }

}
