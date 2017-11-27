package by.tr.collections;

import by.tr.collections.binarytree.BinaryTree;

public class Run {
    public static void main(String[] args) {
        BinaryTree<String> bt = new BinaryTree<>();
        bt.insert("kek");
        bt.insert("lol");
        bt.insert("cheb");
        bt.inorder();
        bt.preorder();
        bt.postorder();

    }
}
