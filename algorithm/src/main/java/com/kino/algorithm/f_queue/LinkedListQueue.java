package com.kino.algorithm.f_queue;

import java.util.Iterator;

/**
 * 用单向环形哨兵链表实现队列
 * @author kino
 * @date 2023/5/2 20:26
 */
public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {

    private static class Node<E> {
        E val;
        Node<E> next;

        public Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node<E> head = new Node<>(null, null);
    private Node<E> tail = head;

    public LinkedListQueue() {
        tail.next = head;
    }

    @Override
    public boolean offer(E value) {
        Node<E> added = new Node<>(value, head);
        tail.next = added;
        tail = added;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        Node<E> remote = head.next;
        head.next = remote.next;
        if (remote == tail) tail = remote;
        return remote.val;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return head.next.val;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> point = head.next;
            @Override
            public boolean hasNext() {
                return point != head;
            }

            @Override
            public E next() {
                E val = point.val;
                point = point.next;
                return val;
            }
        };
    }
}
