package day_172;

public class RedBlackTree {
    
    // 定义颜色
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    
    // 节点类
    private static class Node {
        int data;
        Node left, right, parent;
        boolean color; // 颜色（红色或黑色）

        public Node(int data) {
            this.data = data;
            this.color = RED; // 默认节点是红色
            this.left = this.right = this.parent = null;
        }
    }

    private Node root;
    
    // 插入节点
    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            root.color = BLACK; // 根节点为黑色
            return;
        }

        Node temp = root;
        while (true) {
            if (data < temp.data) {
                if (temp.left == null) {
                    temp.left = newNode;
                    newNode.parent = temp;
                    break;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    newNode.parent = temp;
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }

        // 插入节点后的修复操作
        fixInsert(newNode);
    }

    // 修复插入后的红黑树
    private void fixInsert(Node node) {
        while (node != root && node.parent.color == RED) {
            if (node.parent == node.parent.parent.left) {
                Node uncle = node.parent.parent.right;
                if (uncle != null && uncle.color == RED) {
                    // Case 1: 叔叔节点是红色的
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        // Case 2: 当前节点是右子节点，进行左旋转
                        node = node.parent;
                        leftRotate(node);
                    }
                    // Case 3: 当前节点是左子节点，进行右旋转
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    rightRotate(node.parent.parent);
                }
            } else {
                Node uncle = node.parent.parent.left;
                if (uncle != null && uncle.color == RED) {
                    // Case 1: 叔叔节点是红色的
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        // Case 2: 当前节点是左子节点，进行右旋转
                        node = node.parent;
                        rightRotate(node);
                    }
                    // Case 3: 当前节点是右子节点，进行左旋转
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    leftRotate(node.parent.parent);
                }
            }
        }
        root.color = BLACK; // 根节点始终为黑色
    }

    // 左旋转
    private void leftRotate(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }
        rightChild.parent = node.parent;
        if (node.parent == null) {
            root = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }
        rightChild.left = node;
        node.parent = rightChild;
    }

    // 右旋转
    private void rightRotate(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }
        leftChild.parent = node.parent;
        if (node.parent == null) {
            root = leftChild;
        } else if (node == node.parent.right) {
            node.parent.right = leftChild;
        } else {
            node.parent.left = leftChild;
        }
        leftChild.right = node;
        node.parent = leftChild;
    }

    // 中序遍历打印树
    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(15);
        tree.insert(25);
        
        // 打印中序遍历的结果
        tree.inorderTraversal(); // 输出：10 15 20 25 30
    }
}
