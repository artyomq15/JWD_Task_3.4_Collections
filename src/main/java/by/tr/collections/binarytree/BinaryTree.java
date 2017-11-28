package by.tr.collections.binarytree;

public class BinaryTree<T> {
    Node<T> root;

    StringBuilder traverse;

    public BinaryTree() {
    }

    public BinaryTree(T t) {
        root.setData(t);
    }

    public void insert(T t) {
        root = insert(root, t);
    }

    private Node<T> insert(Node<T> node, T t) {
        if (node == null){

            node = new Node<>(t);
        }
        else {
            if (node.getRight() == null){

                node.right = insert(node.right, t);
            }
            else{
                node.left = insert(node.left, t);

            }
        }
        return node;
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node<T> r) {
        if (r == null){
            return 0;
        }
        else {
            int k = 1;
            k += countNodes(r.getLeft());
            k += countNodes(r.getRight());
            return k;
        }
    }


    public boolean search(T t) {
        return search(root, t);
    }

    private boolean search(Node<T> r, T t) {
        if (r.getData().equals(t)) {

            return true;
        }
        if (r.getLeft() != null) {
            if (search(r.getLeft(), t)) {

                return true;
            }
        }

        if (r.getRight() != null) {
            if (search(r.getRight(), t)) {
                return true;

            }
        }
        return false;
    }

    public String inorder() {
        traverse = new StringBuilder();
        inorder(root);
        return traverse.toString();
    }

    private void inorder(Node<T> r) {
        if (r != null) {
            inorder(r.getLeft());
            traverse.append(r.getData()).append(" ");
            inorder(r.getRight());
        }
    }

    public String preorder() {
        traverse = new StringBuilder();
        preorder(root);
        return traverse.toString();
    }

    private void preorder(Node<T> r) {
        if (r != null) {
            traverse.append(r.getData()).append(" ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }

    public String postorder() {
        traverse = new StringBuilder();
        postorder(root);
        return traverse.toString();
    }

    private void postorder(Node<T> r) {
        if (r != null) {
            postorder(r.getLeft());
            postorder(r.getRight());
            traverse.append(r.getData()).append(" ");
        }
    }


    public boolean isEmpty() {
        return root == null;
    }

    private class Node<E> {
        Node<E> left;
        Node<E> right;
        E data;

        public Node() {

        }

        public Node(E e) {
            left = null;
            right = null;
            data = e;
        }

        public void setLeft(Node<E> n) {
            left = n;
        }

        public void setRight(Node<E> n) {
            right = n;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setData(E e) {
            data = e;
        }

        public E getData() {
            return data;
        }
    }
}
