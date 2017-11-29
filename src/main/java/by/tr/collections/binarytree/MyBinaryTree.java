package by.tr.collections.binarytree;


public class MyBinaryTree {
    private Node root;

    public MyBinaryTree() {

    }

    public boolean add(Object elem) {
        if (root != null) {
            root = add(root, null, elem);
        } else {
            root = new Node();
            root.elem = elem;
        }
        return true;
    }

    private Node add(Node node, Node parent,  Object elem) {
        if (node == null) {
            node = new Node();
            node.elem = elem;
            node.parent = parent;
        } else if (goLeft(node)) {
            node.left = add(node.left,node, elem);
        } else {
            node.right = add(node.right,node, elem);
        }
        return node;
    }


    private int countDepth(Node node, int depth) {
        if (node != null) {
            depth = countDepth(node.right, depth + 1);
        }
        return depth;
    }

    private boolean goLeft(Node node) {
        int depthLeft = countDepth(node.left, 0);
        int depthRight = countDepth(node.right, 0);
        return depthRight == depthLeft;
    }

    private class Node {
        private Node left;
        private Node right;

        private Node parent;

        private Object elem;

        public Node() {

        }

        public Node(Node left, Node right, Node parent, Object elem) {
            this.left = left;
            this.right = right;
            this.elem = elem;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", elem=" + elem +
                    ", parent=" + (parent!=null?parent.elem.toString():null) +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MyBinaryTree{" +
                "root=" + root +
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
