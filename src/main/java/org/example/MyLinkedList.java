package org.example;

import java.util.*;

public class MyLinkedList<T> implements List<T> {

    private int size;
    private MyLinkedList.Node<T> head;
    private MyLinkedList.Node<T> tail;

    // o(1)
    @Override
    public int size() {
        return size;
    }

    // o(1)
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //o(1), так как присваивание в конец/начало списка без его обхода
    @Override
    public boolean add(T t) {
        var l = tail;
        Node<T> newNode = new Node<>(l, t, null);
        tail = newNode;
        if (l == null) {
            head = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        return true;
    }

    // о(n) в случае, если элемент не является head, т.к. обход всего списка
    // o(1) в случае с head
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<T> f = head; f != null; f = f.next) {
                if (f.item == null) {
                    unlink(f);
                    return true;
                }
            }
        } else {
            for (Node<T> f = head; f != null; f = f.next) {
                if (f.item.equals(o)) {
                    unlink(f);
                    return true;
                }
            }
        }
        return false;
    }

    // о(n) - если не на head, так как обход всего списка
    // о(1) - если индекс указывает на head
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> h = head;
        for (int i = 0; i < index; i++) {
            h = h.next;
        }
        return h.item;
    }

    // о(n) - если не на head, так как обход всего списка
    // о(1) - если индекс указывает на head
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> h = head;
        for (int i = 0; i < index; i++) {
            h = h.next;
        }

        return unlink(h);
    }

    private T unlink(Node<T> f) {
        T elem = f.item;
        Node<T> next = f.next;
        Node<T> prev = f.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            f.prev = null;
        }
        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            f.next = null;
        }

        size--;
        f.item = null;
        return elem;
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    private static class Node<T> {
        T item;
        MyLinkedList.Node<T> next;
        MyLinkedList.Node<T> prev;

        Node(MyLinkedList.Node<T> prev, T element, MyLinkedList.Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
