package by.tr.collections.binarytree;

public class BinaryTree<T> {
    Node<T> root;

    public BinaryTree() {
    }

    public BinaryTree(T t) {
        root.setData(t);
    }

    public void insert(T t) {
        root = insert(root, t);
    }

    private Node<T> insert(Node<T> node, T t) {
        if (node == null)
            node = new Node<>(t);
        else {
            if (node.getRight() == null)
                node.right = insert(node.right, t);
            else
                node.left = insert(node.left, t);
        }
        return node;
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node<T> r) {
        if (r == null)
            return 0;
        else {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }


    public boolean search(T t) {
        return search(root, t);
    }

    private boolean search(Node<T> r, T t) {
        if (r.getData().equals(t))
            return true;
        if (r.getLeft() != null)
            if (search(r.getLeft(), t))
                return true;
        if (r.getRight() != null)
            if (search(r.getRight(), t))
                return true;
        return false;
    }


    public void inorder() {
        inorder(root);
    }

    private void inorder(Node<T> r) {
        if (r != null) {
            inorder(r.getLeft());
            System.out.print(r.getData() + " ");
            inorder(r.getRight());
        }
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(Node<T> r) {
        if (r != null) {
            System.out.print(r.getData() + " ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(Node<T> r) {
        if (r != null) {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getData() + " ");
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
