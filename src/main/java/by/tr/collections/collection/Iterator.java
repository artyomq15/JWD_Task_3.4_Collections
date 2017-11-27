package by.tr.collections.collection;

public interface Iterator<T> {
    boolean hasNext();
    T next();
    boolean hasPrevious();
    T previous();
    void remove();
}
