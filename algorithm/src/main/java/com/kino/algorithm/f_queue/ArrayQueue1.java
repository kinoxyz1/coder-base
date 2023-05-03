package com.kino.algorithm.f_queue;

import java.util.Iterator;

/**
 * 环形队列实现队列
 *
 * @author kino
 * @date 2023/5/2 22:09
 */
public class ArrayQueue1<E> implements Queue<E>, Iterable<E> {
    E[] element; // 数组
    private int head = 0; // 头指针
    private int tail = 0; // 尾指针

    @SuppressWarnings("all")
    public ArrayQueue1(int capacity) { // 初始化数组大小
        element = (E[]) new Object[capacity + 1];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) return false;
        element[tail] = value;
        tail = (tail + 1) % element.length;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        E value = element[head];
        head = (head+1) % element.length;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return element[head];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % element.length == head;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int point = 0;
            @Override
            public boolean hasNext() {
                return point != tail;
            }

            @Override
            public E next() {
                E value = element[point];
                point = (point + 1) % element.length;
                return value;
            }
        };
    }
}
