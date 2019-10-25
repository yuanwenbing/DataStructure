package com.yuan.inter.stack;

import com.yuan.inter.linkedlist.DummyHeadLinkedList;
import com.yuan.inter.linkedlist.LinkedList;

public class LinkedListStack<E> implements Stack<E> {

    private DummyHeadLinkedList<E> list;

    public LinkedListStack() {
        list = new DummyHeadLinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }
}