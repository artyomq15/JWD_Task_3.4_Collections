package by.tr.collections.binarytree;

import java.util.List;

public interface Tree<T extends Comparable<T>> {
    boolean add(T elem);

    boolean contains(T elem);

    int size();

    boolean isEmpty();

    boolean remove(T elem);

    List<T> preOrder();

    List<T> inOrder();

    List<T> postOrder();
}
