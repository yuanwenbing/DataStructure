package com.yuan.inter.queue;

public interface Queue<E> {
    void queue(E e);

    E dequeue();

    E getFront();

    boolean isEmpty();

    int getSize();

}
