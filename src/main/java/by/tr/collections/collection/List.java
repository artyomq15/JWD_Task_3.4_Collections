package by.tr.collections.collection;

public interface List<T> extends Collection<T>{
    void add(int index, T t);

    T get(int index);

    T remove(int index);
}
