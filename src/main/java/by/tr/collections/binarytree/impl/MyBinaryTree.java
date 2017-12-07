package by.tr.collections.binarytree.impl;

import by.tr.collections.binarytree.Tree;

import java.util.*;

public class MyBinaryTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;
    private List<T> traverse;

    public MyBinaryTree() {

    }

    @Override
    public boolean add(T elem) {
        if (root != null) {
            root = add(root, elem);
        } else {
            root = new Node<>();
            root.elem = elem;
        }
        return true;
    }

    private Node<T> add(Node<T> node, T elem) {
        if (node == null) {
            node = new Node<T>();
            node.elem = elem;
        } else if (elem.compareTo(node.elem) < 0) {
            node.left = add(node.left, elem);
        } else {
            node.right = add(node.right, elem);
        }
        return node;
    }

    @Override
    public boolean contains(T elem) {
        return contains(root, elem);
    }

    private boolean contains(Node<T> n, T elem) {
        if (n != null) {
            if (elem.equals(n.elem)) {
                return true;
            } else if (elem.compareTo(n.elem) < 0) {
                return contains(n.left, elem);
            } else {
                return contains(n.right, elem);
            }
        }
        return false;
    }


    @Override
    public int size() {
        return inOrder().size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean remove(T elem) {
        if (!contains(elem)) {
            return false;
        }
        root = remove(root, elem);
        return true;
    }

    private Node<T> remove(Node<T> node, T elem) {
        if (elem.compareTo(node.elem) < 0) {
            node.left = remove(node.left, elem);
        } else if (elem.compareTo(node.elem) > 0) {
            node.right = remove(node.right, elem);
        } else if (node.left != null && node.right != null) {
            node.elem = findSuccessor(node.right).elem;
            node.right = remove(node.right, node.elem);
        } else {
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    private Node<T> findSuccessor(Node<T> node) {
        if (node.left != null) {
            node = findSuccessor(node.left);
        }
        return node;
    }

    @Override
    public List<T> inOrder() {
        traverse = new ArrayList<>();
        inOrder(root);
        return traverse;
    }

    private void inOrder(Node<T> n) {
        if (n != null) {
            inOrder(n.left);
            traverse.add(n.elem);
            inOrder(n.right);
        }
    }

    @Override
    public List<T> preOrder() {
        traverse = new ArrayList<>();
        preOrder(root);
        return traverse;
    }

    private void preOrder(Node<T> n) {
        if (n != null) {
            traverse.add(n.elem);
            preOrder(n.left);
            preOrder(n.right);
        }
    }

    @Override
    public List<T> postOrder() {
        traverse = new ArrayList<>();
        postOrder(root);
        return traverse;
    }

    private void postOrder(Node<T> n) {
        if (n != null) {
            postOrder(n.left);
            postOrder(n.right);
            traverse.add(n.elem);
        }
    }

    private class Node<E extends Comparable<E>> {
        private Node<E> left;
        private Node<E> right;

        private E elem;

        public Node() {

        }

        public Node(Node<E> left, Node<E> right, E elem) {
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
                '}';
    }

}
