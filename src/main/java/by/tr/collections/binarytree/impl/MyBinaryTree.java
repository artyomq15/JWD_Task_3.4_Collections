package by.tr.collections.binarytree.impl;


import by.tr.collections.binarytree.Tree;

import java.util.*;

public class MyBinaryTree implements Tree {
    private Node root;
    private List<Object> traverse;

    public MyBinaryTree() {

    }

    @Override
    public boolean add(Object elem) {
        if (root != null) {
            root = add(root, null, elem);
        } else {
            root = new Node();
            root.elem = elem;
        }
        return true;
    }

    private Node add(Node node, Node parent, Object elem) {
        if (node == null) {
            node = new Node();
            node.elem = elem;
            node.parent = parent;
        } else if (goLeft(node)) {
            node.left = add(node.left, node, elem);
        } else {
            node.right = add(node.right, node, elem);
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
    

    private Node findLastNode(Node last, Node node) {
        if (node == null) {
            System.out.println("kek");
            return last;
        } else if (goLeft(node)) {
            System.out.println("kkkk");
            last = findLastNode(node, node.left);
        } else {
            System.out.println("LLLL");
            last = findLastNode(node, node.right);
        }
        return last;
    }

    @Override
    public boolean contains(Object elem) {
        return contains(root, elem);
    }

    @Override
    public int size() {
        return inOrder().size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private boolean contains(Node n, Object elem) {
        boolean res;
        if (n != null) {
            if (elem.equals(n.elem)) {
                return true;
            }
            res = contains(n.left, elem);
            if (res) {
                return true;
            }
            res = contains(n.right, elem);
            if (res) {
                return true;
            }
            return false;
        }
        return false;
    }


    @Override
    public List<Object> inOrder() {
        traverse = new ArrayList<>();
        inOrder(root);
        return traverse;
    }

    private void inOrder(Node n) {
        if (n != null) {
            inOrder(n.left);
            traverse.add(n.elem);
            inOrder(n.right);
        }
    }

    @Override
    public List<Object> preOrder() {
        traverse = new ArrayList<>();
        preOrder(root);
        return traverse;
    }

    private void preOrder(Node n) {
        if (n != null) {
            traverse.add(n.elem);
            preOrder(n.left);
            preOrder(n.right);
        }
    }

    @Override
    public List<Object> postOrder() {
        traverse = new ArrayList<>();
        postOrder(root);
        return traverse;
    }

    private void postOrder(Node n) {
        if (n != null) {
            postOrder(n.left);
            postOrder(n.right);
            traverse.add(n.elem);
        }
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
                    ", parent=" + (parent != null ? parent.elem.toString() : null) +
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

        binaryTree.contains(4);
        System.out.println(binaryTree.inOrder());
        System.out.println(binaryTree.preOrder());
        System.out.println(binaryTree.postOrder());
        System.out.println(binaryTree);


    }
}
