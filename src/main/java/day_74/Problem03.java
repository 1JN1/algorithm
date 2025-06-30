package day_74;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/1/21
 * @description 扁平化多级双向链表
 **/
public class Problem03 {

    @Test
    public void test() {


        Node node1 = new Node();
        node1.val = 1;
        Node node2 = new Node();
        node2.val = 2;
        Node node3 = new Node();
        node3.val = 3;
        Node node4 = new Node();
        node4.val = 4;
        Node node5 = new Node();
        node5.val = 5;
        Node node6 = new Node();
        node6.val = 6;
        Node node7 = new Node();
        node7.val = 7;
        Node node8 = new Node();
        node8.val = 8;
        Node node9 = new Node();
        node9.val = 9;
        Node node10 = new Node();
        node10.val = 10;
        Node node11 = new Node();
        node11.val = 11;
        Node node12 = new Node();
        node12.val = 12;

        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;

        node3.child = node7;
        node7.next = node8;
        node8.prev = node7;
        node8.next = node9;
        node9.prev = node8;
        node9.next = node10;
        node10.prev = node9;

        node8.child = node11;
        node11.next = node12;
        node12.prev = node11;


        Node node = flatten(node1);

    }

    public Node flatten(Node head) {

        if (head == null) {
            return null;
        }

        Node p = head;

        while (p != null) {

            if (p.child != null) {

                Node begin = p.child;
                Node end = p.child;
                while (end.next != null) {
                    end = end.next;
                }

                if (p.next != null) {
                    p.next.prev = end;
                    end.next = p.next;
                }
                p.next = begin;
                begin.prev = p;

                p.child = null;

            }

            p = p.next;

        }

        return head;
    }


    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

}
