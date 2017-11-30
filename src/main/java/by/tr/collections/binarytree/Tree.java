package by.tr.collections.binarytree;


import java.util.List;

public interface Tree {
    boolean add(Object elem);

    boolean contains(Object elem);

    int size();

    boolean isEmpty();

    List<Object> preOrder();

    List<Object> inOrder();

    List<Object> postOrder();
}
