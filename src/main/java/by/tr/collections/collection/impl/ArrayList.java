package by.tr.collections.collection.impl;

import by.tr.collections.collection.Iterator;
import by.tr.collections.collection.List;
import by.tr.collections.collection.exception.InvalidIndexException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T>, Cloneable, Serializable {
    private static final int DEFAULT_SIZE = 10;

    private Object[] array;
    private int size;

    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    public ArrayList(int size) {
        array = new Object[size];
    }

    @Override
    public boolean add(T t) {
        ensureCapacity();
        array[size++] = t;
        return true;
    }

    @Override
    public void add(int index, T t) {
        checkIndex(index);
        ensureCapacity();
        array[size++] = t;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    @Override
    public T remove(int index) {

        checkIndexForRemoving(index);
        Object value = array[index];
        int numberElements = size - index - 1;

        System.arraycopy(array, index + 1, array, index, numberElements);
        array[--size] = null;
        return (T) value;
    }

    @Override
    public boolean remove(T t) {
        for (int i = 0; i < size; ++i) {
            if (array[i].equals(t)) {
                int numberElements = size - i - 1;

                System.arraycopy(array, i + 1, array, i, numberElements);
                array[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T t) {
        for (int i = 0; i < size; ++i) {
            if (array[i].equals(t)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> getIterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private int index;
        int lastReturnedIndex;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (this.hasNext()) {
                lastReturnedIndex = index;
                return (T) array[index++];
            }
            throw new NoSuchElementException();
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public T previous() {
            if (this.hasPrevious()) {
                lastReturnedIndex = index - 1;
                return (T) array[--index];
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            System.out.println(lastReturnedIndex + "_");

            int numberElements = size - lastReturnedIndex - 1;
            System.arraycopy(array, lastReturnedIndex + 1, array, lastReturnedIndex, numberElements);
            array[--size] = null;
            index--;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArrayList<T> that = (ArrayList<T>) o;

        if (size != that.size) return false;
        int count = 0;
        Object elem;
        Object thatElem;

        for (int i = 0; i < size; ++i) {
            elem = array[i];
            thatElem = that.array[i];

            if (elem != null ? elem.equals(thatElem) : thatElem == null) {
                count++;
            }
        }
        return count == size;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(array);
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        if (size > 0) {
            for (int i = 0; i < size - 1; ++i) {
                result.append(array[i]).append(", ");
            }
            result.append(array[size - 1]);
        }

        result.append("]");
        return result.toString();
    }

    private void checkIndex(int index) {
        if (index > size || index < 0) {
            throw new InvalidIndexException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkIndexForRemoving(int index) {
        if (index >= size || size == 0) {
            throw new InvalidIndexException("Index: " + index + ", Size: " + size);
        }
    }

    private void ensureCapacity() {
        if (size < array.length) {
            return;
        }
        resize();
    }

    private void resize() {
        Object[] temp = new Object[array.length * 2];
        System.arraycopy(array, 0, temp, 0, array.length);
        array = temp;
    }
}
