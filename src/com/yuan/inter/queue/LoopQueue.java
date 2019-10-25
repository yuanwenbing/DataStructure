package com.yuan.inter.queue;

import org.omg.CORBA.Object;
import org.omg.CORBA.TIMEOUT;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    public LoopQueue() {
        this(10);
    }


    @Override
    public void queue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("");
        }

        E ref = data[front];
        front = (front + 1) & data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ref;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("");
        }
        return data[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;

    }
}
