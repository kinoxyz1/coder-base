package com.kino.algorithm.f_queue;

import java.util.Iterator;

/**
 * 环形队列实现队列: 该方法不用浪费一个空位
 *
 * @author kino
 * @date 2023/5/3 22:04
 */
public class ArrayQueue2<E> implements Queue<E>, Iterable<E> {

    private final E[] element;
    private int head;
    private int tail;
    private int size; // 已使用的大小

    @SuppressWarnings("all")
    public ArrayQueue2(int capacity) {
        element = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        element[tail] = value;
        tail = (tail + 1) % element.length;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E value = element[head];
        head = (head + 1) % element.length;
        size--;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return element[head];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == element.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int point = 0;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public E next() {
                E value = element[point];
                point++;
                return value;
            }
        };
    }
}
