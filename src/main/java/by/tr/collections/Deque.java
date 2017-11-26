package by.tr.collections;

public interface Deque<T> extends Queue<T> {
    void addFirst(T t);
    void addLast(T t);
    T removeFirst();
    T removeLast();
    T getFirst();
    T getLast();

    boolean offerFirst(T t);
    boolean offerLast(T t);
    T pollFirst();
    T pollLast();
    T peekFirst();
    T peekLast();
}
