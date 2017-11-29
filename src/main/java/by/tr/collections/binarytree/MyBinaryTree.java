package by.tr.collections.binarytree;

/**
 * Created by Lenovo on 11/29/2017.
 */
public class MyBinaryTree {
    private Node root;
    private int depthLeft;
    private int depthRight;

    public MyBinaryTree() {

    }

    public boolean add(Object elem) {
        if (root != null) {
            root = add(root, elem);
        } else {
            root = new Node();
            root.elem = elem;
        }
        return true;
    }

    private Node add(Node node, Object elem) {
        if (node == null) {
            node = new Node();
            node.elem = elem;
        } else if (goLeft(node)) {
            node.left = add(node.left, elem);
        } else {
            node.right = add(node.right, elem);
        }
        return node;
    }


    private void countDepthLeft(Node node) {
        if (node != null) {
            depthLeft++;
            countDepthLeft(node.right);
        }
    }

    private void countDepthRight(Node node) {
        if (node != null) {
            depthRight++;
            countDepthRight(node.right);
        }
    }

    private boolean goLeft(Node node) {
        int depthRight = 0;
        int depthLeft = 0;
        countDepthLeft(node.left);
        countDepthRight(node.right);
        return depthRight == depthLeft;
    }

    private class Node {
        private Node left;
        private Node right;
        private Object elem;

        public Node() {

        }

        public Node(Node left, Node right, Object elem) {
            this.left = left;
            this.right = right;
            this.elem = elem;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", elem=" + elem +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MyBinaryTree{" +
                "root=" + root +
                ", depthLeft=" + depthLeft +
                ", depthRight=" + depthRight +
                '}';
    }

    public static void main(String[] args) {
        MyBinaryTree binaryTree = new MyBinaryTree();
        for (int i = 1; i <= 10; ++i) {
            binaryTree.add(i);
        }
        System.out.println(binaryTree);
    }
}
