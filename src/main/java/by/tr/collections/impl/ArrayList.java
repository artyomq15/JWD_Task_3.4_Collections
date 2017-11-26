package by.tr.collections.impl;

import by.tr.collections.Iterator;
import by.tr.collections.List;
import by.tr.collections.exception.InvalidIndexException;

import java.io.Serializable;

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
        //
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
        return null;
    }



    private void checkIndex(int index) {
        if (index > size || index<0) {
            throw new InvalidIndexException("Index: " +index+", Size: "+size );
        }
    }

    private void checkIndexForRemoving(int index) {
        if (index >= size || size == 0) {
            throw new InvalidIndexException("Index: " +index+", Size: "+size );
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
