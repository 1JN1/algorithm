package day_47;

import day_09.ListNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/12
 * @description 删除链表中的节点
 **/
public class Problem04 {

    @Test
    public void test() {

    }

    public void deleteNode(ListNode node) {

        node.val = node.next.val;

        node.next = node.next.next;


    }

}
