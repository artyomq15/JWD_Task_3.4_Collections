package by.tr.collections;

public interface Collection<T> extends Container<T>{
    boolean add(T t);

    boolean remove(T t);

    int size();

    boolean contains(T value);

    boolean isEmpty();
}
