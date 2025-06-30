package day_36;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2024/10/26
 * @description
 **/
public class Problem02 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    @Test
    public void test() {

        Node root = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        root.next = node1;
        root.random = null;

        node1.next = node2;
        node1.random = root;
        node2.next = node3;
        node2.random = node4;
        node3.next = node4;
        node3.random = node2;
        node4.next = null;
        node4.random = root;

        Node newRoot = copyRandomList(root);

    }

    public Node copyRandomList(Node head) {

        Map<Node, Node> map = new HashMap<>();

        // 复制链表，先构造next指针
        Node current = head;
        Node dummy = new Node(0);
        Node r = dummy;

        int i = 0;

        while (current != null) {

            Node temp = new Node(current.val);
            r.next = temp;
            r = r.next;

            map.put(current, temp);

            current = current.next;
        }

        r.next = null;

        current = head;
        r = dummy.next;


        // 构造random指针
        while (current != null) {
            if (current.random == null) {
                r.random = null;
            } else {
                r.random = map.get(current.random);
            }

            current = current.next;
            r = r.next;
        }

        return dummy.next;
    }

}
