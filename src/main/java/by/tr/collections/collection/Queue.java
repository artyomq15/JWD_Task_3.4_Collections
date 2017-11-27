package by.tr.collections.collection;

public interface Queue<T> extends Collection<T> {
    boolean offer(T t);
    T poll();
    T peek();

    T remove();
    T element();
}
