package day_32;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 王文涛
 * @date 2024/10/20
 * @description 填充每个节点的下一个右侧节点指针
 **/
public class Problem03 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    @Test
    public void test() {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        connect(root);

    }

    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Node node = queue.poll();

                if (i < size - 1) {
                    node.next = queue.peek();
                } else {
                    node.next = null;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

            }

        }

        return root;
    }

    public Node connect2(Node root) {

        if (root == null) {
            return null;
        }

        Node leftmost = root;

        while (leftmost.left != null) {

            Node head = leftmost;

            while (head != null) {

                head.left.next = head.right;

                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;
            }

            leftmost = leftmost.left;
        }

        return root;
    }

}
