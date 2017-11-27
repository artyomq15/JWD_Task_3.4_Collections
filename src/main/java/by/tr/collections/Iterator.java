package by.tr.collections;

public interface Iterator<T> {
    boolean hasNext();
    T next();
    boolean hasPrevious();
    T previous();
}
