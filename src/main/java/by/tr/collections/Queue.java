package by.tr.collections;

public interface Queue<T> extends Collection<T> {
    boolean offer(T t);
    T poll();
    T peek();

    T remove();
    T element();
}
