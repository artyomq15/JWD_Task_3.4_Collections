package by.tr.collections.collection;

public interface Collection<T> extends Container<T>{
    boolean add(T t);

    boolean remove(T t);

    int size();

    boolean contains(T value);

    boolean isEmpty();
}
