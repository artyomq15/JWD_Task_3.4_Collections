package by.tr.collections.collection.impl;

import by.tr.collections.collection.Deque;
import by.tr.collections.collection.Iterator;
import by.tr.collections.collection.List;
import by.tr.collections.collection.exception.InvalidIndexException;

import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T>, Deque<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public LinkedList() {
        last = new Node<>(null, null, null);
        first = new Node<>(null, null, last);
        last.setPrev(first);
    }

    @Override
    public void addFirst(T t) {
        linkFirst(t);
    }

    @Override
    public void addLast(T t) {
        linkLast(t);
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return unlinkFirst();
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return unlinkLast();
    }

    @Override
    public T getFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node<T> t = first.getNext();
        return t.getElem();
    }

    @Override
    public T getLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node<T> t = last.getPrev();
        return t.getElem();
    }

    @Override
    public boolean offerFirst(T t) {
        addFirst(t);
        return true;
    }

    @Override
    public boolean offerLast(T t) {
        addLast(t);
        return true;
    }

    @Override
    public T pollFirst() {
        if (size == 0) {
            return null;
        }
        return unlinkFirst();
    }

    @Override
    public T pollLast() {
        if (size == 0) {
            return null;
        }
        return unlinkLast();
    }

    @Override
    public T peekFirst() {
        if (size == 0) {
            return null;
        }
        Node<T> t = first.getNext();
        return t.getElem();
    }

    @Override
    public T peekLast() {
        if (size == 0) {
            return null;
        }
        Node<T> t = last.getPrev();
        return t.getElem();
    }

    @Override
    public boolean offer(T t) {
        return offerLast(t);
    }

    @Override
    public T poll() {
        return pollFirst();
    }

    @Override
    public T peek() {
        return peekFirst();
    }

    @Override
    public T remove() {
        return removeFirst();
    }

    @Override
    public T element() {
        return getFirst();
    }

    @Override
    public boolean add(T t) {
        addLast(t);
        return true;
    }

    @Override
    public boolean remove(T t) {
        Node<T> n = first.getNext();
        for (int i = 0; i < size; i++) {
            if (n.getElem().equals(t)) {
                n.getPrev().setNext(n.getNext());
                n.getNext().setPrev(n.getPrev());
                size--;
                return true;
            }
            n = n.getNext();
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T t) {
        Node<T> n = first.getNext();
        for (int i = 0; i < size; i++) {
            if (n.getElem().equals(t)) {
                return true;
            }
            n = n.getNext();
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
        private Node<T> n = first;
        private Node<T> lastReturned;


        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (hasNext()) {
                lastReturned = n = n.getNext();
                index++;
                return n.getElem();
            }
            throw new NoSuchElementException();
        }

        @Override
        public boolean hasPrevious() {
            return index>0;
        }

        @Override
        public T previous() {
            if (hasPrevious()) {
                lastReturned = n;
                T t = n.getElem();
                n = n.getPrev();
                index--;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            unlink(lastReturned);
            index--;
        }
    }


    @Override
    public void add(int index, T t) {
        checkIndex(index);
        if (index==0){
            Node<T> tNode = new Node<>(t,first,first.getNext());
            first.getNext().setPrev(tNode);
            first.setNext(tNode);
            size++;
            return;
        }
        Node<T> n = first.getNext();
        for (int i = 0; i <= size; i++) {
            if (i==index){
                Node<T> tNode = new Node<>(t,n.getPrev(),n);
                n.getPrev().setNext(tNode);
                n.setPrev(tNode);
                size++;
                return;
            }
            n = n.getNext();
        }
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        Node<T> n = first.getNext();
        for (int i = 0; i <= size; i++) {
            if (i==index){
               return n.getElem();
            }
            n = n.getNext();
        }
        return null;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        Node<T> n = first.getNext();
        for (int i = 0; i < size; i++) {
            if (i==index){
                return unlink(n);
            }
            n = n.getNext();
        }
        throw new InvalidIndexException("Index: " + index + ", Size: " + size);
    }

    private class Node<E> {
        private E elem;
        private Node<E> prev;
        private Node<E> next;

        public Node() {

        }

        public Node(E elem, Node<E> prev, Node<E> next) {
            this.elem = elem;
            this.prev = prev;
            this.next = next;
        }

        public E getElem() {
            return elem;
        }

        public void setElem(E elem) {
            this.elem = elem;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        list.append("[");
        Node<T> e = first.getNext();
        for (int i = 0; i < size - 1; i++) {
            list.append(e.getElem()).append(", ");
            e = e.getNext();
        }
        list.append(e.getElem()).append("]");
        return list.toString();
    }

    private void linkFirst(T t) {
        Node<T> next = first;
        next.setElem(t);
        first = new Node<>(null, null, next);
        next.setPrev(first);
        size++;
    }

    private void linkLast(T t) {
        Node<T> prev = last;
        prev.setElem(t);
        last = new Node<>(null, prev, null);
        prev.setNext(last);
        size++;
    }

    private T unlink(Node<T> t) {
        t.getPrev().setNext(t.getNext());
        t.getNext().setPrev(t.getPrev());
        size--;
        return t.getElem();
    }

    private T unlinkFirst() {
        Node<T> del = first.getNext();
        first.setNext(del.getNext());
        size--;
        return del.getElem();
    }

    private T unlinkLast() {
        Node<T> del = last.getPrev();
        last.setPrev(del.getPrev());
        size--;
        return del.getElem();
    }

    private void checkIndex(int index) {
        if (index > size || index < 0) {
            throw new InvalidIndexException("Index: " + index + ", Size: " + size);
        }
    }
}
